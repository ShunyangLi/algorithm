public class ContainerWithMostWater {
    /**
     * very good
     * @param height int[] array
     * @return max area
     */
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0, r = height.length-1;

        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * Math.abs(r - l));
            if (height[l] < height[r]) l ++;
            else r --;
        }

        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        int[] nums = new int[] {2,3,4,5,18,17,6};
        System.out.println(c.maxArea(nums));
    }
}
