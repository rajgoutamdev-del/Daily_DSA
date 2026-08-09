/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode ls : lists) {
            while(ls != null) {
                pq.add(ls.val);
                ls = ls.next;
            }
        }
        if(pq.size() <= 0) return null;
        ListNode ans = new ListNode(pq.poll());
        ListNode tmp = ans;
        while(!pq.isEmpty()) {
            ListNode newNode = new ListNode(pq.poll());
            tmp.next = newNode;
            tmp = newNode;
        }
        return ans;
    }
}