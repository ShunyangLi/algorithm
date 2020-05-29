import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i ++) {
            int sub = 0 - nums[i];

            Map<Integer, Integer> map = new HashMap<>();
//            int j = i + 1;
            for (int j = 0; j < nums.length; j ++) {
                int s = sub - nums[j];
                if (map.containsKey(s)) {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(nums[i]);
                    temp.add(nums[map.get(s)]);
                    temp.add(nums[j]);
                    list.add(temp);
                    break;
                }
                else map.put(nums[j], j);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ThreeSum tm = new ThreeSum();
        List<List<Integer>> list = tm.threeSum(new int[] {-1, 0, 1, 2, -1, -4});

        for (List s: list) {
            System.out.println(s);
        }
    }
}
