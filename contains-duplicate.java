class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<Integer>();

        for(int i=0;i<nums.length;i++){
            if(!numbers.contains(nums[i]))
                numbers.add(nums[i]);
        }

        return nums.length == numbers.size() ? false : true;
    }
}
