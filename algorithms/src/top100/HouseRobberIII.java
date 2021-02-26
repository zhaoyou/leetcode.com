package top100;

import binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap();

        return helper(root, map);
    }

    public int helper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;

        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += helper(root.left.left, map) + helper(root.left.right, map);
        }

        if (root.right != null) {
            val += helper(root.right.left, map) + helper(root.right.right, map);
        }

        val = Math.max(root.val + val, helper(root.left, map) + helper(root.right, map));

        map.put(root, val);

        return val;
    }


}
