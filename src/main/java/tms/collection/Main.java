package tms.collection;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        List<String> a = new ArrayList<>();
//		a.add("Hello 1");
//		a.add("Hello 2");
//		a.get(1);
//
//		List<Integer> b = new LinkedList<>();
//		b.add(1);
//		b.add(2);
//		b.get(1);
//
//		Queue<String> c = new LinkedList<>();
//		c.offer("Hello 1");
//		c.offer("Hello 2");
//		String peek = c.peek();
//		String poll = c.poll();
//
//		Deque<String> d = new LinkedList<>();
//		d.addLast("Hello 1");
//		d.addFirst("Hello 0");
//
//		Stack<String> e = new Stack<>();
//		e.push("Hello 1");
//		e.push("Hello 2");
//		System.out.println(e.pop());
//		System.out.println(e.pop());
//		System.out.println(e.peek());
//
//		Map<String, String> f = new HashMap<>();
//		f.put("Hello 1", "Test");
//		f.put("Hello 111", "Test 2");
//		String s = f.get("Hello 111"); //Достаём по ключу
//
//		Set<String> g = new HashSet<>();
//		g.add("Hello 1"); //Внутри идёт HashMap, где ключ - передаваемое значение,
//		g.add("Hello 1"); //а value глушится внутри обычным Object
//
//		MyList<String> myList = new MyArrayList();
//		myList.add("Java1");
//		myList.add("Java2");
//		System.out.println(myList.get(1));
//        myList.remove(1);
//        System.out.println(myList.get(1));
//        myList.add("Java18");
//		 System.out.println(myList.get(15));

//		MyList<Integer> myList = new MyLinkedList();
//		myList.add(3);
//		myList.add(4);
//		myList.add(5);
//		myList.add(6);
//		myList.add(7);
//		myList.add(8);
//		System.out.println(myList.get(2));
//		myList.remove(2);
//		System.out.println(myList.get(2));

		MyMap<String, String> map = new MyHashMap<>();
		map.put("a","a");
		map.put("a","aaa");
		map.put("a","bbb");
		map.put("a","ccc");
		map.put("b","b");
		map.put("c","c");
		map.put("d","d");
		map.remove("d");
		map.remove("d");
		map.remove("a");
		map.put("e","e");
		System.out.println(map.get("a"));
		System.out.println(map.get("b"));
		System.out.println(map.get("c"));
		System.out.println(map.get("d"));
		System.out.println(map.get("e"));
		System.out.println(map.get("f"));
		System.out.println(map.get("g"));
		System.out.println(map.get("h"));
		System.out.println(map.get("i"));
	}

}
