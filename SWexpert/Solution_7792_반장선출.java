import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class Solution_7792_반장선출 {
	static int num = 'Z'-'A'+1;
	static int det(String name) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < name.length(); i++) {
			if(name.charAt(i)==' ') continue;
			set.add(name.charAt(i));
		}
		
		return set.size();
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			s.nextLine();
			int len = -1;
			String maxx = "";
			for (int i = 0; i < n; i++) {
				String name = s.nextLine().trim();
				int var = det(name);
				if(len < var) {
					len = var;
					maxx = name;
				}
				else if(len == var) {
					int iter = 0;
					while(iter < len) {
						if(maxx.charAt(iter)>name.charAt(iter)) {
							maxx = name;
							break;
						}
						else if(maxx.charAt(iter)<name.charAt(iter)) {
							break;
						}
						else
							iter++;
					}
				}
			}
			System.out.println("#"+test+" "+maxx);
		}
	}
}

class HashSet<E> {
	static final long serialVersionUID = -5024744406713321676L;
	
	private transient HashMap<E,Object> map;
	
	// Dummy value to associate with an Object in the backing Map
	private static final Object PRESENT = new Object();
	
	/**
	 * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
	 * default initial capacity (16) and load factor (0.75).
	 */
	public HashSet() {
	    map = new HashMap<>();
	}
	
	
	public HashSet(int initialCapacity, float loadFactor) {
	    map = new HashMap<>(initialCapacity, loadFactor);
	}
	
	
	public HashSet(int initialCapacity) {
	    map = new HashMap<>(initialCapacity);
	}
	
	HashSet(int initialCapacity, float loadFactor, boolean dummy) {
	    map = new LinkedHashMap<>(initialCapacity, loadFactor);
	}
	
	
	public Iterator<E> iterator() {
	    return map.keySet().iterator();
	}
	
	
	public int size() {
	    return map.size();
	}
	
	
	public boolean isEmpty() {
	    return map.isEmpty();
	}
	
	
	public boolean contains(Object o) {
	    return map.containsKey(o);
	}
	
	public boolean add(E e) {
	    return map.put(e, PRESENT)==null;
	}
	
	public boolean remove(Object o) {
	    return map.remove(o)==PRESENT;
	}
	
	public void clear() {
	    map.clear();
	}
	
	@SuppressWarnings("unchecked")
	public Object clone() {
	    try {
	        HashSet<E> newSet = (HashSet<E>) super.clone();
	        newSet.map = (HashMap<E, Object>) map.clone();
	        return newSet;
	    } catch (CloneNotSupportedException e) {
	        throw new InternalError(e);
	    }
	}
}
