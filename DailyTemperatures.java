// Time Complexity : O(2n) -> O(n)
// Space Complexity :  :(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * Problem# : 739 Daily Temperatures
 * 
 * This is monotonically increasing stack: Something that is always increasing not decreasing.
 * 
 * If we have to do it in burte force, we have to be exhaustive and it is an n^2 solution
 * 
 * We can improve using stacks.
 * Go through the temperatures array once
 * and if stack is not empty and the top element of stack is greater than the current i |or| stack is empty
 * 
 * add the ith element to the stack
 * 
 * if stack is not empty and the top element of stack is less than the current temperatures[i] -> pop the stack 
 * result[popped]= i-popped gives the number of days 
 * 
 * Things to remember: 
 * the default if we don't find an increasing day is 0, which will be taken care by the default array creation. Lets say if we want to return -1 for days we cannot resolve, we have to fill the Array first with all the defaults.
 */

import java.util.*;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        // Monotonically increasing
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!st.empty() && temperatures[st.peek()] < temperatures[i]) {
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.add(i);
        }

        return result;
    }
}
