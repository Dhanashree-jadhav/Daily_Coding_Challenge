You are given an integer array arr of size n. An element is considered a leader if it is greater than all the elements to its right. 
Your task is to find all such leader elements in the array.

Input:
An integer array arr of size n.
Example : 
arr = [16, 17, 4, 3, 5, 2]

Output:
Return an array containing all the leader elements in the order in which they appear in the original array.
Example:
Leaders: [17, 5, 2]

Explanation
16 is not a leader because 17 (to its right) is greater.
17 is a leader because there is no element to its right that is greater.
4 is not a leader because 5 (to its right) is greater.
3 is not a leader because 5 (to its right) is greater.
5 is a leader because there is no element to its right that is greater.
2 is a leader because there is no element to its right.

Constraints:
1 ≤ n ≤ 10^6
1 ≤ arr[i] ≤ 10^9

Test Cases:
Input: [1, 2, 3, 4, 0]
Output: [4, 0]
Input: [7, 10, 4, 10, 6, 5, 2]
Output: [10, 6, 5, 2]
Input: [5]
Output: [5]
Input: [100, 50, 20, 10]
Output: [100, 50, 20, 10]
Input: [1, 2, 3, ..., 1000000]
Output: [1000000]

Edge Cases:
The array contains a single element, which is always a leader.
The array is sorted in descending order, making every element a leader.
The array is sorted in ascending order, making only the last element a leader.


Code : 
import java.util.*;

class Solution {
    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int currLeader = arr[n - 1];
        res.add(currLeader);
        
        // Traverse from second last element to first
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= currLeader) {
                currLeader = arr[i];
                res.add(currLeader);
            }
        }
        
        // Reverse to maintain original order
        Collections.reverse(res);
        return res;
    }
    
    // For local testing only (not required on GFG)
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println(leaders(arr, arr.length)); // [17, 5, 2]
    }
}
