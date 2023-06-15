import java.util.ArrayList;
import java.util.List;

class Solution {
    // Generate a single row of Pascal's triangle
    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // Inserting the 1st element

        // Compute the values for each element in the row
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / (col);
            ansRow.add((int) ans);
        }

        return ansRow;
    }

    // Generate Pascal's triangle with the specified number of rows
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        // Store the entire Pascal's triangle row by row
        for (int row = 1; row <= numRows; row++) {
            ans.add(generateRow(row));
        }

        return ans;
    }

    public static void main(String []args){
        int n = 5;
        Solution s = new Solution();

        // Print the Pascal's triangle for n rows
        System.out.println(s.generate(n)); 
    }
}