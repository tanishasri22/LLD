package creationalPattern.factory.abstractMethod.crossPlatformUILibrary.solution;

public class CrossPlatformUI {

    interface Button {
        void printButton();
    }

    interface CheckBox {
        void printCheckBox();
    }

    // MacOS Implementations
    static class MacButton implements Button {
        public void printButton() {
            System.out.println("Printing the button: " + this.getClass().getSimpleName());
        }
    }

    static class MacCheckBox implements CheckBox {
        public void printCheckBox() {
            System.out.println("Printing the checkBox: " + this.getClass().getSimpleName());
        }
    }

    // Windows Implementations
    static class WindowButton implements Button {
        public void printButton() {
            System.out.println("Printing the button: " + this.getClass().getSimpleName());
        }
    }

    static class WindowCheckBox implements CheckBox {
        public void printCheckBox() {
            System.out.println("Printing the checkBox: " + this.getClass().getSimpleName());
        }
    }

    // Linux Implementations
    static class LinuxButton implements Button {
        public void printButton() {
            System.out.println("Printing the button: " + this.getClass().getSimpleName());
        }
    }

    static class LinuxCheckBox implements CheckBox {
        public void printCheckBox() {
            System.out.println("Printing the checkBox: " + this.getClass().getSimpleName());
        }
    }

    // Abstract Factory Interface
    interface GuiFactory {
        Button createButton(); // Fixed method name

        CheckBox createCheckbox();
    }

    // Concrete Factory for MacOS
    static class MacOsGuiFactory implements GuiFactory {
        public Button createButton() {
            return new MacButton();
        }

        public CheckBox createCheckbox() {
            return new MacCheckBox();
        }
    }

    // Concrete Factory for Windows
    static class WindowOsGuiFactory implements GuiFactory {
        public Button createButton() {
            return new WindowButton();
        }

        public CheckBox createCheckbox() {
            return new WindowCheckBox();
        }
    }

    // Concrete Factory for Linux
    static class LinuxOsGuiFactory implements GuiFactory {
        public Button createButton() {
            return new LinuxButton();
        }

        public CheckBox createCheckbox() {
            return new LinuxCheckBox();
        }
    }

    // Client Code
    public static void main(String[] args) {
        GuiFactory factory = new MacOsGuiFactory(); // Using MacOS Factory
        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckbox();

        button.printButton();
        checkBox.printCheckBox();
    }
}
