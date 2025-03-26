package creationalPattern.singletonMethod.singletonWithDependencyInjection.solution;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

class DatabaseConnection {
    private final String name;

    public DatabaseConnection(String name) {
        this.name = name;
    }

    public void use() {
        System.out.println("Using db connection: " + this.name);
    }

    public void reset() {
        System.out.println("Resetting db connection: " + this.name);
    }
}

class DatabaseConnectionPool {
    private static final int DEFAULT_MAX_SIZE = 10;
    private final ConcurrentLinkedQueue<DatabaseConnection> pool = new ConcurrentLinkedQueue<>();
    private final AtomicInteger connectionsMadeSoFar = new AtomicInteger(0);
    private final int maxSize;

    // **Bill Pugh Singleton Pattern**
    private static class SingletonHelper {
        private static final DatabaseConnectionPool INSTANCE = new DatabaseConnectionPool(DEFAULT_MAX_SIZE);
    }

    private DatabaseConnectionPool(int maxSize) {
        this.maxSize = maxSize;
    }

    public static DatabaseConnectionPool getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // **Allow setting maxSize via Dependency Injection**
    public static DatabaseConnectionPool getInstance(int maxSize) {
        return new DatabaseConnectionPool(maxSize);
    }

    public DatabaseConnection getConnection(String name) {
        DatabaseConnection connection = pool.poll();
        if (connection != null) {
            return connection;
        }

        if (connectionsMadeSoFar.get() < maxSize) {
            connectionsMadeSoFar.incrementAndGet();
            return new DatabaseConnection(name);
        }

        throw new IllegalStateException("Number of connections exceeds the maximum limit: " + maxSize);
    }

    public void releaseConnection(DatabaseConnection connection) {
        connection.reset();
        pool.add(connection);
    }

    public int getActiveConnections() {
        return connectionsMadeSoFar.get() - pool.size();
    }
}

public class solution2 {
    public static void main(String[] args) {
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance(2);

        DatabaseConnection conn1 = pool.getConnection("FirstConnection");
        conn1.use();

        DatabaseConnection conn2 = pool.getConnection("SecondConnection");
        conn2.use();

        pool.releaseConnection(conn1);
        DatabaseConnection conn3 = pool.getConnection("ThirdConnection");
        conn3.use();
    }
}
