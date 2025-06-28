class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if(map.containsKey(diff) == true)
            {
                return new int[]{i,map.get(diff)}; 
                //map.get(diff) will return the index of the diff from the map
            }

            map.put(nums[i],i);
        }

        return null;



    }
}
