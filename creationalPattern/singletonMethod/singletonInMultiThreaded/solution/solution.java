package creationalPattern.singletonMethod.singletonInMultiThreaded.solution;

class LoggerLazy { 
    private static LoggerLazy Instance;
    private String filePath;

    private LoggerLazy(){
        this.filePath = "";
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    static LoggerLazy getInstance(){
        if(Instance == null){
            synchronized (LoggerLazy.class){
                if(Instance == null) Instance = new LoggerLazy();
            }
        }
        return Instance;
    }

    void writeToFile(String filePath){
        System.out.println("Writing log to file : "+ filePath + " via Lazy Loading");
    }

}

class LoggerEager{
    private static LoggerEager Instance = new LoggerEager();
    String filePath;

    private LoggerEager(){
        this.filePath = "";
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    static LoggerEager getInstance() {
        return Instance;
    }

    void writeToFile(String filePath) {
        System.out.println("Writing log to file : " + filePath + " via Eager Loading");
    }

}

public class solution {
    public static void main(String[] args) {

        //Lazy Loading
        LoggerLazy loggerLazyObject = LoggerLazy.getInstance();
        System.out.println(loggerLazyObject.hashCode());
        System.out.println(LoggerLazy.getInstance().hashCode());

        loggerLazyObject.writeToFile("file/abc/");



        //Eager Loading
        LoggerEager loggerEagerObject = LoggerEager.getInstance();
        System.out.println(loggerEagerObject.hashCode());
        System.out.println(LoggerEager.getInstance().hashCode());

        loggerEagerObject.writeToFile("file/abc/");
    }
}
