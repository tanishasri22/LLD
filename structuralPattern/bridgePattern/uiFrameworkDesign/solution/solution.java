package structuralPattern.bridgePattern.uiFrameworkDesign.solution;

interface Platforms {
    void renderOnclick(String action, boolean onClickStatus);
    void renderOnselect(String action, boolean onSelectStatus);

}

class Window implements Platforms {
    public void renderOnclick(String action, boolean onClickStatus) {
        if(onClickStatus){
            System.out.println(action + "Windows performing action : ");
        }else{
            System.out.println("No actions performed by Windows since nothing clicked!");
        }
    }

    public void renderOnselect(String action, boolean onSelectStatus) {
        if (onSelectStatus) {
            System.out.println(action + "Windows performing action : ");
        } else {
            System.out.println("No actions performed since nothing selected!");
        }
    }
}

class Linux implements Platforms {
    public void renderOnclick(String action, boolean onClickStatus) {
        if (onClickStatus) {
            System.out.println(action + "Linux performing action.");
        } else {
            System.out.println("No actions performed by Linux since nothing clicked!");
        }
    }

    public void renderOnselect(String action, boolean onSelectStatus) {
        if (onSelectStatus) {
            System.out.println(action + "Linux performing action.");
        } else {
            System.out.println("No actions performed since nothing selected!");
        }
    }
}

class MacOS implements Platforms {
    public void renderOnclick(String action, boolean onClickStatus) {
        if (onClickStatus) {
            System.out.println(action + "MacOS performing action.");
        } else {
            System.out.println("No actions performed by MacOS since nothing clicked!");
        }
    }

    public void renderOnselect(String action, boolean onSelectStatus) {
        if (onSelectStatus) {
            System.out.println(action +"MacOS performing action : ");
        } else {
            System.out.println("No actions performed since nothing selected!");
        }
    }
}

abstract class UIComponent {
    protected boolean onClickStatus;
    protected boolean onSelectStatus;
    protected Platforms platform;

    UIComponent(Platforms plt){
        this.platform = plt;
        onClickStatus = false;
        onSelectStatus = false;
    }

    abstract void onClick();
    abstract void onSelect();
}

class Button extends UIComponent{

    Button(Platforms platforms){
        super(platforms);
    }

    void onClick(){
        this.onClickStatus = true;
        platform.renderOnclick("[Button clicked]: ", onClickStatus);
    }

    void onSelect(){
        this.onSelectStatus = true;
        throw new IllegalAccessError("button can't be selected");
    }

}

class Dropdown extends UIComponent{
    Dropdown(Platforms platforms){
        super(platforms);
    }

    void onClick() {
        this.onClickStatus = true;
        throw new IllegalAccessError("dropdown can't be clicked");
    }

    void onSelect() {
        this.onSelectStatus = true;
        platform.renderOnselect("[Dropdown selected]: ", onSelectStatus);
    }
}

class Textbox extends UIComponent{
    Textbox(Platforms platforms){
        super(platforms);
    }

    void onClick() {
        this.onClickStatus = true;
        platform.renderOnclick("[Textbox clicked]: ", onClickStatus);
    }

    void onSelect() {
        this.onSelectStatus = true;
        platform.renderOnselect("[Textbox selected]: ", onSelectStatus);
    }

}



public class solution {
    public static void main(String[] args) {

        Platforms linux = new MacOS();
        UIComponent textbox = new Textbox(linux);
        textbox.onClick();
        textbox.onSelect();
        
        Platforms macOS = new MacOS();
        UIComponent dropdown = new Dropdown(macOS);
        dropdown.onSelect();
        // dropdown.onClick();
    }
}
