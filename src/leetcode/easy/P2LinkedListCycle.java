package leetcode.easy;

class P2Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        while (ptr2 != null && ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
            if (ptr1 == ptr2) return true;
        }
        return false;
    }
}

public class P2LinkedListCycle {
    public static void main(String[] args) {
        P2Solution solution = new P2Solution();

        ListNode head = new ListNode(1);

        System.out.println(solution.hasCycle(head));
    }
}
