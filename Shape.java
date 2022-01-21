
import java.awt.*;
import java.util.ArrayList;

public abstract class Shape implements Movable {

	protected Point leftTop;
	protected boolean isCircular;
	ArrayList<Point> points = new ArrayList<Point>();
	protected double area;
	protected double perimeter;

	public void calculatePoints() {

	}

	public double calculateArea() {
		return 1;
	}

	public double calculatePerimeter() {
		return 1;
	}

	public String toString() {

		return "";
	}

	public void move(int newx, int newy) {
	}
}
