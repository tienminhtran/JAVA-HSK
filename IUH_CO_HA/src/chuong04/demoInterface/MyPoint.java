package chuong04.demoInterface;

public class MyPoint implements Moveable {
	private int x, y;

	public MyPoint() {
		x = 0;
		y = 0;
	}

	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
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

	public int[] getXY() {
		int[] xy = new int[2];
		xy[0] = x;
		xy[1] = y;
		return xy;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}

	/**
	 * 
	 * @return khoảng cách giữa điểm MyPoint và toạ độ gốc (0,0)
	 */
	public double distance() {
		// Math.sqrt((x-0)^2+(y-0)^2)
		return Math.sqrt(x * x + y * y);
	}

	public double distance(int x2, int y2) {
		return Math.sqrt((x2 - x) * (x2 - x) + (y2 - y) * (y2 - y));
	}

	public double distance(MyPoint p) {
		return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	
}
