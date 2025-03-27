package creationalPattern.factory.factoryMethod.factoryMethodWithMultipleImplementation.solution;

interface DatabaseConnection{
    boolean connect();
    boolean disconnect();
}

class PostgreSQLConnection implements DatabaseConnection{
    public boolean connect(){
        System.out.println("Connection successful of "+ this.getClass().getSimpleName());
        return true;
    }

    public boolean disconnect() {
        System.out.println("Successfully disconnected " + this.getClass().getSimpleName());
        return true;
    }
}

class MySQLConnection implements DatabaseConnection {
    public boolean connect() {
        System.out.println("Connection successful of " + this.getClass().getSimpleName());
        return true;
    }

    public boolean disconnect() {
        System.out.println("Successfully disconnected " + this.getClass().getSimpleName());
        return true;
    }
}

class MongoDBConnection implements DatabaseConnection {
    public boolean connect() {
        System.out.println("Connection successful of " + this.getClass().getSimpleName());
        return true;
    }

    public boolean disconnect() {
        System.out.println("Successfully disconnected " + this.getClass().getSimpleName());
        return true;
    }
}

interface DatabaseConnectionFactory{
    DatabaseConnection createConnection();
}

class PostgreSQLFactory implements DatabaseConnectionFactory{
    public DatabaseConnection createConnection(){
        return new PostgreSQLConnection();
    }
}

class MySQLFactory implements DatabaseConnectionFactory {
    public DatabaseConnection createConnection() {
        return new MySQLConnection();
    }
}

class MongoDBFactory implements DatabaseConnectionFactory {
    public DatabaseConnection createConnection() {
        return new MongoDBConnection();
    }
}


public class solution {
    public static void main(String[] args) {
        DatabaseConnectionFactory factory = new MySQLFactory();
        DatabaseConnection mySqlConnection = factory.createConnection();
        mySqlConnection.connect();
        mySqlConnection.disconnect();

        DatabaseConnectionFactory factory2 = new PostgreSQLFactory();
        DatabaseConnection mySqlConnection2 = factory2.createConnection();
        mySqlConnection2.connect();
        mySqlConnection2.disconnect();
    }
}
