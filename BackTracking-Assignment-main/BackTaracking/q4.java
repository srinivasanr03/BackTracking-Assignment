public class q4 {
    public boolean isSubsetProductEqualToTarget(int[] nums, int target) {
        return backtrack(nums, 0, 1, target);
    }

    private boolean backtrack(int[] nums, int index, int currentProduct, int target) {
        if (currentProduct == target) {
            return true;
        }
        if (index == nums.length || currentProduct > target) {
            return false;
        }
        // Include the current element
        if (backtrack(nums, index + 1, currentProduct * nums[index], target)) {
            return true;
        }
        // Exclude the current element
        if (backtrack(nums, index + 1, currentProduct, target)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        q4 solution = new q4();
        int[] nums1 = {1, 2, 3, 4};
        int target1 = 6;
        System.out.println("Subset product equal to target? " + solution.isSubsetProductEqualToTarget(nums1, target1)); // Output: true

        int[] nums2 = {2, 3, 5};
        int target2 = 10;
        System.out.println("Subset product equal to target? " + solution.isSubsetProductEqualToTarget(nums2, target2)); // Output: true

        int[] nums3 = {2, 3, 6};
        int target3 = 10;
        System.out.println("Subset product equal to target? " + solution.isSubsetProductEqualToTarget(nums3, target3)); // Output: false
    }
}
