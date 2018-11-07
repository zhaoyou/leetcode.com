package ListNode;


/**
 * reference: https://blog.csdn.net/u012814856/article/details/72850870
 */
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            node = null;
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
