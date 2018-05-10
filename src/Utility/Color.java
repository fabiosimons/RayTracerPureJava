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
    public Color(int rgb){
        fromInt(rgb);
    }
    public Color multiplyWithDouble(double x){
        float r = this.r * (float) x;
        float g = this.g * (float) x;
        float b = this.b * (float) x;

        return new Color(r,g,b);
    }
    public void add(Color color){
        this.r += color.getR();
        this.g += color.getG();
        this.b += color.getB();
    }
    public Color plus(Color color){
        return new Color(this.r + color.r,
        this.g + color.g,
        this.b + color.b);
    }
    public void divide(int divide){
        this.r /= divide;
        this.g /= divide;
        this.b /= divide;
    }
    public void convertTo255(){
        this.r *= 255.0f;
        this.g *= 255.0f;
        this.b *= 255.0f;
    }
    public int toInt(){
        int rgb = (int)getR();
        rgb = (rgb << 8) + (int)getG();
        rgb = (rgb << 8) + (int)getB();
        return rgb;
    }
    public Color multiply(Color c){
        float r = getR() * c.getR();
        float g = getG() * c.getG();
        float b = getB() * c.getB();
        return new Color(r,g,b);
    }
    public void fromInt(int rgb) {
        this.r = (rgb >> 16 & 0xff) / 255;
        this.g = (rgb >> 8 & 0xff) / 255;
        this.b = (rgb >> 0 & 0xff) / 255;
    }
    public String toString(){
        return "R : " + getR() + ", G: " + getG() + ", B : " + getB();
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
