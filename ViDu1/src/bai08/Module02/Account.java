package bai08.Module02;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
	private long accountNumber;
	private String name;
	private double balance;
	final double RATE = 0.035;

	public Account(long accountNumber, String name, double balance) throws Exception {
		if (accountNumber > 0) {
			this.accountNumber = accountNumber;
		} else {
			this.accountNumber = 999999;
		}

		if (name.trim().equals("")) {
			this.name = "Chua xac dinh";
		} else {
			this.name = name;
		}

		if (balance > 0) {
			this.balance = balance;
		} else {
			this.balance = 50000;
		}

	} // (dữ liệu gán là hợp lệ khi số tài khoản >0, tên tài khoản khác rỗng, số dư
		// >=50000).

	public Account(long accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = 50000;

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
	
	/**
	 * Hàm gửi thêm vào tài khoản
	 * 
	 * @param amount số tiền cần thêm
	 * @return
	 */
	boolean deposit(double amount) throws Exception {
		if(amount < 0) {
			throw new Exception("So tien gui phai lon hon 0");
		}
		else {
			balance = balance+amount;
			return true;
		}
	}
	

	/**
	 * cho phép rút số tiền amount từ tài khoản
	 * 
	 * @param amount số tiền cần rút
	 * @param fee    phí rút tiền
	 * @return
	 */
	public boolean withdraw(double amount, double fee) {
		if (amount > 0 && amount + fee <= this.balance) {
			this.balance = this.balance- (amount + fee);
			return true;
		}
		return false;
	}

	/**
	 * tính tiền lãi
	 */
	public void addInterest() {
		this.balance =this.balance + this.balance * RATE;
	}

	/**
	 * transfer: hàm chuyền tiền từ account này sang account khác
	 * @param acc2
	 * @param amount số tiền cẩn chuyển
	 * @return
	 * @throws Exception 
	 */
	public boolean transfer(Account acc2, double amount) throws Exception {
		if (amount >= 0) {
			this.withdraw(amount, 0);
			acc2.deposit(amount);
			return true;
		}
		return false;

	}
	/**
	 * Định dạng tiêu đề bảng
	 * 
	 * @return
	 */
	public static String layTieuDe() {
		return String.format("|%-30s|%-30s|%-30s|", "Account name", "Number Account", "Balance");
	}

	/**
	 * Định dạng bảng
	 * 
	 * @return
	 */
	public String toString() {
		Locale local = new Locale("vi", "vn");
		NumberFormat currency = NumberFormat.getCurrencyInstance(local);
		return String.format("|%-30s|%-30d|%-30s|", name, accountNumber, currency.format(balance));

	}
}
