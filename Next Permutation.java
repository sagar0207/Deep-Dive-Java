class Solution {
    public void nextPermutation(int[] nums) {
        
        int p = 0;
        int q = nums.length-1;
        int flag = 0;
        for(int i = nums.length-1; i>0; i--)
        {
            if(nums[i-1] < nums[i])
            {   
                p = i-1;
                flag = 1;
                break;
            }
            flag = 0;
        }
        
        for(int i = nums.length-1; i>=0; i--)
        {
            if(nums[p] < nums[i])
            {
                q = i;
                break;
            }
        }
        
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
        
        if(flag == 0)
            Arrays.sort(nums);
        else
        {
            reverse(nums, p+1, nums.length-1);
        }
    }
    public void reverse(int[] nums, int left, int right){
    while(left<right){
        int temp = nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
        left++;
        right--;
    }
    }
}
