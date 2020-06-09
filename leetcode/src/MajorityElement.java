import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length <= 0) return -1;
        int len = nums.length - 1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= len; i ++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) + 1 >= nums.length/2) return nums[i];
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        return -1;
    }

//    public int majorityElement(int[] nums) {
//        if (nums.length == 0) return -1;
//        Arrays.sort(nums);
//        return nums[nums.length/2];
//    }

    public static void main(String[] args) {
        MajorityElement m =  new MajorityElement();

        System.out.println(m.majorityElement(new int[]{2, 3, 3}));
    }
}
