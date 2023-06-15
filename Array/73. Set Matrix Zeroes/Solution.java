// Better approach
// T(n) = O(2*m*n)
// S(n) = O(n+m)
// int[] row = new int[n]; // row array
//         int[] col = new int[m]; // col array

//         // Traverse the matrix:
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (matrix.get(i).get(j) == 0) {
//                     // mark ith index of row wih 1:
//                     row[i] = 1;

//                     // mark jth index of col wih 1:
//                     col[j] = 1;
//                 }
//             }
//         }

//         // Finally, mark all (i, j) as 0
//         // if row[i] or col[j] is marked with 1.
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (row[i] == 1 || col[j] == 1) {
//                     matrix.get(i).set(j, 0);
//                 }
//             }
//         }

        
//     }

// Optimal approach
// T(n)=O(2*m*n)
// S(n)=O(1)

import java.util.Arrays;
class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1; // Variable to track if the first column needs to be set to zero
        int n = matrix.length; // Number of rows in the matrix
        int m = matrix[0].length; // Number of columns in the matrix

        // Iterate through the matrix to mark the rows and columns that need to be set to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Mark i-th row
                    matrix[i][0] = 0;

                    // Mark j-th column
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        // Set the appropriate cells to zero based on the marked rows and columns
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Set the first row to zero if the first cell is marked
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Set the first column to zero if col0 is marked
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 1, 1},{1, 0, 1},{1, 1, 1}};
        Solution s = new Solution();
        s.setZeroes(matrix);
        
        Arrays.stream(matrix).forEach(a -> System.out.println(Arrays.toString(a)));
    }
}
