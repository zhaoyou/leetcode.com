package top100;

import java.util.HashMap;
import java.util.Map;

import binarytree.TreeNode;

public class PathSum3 {
    
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, targetSum, map);
    }

    private int helper(TreeNode node, int curSum, int targetSum, Map<Integer, Integer> map) {
        if (node == null) return 0;

        curSum += node.val;

        int countSumPath = map.getOrDefault(curSum - targetSum, 0);

        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        int res = countSumPath 
        + helper(node.left, curSum, targetSum, map) 
        + helper(node.right, curSum, targetSum, map);

        map.put(curSum, map.get(curSum) - 1);

        return res;
    }
}
