public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zero = -1;

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                if (zero == -1) continue;
                nums[zero] = nums[i];
                nums[i] = 0;
                zero = (zero == i + 1) ? i : zero+1;
            } else {
                if (zero != -1) continue;
                zero = i;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums = new int[] {0, 0, 1, 0, 1};

        mz.moveZeroes(nums);
        for(int i: nums) {
            System.out.print(i);
        }
    }
}
