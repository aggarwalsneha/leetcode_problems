class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    static int mergeSort(int[] arr,int l,int r)
    {
        int count=0;
        if(l<r)
        {
            int mid=(l+r)/2;
            count+=mergeSort(arr,l,mid);
            count+=mergeSort(arr,mid+1,r);
            count+=merge(arr,l,mid,r);
        }
        return count;
    }
    static int merge(int[] arr,int l,int mid,int r)
    {
        int n1=mid-l+1;
        int n2=r-mid;
        int[] L=new int[n1];
        int[] R=new int[n2];
        int i,j,k;
        int count=0;
        for(i=0;i<n1;i++)
        L[i]=arr[l+i];
        for(j=0;j<n2;j++)
        R[j]=arr[mid+1+j];
        i=0;
        j=0;
        k=l;
        for(int m=0;m<n1;m++)
        {
            while(j<n2 && L[m]>2*(long)R[j]){
            j++;
            }
            count+=j;
        }
        j=0;
        while(i<n1 && j<n2)
        {
            if(L[i]<=R[j])
            {
                arr[k]=L[i];
                i++;
            }
            else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1)
        {
            arr[k]=L[i];
            i++;
            k++;
        }
         while(j<n2)
        {
            arr[k]=R[j];
            j++;
            k++;
        }
        return count;
    }
}