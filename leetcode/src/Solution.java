import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            int minus = target - nums[i];

            if (map.containsKey(minus)) {
                return new int[]{map.get(minus), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

    int[] another(int[] nums, int target) {
        int head = 0;
        int tail = 0;

        // sort it
        Arrays.sort(nums);

        while (true) {
            int value = nums[head] + nums[tail];

            if (value == target) break;
            else if (value > target) tail -= 1;
            else head += 1;

            if (head == tail) break;
        }

        if (head != tail) return new int[] {nums[head], nums[tail]};
        return null;
    }
}
