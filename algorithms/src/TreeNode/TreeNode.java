package TreeNode;

public class TreeNode {
    public String val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    TreeNode(String x) { val = x; }

    @Override
    public String toString() {
        return val + " ";
    }
}
