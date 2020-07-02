import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        back_tracking(res, new ArrayList<>(), target, candidates, 0);
        return res;
    }

    // 回溯算法
    public void back_tracking(List<List<Integer>> res, List<Integer> temp, int target, int[] nums, int index) {
        if (target < 0) return;
        else if (target == 0) res.add(new ArrayList<>(temp));
        else {
            for (int i = index; i < nums.length; i ++) {
                temp.add(nums[i]);
                back_tracking(res, temp, target - nums[i], nums, i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] nums = new int[] {2,3,6,7};
        List<List<Integer>> res = cs.combinationSum(nums, 7);

        for (List<Integer> l : res) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}

