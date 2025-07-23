class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int num:nums){
            pq.add(num);
        }
        
        int ans = -100000;
        for(int i=0;i<k;i++){
            ans = pq.poll();
        }

        return ans;
    }
}
