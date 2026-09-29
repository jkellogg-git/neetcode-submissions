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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. Create a dummy node. Its .next will become the head of the result.
        ListNode dummy = new ListNode(0);

        // 2. 'node' is the tail pointer — the last node we've attached so far.
        ListNode node = dummy;

        // 3. Walk both lists while both still have nodes.
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                // TODO: attach list1 to node.next
                node.next = list1;
                // TODO: advance list1
                list1 = list1.next;
            } else {
                // TODO: attach list2 to node.next
                node.next = list2;
                // TODO: advance list2
                list2 = list2.next;
            }
            // TODO: advance node
            node = node.next;
        }

        // 4. One list is empty — attach whatever remains of the other.
        //    (Hint: an if/else on which list is non-null works.)
        // TODO
        if (list1 == null) {
            node.next = list2;
        } else if (list2 == null) {
            node.next = list1;
        }

        // 5. Return the real head (skip the dummy).
        return dummy.next;        
    }
}