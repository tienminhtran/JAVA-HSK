
public class MyDate {
	private int day;
	private int month;
	private int year;

	public MyDate(int d, int m, int y) {
		if (d >= 1 && d <= 31) {
			this.day = d;
		}
		else {
			this.day = 1; // hạn chế cố định ng dùng nhập sai sẽ trả về ngày 1.
		}
		if (month >= 1 && month <= 12) {
			this.month = m;
		} else {
			this.month = 1;
		}
		if (year >= 1) {
			this.year = y;
		} else {
			this.year = 1;
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int d) {
		if (d >= 1 && d <= 31)
			this.day = d;
	}

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int m) {
		if (m >= 1 && m <= 12)
			this.month = m;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int y) {
		if (year >= 1)
			this.year = y;
	}

}