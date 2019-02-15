
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        k = Math.abs(k);
        int sum = 0;
        int flag = 0;
        map.put(0,-1);
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i]!= 0)
                flag = 1;
        }
        if(k == 0 && flag == 1)
            return false;
        if(nums.length >= 2)
        {
            for(int i = 0; i<nums.length; i++)
            {
                sum+=nums[i];
                if(k!=0)
                    sum%=k;
                
                if(map.containsKey(sum))
                {
                    if(i - map.get(sum) > 1)
                        return true;
                }
                else
                    map.put(sum, i);
            }
            return false;
        }
        else
            return false;
    }
}
