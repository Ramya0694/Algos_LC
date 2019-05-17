package main.java.binarysearch;

public class MergeSortedArrays {

	public static void main(String[] args) { 
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(4);
		listNode1.next = listNode2;
		ListNode listNode3 = new ListNode(5);
		listNode2.next = listNode3;
		
		ListNode listNode4 = new ListNode(1);
		ListNode listNode5 = new ListNode(3);
		listNode4.next = listNode5;
		ListNode listNode6 = new ListNode(4);
		listNode5.next = listNode6;
		
		ListNode listNode7 = new ListNode(2);
		ListNode listNode8 = new ListNode(6);
		listNode7.next = listNode8;
		
		ListNode[] nodeListNodes = new ListNode[2];
		nodeListNodes[0] = listNode1;
		nodeListNodes[1] = listNode4;
		//nodeListNodes[2] = listNode7;
		
		//mergeKLists(nodeListNodes);
		mergeKLists(nodeListNodes);
	}
	
	public static ListNode mergeKLists(ListNode[] nodeListNodes) {
        if(nodeListNodes.length > 0){
            ListNode l1 = nodeListNodes[0];
            for(int i=1; i<nodeListNodes.length; i++) {
                ListNode l2 = nodeListNodes[i];
                l1 = mergeTwoLists(l1, l2);
            }
            return l1;
        }else{
            return nodeListNodes[0];
        }
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			System.out.println("L1" + l1.toString());
			return l1;
		}else {
			l2.next = mergeTwoLists(l1, l2.next);
			System.out.println("L2" + l2.toString());
			return l2;
		}
	}

	/*
	 * public static ListNode mergeKLists(ListNode[] lists) { ListNode tempListNode
	 * = lists[0]; ListNode finalListNode; ListNode nextListNode = lists[1];
	 * 
	 * if(tempListNode.val < lists[1].val) { finalListNode = new
	 * ListNode(tempListNode.val); finalListNode.next = new ListNode(1);
	 * tempListNode = tempListNode.next; }else { finalListNode = new
	 * ListNode(nextListNode.val); finalListNode.next = new ListNode(1);
	 * nextListNode = nextListNode.next; }
	 * 
	 * for(int k=1; k<lists.length; k++) { if(k>=2) { nextListNode = lists[k]; }
	 * 
	 * while(tempListNode != null && nextListNode != null) {
	 * if(tempListNode.val<nextListNode.val) { ListNode node = new
	 * ListNode(tempListNode.val); finalListNode = finalListNode.next;
	 * finalListNode.val = tempListNode.val; finalListNode.next = new ListNode(1);
	 * tempListNode = tempListNode.next; }else { ListNode node = new
	 * ListNode(nextListNode.val); finalListNode.next = node; nextListNode =
	 * nextListNode.next; } } }
	 * 
	 * tempListNode = finalListNode; return tempListNode; }
	 */

}
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }

  @Override
  public String toString() {
	return "ListNode [val=" + val + ", next=" + next + "]";
  }
  
  
}