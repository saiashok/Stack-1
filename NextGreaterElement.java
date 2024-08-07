// Time Complexity : O(n)+ O(2n)+O(n) -> O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * Problem# :503. Next Greater Element II in a circular array
 * 
 * A monotonically increasing order to be identified in a circular array.
 * 
 * The default value if we couldnt find a increasing number is -1, so fill the Array with default.
 * 
 * Since its a circular array and we will have to go through the array twice
 * since we are going twice, the index will be i%n 
 * 
 * if the stack is empty or if the stack is not empty and the top elemenent of the stack is greater than the current element -> just add the element to the stack.
 * -> We hope to find a elmement greater than the current in future. if not the default value is -1
 * 
 * if the stack is not empty and the top elemenet fo the stack is smaller than the current element, we found a monotonically increasing sequence number
 * -> pop the element of the stack
 * -> result[popped] = nums[i%n]
 * 
 * //small improvements:
 * we need not add the element in the second pass, we are only trying to resolve or look for a greater element
 * if we end in a full circle and reach the same index - break 
 */

import java.util.*;

public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // add values as default
        for (int i = 0; i < 2 * n; i++) { // Go through twice, since the last element might have a increasing value in
                                          // the beginning of the array
            while (!st.isEmpty() && nums[st.peek()] < nums[i % n]) { // O(n)-
                // FOund an element that is greater than the current peek ; so resolve.
                int popped = st.pop();
                result[popped] = nums[i % n];
            }
            if (i < n) {
                st.add(i % n); // add only in the first pass i.e., don't add in the second pass
            } else {
                if (st.peek() == i % n)
                    break; // if you are already at the same index as in stack, break - we dont have to
                           // continue till 2*n
            }
        }
        return result;
    }
}
