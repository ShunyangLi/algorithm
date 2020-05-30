public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // the last position of array
        int last = nums1.length - 1;
        m--; n--;
        while (m > 0 && n > 0) {
            if (nums1[m] > nums2[n]) nums1[last--] = nums1[m--];
            else nums1[last--] = nums2[n--];
        }

        while (m > 0) nums1[last--] = nums1[m--];
        while (n > 0) nums1[last--] = nums2[n--];
    }

    public static void main(String[] args) {
        int[] num1 = new int[] {1,2,3,0,0,0};
        int[] num2 = new int[] {2,5,6};

        MergeSortedArray m = new MergeSortedArray();
        m.merge(num1, 3, num2, 3);

        for (int x: num1) {
            System.out.println(x);
        }
    }
}
