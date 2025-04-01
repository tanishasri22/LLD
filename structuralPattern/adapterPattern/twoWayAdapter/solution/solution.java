package structuralPattern.adapterPattern.twoWayAdapter.solution;

interface USB {
    void chargeViaUSB();
}

interface TypeC {
    void chargeViaTypeC();
}

class TypeCCompany implements TypeC{
    public void chargeViaTypeC(){
        System.out.println("Charging via " + this.getClass().getSimpleName());
    }
}

class TwoWayAdapter implements USB, TypeC{

    USB usb;
    TypeC typeC;

    TwoWayAdapter(){
        usb = new UsbCompany();
        typeC = new TypeCCompany();
    }

    public void chargeViaTypeC() {
        // Converting typeC charging to USB
        System.out.print("\nConverting typeC to USB ");
        usb.chargeViaUSB();
    }
    
    public void chargeViaUSB() {
        //Converting usb charging to typeC
        System.out.print("\nConverting USB to typeC ");
        typeC.chargeViaTypeC();
    }
}


class UsbCompany implements USB{
    public void chargeViaUSB(){
        System.out.println("Charging via " + this.getClass().getSimpleName());
    }
}


public class solution {
    public static void main(String[] args) {
        USB usbUser = new UsbCompany();
        usbUser.chargeViaUSB();

        //usb to typeC via adapter
        TwoWayAdapter adapter = new TwoWayAdapter();
        adapter.chargeViaUSB();

        TypeC typeCUser = new TypeCCompany();
        typeCUser.chargeViaTypeC();
        adapter.chargeViaTypeC();

    }
}
