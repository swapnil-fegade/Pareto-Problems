class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        int map[] = new int[26];
        Arrays.fill(map, 0);

        for(char ch : s.toCharArray()){
            map[ch - 'a']++;
        }

        for(char ch : t.toCharArray()){
            if(map[ch - 'a']!=0){
                map[ch - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}
