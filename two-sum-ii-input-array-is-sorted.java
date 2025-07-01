class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int j=numbers.length-1;
        int i=0;
        while(true){
            if(target - numbers[i] == numbers[j]) break;

            if(target-numbers[i] > numbers[j]){
                i++;
            } else if (target-numbers[i] < numbers[j]){
                j--;
            } 
        }

        return new int[]{i+1, j+1};     
    }
}
