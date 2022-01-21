 
import java.awt.Point;

public class Rectangle extends Shape {
	private int height;
	private int width;
	private Point leftbottom;
	private Point righttop;
	private Point rightbottom;

	public Rectangle(int x, int y, int height, int width) {
		this.height = height;
		this.width = width;
		leftTop = new Point(x, y);
		calculatePoints();
		points.add(leftTop);
		points.add(righttop);
		points.add(rightbottom);
		points.add(leftbottom);
		isCircular = false;
	}

	public void calculatePoints() {
		points.clear();
		int x = (int) leftTop.getX();
		int y = (int) leftTop.getY();
		leftbottom = new Point(x, y + height);

		righttop = new Point(x + width, y);
		rightbottom = new Point(x + width, y + height);
		points.add(leftTop);
		points.add(righttop);
		points.add(rightbottom);
		points.add(leftbottom);

	}

	public double calculateArea() {
		return height * width;
	}

	public double calculatePerimeter() {
		return 2 * (height + width);
	}

	public void move(int newx, int newy) {
		leftTop.setLocation(newx, newy);
		calculatePoints();

	}

	public String toString() {
		String result = "Rectangle[h=" + height + ",w=" + width + "]\nPoints[ (" + (int) leftTop.getX() + ","
				+ (int) leftTop.getY() + ") (" + (int) righttop.getX() + "," + (int) righttop.getY() + ") ("
				+ (int) rightbottom.getX() + "," + (int) rightbottom.getY() + ") (" + (int) leftbottom.getX() + ","
				+ (int) leftbottom.getY() + ")" + " ]\nArea=" + String.format("%.1f", calculateArea()) + "\nPerimeter="
				+ String.format("%.1f", calculatePerimeter());

		return result;

	}
}
