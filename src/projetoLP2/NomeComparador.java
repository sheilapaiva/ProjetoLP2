package projetoLP2;

import java.util.Comparator;

public class NomeComparador implements Comparator<String>{
	
	@Override
	public int compare(String o1, String o2) {
		System.out.println(o1.substring(0, 5) + " " + o2.substring(0, 5));
		if (o1.substring(0, 3).equals("PL ") && !o2.substring(0, 3).equals("PL ")) {
			return o1.substring(0, 4).compareTo(o2.substring(0,5));
		
		} else if (!o1.substring(0, 3).equals("PL ") && o2.substring(0, 3).equals("PL ")){
			return o1.substring(0, 5).compareTo(o2.substring(0, 4));
		
		}else if (o1.substring(0, 3).equals("PL ") && o2.substring(0, 3).equals("PL ")){
			return o1.substring(0, 4).compareTo(o2.substring(0, 4));
		
		} else {
			return o1.substring(0, 5).compareTo(o2.substring(0, 5));
		}
		
	}
	
}
