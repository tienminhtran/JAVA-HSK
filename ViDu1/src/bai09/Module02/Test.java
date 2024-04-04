package bai09.Module02;

public class Test {

	public static void main(String[] args) {
		ToaDo td = new ToaDo("A",5,5);
		HinhTron ht = new HinhTron(10.5,td);
		System.out.println(ht.toString());

	}

}
