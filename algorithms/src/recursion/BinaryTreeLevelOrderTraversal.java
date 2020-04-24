package recursion;

import binarytree.TreeNode;
import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();

        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {


            int size = queue.size();

            List<Integer> sub = new LinkedList<>();

            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                sub.add(cur.val);

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }

            list.add(sub);
        }

        return list;
    }

}
