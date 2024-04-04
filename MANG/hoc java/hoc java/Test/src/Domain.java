import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Domain {
	public void f0(ArrayList<Book> list) 
	{
		list.stream().forEach(p->System.out.println(p));
	}
	public void f1(ArrayList<Book> list) 
	{
		long c=list.stream().filter(p->p.getPrice()>10).count();
		System.out.println("So luong book gia lon hon 10: "+c);
	}
	public void f2(ArrayList<Book> list) 
	{
		System.out.println("So luong book gia lon hon 10 nho hon 20: "
				+list.stream().filter(p->p.getPrice()>10&&p.getPrice()<20).count());
	}
	public void f3(ArrayList<Book> list) 
	{
		System.out.println(list.get(5).toString());
	}
	public void f4(ArrayList<Book> list,Book book) 
	{
		System.out.println(list.add(book)?"oke da them":"khong duoc");
	}
	public void f5(ArrayList<Book> list,Book book) 
	{
		list.add(4, book);

	}
	public void f6(ArrayList<Book> list,String brand) 
	{
		brand="Truyen dai";
		list.get(4).setBrand(brand);
	}
	public void f7(ArrayList<Book> list) 
	{
		list.remove(3);
		
	}
	public long f8(ArrayList<Book> list) 
	{
		return  list.stream().filter(p->p.getBrand().equals("Truyen tranh")).count();
	}
	public long f9(ArrayList<Book> list) 
	{
		return list.stream().filter(p->p.getName().startsWith("k")).count();
		
	}
	public void f10(ArrayList<Book> list) 
	{
//	list.stream().map(p->p.getPrice()*0.9).forEach(p->System.out.println(p));
//	list.stream().map(p->(double)p=p.getPrice()*0.9);
		for(int i=0;i<list.size();i++) 
		{
			double price= list.get(i).getPrice()*0.9;
			list.get(i).setPrice(price);
		}
	}
	public void f11(ArrayList<Book> list) 
	{
		for (Book book : list) {
			if(book.getBrand().equals("Truyen dai")) {
				book.setPrice(book.getPrice()*0.9);
			}
		}
	}
	public void f12(ArrayList<Book> list) //ss ma int
	{
		Collections.sort(list,new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				
				return o1.getCode()-o2.getCode();
			}
			
		
		});
	}
	public void f13(ArrayList<Book> list) //ss ten
	{
		//anonymous class
//		Collections.sort(list, new Comparator<Book>() {
//
//			@Override
//			public int compare(Book o1, Book o2) {
//				
//				return o1.getName().compareTo(o2.getName());
//			}
//		});
		//bieu thuc lambda
		Collections.sort(list,(Book o1, Book o2)->o1.getCode()-o2.getCode());
	}
	public void f14(ArrayList<Book> list) //ss gia
	{
		Collections.sort(list, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				// TODO Auto-generated method stub
//				return (int)(o1.getPrice()-o2.getPrice());
				if(o1.getPrice()>o2.getPrice())
				{		
					return 1;
				}
				else if(o1.getPrice()<o2.getPrice()) 
				{
					return -1;
				}
				else return 0;
				
			}
		});
	}
	
	public static void main(String[] args) {
		ArrayList<Book> arrlist= new ArrayList<>();
		Book bo= new Book();
		bo.setName("conan");
		bo.setCode(0);
		bo.setPrice(10);
		bo.setBrand("Truyen tranh");
		Book b1= new Book("Doraemon", 2,20, "Truyen tranh");
		Book b2= new Book("kao hac", 3, 15, "Truyen dai");
		Book b3= new Book("Mac biec", 1,40, "Truyen dai");
		String name4="Chi pheo";
		int code4=4;
		double price4= 50;
		String brand="Truyen Ngan";
		Book b4= new Book(name4, code4, price4, brand);
		Book b5= new Book("Tam Cam", 5,40, "Truyen dai");
		Book b6= new Book("Loi",3,50,"Truyen Tinh yeu");
		Book b7= new Book("khanh",1,60,"Truyen Hanh phuc");
		arrlist.add(bo);
		arrlist.add(b1);
		arrlist.add(b2);
		arrlist.add(b3);
		arrlist.add(b4);
		arrlist.add(b5);

		Domain d= new Domain();
		d.f1(arrlist);
		d.f2(arrlist);
		d.f3(arrlist);
		d.f4(arrlist, b6);
		d.f0(arrlist);
		System.out.println();
		d.f5(arrlist, b7);
		d.f0(arrlist);
		System.out.println();
		d.f6(arrlist, null);
		d.f0(arrlist);
		System.out.println();
		d.f7(arrlist);
		d.f0(arrlist);
		System.out.println();
		System.out.println("So luong Truyen tranh: "+d.f8(arrlist));
		System.out.println("Ten bat dau bang chu k: "+d.f9(arrlist));
		d.f10(arrlist);
		d.f0(arrlist);
		System.out.println();
		d.f11(arrlist);
		d.f0(arrlist);
		System.out.println();
		d.f12(arrlist);
		d.f0(arrlist);
		System.out.println();
		d.f13(arrlist);
		d.f0(arrlist);
	}
}
