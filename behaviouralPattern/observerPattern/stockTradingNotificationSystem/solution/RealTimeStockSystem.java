package behaviouralPattern.observerPattern.stockTradingNotificationSystem.solution;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.*;


// ----------- Listener Interface -----------
interface StockListener {
    void onPriceUpdate(String symbol, double price);
}

// ----------- Stock Update Model -----------
class StockUpdate {
    final String symbol;
    final double price;

    StockUpdate(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

// ----------- Async Listener Wrapper -----------
class AsyncListener {
    final StockListener listener;
    private final BlockingQueue<StockUpdate> queue;
    private final Thread worker;
    private final AtomicBoolean running = new AtomicBoolean(true);
    private static final int MAX_QUEUE_SIZE = 100;

    AsyncListener(StockListener listener) {
        this.listener = listener;
        this.queue = new ArrayBlockingQueue<>(MAX_QUEUE_SIZE);
        this.worker = new Thread(this::processQueue);
        this.worker.start();
    }

    void enqueueUpdate(String symbol, double price) {
        if (!queue.offer(new StockUpdate(symbol, price))) {
            System.err.println("Queue full for listener, dropping update: " + symbol);
        }
    }

    private void processQueue() {
        while (running.get()) {
            try {
                StockUpdate update = queue.poll(100, TimeUnit.MILLISECONDS);
                if (update != null) {
                    try {
                        listener.onPriceUpdate(update.symbol, update.price);
                    } catch (Exception e) {
                        System.err.println("Error in listener: " + e.getMessage());
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Listener thread stopped.");
    }

    void stop() {
        running.set(false);
        worker.interrupt();
    }
}

// ----------- Stock Publisher -----------
class StockPublisher {
    private final CopyOnWriteArrayList<AsyncListener> listeners = new CopyOnWriteArrayList<>();

    public void registerListener(StockListener listener) {
        listeners.add(new AsyncListener(listener));
    }

    public void unregisterListener(StockListener listener) {
        listeners.removeIf(l -> l.listener == listener);
    }

    public void publish(String symbol, double price) {
        for (AsyncListener l : listeners) {
            l.enqueueUpdate(symbol, price);
        }
    }

    public void shutdown() {
        for (AsyncListener l : listeners) {
            l.stop();
        }
        listeners.clear();
    }
}

// ----------- Demo Main Class -----------
public class RealTimeStockSystem {
    public static void main(String[] args) throws InterruptedException {
        StockPublisher publisher = new StockPublisher();

        // Sample Listener 1 - Charting
        publisher.registerListener((symbol, price) -> {
            System.out.println("[Charting] " + symbol + ": $" + price);
        });

        // Sample Listener 2 - Logging
        publisher.registerListener((symbol, price) -> {
            System.out.println("[Logging] " + symbol + " updated at " + new Date() + " to $" + price);
        });

        // Sample Listener 3 - Slow (simulate delay)
        publisher.registerListener((symbol, price) -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } // simulate slowness
            System.out.println("[SlowListener] Processed " + symbol + ": $" + price);
        });

        // Simulate price feed (running in a separate thread)
        ExecutorService feedExecutor = Executors.newSingleThreadExecutor();
        feedExecutor.submit(() -> {
            String[] symbols = { "AAPL", "GOOGL", "MSFT", "TSLA" };
            Random rand = new Random();
            try {
                for (int i = 0; i < 20; i++) {
                    String sym = symbols[rand.nextInt(symbols.length)];
                    double price = 100 + rand.nextDouble() * 1000;
                    publisher.publish(sym, price);
                    Thread.sleep(100); // simulate high frequency
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Allow time for processing
        Thread.sleep(6000);

        // Graceful shutdown
        publisher.shutdown();
        feedExecutor.shutdownNow();
        System.out.println("System shut down.");
    }
}
