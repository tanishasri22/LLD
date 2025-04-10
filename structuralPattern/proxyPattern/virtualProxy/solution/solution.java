package structuralPattern.proxyPattern.virtualProxy.solution;

interface Image{
    void display();
}

class HighResolutionImage implements Image{
    private String filePath;
    HighResolutionImage(String filepath){
        this.filePath = filepath;

    }
    public void loadImage(){
        System.out.println("Loading image from disk from file : " + filePath);
    }

    public void display(){
        System.out.println("Displaying image : " + filePath);
    }
}

class ProxyImage implements Image{
    HighResolutionImage highResolutionImage;
    private String filePath;
    ProxyImage(String filePath){
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void display(){
        System.out.println("Loading image "+ filePath);
        if(highResolutionImage == null){
            highResolutionImage = new HighResolutionImage(filePath);
        }
        highResolutionImage.display();
    }
}

public class solution {
    public static void main(String[] args) {
        ProxyImage img1 = new ProxyImage("img1.jpg");

        System.out.println("Image not loaded yet but object created of image!");
        img1.display();
        System.out.println("Image loaded : " + img1.getFilePath());
    }
}
