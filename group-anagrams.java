class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String canonicalKey = new String(charArray); // unique key for anagrams

            
            if (anagramGroups.containsKey(canonicalKey)) {
                anagramGroups.get(canonicalKey).add(str);
            } else {    
                List<String> newList = new ArrayList<>();
                newList.add(str);
                anagramGroups.put(canonicalKey, newList);
            }
        }

        //return the map's values (which are the lists of anagrams) into a List of List<String>.
        return new ArrayList<>(anagramGroups.values());
    }
}
