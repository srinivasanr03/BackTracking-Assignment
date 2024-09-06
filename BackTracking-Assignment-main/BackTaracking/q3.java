import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q3 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue; // Skip duplicate elements
            }
            permutation.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, permutation, result);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        q3 solution = new q3();
        int[] nums = {1, 1, 2};
        List<List<Integer>> permutations = solution.permuteUnique(nums);
        System.out.println("All unique permutations:");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
