import java.util.Arrays;

public class Sort {
    /**
     * bubble sort methods
     * 冒泡排序，就是较大的数和较小的数字交换位置，一直这样循环，
     * 直到最后，这样就排序完了
     * O(n^2)
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
