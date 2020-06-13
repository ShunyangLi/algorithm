import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Disappeared {
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> dis = new LinkedList<>();
//        if (nums.length == 0) return dis;
//        Arrays.sort(nums);
//
//        int num = nums[0];
//        while (num > 1) {
//            num --;
//            dis.add(num);
//        }
//
//        num = nums[0];
//
//        for (int i = 1; i < nums.length; i ++) {
//            while (num + 1 != nums[i] && num != nums[i]) {
//                num++;
//                dis.add(num);
//            }
//            num = nums[i];
//        }
//
//        num = nums[nums.length-1];
//        while (num != nums.length) {
//            num++;
//            dis.add(num);
//        }
//        return dis;
//    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> dis = new LinkedList<>();
        if (nums.length == 0) return dis;

        for (int i = 0; i < nums.length; i ++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i ++) if (nums[i] > 0) dis.add(i + 1);

        return dis;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,3,2,7,8,2,3,1};
        Disappeared d = new Disappeared();
        List<Integer> res = d.findDisappearedNumbers(nums);
    }
}
