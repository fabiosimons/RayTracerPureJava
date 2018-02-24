package Utility;

public class Color {
    float r, g, b;

    public Color(){
        setR(0.0f);
        setG(0.0f);
        setB(0.0f);
    }
    public Color(float r, float g, float b){
        setR(r);
        setG(g);
        setB(b);
    }
    public Color(Color color){
        setR(color.r);
        setG(color.g);
        setB(color.b);
    }
    public void add(Color color){
        this.r += color.getR();
        this.g += color.getG();
        this.b += color.getB();
    }
    public void divide(int divide){
        this.r /= divide;
        this.g /= divide;
        this.b /= divide;
    }
    public int toInt(){
        int rgb = (int)getR();
        rgb = (rgb << 8) + (int)getG();
        rgb = (rgb << 8) + (int)getB();
        return rgb;
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setG(float g) {
        this.g = g;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getR(){
        return this.r;
    }
    public float getG(){
        return this.g;
    }
    public float getB(){
        return this.b;
    }
}
