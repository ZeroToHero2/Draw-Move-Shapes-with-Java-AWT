
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver{

	public static void main(String[] args) {

		ArrayList<Shape> shapes = new ArrayList<Shape>();
		ArrayList<ShapeGroup> shapegroupList = new ArrayList<ShapeGroup>();
		shapegroupList.add(0, new ShapeGroup());

		DrawingTool window = new DrawingTool(shapes); // shapegroupList.get(0)

		Scanner scan = new Scanner(System.in);
		String userCommand = "";

		while (!userCommand.equalsIgnoreCase("exit")) {
			System.out.print("Enter the command: ");
			userCommand = scan.nextLine().trim();

			String[] parameters = userCommand.split(" ");
			String command = parameters[0];

			if (command.equals("addR")) {
				Shape r1 = new Rectangle(Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]),
				Integer.parseInt(parameters[3]), Integer.parseInt(parameters[4]));
				shapegroupList.get(0).addShape(r1);// shapes.add(r1);
				System.out.println(r1);

			} else if (command.equals("addS")) {
				Shape s1 = new Square(Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]),
				Integer.parseInt(parameters[3]));
				shapegroupList.get(0).addShape(s1);// shapes.add(s1); shapegroupList.get(0).addShape(s1);
				System.out.println(s1);
			} else if (command.equals("addC")) {
				Shape c1 = new Circle(Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]),
				Integer.parseInt(parameters[3]));
				shapegroupList.get(0).addShape(c1);// shapes.add(c1);
				System.out.println(c1);
			} else if (command.equals("move")) {
				// Read parameters
				int shapeNo = Integer.parseInt(parameters[1]);
				int x = Integer.parseInt(parameters[2]);
				int y = Integer.parseInt(parameters[3]);
				Movable sm = shapegroupList.get(0).getShape(shapeNo - 1);
				sm.move(x, y);

				System.out.println(sm);

			} else if (command.equals("createEmptyGroup")) {
				shapegroupList.add(new ShapeGroup());
				System.out.println("New Group Added.");

			} else if (command.equals("addToGroup")) {
				int groupno = Integer.parseInt(parameters[1]);
				int shapeno = Integer.parseInt(parameters[2]);
				Shape removedshape = shapegroupList.get(0).removeShape(shapeno - 1);
				shapegroupList.get(groupno).addShape(removedshape);
				System.out.println(shapegroupList.get(groupno).toString());

			} else if (command.equals("moveGroup")) {
				int groupno = Integer.parseInt(parameters[1]);
				int newx = Integer.parseInt(parameters[2]);
				int newy = Integer.parseInt(parameters[3]);
				shapegroupList.get(groupno).moveGroup(newx, newy);
				System.out.println(shapegroupList.get(groupno).toString());

			} else if (command.equals("switchGroup")) {// change sides
				int prevGroupNo = Integer.parseInt(parameters[1]);
				int newGroupNo = Integer.parseInt(parameters[2]);
				int shapeNo = Integer.parseInt(parameters[3]);
				shapegroupList.get(prevGroupNo).switchGroup(shapegroupList.get(newGroupNo));
				System.out.println(shapegroupList.get(prevGroupNo).toString());
				System.out.println(shapegroupList.get(newGroupNo).toString());
			} else if (command.equals("mergeGroup")) {// divide one group into pieces
				int firstGroup = Integer.parseInt(parameters[1]);
				int secondGroup = Integer.parseInt(parameters[2]);
				if (firstGroup > secondGroup) {
					shapegroupList.get(secondGroup).mergeGroup(shapegroupList.get(firstGroup));
					shapegroupList.remove(secondGroup);
				} else {
					shapegroupList.get(firstGroup).mergeGroup(shapegroupList.get(secondGroup));
					shapegroupList.remove(firstGroup);
				}
			}

			window.repaint();

		}
		scan.close();
		System.exit(0);
	}

}
