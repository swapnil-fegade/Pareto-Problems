import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int n = s.length();
    
        HashMap<Character, Integer> freqInWindow = new HashMap<>();
        
        // Stores the maximum length found so far
        int maxLength = 0;   
        // Stores the frequency of the most frequent character in the current window
        int maxFreq = 0;     

        // Iterate with the right pointer
        for (int r = 0; r < n; r++) {
            char currentChar = s.charAt(r);

            // Expand the window and update frequency
            freqInWindow.put(currentChar, freqInWindow.getOrDefault(currentChar, 0) + 1);

            // Update the maximum frequency in the current window
            maxFreq = Math.max(maxFreq, freqInWindow.get(currentChar));

            // Check if the current window is valid (can be made uniform with k replacements)
            // (Current window size) - (count of most frequent character) <= k
            // This means characters to replace <= k
            if ((r - l + 1) - maxFreq > k) {
                // If the window is invalid, shrink it from the left
                char charLeavingWindow = s.charAt(l);
                freqInWindow.put(charLeavingWindow, freqInWindow.get(charLeavingWindow) - 1);
                l++; 
            }

            // Update the maximum length found so far
            maxLength = Math.max(maxLength, r - l + 1);
        }
        
        return maxLength;
    }
}
