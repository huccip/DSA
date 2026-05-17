package leetcode.easy;

import java.util.ArrayList;

/**
 * <h1><a href="https://leetcode.com/problems/merge-two-sorted-lists/description" target="_blank">Problem 6 | Merge Two Sorted Lists</a></h1>
 * <br>
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * <br><br>
 *
 * <h1><u>Follow-up:</u></h1>
 * <br>
 * N/A
 *
 * <br><br>
 *
 * <h1><u>Optimization:</u></h1>
 * <br>
 * N/A
 *
 */

class P6Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
        } else  {
            list2.next = mergeTwoLists(list1, list2.next);
        }

        return list1.val >= list2.val ? list2 : list1;
    }
}

public class P6MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(0);

        list1.next = new ListNode(3);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(4);

        P6Solution sol = new P6Solution();
        ListNode list = sol.mergeTwoLists(list1, list2);
    }
}
