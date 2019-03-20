class Solution {
    int[] original = null;
    int[] shuffle = null;
    Random rand = null;
    public Solution(int[] nums) {
        original = nums;
        shuffle = Arrays.copyOf(nums, nums.length);
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        //shuffle = Arrays.copyOf(original, original.length);
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i<shuffle.length; i++)
        {
            int randomPosition = rand.nextInt(shuffle.length);
            int temp = shuffle[i];
            shuffle[i] = shuffle[randomPosition];
            shuffle[randomPosition] = temp;
        }
        return shuffle;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
