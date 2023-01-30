class Solution {
    public int missingNumber(int[] arr) {
        int[] count=new int[arr.length+1];
        for(int num:arr)
            count[num]++;
        for(int i=0;i<count.length;i++)
        {
            if(count[i]==0)
                return i;
        }
        return 0;
    }
}