/**
 * This is complete function of Leetcode in TS
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function getIntersectionNode(headA: ListNode | null, headB: ListNode | null): ListNode | null {
    let st = new Set<ListNode>();
    while(headA) {
        st.add(headA);
        headA = headA.next;
    }
    while(headB) {
        if(st.has(headB)) return headB;
        st.add(headB);
        headB = headB.next;
    }
    return null;

};