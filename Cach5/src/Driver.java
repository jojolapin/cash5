import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		
        list.add("10");
        list.add("20");
        list.add("37");
        list.add("40");
        list.add("50");
        list.add("60");
        list.add("70");
        list.add("80");
        list.add("90");
        list.add("100");
        list.add("19");
        list.add("21");
        list.add("33");
        list.add("25");
        list.add("20");
        list.add("26");
        list.add("27");
        list.add("28");
        list.add("29");
        list.add("30");

		Cash5 c5 = new Cash5();
		
		List<String> list3 = c5.getRandomList(list, 10);
		List<String> list4 = c5.getRandomList(list, 15);
		
		System.out.println("List1: " + list3);
		System.out.println("List2: " + list4);
		
		System.out.println("list3 U list4: = " + c5.joinList(list3, list4));
		
		c5.findCombinationOf(list, 10);
		
		c5.findCombinationOf(list4, 5);
	}

}
