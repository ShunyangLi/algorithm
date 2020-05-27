public class Midan {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mid = ((nums1.length + nums2.length)%2 == 0) ?
                new int[]{(nums1.length+nums2.length / 2) - 2, (int)(nums1.length+nums2.length / 2) - 1}:
                new int[]{(nums1.length+nums2.length / 2) - 1};

        int[] nums = new int[]{0, 0};
        int n1 = 0; int n2 = 0;
        int curr = 0; int mids = 0;

        while (n1 < nums1.length || n2 < nums2.length) {
            if (mids > 2 || curr > 2) break;
            if (n1 == mid[mids]) {
                nums[curr] = nums1[n1];
                curr += 1;
                mids += 1;
            }
            if (n2 == mid[mids]) {
                nums[curr] = nums2[n2];
                curr += 1;
                mids += 1;
            }

            n1 += (nums1[n1] > nums2[n2]) ? 1 : 0;
            n2 += (nums1[n1] < nums2[n2]) ? 1 : 0;
        }

        if (mid.length == 1) return nums[0];
        return (double) ((nums[0] + nums[1]) / 2);
    }

    public static void main(String[] args) {
        Midan m = new Midan();
        int[] num1 = new int[] {1,3};
        int[] num2 = new int[] {2};
        System.out.println(m.findMedianSortedArrays(num1, num2));
    }
}
