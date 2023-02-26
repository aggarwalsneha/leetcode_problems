class Solution {
    public int nthUglyNumber(int n) {
        int[] arr=new int[n];
        arr[0]=1;
        int i1=0,i2=0,i3=0;
        for(int i=1;i<n;i++)
        {
            int two=arr[i1]*2;
            int three=arr[i2]*3;
            int five=arr[i3]*5;
            arr[i]=Math.min(two,Math.min(three,five));
            if(arr[i]==two)
                i1++;
            if(arr[i]==three)
                i2++;
            if(arr[i]==five)
                i3++;
        }
        return arr[n-1];
    }
}