package leetcode.easy;

/**
 * <h1><a href="https://leetcode.com/problems/linked-list-cycle/description/" target="_blank">Problem 2 | Linked List Cycle</a></h1>
 * <br>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * <br><br>
 *
 * <h1>Constraints:</h1>
 * <br>
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 * <br><br>
 * <h1>Follow up:</h1>
 * <br>
 * Can you solve it using O(1) (i.e. constant) memory?
 *
 * <br><br>
 *
 * <h1><u>Optimization:</u></h1>
 * <br>
 * This is a reference to Floyd’s Cycle-Finding Algorithm
 * Basically you're having two pointers running checks on your Linked List regardless of how big it is so:
 * <br>
 * => Time is O(n)
 * => Space is O(1)
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
