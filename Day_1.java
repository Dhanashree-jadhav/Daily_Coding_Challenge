You are given an array arr consisting only of 0s, 1s, and 2s. The task is to sort the array in increasing order in linear time (i.e., O(n)) without using any extra space. This means you need to rearrange the array in-place.

Input:
An integer array arr of size n where each element is either 0, 1, or 2.
Example : arr = [0, 1, 2, 1, 0, 2, 1, 0]

Output:
The sorted array, arranged in increasing order of 0s, 1s, and 2s.
Example: [0, 0, 0, 1, 1, 1, 2, 2]

Constraints:
The input array may have up to 105 elements.
The values in the array are limited to 0, 1, and 2.
The sorting algorithm must operate in linear time (i.e., O(n)) and in-place (i.e., without using extra space beyond a few variables).

Approach:
You can solve this problem using the Dutch National Flag Algorithm developed by Edsger Dijkstra.

Test Cases:
Test Case 1
Input: [0, 1, 2, 1, 0, 2, 1, 0]
Output: [0, 0, 0, 1, 1, 1, 2, 2]
Test Case 2:
Input: [2, 2, 2, 2]
Output: [2, 2, 2, 2]
Test Case 3:
Input: [0, 0, 0, 0]
Output: [0, 0, 0, 0]
Test Case 4:
Input: [1, 1, 1, 1]
Output: [1, 1, 1, 1]
Test Case 5:
Input: [2, 0, 1]
Output: [0, 1, 2]
Test Case 6:
Input: []
Output: []

Edge Cases:
Empty array.
Array with all elements the same (all 0s, all 1s, or all 2s).
Array already sorted. give me code for this challenge in java  


  
Code : 
public class SortColors {

    public static void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid], increment low and mid
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    // Just move mid
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high], decrement high
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {0, 1, 2, 1, 0, 2, 1, 0},  // Test Case 1
            {2, 2, 2, 2},              // Test Case 2
            {0, 0, 0, 0},              // Test Case 3
            {1, 1, 1, 1},              // Test Case 4
            {2, 0, 1},                 // Test Case 5
            {}                         // Test Case 6
        };

        for (int[] testCase : testCases) {
            sortColors(testCase);
            System.out.println(java.util.Arrays.toString(testCase));
        }
    }
}



Output : 
[0, 0, 0, 1, 1, 1, 2, 2]
[2, 2, 2, 2]
[0, 0, 0, 0]
[1, 1, 1, 1]
[0, 1, 2]
[]
