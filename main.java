
package person;

import java.util.*;

public class main {

	public static void main(String[] args) {

		LInkedlist a = new LInkedlist();
		a.insertatfront(30);
		a.insertatfront(20);
		a.insertatfront(10);
		LInkedlist b = new LInkedlist();
		b.insertatfront(50);
		b.insertatfront(30);
		b.insertatfront(20);
		System.out.println("List A:");
		a.displayforward();
		System.out.println("\nList B:");
		b.displayforward();
		System.out.println("\n\nSearch for 20 in A:");
		System.out.println(a.searchrecursive(20));
		System.out.println("Search for 99 in A:");
		System.out.println(a.searchrecursive(99));
		a.reverse();
		System.out.println("\nList A after reversing:");
		a.displayforward();
		System.out.println("\nList A backward:");
		a.displaybackward();
		LInkedlist result = LInkedlist.intersection(a, b);
		System.out.println("\n\nIntersection of A and B:");
		result.displayforward();
		a.deletefromfront();
		System.out.println("\n\nA after deleting from front:");
		a.displayforward();
		a.deletebyvalue(30);
		System.out.println("\nA after deleting 30:");
		a.displayforward();
	}
}
