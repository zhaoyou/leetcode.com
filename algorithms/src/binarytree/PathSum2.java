package binarytree;

import java.util.LinkedList;
import java.util.List;

public class PathSum2 {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new LinkedList<>());
        return result;
    }

    private void helper(TreeNode node, int targetSum, List<Integer> list) {
        if (node == null) return;

        list.add(node.val);


        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new LinkedList<>(list));
        } else {
            helper(node.left, targetSum - node.val, list);
            helper(node.right, targetSum - node.val, list);
        }

        list.remove(list.size() - 1);
    }
}
