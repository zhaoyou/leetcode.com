package interviewMedium.Tree;


import java.util.ArrayList;
import java.util.List;

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class BinaryTreeInorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root != null) {
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);

        }
    }
}
