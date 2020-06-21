import java.util.Arrays;

public class Sort {
    /**
     * bubble sort methods
     * @param nums which need to be sorted
     */
    public void bubble_sort(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < nums.length; j ++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 2, 5};
        Sort sort = new Sort();
        sort.bubble_sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
