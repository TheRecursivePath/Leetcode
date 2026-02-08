import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1_Two_Sum {
    public static int[] twoSum_BruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) { // for selecting the first number
            int num1 = nums[i]; // first number
            for (int j = i + 1; j < n; j++) { // for selecting the second number
                int num2 = nums[j]; // second number
                if (num1 + num2 == target) { // checking the condition
                    return new int[] { i, j }; // returning the array
                }
            }
        }
        return new int[] { -1, -1 }; // Ideally code should not reach to this retrun as it is guaranteed that there
                                     // is alaways going to be one solution.
    }

    public static int[] twoSum_Optimal(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // Key: number, Value: index
        for (int i = 0; i < n; i++) { // iterating through the array
            int num = nums[i]; // current number
            int complement = target - num; // complement of the current number
            if (map.containsKey(complement)) { // checking if the complement is in the map
                return new int[] { map.get(complement), i }; // returning the indices
            }
            map.put(num, i); // putting the current number and its index in the map
        }
        return new int[] { -1, -1 }; // Ideally code should not reach to this retrun as it is guaranteed that there
                                     // is alaways going to be one solution.
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] res = twoSum_BruteForce(nums, target);
        System.out.println("Brute Force: " + Arrays.toString(res));
        int[] res2 = twoSum_Optimal(nums, target);
        System.out.println("Optimal: " + Arrays.toString(res2));
    }
}
