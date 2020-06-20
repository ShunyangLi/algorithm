import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for (int num : nums) {
            hashSet.add(num);
        }

        return nums.length != hashSet.size();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3, 1};
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.containsDuplicate(nums));
    }
}
