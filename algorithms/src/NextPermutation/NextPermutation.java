package NextPermutation;

public class NextPermutation {
    public static void main(String[] args) {
        int [] nums = {1,2,7,4,3,1};
//        int [] nums = {1,2,1};
//        int [] nums = {5, 3, 2, 1};

        //int [] nums = {1, 3, 2};
        display(nums);
        new NextPermutation().nextPermutation(nums);
        display(nums);
    }


    public  static void display(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
    }

    public void nextPermutation(int[] nums) {
        for (int j = nums.length - 1; j > 0; j --) {
            if (nums[j] > nums[j - 1]) {
                for (int k = nums.length - 1; k >=j; k --) {
                    if (nums[k] > nums[j - 1]) {
                        int temp = nums[k];
                        nums[k] = nums[j - 1];
                        nums[j - 1] = temp;
                        break;
                    }
                }
                sort(nums, j, nums.length);
                return;
            }

        }
        sort(nums, 0, nums.length);
    }


    public void sort(int[] nums, int start, int end) {
        for (;start < end; start ++) {
            for (int j = start + 1; j < end; j++) {
                if (nums[start] > nums[j]) {
                    int temp = nums[start];
                    nums[start] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
