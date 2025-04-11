package structuralPattern.proxyPattern.protectionProxy.solution;

import java.nio.file.AccessDeniedException;

interface Document {
    void read();
    void write(String content) throws AccessDeniedException;
}

class OriginalDocument implements Document{
    private String filePath;

    OriginalDocument(String filePath){
        this.filePath = filePath;
    }

    public void read(){
        System.out.println("Reading file at location: " + filePath);
    }

    public void write(String content){
        System.out.println("Writing at location: " + filePath + ", the content: "+ content);
    }
}

class ProxyDocument implements Document{
    private OriginalDocument originalDocument;
    String filePath;
    String userType;

    ProxyDocument(String userType, String filePath){
        this.filePath = filePath;
        this.userType = userType;
    }

    private void initializeIfNeeded() {
        if (originalDocument == null) {
            originalDocument = new OriginalDocument(filePath);
        }
    }

    public void read() {
        initializeIfNeeded();
        System.out.print(userType + " is ");
        originalDocument.read();
    }

    public void write(String content) throws AccessDeniedException{
        if(userType.equalsIgnoreCase("Viewer")) throw new AccessDeniedException(content);
        initializeIfNeeded();
        originalDocument.write(content + " by " + userType);
    }

}

public class solution {
    public static void main(String[] args) throws AccessDeniedException {
        ProxyDocument proxyDocumentByViewer = new ProxyDocument("Viewer", "C://");
        ProxyDocument proxyDocumentByAdmin = new ProxyDocument("Admin", "C://");

        proxyDocumentByAdmin.read();
        proxyDocumentByViewer.read();

        proxyDocumentByAdmin.write("this is the content written in C drive");
        proxyDocumentByViewer.write("this is the content written in C drive");
    }
}
