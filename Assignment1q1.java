class Assignment1Q1 {

    // Function that finds the maximum
    // Sub-Matrix Sum
    static int maxSubMatSum(int[][] mat) {
        // Number of rows in the matrix
        int n = mat.length;

        // Number of columns in the matrix
        int m = mat[0].length;

        int i, j;

        // dp[][] matrix to store the
        // results of each iteration
        int[][] dp = new int[n][m];

        // Base Case - The largest
        // element in the matrix
        dp[n - 1][m - 1] = mat[n - 1][m - 1];

        // To stores the final result
        int res = dp[n - 1][m - 1];

        // Find the max sub matrix sum for
        // the last row
        for (i = m - 2; i >= 0; i--) {
            dp[n - 1][i] = mat[n - 1][i] + dp[n - 1][i + 1];

            // Check whether the current
            // sub-array yeilds maximum sum
            res = Math.max(res, dp[n - 1][i]);
        }

        // Calculate the max sub matrix
        // sum for the last column
        for (i = n - 2; i >= 0; i--) {
            dp[i][m - 1] = mat[i][m - 1] + dp[i + 1][m - 1];

            // Check whether the current
            // sub-array yeilds maximum sum
            res = Math.max(res, dp[i][m - 1]);
        }

        // Build the dp[][] matrix from
        // bottom to the top row
        for (i = n - 2; i >= 0; i--) {
            for (j = m - 2; j >= 0; j--) {

                // Update sum at each
                // cell in dp[][]
                dp[i][j] = mat[i][j] + dp[i][j + 1] + dp[i + 1][j] - dp[i + 1][j + 1];

                // Update the maximum sum
                res = Math.max(res, dp[i][j]);
            }
        }

        // Return the maximum sum
        return res;
    }

    // Driver Code
    public static void main(String[] args) {
        // Given matrix mat[][]
        int[][] mat = { { -6, -4, -1 }, { -3, 2, 4 }, { 2, 5, 8 } };

        // Function Call
        System.out.println(maxSubMatSum(mat));
    }
}