/* 2. Collection
 *	Write a Java program to get a reverse order view of the keys contained in a given map
 * */

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class MapExample {
	
	public static void main(String[] args) {
	
		Map<Integer, String> map = new TreeMap<Integer, String>();
	    map.put(1, "abc1");
	    map.put(2, "cdf2");
	    map.put(34, "a666");
	    map.put(3, "hyt3");
	    map.put(6, "sddf");
	    map.put(21, "cxd");
	
	    ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
	    for(int i=keys.size()-1; i>=0;i--){
	        System.out.println("Keys: "+keys.get(i)+" Values: "+map.get(keys.get(i)));
	    }
	}
}
