package chuong03.caseStudy02;

public class Test {

	public static void main(String[] args) {
		Author aus[]=new Author[3];
		aus[0]=new Author("An", "an@gmail.com", 'M');
		aus[1]=new Author("Nam", "nam@gmail.com", 'F');
		Book b=new Book("lt hdt", aus, 10000, 10);
		System.out.println(b);
		System.out.println(b.getAuthorNames());
	}

}
