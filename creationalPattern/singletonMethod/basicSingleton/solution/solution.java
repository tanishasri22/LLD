package creationalPattern.singletonMethod.basicSingleton.solution;

// Lazy Initialization Singleton with Double-Checked Locking
class CardManufacturingSingletonLazy {

    private static volatile CardManufacturingSingletonLazy config;
    private String apiKey;
    private String dataBaseUrl;

    // Private constructor to prevent instantiation
    private CardManufacturingSingletonLazy() {
    }

    // Lazy Initialization with Thread Safety (Double-Checked Locking)
    public static CardManufacturingSingletonLazy getInstance() {
        if (config == null) {
            synchronized (CardManufacturingSingletonLazy.class) {
                if (config == null) { // Double-Check
                    config = new CardManufacturingSingletonLazy();
                }
            }
        }
        return config;
    }

    // Setter and Getter methods
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setDataBaseUrl(String dataBaseUrl) {
        this.dataBaseUrl = dataBaseUrl;
    }

    public String getDataBaseUrl() {
        return dataBaseUrl;
    }
}

// Eager Initialization Singleton
class CardManufacturingSingletonEager {

    // Instance created at class loading time
    private static final CardManufacturingSingletonEager INSTANCE = new CardManufacturingSingletonEager();

    private String apiKey;
    private String dataBaseUrl;

    // Private constructor to prevent instantiation
    private CardManufacturingSingletonEager() {
    }

    // Public method to get the instance
    public static CardManufacturingSingletonEager getInstance() {
        return INSTANCE;
    }

    // Setter and Getter methods
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setDataBaseUrl(String dataBaseUrl) {
        this.dataBaseUrl = dataBaseUrl;
    }

    public String getDataBaseUrl() {
        return dataBaseUrl;
    }
}

// Driver Class
public class solution {
    public static void main(String[] args) {
        CardManufacturingSingletonLazy object = CardManufacturingSingletonLazy.getInstance();

        // Checking singleton instance hash codes
        System.out.println(CardManufacturingSingletonLazy.getInstance().hashCode());
        System.out.println(CardManufacturingSingletonLazy.getInstance().hashCode());

        // Setting and getting API key
        object.setApiKey("xxxx3212ddss");
        System.out.println(object.getApiKey());

        // Setting and getting Database URL
        object.setDataBaseUrl("http://localhost");
        System.out.println(object.getDataBaseUrl());
    }
}
