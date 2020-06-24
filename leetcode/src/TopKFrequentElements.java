import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    /***
     * class Solution:
     *     def topKFrequent(self, nums: List[int], k: int) -> List[int]:
     *         frequence = {}
     *
     *         for value in nums:
     *             if value in frequence:
     *                 frequence[value] += 1
     *             else:
     *                 frequence[value] = 1
     *
     *         frequence = sorted(frequence.items(), key=lambda x: x[1], reverse=True)
     *         index = 0
     *         res = []
     *
     *         for t in frequence:
     *             index += 1
     *             res.append(t[0])
     *             if index == k:
     *                 break
     *
     *         return res
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return new int[] {nums[0]};

        Arrays.sort(nums);
        int[] res = new int[k];
        int index = 0;
        int num = nums[0];

        for (int i = 1; i < nums.length; i ++) {
            if (num != nums[i]) {
                res[index++] = num;
                num = nums[i];
            }

            if (index == k) break;
        }

        return res;
    }
}
