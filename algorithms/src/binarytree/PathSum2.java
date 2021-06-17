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

        if (node.left == null && node.right == null) {
            if (node.val == targetSum) {
                list.add(node.val);
                result.add(list);
            }
        } else {
            list.add(node.val);
            helper(node.left, targetSum - node.val, new LinkedList<>(list));

            helper(node.right, targetSum - node.val, new LinkedList<>(list));

            list.remove(list.size() - 1);
        }
    }
}
