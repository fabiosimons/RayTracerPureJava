package World;

public class ViewPlane {
    public int horizontalRes;   // HORIZONTAL IMAGE RESOLUTION
    public int verticalRes;   // VERTICAL IMAGE RESOLUTION
    public float pixelSize;  // size of pixel
    public int numOfSamples;
    public float gamma;

    public ViewPlane(int horizontal, int vertical, float pixelSize){
        setHorizontalRes(horizontal);
        setVerticalRes(vertical);
        setPixelSize(pixelSize);
    }
    public void setHorizontalRes(int horizontalRes){
        this.horizontalRes = horizontalRes;
    }
    public void setVerticalRes(int verticalRes){
        this.verticalRes = verticalRes;
    }
    public void setPixelSize(float pixelSize){
        this.pixelSize = pixelSize;
    }
    public int getHorizontalRes(){
        return this.horizontalRes;
    }
    public int getVerticalRes(){
        return this.verticalRes;
    }
    public float getPixelSize(){
        return this.pixelSize;
    }
}
