package recursion;


import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return  new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if (start > end) {
            list.add(null);
            return list;
        }


        for(int i = start; i <= end; i++) {

            List<TreeNode> leftList = helper(start, i - 1);
            List<TreeNode> rightList = helper(i + 1, end);

            for(TreeNode left: leftList) {
                for(TreeNode right: rightList) {

                    TreeNode cur = new TreeNode(i);

                    cur.left = left;
                    cur.right = right;

                    list.add(cur);

                }
            }

        }
        return list;

    }
}
