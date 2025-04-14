package structuralPattern.bridgePattern.uiFrameworkDesign.solution;

interface PlatformRenderer {
    void render(String componentType, String action);
}

class MacOSRenderer implements PlatformRenderer {
    public void render(String componentType, String action) {
        System.out.println("Rendering " + componentType + " on macOS: " + action);
    }
}

class WindowsRenderer implements PlatformRenderer {
    public void render(String componentType, String action) {
        System.out.println("Rendering " + componentType + " on Windows: " + action);
    }
}

class LinuxRenderer implements PlatformRenderer {
    public void render(String componentType, String action) {
        System.out.println("Rendering " + componentType + " on Linux: " + action);
    }
}

abstract class UIComponent {
    protected PlatformRenderer renderer;
    protected String componentType;

    UIComponent(PlatformRenderer renderer, String componentType) {
        this.renderer = renderer;
        this.componentType = componentType;
    }

    abstract void onClick();

    abstract void onSelect();
}

class Button extends UIComponent {
    Button(PlatformRenderer renderer) {
        super(renderer, "Button");
    }

    public void onClick() {
        renderer.render(componentType, "clicked");
    }

    public void onSelect() {
        renderer.render(componentType, "selected");
    }
}

class Dropdown extends UIComponent {
    Dropdown(PlatformRenderer renderer) {
        super(renderer, "Dropdown");
    }

    public void onClick() {
        renderer.render(componentType, "clicked - showing options");
    }

    public void onSelect() {
        renderer.render(componentType, "option selected");
    }
}

class Textbox extends UIComponent {
    Textbox(PlatformRenderer renderer) {
        super(renderer, "Textbox");
    }

    public void onClick() {
        renderer.render(componentType, "clicked - focusing input");
    }

    public void onSelect() {
        renderer.render(componentType, "text selected");
    }
}

public class UIFramework {
    public static void main(String[] args) {
        // Create platform renderers
        PlatformRenderer mac = new MacOSRenderer();
        PlatformRenderer windows = new WindowsRenderer();
        PlatformRenderer linux = new LinuxRenderer();

        // Create components with different renderers
        UIComponent macButton = new Button(mac);
        UIComponent windowsTextbox = new Textbox(windows);
        UIComponent linuxDropdown = new Dropdown(linux);

        // Test interactions
        macButton.onClick();
        macButton.onSelect();

        windowsTextbox.onClick();
        windowsTextbox.onSelect();

        linuxDropdown.onClick();
        linuxDropdown.onSelect();
    }
}
