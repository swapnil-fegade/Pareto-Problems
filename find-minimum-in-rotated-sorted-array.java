// Intended sol 
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];        
    }
}

// but this works too for some reason 
class Solution {
    public int findMin(int[] nums) {
        for(int i=nums.length-1; i > 0; i--){
            if(nums[i] < nums[i-1]){
                return nums[i];
            }
        }

        return nums[0];
    }
}
