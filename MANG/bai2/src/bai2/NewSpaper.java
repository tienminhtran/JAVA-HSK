package bai2;

public class NewSpaper extends Document {
	private int dayIssue;

	public NewSpaper(String id, String nxb, String number, int dayIssue) {
		super(id, nxb, number);
		this.dayIssue = dayIssue;
	}
	public void setdayissue(int dayissue) 
	{
		this.dayIssue=dayissue;
	}
	public int getdayissue() 
	{
		return this.dayIssue;
	}
	@Override
	public String toString() {
		return "NewSpaper [dayIssue=" + dayIssue + ", getId()=" + getId() + ", getNxb()=" + getNxb() + ", getNumber()="
				+ getNumber() + "]";
	}
	
}
