public class FindFirstandLastPosition {
//    public int[] searchRange(int[] nums, int target) {
//        if (nums.length == 0) return new int[] {-1, -1};
//        if (nums.length == 1)return  (nums[0] == target) ? new int[] {0, 0}: new int[]{-1, -1};
//
//        int head = 0, tail = nums.length - 1;
//        int[] range = new int[] {-1, -1};
//
//        while (head <= tail) {
//            if (nums[head] == target) {
//                range[0] = head;
//                if (range[1] != -1) break;
//            }
//
//            if (nums[tail] == target) {
//                range[1] = tail;
//                if (range[0] != -1) break;
//            }
//
//            if (nums[head] < target) head ++;
//            if (nums[tail] > target) tail --;
//        }
//
//        if (head == tail) {
//            if (range[0] == -1 || range[1] == -1) {
//                range[0] = Math.max(range[0], range[1]);
//                range[1] = Math.max(range[0], range[1]);
//            }
//        }
//
//        return range;
//    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};

        int head = 0, tail = nums.length - 1;
        int[] range = new int[] {-1, -1};

        while (head <= tail) {
            int mid = (head + tail) / 2;

            if (nums[mid] > target) {
                tail = mid - 1;
            } else if (nums[mid] < target) {
                head = mid + 1;
            } else {
                // make a loop from head to tail and tail to end
                while (head <= mid) {
                    if (nums[head] == target) {
                        range[0] = head;
                        break;
                    }
                    head ++;
                }

                while (tail >= mid) {
                    if (nums[tail] == target) {
                        range[1] = tail;
                        break;
                    }
                    tail --;
                }
                break;
            }
        }

        return range;
    }

    public static void main(String[] args) {
        FindFirstandLastPosition fb = new FindFirstandLastPosition();

        int[] nums = new int[]{5,7,7,8,8,10};

        int[] res = fb.searchRange(nums, 8);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
