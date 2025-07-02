class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int h,w,max=0;
        int water = 0;

        while(left<right){
            h = Math.min(height[left], height[right]);
            w = right - left;
            water = h*w;

            max = Math.max(max,water);
            
            if(height[left]<height[right])
            {
                left++;
            }
            else
            {
                right--;
            }           
        }
        return max;
    }
}
