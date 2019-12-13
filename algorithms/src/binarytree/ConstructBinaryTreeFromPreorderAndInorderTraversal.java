package binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);


    }

    private TreeNode helper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie, Map<Integer, Integer> map) {

        if (ps > pe) return null;

        TreeNode root = new TreeNode(preorder[ps]);

        int ri = map.get(root.val);
        int left_count = ri - is;
        root.left = helper(preorder, inorder, ps + 1, ps + ri - is,  is, ri - 1, map);
        root.right = helper(preorder, inorder, ps + ri - is + 1, pe, ri + 1 , ie, map);

        return root;
    }


}
