import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    // 放弃了我使用hashmap来写好吧。。。
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII c = new ContainsDuplicateII();
        int[] nums = new int[] {1,2,3,1,2,3};

        System.out.println(c.containsNearbyDuplicate(nums, 2));
    }
}
