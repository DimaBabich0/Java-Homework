import com.google.common.collect.Multimap;
import com.google.common.collect.ArrayListMultimap;

public class Main {

	public static void main(String[] args) {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("cat", "Murzik");
        multimap.put("cat", "House");
        multimap.put("cat", "Alex");

        multimap.put("color", "red");
        multimap.put("color", "green");
        
        System.out.println(multimap.get("cat"));
        System.out.println(multimap.get("color"));
        System.out.println(multimap.entries());
        System.out.println(multimap.keys());
        System.out.println(multimap.keySet());
	}

}
