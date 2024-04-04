
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		List<Integer> sn= Arrays.asList(1,2,3,4,5,6,7);
//		languages.forEach(l->{
//			if(l.startsWith("j")) 
//			{
//				System.out.println(l);
//			}
//		});
	
		
//		IntStream.of(value).forEach(System.out::println);
//		System.out.println(IntStream.of(value).count());
//		System.out.println(IntStream.of(value).max().getAsInt());
//		System.out.println(IntStream.of(value).sum());
//		System.out.println(IntStream.of(value).average().getAsDouble());
//		long c= IntStream.of(value).filter(n ->n%2==0).count();
//		IntStream.of(value).filter(k ->k%2==0).forEach(k->System.out.println(k));
//		IntStream b=IntStream.of(value).sorted();
//		b.forEach(System.out::println);
//		IntStream.of(value).map(v->v+1).forEach(v ->System.out.println(v));
		product pt1= new product("loi", 20);
		product pt2= new product("linh", 23);
		product pt3= new product("TIEN", 19);
		List<product> productlist= new ArrayList<>();
		productlist.add(pt1);
		productlist.add(pt2);
		productlist.add(pt3);
//		String name="loi";
//		productlist.stream().filter(o ->o.getName().contains(name)).forEach(System.out::println);;
//		int[] a= {6,2,3,4,5};
//		IntStream.of(a).map(p->p).forEach(System.out::println);

			List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 4, 4, 4, 4);
			 Integer c = numbers.stream()
					.filter(t -> t > 3)
					.findFirst()
					.orElse(null);
			System.out.println(numbers.stream()
					.filter(t -> t > 3)
					.findFirst()
					.orElse(null));
			List<student> ds= new ArrayList<>();
			student st1= new student("loi", 3);
			student st2= new student("linh", 2);
			student st3= new student("trung", 1);
			ds.add(st1);
			ds.add(st2);
			ds.add(st3);
			System.out.println(ds.stream().flatMapToInt(p->IntStream.of(p.getDiem())).sum());
			ds.stream().filter(p->p.getName().equals("loi")).forEach(System.out::println);
			ds.forEach(System.out::println);
			
		
			
			
			
	}		
	}

