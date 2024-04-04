import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		ManangerOfficer managerOfficer= new ManangerOfficer();
		while(true) 
		{
			System.out.println("Application Manager Officer");
			System.out.println("Enter 1: To insert officer");
			System.out.println("Enter 2: To search officer by name");
			System.out.println("Enter 3: To show informatinon officers");
			System.out.println("Enter 4: To exit");
			String line= scanner.nextLine();
			switch(line) 
			{
			case "1":
			{
				System.out.println("Enter a: to insert Enginner");
				System.out.println("Enter b: to insert Work");
				System.out.println("Enter c: to insert Staff");
				String type= scanner.nextLine();
				switch(type) 
				{
				case "a":
				{
					System.out.println("Enter name: ");
					String name= scanner.nextLine();
					
					System.out.println("Enter age:");
					int age= scanner.nextInt();
					
					System.out.println("Enter gender:");
					scanner.nextLine();
					String gender=scanner.nextLine();
					
					System.out.println("Enter address");
					String address= scanner.nextLine();
					
					System.out.println("Enter branch:");
					String branch=scanner.nextLine();
					
					Canbo kisu= new Kysu(name, gender, address, age, branch);
					managerOfficer.addcanbo(kisu);
					System.out.println(kisu.toString());
					break;
				}
				case "b": 
				{
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age:");
                    int age = scanner.nextInt();
                    System.out.print("Enter gender: ");
                    scanner.nextLine();
                    String gender = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter level: ");
                    int level = scanner.nextInt();
                    Canbo congnhan= new Congnhan(name, gender, address, age, level);
                    managerOfficer.addcanbo(congnhan);
                    System.out.println(congnhan.toString());
                    scanner.nextLine();
                    break;
				}
				case "c":
				{
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter gender: ");
                    scanner.nextLine();
                    String gender = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    Canbo nhanvien= new Nhanvien(name, gender, address, age, task);
                    managerOfficer.addcanbo(nhanvien);
                    System.out.println(nhanvien.toString());
                    break;
				
				}
				default:
					System.out.println("Invalid");
					break;
			}
				break;
		}
			case "2":
			{
				System.out.println("Enter name to search: ");
				String name= scanner.nextLine();
				managerOfficer.timkiemten(name).forEach(System.out::println);
				break;
			}
			case "3":
			{
				managerOfficer.indansach();
				break;
			}
			case "4":
			{
				return;
			}
			default:
				System.out.println("Invalid");
				continue;
	}
	}
	}
}

