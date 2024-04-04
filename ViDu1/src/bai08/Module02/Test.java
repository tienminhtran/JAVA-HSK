package bai08.Module02;

public class Test {
	public static void main(String[] args) throws Exception {
		Account acc1 = new Account(72354, "Ted Murphy", 100000);
		Account acc2 = new Account(69713, "Jane Smith", 40000);
		Account acc3 = new Account(93757, "Edward Demsey", 700000);

		acc1.deposit(250000);
		acc2.deposit(500000);
		acc2.withdraw(430000, 2000);
		acc3.addInterest();
		System.out.println(Account.layTieuDe());
		System.out.println(acc1);
		System.out.println(acc2);
		System.out.println(acc3);

		acc2.transfer(acc1, 100000);
		System.out.println("Sau khi chuyen tien");
		System.out.println(Account.layTieuDe());
		System.out.println(acc1);
		System.out.println(acc2);
	}
}
