package top100;

import java.util.LinkedList;
import java.util.List;

import binarytree.TreeNode;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null ) return result;
        return helper(root, targetSum, result, new LinkedList<>());
    }

    private List<List<Integer>> helper(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> list) {
        if (node == null) return result;

        if (node.left == null && node.right == null) {
            if (targetSum == node.val) {
                result.add(new LinkedList<>(list));
            }
            return result;
        }

        if (node.left != null) {
            list.add(node.val);
            helper(node.left, targetSum - node.val, result, list);
            list.remove(list.size() - 1);
        }

        if (node.right != null) {
            list.add(node.val);
            helper(node.right, targetSum - node.val, result, list);
            list.remove(list.size() - 1);
        }

        return result;
    } 
    
}
