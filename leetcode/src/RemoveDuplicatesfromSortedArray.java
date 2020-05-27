import java.util.*;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int dup = nums[0];
        int curr = 1;

        for (int i = 0; i < nums.length; i ++) {
            if (dup != nums[i]) {
                dup = nums[i];
                nums[curr++] = nums[i];
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
        int[] arr = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println(r.removeDuplicates(arr));

    }
}
