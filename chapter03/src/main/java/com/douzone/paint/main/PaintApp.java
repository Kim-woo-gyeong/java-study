package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;
import com.douzone.paint.point.Point;

public class PaintApp {

	public static void main(String[] args) {
		Point point  = new Point(2, 5);
        /*point.setX(2);
        point.setY(5);*/
        
        draw(point); //인터페이스
        //drawPoint(point); // 추상클래스
        //point.show(); //
        
        Point point2 = new Point(10, 50);
        draw(point2);
        //drawPoint(point2);
        //point2.show(false);
        
        Point point3 = new ColorPoint(50, 100, "red");
        draw(point3);
        //drawPoint(point3);
        point3.show(false);
        point3.show(true);
        
        Rect rect = new Rect();
        //drawRect(rect); // 클래스
        //drawShape(rect); // 추상클래스
        draw(rect);// 인터페이스
        
        Triangle triangle = new Triangle();
        //drawShape(triangle);
        draw(triangle);
        
        Circle circle = new Circle();
        //drawShape(circle);
        draw(circle);
        
        draw(new GraphicText("hello")); //인터페이스
        
        /*------instanceof test---------*/
        System.out.println(circle instanceof Object);
        System.out.println(circle instanceof Shape);
        System.out.println(circle instanceof Circle);
        
        /*------클래스는  hierachy만 instanceof 연산자 사용 가능---------*/
        //System.out.println(circle instanceof Rect);  오류 상위나 하위는 가능 옆으로는 안됨
        Shape s = new Circle();
        System.out.println(s instanceof Rect);
        
        /*------interface test 인터페잇는 hierachy 상관없이 instanceof 연산자 사용 가능---------*/
        System.out.println(s instanceof Drawable);
        System.out.println(s instanceof Runnable); // Runnable은 내장 API
	}
	
	public static void draw(Drawable d)
	{
		d.draw();
	}
	public static void drawShape(Shape shape)
	{
		shape.draw();
	}
	public static void drawPoint(Point point)
	{
		point.show();
	}
	
	/*public static void drawRect(Rect rect)
	{
		rect.draw();
	}
	
	public static void drawTriangle(Triangle triangle)
	{
		triangle.draw();
	}*/
}
