package creationalPattern.singletonMethod.singletonWithDependencyInjection.solution;
import java.util.*;

class DatabaseConnection {
    String name;
    DatabaseConnection(String name){
        this.name = name;
    }

    void use(){
        System.out.println("Using db connection "+ this.name);
    }

    void reset(){
        this.name = "";
        System.out.println("Resetting db connection " + this.name);
    }
}

class DatabaseConnectionPool{
    private static DatabaseConnectionPool instance = null; // Singleton instance
    private static Queue<DatabaseConnection> pool = new LinkedList<>();
    int connectionsMadeSoFar = 0;
    static final int maxSize = 10;
    private DatabaseConnectionPool(){
        // pool = new LinkedList<>();
    }
    // Public method to provide access to the single instance
    public static synchronized DatabaseConnectionPool getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionPool();
        }
        return instance;
    }

    public DatabaseConnection getConnection(String name) {
        // Quick check outside synchronization to avoid blocking
        // 1. first we check if pool contains any connection already, if it does
        // we return one
        if (!pool.isEmpty()) {
            synchronized (DatabaseConnectionPool.class) {
                if (!pool.isEmpty()) { // Double-check inside lock
                    return pool.poll();
                }
            }
        }

        // if pool is empty but total connections made so far is less than max possible
        // connections (note: connectionsMadeSoFar: number of connection made so far.
        synchronized (DatabaseConnectionPool.class) {
            if (connectionsMadeSoFar < maxSize) {
                connectionsMadeSoFar++;
                return new DatabaseConnection(name);
            }
        }

        throw new IllegalStateException("Number of connections exceeds the maximum limit: " + maxSize);
    }

    public void releaseConnection(DatabaseConnection connection) {
        connection.reset(); // No need for synchronization

        synchronized (DatabaseConnectionPool.class) { // Synchronize only when modifying the pool
            pool.add(connection);
        }
    }

    public int getActiveConnections() {
        return connectionsMadeSoFar - pool.size();
    }
}


public class solution {
    public static void main(String[] args) {        
        // DatabaseConnectionPool.setMaxSize(2);
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();

        DatabaseConnection conn1 = pool.getConnection("FirstConnection");
        conn1.use();
        
        DatabaseConnection conn2 = pool.getConnection("SecondConnection");
        conn2.use();

        // conn3.use();

        pool.releaseConnection(conn1);
        DatabaseConnection conn3 = pool.getConnection("ThirdConnection");

        // DatabaseConnection conn3 = DatabaseConnectionPool.getConnection("ThirdConnection");
        conn3.use();
    }
}
