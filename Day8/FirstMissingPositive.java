package Day8;

import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int z = 1;
        // Set<Integer> set = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     set.add(nums[i]);
        // }
        // for(int i=0;i<set.size();i++){
        //     if(set.contains(z)){
        //         z++;
        //     }
        //     else{
        //         break;
        //     }
        // }
        // return z;
        Arrays.sort(nums);
        int smallest = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == smallest) {
                smallest++;
            }
        }
        return smallest;
    }
}
