import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        if (nums.length < 3) return list;
        Arrays.sort(nums);

        // assume the list is sorted
        // then just make a loop
        for (int i = 0; i < nums.length - 1; i ++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int num = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left <= right) {
                if (left == right) break;
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right --;
                    continue;
                }
                if (nums[left] + nums[right] == num) {
                    // then add numbers to the list
                    List<Integer> temp = new LinkedList<Integer>(
                            Arrays.asList(nums[i], nums[left], nums[right])
                    );
                    list.add(temp);
                    while (left < right && nums[left] == nums[left+1]) left ++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left ++;
                    right --;
                } else if (nums[left] + nums[right] < num) {
                    left ++;
                } else {
                    right --;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        ThreeSum tm = new ThreeSum();
//        List<List<Integer>> list = tm.threeSum(new int[] {-1,0,1,2,-1,-4});
        List<List<Integer>> list = tm.threeSum(new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});

        for (List s: list) {
            System.out.println(s);
        }
    }
}
