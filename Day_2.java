
Day 2 of 30 🗓

Problem : Find the Missing Number
You are given an array arr containing n-1 distinct integers. The array consists of integers taken from the range 1 to n,
meaning one integer is missing from this sequence. Your task is to find the missing integer.

Input :
An integer array arr of size n-1 where the elements are distinct and taken from the range 1 to n.
Example : arr = [1, 2, 4, 5]

Output :
Return the missing integer from the array.
Example: Missing number: 3


code :
public class MissingNumberFinder {

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1; // since one number is missing
        int expectedSum = n * (n + 1) / 2; // sum of first n natural numbers
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};  // Example input
        System.out.println("Missing number: " + findMissingNumber(arr));
    }
}

Output : 
Missing number: 3
