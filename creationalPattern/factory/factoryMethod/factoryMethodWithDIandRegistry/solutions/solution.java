package creationalPattern.factory.factoryMethod.factoryMethodWithDIandRegistry.solutions;

import java.util.*;

interface Analytics {
    void trackEvent(String event);
}

class GoogleAnalytics implements Analytics {
    public void trackEvent(String event) {
        System.out.println("Tracking " + event + " in " + this.getClass().getSimpleName());
    }
}

class Mixpanel implements Analytics {
    public void trackEvent(String event) {
        System.out.println("Tracking " + event + " in " + this.getClass().getSimpleName());
    }
}

class Segment implements Analytics {
    public void trackEvent(String event) {
        System.out.println("Tracking " + event + " in " + this.getClass().getSimpleName());
    }
}

abstract class AnalyticsFactory {
    // All factory instances share the same map(static), and the map itself cannot be
    // reassigned(final). Best for shared caching.
    private static final HashMap<String, Analytics> map = new HashMap<>();

    protected Analytics registeredAnalytics(String key, Analytics value) {
        return map.putIfAbsent(key, value) == null ? value : map.get(key);
    }

    abstract Analytics createAnalytics();
}

class GoogleAnalyticsFactory extends AnalyticsFactory {
    public Analytics createAnalytics() {
        return registeredAnalytics("GoogleAnalytics", new GoogleAnalytics());
    }
}

class MixpanelFactory extends AnalyticsFactory {
    public Analytics createAnalytics() {
        return registeredAnalytics("Mixpanel", new Mixpanel());
    }
}

class SegmentFactory extends AnalyticsFactory {
    public Analytics createAnalytics() {
        return registeredAnalytics("Segment", new Segment());
    }
}

public class solution {
    public static void main(String[] args) {
        AnalyticsFactory factory1 = new GoogleAnalyticsFactory();
        Analytics analytics1 = factory1.createAnalytics();
        analytics1.trackEvent("GOOGLE DATA");
        System.out.println();

        AnalyticsFactory factory2 = new GoogleAnalyticsFactory();
        Analytics analytics2 = factory2.createAnalytics();
        analytics2.trackEvent("AMAZON DATA");
        System.out.println();

        AnalyticsFactory factory3 = new MixpanelFactory();
        Analytics analytics3 = factory3.createAnalytics();
        analytics3.trackEvent("MIXPANEL DATA");
    }
}
