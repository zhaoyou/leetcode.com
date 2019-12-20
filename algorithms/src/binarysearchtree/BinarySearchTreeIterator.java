package binarysearchtree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/discuss/52526/Ideal-Solution-using-Stack-(Java)
 */
public class BinarySearchTreeIterator {
}

class BSTIterator {

    List<Integer> list = new LinkedList();

    public BSTIterator(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
             while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
             }

             cur = stack.pop();
             list.add(cur.val);
             cur = cur.right;
        }

    }

    /** @return the next smallest number */
    public int next() {
        return list.remove(list.size() - 1);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return list.size() > 0;
    }
}
