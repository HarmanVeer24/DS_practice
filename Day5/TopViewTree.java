package Day5;
import java.util.*;
import java.io.*;

class Nod {
    Nod left;
    Nod right;
    int data;

    Nod(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TopViewTree {
    /*

    class Nod
        int data;
        Nod left;
        Nod right;
    */
    public static void topView(Nod root){
        if(root==null)return;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Map.Entry<Nod,Integer>> q = new LinkedList<>();
        q.add(new AbstractMap.SimpleEntry<>(root, 0));
        while(!q.isEmpty()){
            Map.Entry<Nod, Integer> entry = q.poll();
            Nod currentNod = entry.getKey();
            int value = entry.getValue();
            if(!map.containsKey(value)){
                map.put(value,currentNod.data);
            }
            if(currentNod.left != null){
                q.add(new AbstractMap.SimpleEntry<>(currentNod.left,value-1));
            }
            if(currentNod.right != null){
                q.add(new AbstractMap.SimpleEntry<>(currentNod.right,value+1));
            }
        }
        for(int values : map.values()){
            System.out.print(values+" ");
        }

    }

    public static Nod insert(Nod root, int data) {
        if(root == null) {
            return new Nod(data);
        } else {
            Nod cur;
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
        Nod root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}
