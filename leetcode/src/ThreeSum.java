import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        if (nums.length < 3) return list;
        List<Integer> temp = null;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i ++) {
            int sub = 0 - nums[i];
            if (temp != null) if (temp.contains(nums[i])) continue;

            int left = 0, right = nums.length - 1;
            while (left != right) {
                if (left == i){
                    left ++;
                    continue;
                }
                if (right == i) {
                    right --;
                    continue;
                }
                int sum = nums[left] + nums[right];

                if (sum < sub) left ++;
                else if (sum > sub) right --;
                else {
                    temp = new LinkedList<>();
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    temp.add(nums[i]);

                    Collections.sort(temp);
                    if(list.contains(temp)) break;
                    list.add(temp);
                    break;
                }
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
