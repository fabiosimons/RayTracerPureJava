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
        r += color.r;
        g += color.g;
        b += color.b;
    }
    public void divide(int divide){
        r /= divide;
        g /= divide;
        b /= divide;
    }
    public int toInt(){
        return (65536 * (int)getR() + 256 * (int)getG() + (int)getB());
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void setG(float g) {
        this.g = g;
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
