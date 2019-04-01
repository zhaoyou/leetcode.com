package interviewEasy.Tree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
//        StringBuffer sb = new StringBuffer();
//        StringBuffer sb2 = new StringBuffer();
//        return preOrder(root, sb).equals(postOrder(root, sb2).toString());
//        System.out.println(sb.toString());
//        return false;
        return (root != null) && symmetricHelp(root.left, root.right);
    }

    private boolean symmetricHelp( TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        if (left.val != right.val)
            return false;

        return symmetricHelp(left.right, right.left) && symmetricHelp(left.left, right.right);

    }

    private StringBuffer preOrder(TreeNode root, StringBuffer sb) {
        if(root != null) {
            sb.append(root.val);
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }

        return sb;
    }

    private StringBuffer postOrder(TreeNode root, StringBuffer sb) {
        if(root != null) {
            sb.append(root.val);
            preOrder(root.right, sb);
            preOrder(root.left, sb);
        }

        return sb;
    }

}
