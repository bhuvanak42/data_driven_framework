package collset;

import java.util.HashSet;
import java.util.Iterator;

public class Set {

	public static void main(String[] args) {
	
		
		HashSet<String> s = new HashSet<String>();
		
		s.add("Shyamala");
		
	s.add("Mahe");
	
	s.add("Ram");
	s.add("deva");
	
	System.out.println(s);
	
	Iterator<String> itr = s.iterator();
	
	while(itr.hasNext())
	{
		String a = itr.next();
		
		if(a.equals("deva"))
{
	System.out.println(a);
}
	}
	
	
	

	}

}
