package Mode2Bai8;

public class Account {
	private long accountNumber;
	private String name;
	private double balance;
	final double RATE = 0.035;

	public Account(long accountNumber, String name, double balance) throws Exception{
		setAccountNumber(accountNumber);
		setName(name);
		setBalance(balance);

	} // (dữ liệu gán là hợp lệ khi số tài khoản >0, tên tài khoản khác rỗng, số dư
		// >=50000).

	public Account(long accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
	}

	public Account() {
		this.accountNumber = 999999;
		this.name = "chua xac dinh";
		this.balance = 50000;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		if (accountNumber > 0)
			this.accountNumber = accountNumber;
		else
			this.accountNumber = 999999;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!name.trim().equals(" "))
			this.name = name;
		else
			this.name = "chua xac dinh";

	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if (balance >= 50000)
			this.balance = balance;
		else
			this.balance = 50000;

	}

	public double getRATE() {
		return RATE;
	}

}
