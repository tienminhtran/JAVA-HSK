package chuong03.caseStudy03;

public class PolyLine {
	private Point[] points;
	private int count;// số lượng pt hiện có trong mảng points

	/**
	 * 
	 * @param n kích thước mảng cần cấp phát cho points
	 */
	public PolyLine(int n) {
		points = new Point[n];
		count = 0;
	}

	/**
	 * thêm 1 phần tử vào mảng points
	 * 
	 * @param x
	 * @param y
	 * @throws Exception
	 */
	public void appendPoint(int x, int y) throws Exception {
		if (count < points.length)
			points[count++] = new Point(x, y);
		else {
			throw new Exception("Vượt quá kích thước mảng");
		}
	}

	public void appendPoint(Point p) throws Exception {
		if (count < points.length)
			points[count++] = p;
		else {
			throw new Exception("Vượt quá kích thước mảng");
		}
	}

	public int getLength() {
		return count;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < count; i++) {
			s += points[i];
		}

		return s;
	}
}
