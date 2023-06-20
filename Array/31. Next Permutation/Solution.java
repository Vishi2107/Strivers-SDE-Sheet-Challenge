// T(n) = O(3n)
// S(n) = O(n) = O(1) {if modifying array is considered then O(n) else O(1)}

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1, i; // Variables for storing indices
        int n = nums.length; // Length of the array

        // Find the index where the decreasing order breaks
        for (i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i; // Store the index
                break;
            }
        }

        if (idx == -1) {
            // If the array is in non-increasing order, reverse it
            reverse(nums, 0, n - 1);
            return; // Exit the method
        } else {
            // Find the smallest element greater than nums[idx] towards the right
            for (i = n - 1; i > idx; i--) {
                if (nums[i] > nums[idx]) {
                    swap(nums, i, idx); // Swap the elements
                    break;
                }
            }
            // Reverse the elements from idx+1 to the end
            reverse(nums, idx + 1, n - 1);
        }
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Swap elements at start and end indices
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            // Move the indices towards the center
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5}; // Input array
        Solution s = new Solution(); // Create an instance of Solution class
        s.nextPermutation(nums); // Invoke the nextPermutation method
        System.out.println(Arrays.toString(nums)); // Print the modified array
    }
}
