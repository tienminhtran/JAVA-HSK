package CK.DE1;

import java.time.LocalDate;

public class Fresher extends Employee{
	private int gradYear;
	private LoaiTotNghiep gradRank;
	
	public Fresher(String iD, FullName fullName, LocalDate birthday, String phone, int gradYear,
			LoaiTotNghiep gradRank) {
		super(iD, fullName, birthday, phone);
		setGradYear(gradYear);
		this.gradRank = gradRank;
	}

	public int getGradYear() {
		return gradYear;
	}

	/**
	 * Nam tot nghiep phai truoc nam hien tai
	 * @param gradYear
	 */
	public void setGradYear(int gradYear) {
		if (gradYear <= LocalDate.now().getYear())
			this.gradYear = gradYear;
		else
			this.gradYear = LocalDate.now().getYear();
	}

	public LoaiTotNghiep getGradRank() {
		return gradRank;
	}

	public void setGradRank(LoaiTotNghiep gradRank) {
		this.gradRank = gradRank;
	}

	@Override
	public String toString() {
		return "Fresher "+super.toString()+", gradYear = " + gradYear + ", gradRank = " + gradRank;
	}
	
	
}
