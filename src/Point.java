	/**
	 * This class represents a point on a plane
	 * 
	 * 
	 * @author Carter Clark
	 */
public class Point {
	
	/**
	 * Instance Variables:
	 * integers x and y are coordinates for the point
	 * integer id is the unique identifier for a particular point
	 * idCounter will be used to increment id and give each object it's unique id
	 */
	private int x;
	private int y;
	private int id;
	private static int idCounter = 1;
	
	/**
	 * A constructor for class Point
	 * @param x, an integer for the x coordinate of the point
	 * @param y, an integer for the y coordinate of the point
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.id = idCounter++;
		
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
		return "Point: " + id
				+ "\nX coordinate = " + x
				+ "\nY coordinate = " + y
				+ "\n";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if(object instanceof Point) {
			return ((Point) object).id == this.id;
		}
		else {
			return false;
		}
	}
	
	

}
