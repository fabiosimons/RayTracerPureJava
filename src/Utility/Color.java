package Utility;

public class Color {
    public float r,g,b;

    public Color(){  // DEFAULT CONSTRUCTOR THE CREATES THE COLOR BLACK
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
        setR(color.getR());
        setG(color.getG());
        setB(color.getB());
    }
    public int toInteger(){
        int r = Math.round(255* getR());
        int g = Math.round(255* getG());
        int b = Math.round(255* getB());

        int rgb = r;
        rgb = (rgb << 8) + g;
        rgb = (rgb << 8) + b;

        return rgb;
    }

    // SETTERS AND GETTERS
    public float getR(){
        return this.r;
    }
    public float getG(){
        return this.r;
    }
    public float getB() {
        return this.b;
    }
    public void setR(float r){
        this.r = r;
    }
    public void setG(float g){
        this.g = g;
    }
    public void setB(float b){
        this.b = b;
    }
}
