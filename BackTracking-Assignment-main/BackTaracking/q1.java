import java.util.Arrays;

public class q1 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false; // If the total sum is not divisible by k, it's not possible to form k equal subsets
        }
        int targetSum = sum / k;
        boolean[] visited = new boolean[nums.length];
        return backtrack(nums, k, 0, 0, targetSum, visited);
    }

    private boolean backtrack(int[] nums, int k, int startIndex, int currentSum, int targetSum, boolean[] visited) {
        if (k == 0) {
            return true; // All subsets have been formed
        }
        if (currentSum > targetSum) {
            return false; // Subset sum exceeded the target sum, backtrack
        }
        if (currentSum == targetSum) {
            return backtrack(nums, k - 1, 0, 0, targetSum, visited); // Move to the next subset
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (backtrack(nums, k, i + 1, currentSum + nums[i], targetSum, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        q1 solution = new q1();
        int[] nums = {1, 3, 2, 2};
        int k = 2;
        System.out.println("Possible to divide into k subsets with equal sum? " + solution.canPartitionKSubsets(nums, k)); // Output: true
    }
}
