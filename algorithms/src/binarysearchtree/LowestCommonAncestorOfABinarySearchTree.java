package binarysearchtree;

public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * 通用binary tree 算法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
            return right;

        if (right == null)
            return left;

        return root;
    }

    /**
     * 递归方式-利用BST结构的特定只需需要搜索特定的subTree
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

       if (root.val > p.val && root.val > q.val) {
           return lowestCommonAncestor2(root.left, p, q);
       } else if (root.val < p.val && root.val < q.val) {
           return lowestCommonAncestor2(root.right, p, q);
       } else {
           return root;
       }
    }

    /**
     * 循环方式-利用BST结构去搜索
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {

        int pVal = p.val;
        int qVal = q.val;

        TreeNode node = root;

        while(node != null) {
            int parentVal = node.val;
            if (parentVal > pVal && parentVal > qVal) {
                node = node.left;
            } else if (parentVal < pVal && parentVal < qVal) {
                node = node.right;
            } else {
                return node;
            }
        }

        return null;
    }

}
