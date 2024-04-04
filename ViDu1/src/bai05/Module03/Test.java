package bai05.Module03;

public class Test {

	public static void main(String[] args) {
		Employee[] e1 = new Employee[4];
		e1[0] = new SalariedEmployee("Tien", "Tran", "13111", 520000);
		e1[1] = new HoulyEmployee("Adam", "Serct", "64104", 23000, 30);
		e1[2] = new CommissionEmployee("Sechi", "Eri", "64512", 230, 0.5);
		e1[3] = new BasePlusCommissionEmployee("A", "Tran", "64104",120, 0.6, 120000);
		
		for (Employee employee : e1) {
			System.out.println(employee+"\n");
		}
		
	}

}
