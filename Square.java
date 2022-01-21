
import java.awt.Point;

public class Square extends Shape {
	private int edge;
	private Point leftbottom;
	private Point righttop;
	private Point rightbottom;

	public Square(int x, int y, int edge) {
		this.edge = edge;
		leftTop = new Point(x, y);
		calculatePoints();

		isCircular = false;
	}

	public void calculatePoints() {
		points.clear();
		int x = (int) leftTop.getX();
		int y = (int) leftTop.getY();
		leftbottom = new Point(x, y + edge);
		righttop = new Point(x + edge, y);
		rightbottom = new Point(x + edge, y + edge);
		points.add(leftTop);
		points.add(righttop);
		points.add(rightbottom);
		points.add(leftbottom);
	}
	

	public double calculateArea() {
		return edge * edge;
	}

	public double calculatePerimeter() {
		return 2 * (edge + edge);
	}

	public void move(int newx, int newy) {
		leftTop.setLocation(newx, newy);
		calculatePoints();

	}

	public String toString() {
		String result = "Square[e=" + edge + "]\nPoints[ (" + (int) leftTop.getX() + "," + (int) leftTop.getY() + ") ("
				+ (int) righttop.getX() + "," + (int) righttop.getY() + ") (" + (int) rightbottom.getX() + ","
				+ (int) rightbottom.getY() + ") (" + (int) leftbottom.getX() + "," + (int) leftbottom.getY() + ")"
				+ " ]\nArea=" + String.format("%.1f", calculateArea()) + "\nPerimeter="
				+ String.format("%.1f", calculatePerimeter());

		return result;

	}
}
