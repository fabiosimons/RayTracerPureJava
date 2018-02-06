package World;

public class ViewPlane {
    public int m_horizontalRes;   // HORIZONTAL IMAGE RESOLUTION
    public int m_VerticalRes;   // VERTICAL IMAGE RESOLUTION
    public float m_pixelSize;  // size of pixel

    public ViewPlane(int horizontal, int vertical, float pixelSize){
        setHorizontalRes(horizontal);
        setVerticalRes(vertical);
        setPixelSize(pixelSize);
    }
    public void setHorizontalRes(int horizontalRes){
        m_horizontalRes = horizontalRes;
    }
    public void setVerticalRes(int verticalRes){
        m_VerticalRes = verticalRes;
    }
    public void setPixelSize(float pixelSize){
        m_pixelSize = pixelSize;
    }
    public int getHorizontalRes(){
        return m_horizontalRes;
    }
    public int getVerticalRes(){
        return m_VerticalRes;
    }
    public float getPixelSize(){
        return this.m_pixelSize;
    }
}
