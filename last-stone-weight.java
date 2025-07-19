class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int weight:stones){
            maxHeap.add(weight);
        }

        while(!maxHeap.isEmpty()) {
            int x = maxHeap.poll(); 
            if(maxHeap.peek()==null) return x;
            int y = maxHeap.poll();
            if(x!=y)
            maxHeap.add(x-y);
            
        }

        return 0;
    }
}
