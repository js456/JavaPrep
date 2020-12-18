package assessment;

import org.junit.BeforeClass;
import org.junit.Test;

public class EnqueroAssessmentTest {

	static EnqueroAssessment.Node head ;
	static EnqueroAssessment enq;
	@BeforeClass
	public static void init() {
		enq = new EnqueroAssessment();
		EnqueroAssessment enq = new EnqueroAssessment();
		head = enq.new Node();
		int [] arr = {1, 3, 5, 7, 9, 10, 12, 15,123};
		for(int i:arr) {
			head.insert(i);
		}
		head = head.head;
	}
	
	@Test
	public void printList() {
		enq.printList(head);
	}	
	@Test
	public void testMissingNumbers() {
		int arr[] = {2, 4, 1, 2};
		System.out.println();
		for(int i: enq.findMissingNumber(arr)) {
			System.out.print(i);
			System.out.print(" ");
		}
	}
	
	@Test
	public void testRemoveDuplicate() {
		EnqueroAssessment.Node linkedList = enq.new Node(); ;
		System.out.println();
		int [] arr = {2, 2, 2, 11};
		for(int i:arr) {
			linkedList.insert(i);
		}
		linkedList = linkedList.head;
		
		System.out.println(enq.removeDuplicateLinkedList(linkedList));
	}
}
