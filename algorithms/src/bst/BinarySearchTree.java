package bst;

import apple.laf.JRSUIUtils;

public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree() { }


    public int maxDepth(TreeNode node) {
        return maxDepthHelper(node);
    }

    private int maxDepthHelper(TreeNode node) {
        if (node == null) return 0;

        int left = maxDepthHelper(node.left);
        int right = maxDepthHelper(node.right);

        return Math.max(left, right) + 1;
    }


    public int minDepth(TreeNode node) {
        if (node == null) return 0;
        return minDepthHelper(node);
    }

    private int minDepthHelper(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;

        if (node.left == null && node.right == null) return 1;

        return Math.min(minDepthHelper(node.left), minDepthHelper(node.right)) + 1;
    }

    public TreeNode search(TreeNode root, int key) {

        if (root == null || root.val == key) return root;

        if (root.val > key) return search(root.right, key);

        return search(root.left, key);
    }


    public void insert(int key) {
        root = insertHelper(root, key);
    }

    private TreeNode insertHelper(TreeNode root, int key) {
        if (root == null) {
            TreeNode node = new TreeNode(key);
            return node;
        }

        if (root.val > key) {
            root.left = insertHelper(root.left, key);
        } else {
            root.right = insertHelper(root.right, key);
        }


        return root;
    }


    public void inOrder() {
        inOrderHelper(root);
    }

    private void inOrderHelper(TreeNode node) {
        if (node != null) {
            inOrderHelper(node.left);
            System.out.println(node.val);
            inOrderHelper(node.right);
        }
    }

    public void delete(int key) {
        root = deleteHelper(root, key);
    }


    private TreeNode deleteHelper(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val < key) {
            root.right = deleteHelper(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteHelper(root.left, key);
            return root;
        } else {


            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {

                root.val = findMinValue(root.right); // 找到以当前节点的右子节点为父节点的最左边的一个值。

                root.right = deleteHelper(root.right, root.val); // 删除掉右边节点中子节点中做左边的那个点

                return root;

            }


        }

    }

    private int findMinValue(TreeNode node) {
        int minValue = node.val;

        while(node.left != null) {
            minValue = node.left.val;
            node = node.left;
        }

        return minValue;
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(30);
        bst.insert(20);
        bst.insert(70);
        bst.insert(40);
        bst.insert(50);
        bst.insert(100);
        bst.insert(80);

        bst.inOrder();

        //bst.delete(40);
//        bst.delete(50);
//        bst.delete(100);
//        bst.delete(80);
//        bst.delete(70);
//        bst.delete(20);
//        bst.delete(30);






        System.out.println("========");

        //bst.inOrder();
    }



}

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}
        public TreeNode(int val) {this.val = val;}


        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
