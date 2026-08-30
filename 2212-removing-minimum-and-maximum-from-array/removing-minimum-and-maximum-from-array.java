class Solution {
    public int minimumDeletions(int[] nums) {
        int min = 0, max = 0, n = nums.length;
        for (int i = 1; i < n; i++){
            if (nums[i] > nums[max]){
                max = i;
            }
            if (nums[i] < nums[min]){
                min = i;
            }
        }
        int removeFront = Math.max(min,max) + 1;
        int removeEnd = n - Math.min(min,max);
        int removeSides = Math.min(min + 1 + (n - max), max + 1 + (n - min));
        return Math.min(removeFront, Math.min(removeEnd,removeSides));
    }
}