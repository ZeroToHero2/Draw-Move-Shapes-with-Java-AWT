
import java.awt.Point;
import java.util.Arrays;

public class Circle extends Shape {
	private int radius;
	private Point rightBottom;

	public Circle(int x, int y, int radius) {
		this.radius = radius;
		leftTop = new Point(x, y);
		calculatePoints();
		isCircular = true;
	}

	public double calculateArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	public double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}

	public void calculatePoints() {
		points.clear();
		int x = (int) leftTop.getX();
		int y = (int) leftTop.getY();
		rightBottom = new Point(x + 2 * radius, y + 2 * radius);
		points.add(leftTop);
		points.add(rightBottom);
	}

	public void move(int newx, int newy) {
		leftTop.setLocation(newx, newy);
		calculatePoints();
	}

	public String toString() {

		String result = "Circle[r=" + radius + "]\nPoints[ (" + (int) leftTop.getX() + "," + (int) leftTop.getY()
				+ ") (" + (int) rightBottom.getX() + "," + (int) rightBottom.getY() + ")" + " ]\nArea="
				+ String.format("%.1f", calculateArea()) + "\nPerimeter=" + String.format("%.1f", calculatePerimeter());

		return result;

	}
}
