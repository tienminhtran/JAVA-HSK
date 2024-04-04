
public class Test {
	public static void main(String[] args) {
		Ngay ngay1= new Ngay(15, 5, 2022);
		Ngay ngay2= new Ngay(31,1 , 2025);
		Ngay ngay3= new Ngay(16, 02, 2030);
		
		Hangsanxuat hangsanxuat1= new Hangsanxuat("Hang A", "Viet Nam");
		Hangsanxuat hangsanxuat2= new Hangsanxuat("Hang B", "My");
		Hangsanxuat hangsanxuat3= new Hangsanxuat("Hang C", "Ba Lan");
		
		Bophim bophim1= new Bophim("phim ma", 2022, hangsanxuat1, 105000, ngay1);
		Bophim bophim2= new Bophim("phim sex", 2024, hangsanxuat2, 115000, ngay2);
		Bophim bophim3= new Bophim("phim 18+", 2026, hangsanxuat3, 125000, ngay3);
		System.out.println("ss gia 1 re hon 2"+bophim1.kiemtragiaverehon(bophim3));
		
	}
}
