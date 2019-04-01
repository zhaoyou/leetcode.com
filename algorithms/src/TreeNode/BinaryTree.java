package TreeNode;

public class BinaryTree {

    TreeNode root;

    public BinaryTree() {

    }

    public BinaryTree(TreeNode treeNode) {
        root = treeNode;
    }

    void preorder(TreeNode current) {

        if (current != null) {

            System.out.println(current.val);

            preorder(current.left);
            preorder(current.right);
        }

    }
    void inorder(TreeNode current) {

        if (current != null) {

        }

    }

    void postorder(TreeNode current) {

    }

    void Levelorder() {

    }

    /**
     *
     * @param args
     */


    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");

        TreeNode nodeH = new TreeNode("H");
        TreeNode nodeI = new TreeNode("I");

        nodeA.left = nodeB;
        nodeA.right = nodeC;

        nodeB.left = nodeD;
        nodeB.right = nodeE;

        nodeE.left = nodeG;
        nodeE.right = nodeH;

        nodeC.left = nodeF;
        nodeF.right = nodeI;


        BinaryTree binaryTree = new BinaryTree(nodeA);

        binaryTree.preorder(binaryTree.root);



    }

}
