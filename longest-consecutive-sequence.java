// My sol
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 0) return 1;

        Set<Integer> st = new TreeSet<>();
        int maxLen = 0;
        int len = 0;
    
        for(int num:nums){
            st.add(num);
        }
        

        for(int num : st){
            if(st.contains(num+1)) len++;
            else len = 0 ;

            maxLen = Math.max(maxLen, len);
        }

        return maxLen+1;
    }
}

// Optimised sol
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }

        int maxLen = 0;

        for (int num : st) {
            if (!st.contains(num - 1)) {
                int length = 1;

                while (st.contains(num + length)) {
                    length++;
                }

                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;        
    }
}
