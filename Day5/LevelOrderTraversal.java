package Day5;

import java.util.*;
import java.io.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class LevelOrderTraversal {

    /*

    class TreeNode
        int data;
        TreeNode left;
        TreeNode right;
    */
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int datasize = q.size();
            for(int i=0;i<datasize;i++){
                TreeNode curr = q.poll();
                System.out.print(curr.data+" ");

                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }

    public static TreeNode insert(TreeNode root, int data) {
        if(root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        TreeNode root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}