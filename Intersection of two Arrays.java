class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
 int count=0,k=0;
      for(int i=0;i<nums1.length;i++)
      {
          for(int j=0;j<nums2.length;j++)
          {
              if(nums1[i]==nums2[j])
                 count++;
          }
      }
       int []b=new int [count];
           for(int i=0;i<nums1.length;i++)
      {
          for(int j=0;j<nums2.length;j++)
          {
              if(nums1[i]==nums2[j]){
                b[k++]=nums1[i];
              }
          }
      }
        Arrays.sort(b);
       for(int i=0;i<k;i++)
        {
           if(i+1<k){
        if(b[i]==b[i+1])
        {for(int j=i;j<k-1;j++)
            
            b[j]=b[j+1];
          k--;
         i--;
        }
          
           }
            }
        int arr[]=new int[k];
        for(int i=0;i<k;i++)
            arr[i]=b[i];
        return arr;
    }
}
