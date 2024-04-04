import java.util.ArrayList;
import java.util.Scanner;
public class Studenttext {
	public static void main(String[] args) {
		ArrayList<Student> studentlist= new ArrayList<Student>();
		Scanner sc= new Scanner(System.in);
		int choose=0;
		do 
		{
			showMenu();
			System.out.println("Choose: ");
			choose=sc.nextInt();
			switch (choose) 
			{
			case 1:
				int n;
				System.out.println("Nhap so sinh vien can them: ");
				n=sc.nextInt();
				for (int i=0;i<n;i++) 
				{
					Student std= new Student();
					std.inputInfo();
					studentlist.add(std);
					
				}
				break;
			case 2:
				for(int i=0;i<studentlist.size();i++) 
				{
					studentlist.get(i).showInfo();
				}
				break;
			case 3:
				int minindex=0,maxindex=0;
				float minmark,maxmark;
				minmark= studentlist.get(0).getMark();
				maxmark= studentlist.get(0).getMark();
				for (int i = 0; i < studentlist.size(); i++) {
					if(minmark>studentlist.get(i).getMark()) 
					{
						minindex=i;
						minmark=studentlist.get(i).getMark();
					}
					if(maxmark<studentlist.get(i).getMark()) 
					{
						maxindex=i;
						maxmark=studentlist.get(i).getMark();
					}
					System.out.println("Sinh vien co diem trung binh cao nhat");
					studentlist.get(minindex).showInfo();
					System.out.println("Sinh vien co diem trung binh thap nhat");
					studentlist.get(maxindex).showInfo();
				}
				break;
			case 4:
				
				System.out.println("Nhap ma sinh vien can tim kiem: ");
				String rollNosearch= sc.nextLine();
				for(int i=0;i<studentlist.size();i++) 
				{
					if(studentlist.get(i).getRollNo()==rollNosearch) 
					{
						studentlist.get(i).showInfo();
					}
				}
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				System.out.println("Goodbye!!!");
				break;
			default:
				System.err.println("Nhap sai!!!");
			}
		}
		while(choose!=7);
	
	}
	
	public static void showMenu() 
	{
		System.out.println("1. Nhap vao N sinh vien");
		System.out.println("2. Hien thi thong tin sinh vien");
		System.out.println("3. Hien thi max va min theo diem trung binh");
		System.out.println("4. Tim Kiem sinh vien theo ma sinh vien");
		System.out.println("5. Sort A-Z theo ten sinh vien & hien thi");
		System.out.println("6. Hien thi sinh vien duoc hong bong & sort giam dan");
		System.out.println("7. Thoat");
	}
}
