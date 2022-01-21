
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class ShapeGroup {
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	Point leftTop;

	public ShapeGroup() {

	}

	public void addShape(Shape newShape) {

		shapes.add(newShape);
		findLeftTop();
	}

	public Shape removeShape(int index) {
		Shape removedshape = shapes.get(index);
		shapes.remove(index);
		findLeftTop();
		return removedshape;
	}

	public void moveGroup(int newx, int newy) {
		// int distancex = (int) leftTop.getX()-newx;
		// int distancey = newy - (int) leftTop.getY();
		// leftTop.setLocation(newx, newy);

		for (int a = 0; a < shapes.size(); a++) {
			int distancex = (int) leftTop.getX() - (int) shapes.get(a).leftTop.getX();
			int distancey = (int) shapes.get(a).leftTop.getY() - (int) leftTop.getY();// (int) leftTop.getY() - (int)
																						// shapes.get(a).leftTop.getY();

			shapes.get(a).move(newx + distancex, newy + distancey);

		}
		leftTop.setLocation(newx, newy);

	}

	public Shape getShape(int index) {

		Shape returned = shapes.get(index);

		return returned;
	}

	public void findLeftTop() {
		Point acceptedp = shapes.get(0).leftTop;
		for (int a = 1; a < shapes.size(); a++) {
			if (shapes.get(a).leftTop.getX() < acceptedp.getX()) {
				acceptedp.x = (int) shapes.get(a).leftTop.getX();

			}
			if (shapes.get(a).leftTop.getY() < acceptedp.getY()) {
				acceptedp.y = (int) shapes.get(a).leftTop.getY();

			}

		}
		leftTop = acceptedp;
	}

	public ArrayList<Shape> getGroup() {
		return shapes;

	}

	public void switchGroup(ShapeGroup newgroup) {
		ArrayList<Shape> shapeArray = new ArrayList<Shape>();
		// shapeArray = (ArrayList<Shape>) this.shapes.clone();
		// this.shapes = (ArrayList<Shape>) newgroup.shapes.clone();
		// newgroup.shapes = (ArrayList<Shape>) shapeArray.clone();
		for (int a = 0; a < this.shapes.size(); a++) {
			shapeArray.add(this.shapes.get(a));
		}
		for (int a = 0; a < newgroup.shapes.size(); a++) {
			this.shapes.add(newgroup.shapes.get(a));
		}
		for (int a = 0; a < shapeArray.size(); a++) {
			newgroup.shapes.add(shapeArray.get(a));
		}
		// Collections.copy(shapeArray, this.shapes);
		// Collections.copy(this.shapes, newgroup.shapes);B
		// Collections.copy(newgroup.shapes, shapeArray);
		findLeftTop();
		newgroup.findLeftTop();

	}

	public void mergeGroup(ShapeGroup shapegroup1) {
		this.shapes.addAll(shapegroup1.shapes);
		findLeftTop();

	}

	public String toString() {
		String result = "";
		result += "Left Top Point: x: " + (int) this.leftTop.getX() + ", y: " + (int) this.leftTop.getY();
		for (Shape shape : shapes) {
			result += "\nShape " + (shapes.indexOf(shape) + 1) + ";\n";
			result += shape.toString();
		}
		return result;
	}

}
