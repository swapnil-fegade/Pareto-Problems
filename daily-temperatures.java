class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>(); 

        for (int i = 0; i < n; i++) {
            // While the stack is not empty AND the current temperature is warmer
            // than the temperature at the index on top of the stack:
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); // Pop the index that found its warmer day
                answer[prevIndex] = i - prevIndex; // Calculate the number of days
            }
            // Push the current index onto the stack
            stack.push(i);
        }
        return answer;
    }
}
