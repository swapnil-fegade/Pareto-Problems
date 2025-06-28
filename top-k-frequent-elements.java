class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length)
            return nums;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] arr = new ArrayList[nums.length + 1];
        for (int num : map.keySet()) //freq->   [0 1 2 3 ....]
        {                           //num->     [  3 2 1 ....]
            int freq = map.get(num);
            if (arr[freq] == null) //index is the freq
                arr[freq] = new ArrayList<>();
            arr[freq].add(num); //Add num to bucket at the index corresponding to its freq
        }

        int[] res = new int[k];
        int j = 0;
        for (int i = arr.length - 1; i >= 0 && j < k; i--) // Traverse from highest count to low
        {
            if (arr[i] != null) {
                for (int num : arr[i]) {
                    res[j] = num;
                    j++;
                }
            }
        }
        return res;

    }
}
