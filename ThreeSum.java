import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort the array to make use of two-pointer technique
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // To avoid duplicates
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1;
                int right = nums.length - 1;
                int target = -nums[i];

                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // To avoid duplicates
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println("Unique triplets that sum up to 0:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
