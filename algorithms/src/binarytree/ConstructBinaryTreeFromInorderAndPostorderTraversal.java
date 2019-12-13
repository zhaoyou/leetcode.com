package binarytree;

/**
 * reference
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34782/My-recursive-Java-code-with-O(n)-time-and-O(n)-space
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }


    /**
     * start_inorder - start index for inorder array
     * end_inorder - end index for inorder array
     *
     * start_postorder - start index for postorder array
     * end_postorder - end index for postorder array
     *
     * Remember :
     * InOrder is (left subtree) node (right subtree)
     * PostOrder is (left subtree)(right subtree) (node)
     * From post order array we get the root which will be at index pe
     * while from in order we can get the number of children in the left subtree ie. root_index - start_inorder
     *
     *
     *
     * @param inorder
     * @param postorder
     * @param start_inorder
     * @param end_inorder
     * @param start_postorder
     * @param end_postorder
     * @return
     */
    private TreeNode helper(int[] inorder, int[] postorder, int start_inorder, int end_inorder, int start_postorder,
                            int end_postorder) {

        if (start_inorder > end_inorder || start_postorder > end_postorder) return null;

        TreeNode root = new TreeNode(postorder[end_postorder]);

        int root_index = 0;

        // 找到root的索引
        for(int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) { root_index = i;break;}
        }

        root.left = helper(inorder, postorder, start_inorder,
                 root_index - 1, start_postorder, start_postorder + root_index - start_inorder -1);

        root.right = helper(inorder, postorder, root_index + 1, end_inorder,
                        start_postorder + root_index - start_inorder, end_postorder - 1);

//        root.right = helper(inorder, postorder, root_index + 1, end_inorder,
//                end_postorder - (root_index - start_inorder), end_postorder - 1);




        return root;

    }

}
