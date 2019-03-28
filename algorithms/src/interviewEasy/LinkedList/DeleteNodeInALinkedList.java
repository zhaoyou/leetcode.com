package interviewEasy.LinkedList;

import ListNode.ListNode;

public class DeleteNodeInALinkedList {


    public void deleteNode(ListNode node) {

        ListNode next = node.next.next;

        int v = node.next.val;
        node.val = v;
        node.next = next;
    }
}
