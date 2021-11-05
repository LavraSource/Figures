package com.company;

public class Main {

    public static void main(String[] args) {

    }
}
interface Moveable{
    void move(float dx,float dy);
    void resize(float koeff);
}
abstract class Figure{
    float x,y;
    abstract float getArea();
    abstract float getPerimeter();
    public Figure(float x, float y){
        this.x=x;
        this.y=y;
    }
}
class Ellipse extends Figure implements Moveable{
    float radiusx,radiusy;
    float getArea(){
        return (float) (radiusx*Math.PI*radiusx)*(radiusx/radiusy);

    }
    float getPerimeter(){
        return (float) (radiusx*Math.PI*2)*(radiusx/radiusy);
    }
    public Ellipse(float x, float y,float radiusx,float radiusy){
        super(x,y);
        this.radiusx=radiusx;
        this.radiusy=radiusy;
    }

    public void move(float dx, float dy) {
        x+=dx;
        y+=dy;
    }

    public void resize(float koeff) {
        radiusx*=koeff;
        radiusy*=koeff;
    }
    @Override
    public String toString(){
        return String.format("Ellipse\n" +
                "Center: (%.1f, %.1f)\n" +
                "Radius X: %.1f\n"+"Radius Y: %.1f",x,y,radiusx,radiusy);
    }
}
class Circle extends Ellipse{
    @Override
    float getArea(){
        return (float) (radiusx*Math.PI*radiusx);

    }
    @Override
    float getPerimeter(){
        return (float) (radiusx*Math.PI*2);
    }
    public Circle(float x, float y,float radius){
        super(x,y,radius,radius);
    }
    @Override
    public void resize(float koeff) {
        radiusx*=koeff;
    }
    @Override
    public String toString(){
        return String.format("Circle\n" +
                "Center: (%.1f, %.1f)\n" +
                "Radius: %.1f",x,y,radiusx);
    }
}
class Rectangle extends Figure implements Moveable{
    float width, height;
    float getArea(){
        return width * height;
    }
    float getPerimeter(){
        return width *2+ height *2;
    }
    public Rectangle(float x, float y,float a,float b){
        super(x,y);
        width=a;
        height=b;
    }
    public void move(float dx, float dy) {
        x+=dx;
        y+=dy;
    }

    public void resize(float koeff) {
        width*=koeff;
        height*=koeff;
    }
    @Override
    public String toString(){
        return String.format("Rectangle\n" +
                "Center: (%.1f, %.1f)\n" +
                "Height: %.1f\n" +
                "Width: %.1f",x+width/2,y+height/2,height,width);
    }
}
class Square extends Rectangle{

    public Square(float x, float y,float a){
        super(x,y,a,a);
    }
    @Override
    public void resize(float koeff) {
        width*=koeff;
        height*=koeff;
    }
    @Override
    public String toString(){
        return String.format("Square\n" +
                    "Center: (%.1f, %.1f)\n" +
                    "Side: %.1f\n",x+width/2,y+width/2,width);
    }
}