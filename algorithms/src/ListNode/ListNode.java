package ListNode;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {this.val = val;}
    public ListNode(int val, ListNode next) {this.val = val; this.next = next;}


    @java.lang.Override
    public java.lang.String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}