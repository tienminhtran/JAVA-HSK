import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLCB {
	
public static void main(String[] args) 
{
	List<Canbo> canbolist= new ArrayList<>();
	
 	 int choose;
 	Scanner sc= new Scanner(System.in);
 	 do 
 	 {
 		 showmennu();
 		 choose=Integer.parseInt(sc.nextLine());
 		 switch (choose) {
 		 case 1:
 			 Canbo cb= new Conhnhan();
 			 cb.input();
 			 canbolist.add(cb);
 			 break;
 		 case 2:
 			 break;
 		 case 3:
 			 for (Canbo canbo : canbolist) {
				System.out.println(canbo);
			}
 			 break;
 		 case 4:
 			 System.out.println("Thoat!!!");
 			 break;
 		 default:
 			 System.out.println("Nhap sai!!!");
 		 }
				 
 	 }
 	 while(choose!=4);
}
 static void showmennu() 
{
	System.out.println("1. Nhap thong tin moi cho can bo");
	System.out.println("2. Tim kiem theo ten: ");
	System.out.println("3. Hien thi thong tin");
	System.out.println("4. Thoat");
}

}
