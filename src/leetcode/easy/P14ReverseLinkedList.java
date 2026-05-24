package leetcode.easy;

/**
 * <h1><a href="https://leetcode.com/problems/reverse-linked-list/description/?envType=problem-list-v2&envId=oizxjoit" target="_blank">Problem 14 | Reverse Linked List</a></h1>
 * <br>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * <br><br>
 *
 * <h1><u>Follow-up:</u></h1>
 * <br>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * <br><br>
 *
 * <h1><u>Optimization:</u></h1>
 * <br>
 * N/A
 *
 */

class P14Solution {

    // follow up: iterative solution
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//
//        ListNode previous = null; // the entry point to our original list (null -> head -> head.next -> ... -> null)
//        ListNode current = head;
//
//        while (current != null) {
//            ListNode temporary = current.next; // because we are going to break the forward link and reverse it we need to have a reference to the rest of the list
//            current.next = previous;
//            previous = current;
//            current = temporary;
//        }
//
//        return previous;
//    }

    // follow up: recursive solution
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next); // allows us to reach for the tail of this list

        head.next.next = head; // after we reach the tail we got to make it link back to the current Node
        head.next = null; // after linking it back to the current Node we have to destroy the forward connection

        return newHead;
    }
}

public class P14ReverseLinkedList {
    public static void main(String[] args) {
        P14Solution sol = new P14Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode result = sol.reverseList(head);
        while(result != null){
            System.out.print(result.val + (result.next == null ? "" : " -> "));
            result = result.next;
        }
    }
}
