package interviewEasy.Tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while(!queue.isEmpty()) {

            int queueSize = queue.size();

            List<Integer> subList = new ArrayList<>();

            for(int i = 0; i < queueSize; i++) {
                TreeNode current = queue.poll();  //每次从队列里面取出，需要在循环里面去获取

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
                subList.add(current.val);
            }

            list.add(subList);
        }

        return list;
    }
}
