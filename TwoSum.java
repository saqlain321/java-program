import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Map to store each number's index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                // Return indices of complement and current number
                return new int[] { map.get(complement), i };
            }
            // Add current number and its index to the map
            map.put(nums[i], i);
        }
        // If no solution found, return null
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        if (result != null) {
            System.out.println("Indices of two numbers that sum up to " + target + ": " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
}
