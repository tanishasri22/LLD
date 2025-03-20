package creationalPattern.simpleFactory.factoryWithDependencyInjection.solution;

// Step 1: Logger Interface
interface Logger {
    void log(String message);
}

// Step 2: Concrete Loggers
class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("ConsoleLogger: " + message);
    }
}

class FileLogger implements Logger {
    private String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void log(String message) {
        System.out.println("Logging to file [" + filePath + "]: " + message);
        // File writing logic goes here
    }
}

class DatabaseLogger implements Logger {
    private String dbConnection;

    public DatabaseLogger(String dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void log(String message) {
        System.out.println("Logging to database [" + dbConnection + "]: " + message);
        // Database writing logic goes here
    }
}

// Step 3: Logger Factory with Dependency Injection
class LoggerFactory {
    public static Logger getLogger(String type, String dependency) {
        switch (type.toLowerCase()) {
            case "console":
                return new ConsoleLogger();
            case "file":
                return new FileLogger(dependency); // File path
            case "database":
                return new DatabaseLogger(dependency); // Database connection
            default:
                throw new IllegalArgumentException("Unknown logger type");
        }
    }
}

// Step 4: Testing the Factory
public class LoggerFactoryDemo {
    public static void main(String[] args) {
        Logger consoleLogger = LoggerFactory.getLogger("console", "");
        Logger fileLogger = LoggerFactory.getLogger("file", "/var/logs/app.log");
        Logger dbLogger = LoggerFactory.getLogger("database", "jdbc:mysql://localhost:3306/logs");

        consoleLogger.log("This is a console log.");
        fileLogger.log("This is a file log.");
        dbLogger.log("This is a database log.");
    }
}
