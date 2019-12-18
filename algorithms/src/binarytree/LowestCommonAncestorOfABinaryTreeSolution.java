package binarytree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * https://blog.csdn.net/ljyljyok/article/details/78268547
 */
public class LowestCommonAncestorOfABinaryTreeSolution {


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left == null)
            return right;

        if (right == null)
            return left;

        return root;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pList = new LinkedList<>();
        List<TreeNode> qList = new LinkedList<>();
        findPath(root, p.val, pList);
        findPath(root, q.val, qList);


        TreeNode res = root;

        for (int i = 0; i < pList.size() && i < qList.size(); i++) {
            if (pList.get(i).val == qList.get(i).val) res = pList.get(i);
            else break;
        }

        return res;

    }


    private boolean findPath(TreeNode root, Integer target, List<TreeNode> list) {

        if (root == null) return false;

        list.add(root);

        if (root.val == target) return true;

        if (findPath(root.left, target, list) || findPath(root.right, target, list)) return true;

        list.remove(list.size() - 1);

        return false;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(3);

        TreeNode leftNode = new TreeNode(5);
        TreeNode rightNode = new TreeNode(1);

        root.right = rightNode;
        root.left = leftNode;



        TreeNode t56 = new TreeNode(6);
        TreeNode t52 = new TreeNode(2);

        leftNode.left = t56;
        leftNode.right = t52;

        TreeNode t27 = new TreeNode(7);
        TreeNode t24 = new TreeNode(4);

        t52.left = t27;
        t52.right = t24;






        TreeNode leftNode2 = new TreeNode(0);
        TreeNode rightNode2 = new TreeNode(8);

        rightNode.left = leftNode2;
        rightNode.right = rightNode2;





        System.out.println(lowestCommonAncestor2(root, leftNode, rightNode));
    }
}
