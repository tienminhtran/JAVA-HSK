import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class ManangerOfficer {
	private List<Canbo>canbo;
	public ManangerOfficer() 
	{
		this.canbo= new ArrayList<>();
	}
	public void addcanbo(Canbo canbo) 
	{
		this.canbo.add(canbo);
	}
	public List<Canbo>timkiemten(String name)
	{
		return this.canbo.stream().filter(o -> o.getName().contains(name)).collect(Collectors.toList());
	}
	public void indansach() 
	{
		this.canbo.stream().forEach(o->System.out.println(o.toString()));
	}
}
