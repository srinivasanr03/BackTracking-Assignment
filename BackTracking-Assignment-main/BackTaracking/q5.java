public class q5 {
    public int totalNQueens(int n) {
        int[] queens = new int[n];
        return backtrack(queens, 0);
    }

    private int backtrack(int[] queens, int row) {
        int count = 0;
        if (row == queens.length) {
            return 1; // Found a valid solution
        }
        for (int col = 0; col < queens.length; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col; // Place queen at current position
                count += backtrack(queens, row + 1); // Try placing queens in the next row
            }
        }
        return count;
    }

    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false; // Queens in the same column or diagonal
            }
        }
        return true;
    }

    public static void main(String[] args) {
        q5 solution = new q5();
        int n = 4;
        System.out.println("Number of distinct solutions for " + n + "-queens puzzle: " + solution.totalNQueens(n)); // Output: 2
    }
}
