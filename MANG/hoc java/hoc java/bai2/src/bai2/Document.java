package bai2;

public class Document 
{
	private String id;
	private String nxb;
	private String number
	public Document(String id, String nxb, String number) {
		this.id = id;
		this.nxb = nxb;
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNxb() {
		return nxb;
	}
	public void setNxb(String nxb) {
		this.nxb = nxb;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", nxb=" + nxb + ", number=" + number + "]";
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
