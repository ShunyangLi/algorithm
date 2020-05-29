import java.util.LinkedList;
import java.util.List;

public class Midan {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> list = new LinkedList<>();
        int l1 = 0, l2 = 0;

        while (l1 < nums1.length && l2 < nums2.length) {
            if (nums1[l1] < nums2[l2]) {
                list.add(nums1[l1]);
                l1 += 1;
            } else {
                list.add(nums2[l2]);
                l2 += 1;
            }
        }

        // add n2
        if (l1 >= nums1.length) {
            for (int i = l2; i < nums2.length; i ++) list.add(nums2[i]);
        } else {
            for (int i = l1; i < nums1.length; i ++) list.add(nums1[i]);
        }

        int len = list.size();
        if (len % 2 != 0) return list.get(len/2);
        return (double) (list.get(len/2) + list.get(len/2-1)) / 2;
    }

    public static void main(String[] args) {
        Midan m = new Midan();
        int[] num1 = new int[] {1,2};
        int[] num2 = new int[] {3,4};
        System.out.println(m.findMedianSortedArrays(num1, num2));
    }
}
