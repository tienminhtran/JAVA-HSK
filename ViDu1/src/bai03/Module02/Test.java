package bai03.Module02;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		try {
			DecimalFormat fmt = new DecimalFormat("0.##");
			double x, y;
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap ban kinh: ");
			x = sc.nextDouble();
			System.out.println("Nhap chieu cao: ");
			y = sc.nextDouble();
			Cylinder cy = new Cylinder(x, y);
			System.out.println("Dien Tich Xung Quanh: " + fmt.format(cy.tinhDienTichXungQuanh()));
			System.out.println("Dien Tich Toan Phan: " + fmt.format(cy.tinhDienTichToanPhan()));
			System.out.println("The tich: " + fmt.format(cy.tinhTheTich()));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
