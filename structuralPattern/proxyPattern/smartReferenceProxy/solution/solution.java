package structuralPattern.proxyPattern.smartReferenceProxy.solution;

interface Query {
    void query(String query);
}

class DatabaseConnection implements Query {
    private String dbConnectionString;

    DatabaseConnection(String dbConnectString) {
        this.dbConnectionString = dbConnectString;
        connectDb(dbConnectionString);
    }

    private void connectDb(String connectionString) {
        System.out.println("Connecting to database via connectionString: " + connectionString);
    }

    public void query(String query) {
        System.out.println("Querying: " + query);
    }
}

class DatabaseConnectionProxy implements Query {
    private DatabaseConnection dbConnect;
    private final String dbConnectionString;
    private final int threshold;
    private int countQuery;
    private boolean warningShown;

    DatabaseConnectionProxy(String dbConnectionString, int threshold) {
        this.dbConnectionString = dbConnectionString;
        this.threshold = threshold;
        this.countQuery = 0;
        this.warningShown = false;
    }

    private void initializeIfNeeded() {
        if (dbConnect == null) {
            dbConnect = new DatabaseConnection(dbConnectionString);
        }
    }

    public void query(String query) {
        initializeIfNeeded();
        countQuery++;
        if (countQuery > threshold && !warningShown) {
            System.out.println("⚠️ WARNING: Query count exceeded " + threshold + "!");
            warningShown = true;
        }
        dbConnect.query(query);
    }
}

public class solution {
    public static void main(String[] args) {
        int threshold = 5;

        DatabaseConnectionProxy dbProxy1 = new DatabaseConnectionProxy("tanishadb:qwerty", threshold);
        for (int i = 0; i < 7; i++) {
            dbProxy1.query("SELECT * FROM db WHERE id = " + i);
        }

        System.out.println("---------------------------------------");

        DatabaseConnectionProxy dbProxy2 = new DatabaseConnectionProxy("tanishadb:qwerty", threshold);
        for (int i = 0; i < 7; i++) {
            dbProxy2.query("SELECT * FROM db WHERE id = " + i);
        }
    }
}
