/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        return findIntersection(headA, headB);
    }

    int length(ListNode head) {
        if (head == null) return 0;
        return 1 + length(head.next);
    }

    ListNode findIntersection(ListNode a, ListNode b) {
        if (a == null || b == null) return null;
        if (a == b) return a;
        return findIntersection(a.next, b.next);
    }
}
