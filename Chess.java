package hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Chess {
	static List<String> queenRoutes = new ArrayList<String>();
	static List<String> leftRoutes = new ArrayList<String>();
	static List<String> rightRoutes = new ArrayList<String>();
	static Map<String, List<String>> roles = new HashMap<String, List<String>>();

	public Chess() {
		queenRoutes.add("N");
		queenRoutes.add("S");
		queenRoutes.add("W");
		queenRoutes.add("E");
		queenRoutes.add("NW");
		queenRoutes.add("NE");
		queenRoutes.add("SE");
		queenRoutes.add("SW");

		leftRoutes.add("NW");
		leftRoutes.add("SW");
		leftRoutes.add("W");

		rightRoutes.add("NE");
		rightRoutes.add("SE");
		rightRoutes.add("E");

		roles.put("QUEEN", queenRoutes);
	}

	public static void main(String[] args) {
		Chess chess = new Chess();
		Cell cell = new Cell(3, 2);
		System.out.println(cell);
		/*
		 * Scanner s = new Scanner(System.in); while (s.hasNextLine()) { String
		 * name = s.nextLine(); Cell cell1 = moveCell(cell, name);
		 * System.out.println(cell1); }
		 */

		String role = "QUEEN";
		int limit = 4;
		getPossibleMoves(cell, role, limit);
	}

	public static boolean checkSubOrdinates(Cell cell, int limit) {
		if (cell.getX() < 1 || cell.getY() > limit) {
			return false;
		}
		return true;
	}

	private static void getPossibleMoves(Cell cell, String role, int limit) {
		switch (role) {
		case "QUEEN":
			Cell newCell = cell;
			List<String> directionList = roles.get(role);
			for (String direction : directionList) {
				if (direction.equals("SW")) {
					while (newCell.getX() != limit && newCell.getY() > 1) {
						newCell = moveCell(newCell, direction, limit);
					}
				} else if (direction.equals("NW")) {
					while (newCell.getX() > 1 && newCell.getY() > 1) {
						newCell = moveCell(newCell, direction, limit);
					}
				} else if (direction.equals("W")) {
					while (newCell.getY() > 1) {
						newCell = moveCell(newCell, direction, limit);
					}
				} else if (direction.equals("SE")) {
					while (newCell.getX() < limit && newCell.getY() < limit) {
						newCell = moveCell(newCell, direction, limit);
					}
				} else if (direction.equals("NE")) {
					while (newCell.getX() > 1 && newCell.getY() != limit) {
						newCell = moveCell(newCell, direction, limit);
					}
				} else if (direction.equals("E")) {
					while (newCell.getY() != limit) {
						newCell = moveCell(newCell, direction, limit);
					}
				} else if (direction.contains("N")) {
					while (newCell.getX() > 1) {
						newCell = moveCell(newCell, direction, limit);
					}
				} else if (direction.contains("S")) {
					while (newCell.getX() != limit) {
						newCell = moveCell(newCell, direction, limit);
					}
				}
				newCell = cell;
			}
			break;
		default:
			break;
		}
	}

	private static Cell moveCell(Cell cell, String name, int limit) {
		Cell newCell = null;
		switch (name) {
		case "N":
			newCell = new Cell((cell.getX() - 1), cell.getY());
			break;
		case "S":
			newCell = new Cell((cell.getX() + 1), cell.getY());
			break;
		case "W":
			newCell = new Cell(cell.getX(), (cell.getY() - 1));
			break;
		case "E":
			newCell = new Cell(cell.getX(), (cell.getY() + 1));
			break;
		case "NW":
			newCell = new Cell((cell.getX() - 1), (cell.getY() - 1));
			break;
		case "NE":
			newCell = new Cell((cell.getX() - 1), (cell.getY() + 1));
			break;
		case "SW":
			newCell = new Cell((cell.getX() + 1), (cell.getY() - 1));
			break;
		case "SE":
			newCell = new Cell((cell.getX() + 1), (cell.getY() + 1));
			break;
		default:
			break;
		}
		System.out.println(newCell);
		return newCell;
	}
}

class Cell {
	private int x;
	private int y;

	public Cell(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Cell [x=" + x + ", y=" + y + "]";
	}

}
