public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int curr = 0;

        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[curr++] = nums[i];
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] data = new int[] {0,1,2,2,3,0,4,2};
        System.out.println(re.removeElement(data, 2));


    }
}
