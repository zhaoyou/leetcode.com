package SearchInRotatedSortedArray;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;
        System.out.println(new SearchInRotatedSortedArray().search2(nums, target));
    }

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while(start < end) {
            int mid = start + ((end - start) / 2);

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + ((end - start) / 2);

            if (nums[mid] == target) return mid;


            if (nums[mid] < nums[end]) {

                if (nums[mid] <= target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }


            } else {

                if (nums[start] <= target && nums[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }

        }
        return -1;
    }
}
