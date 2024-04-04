package bai2;

import java.util.ArrayList;
import java.util.List;

public class ManagerDocument {
	List<Document> documents;
	
	public ManagerDocument() 
	{
		this.documents=new ArrayList<>();
	}
	public void addDocument(Document docmuent) 
	{
		this.documents.add(docmuent);
	}
	public boolean deleteDocument(String id) 
	{
		Document doc= this.documents.stream()
				.filter(p->p.getId().equals(id))
				.findFirst().orElse(null);
		
		if(doc==null) return false;
		else 
		{
			this.documents.remove(doc);
			return true;
		}
		
	}
	public void showInfo() 
	{
		this.documents.forEach(System.out::println);
	}
}
