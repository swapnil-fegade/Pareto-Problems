class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0; 
        
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        int maxLength = 0; 
        int left = 0;      
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (lastIndex.containsKey(currentChar) && lastIndex.get(currentChar) >= left) {
                left = lastIndex.get(currentChar) + 1;
            }
        
            lastIndex.put(currentChar, right); //updating the last seen index of the curr char
            
    
            maxLength = Math.max(maxLength, right - left + 1); // size of the window = lengthOfLongestSubstring
        }
        
        return maxLength;
    }
}
