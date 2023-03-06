class Solution {
    public int findKthPositive(int[] arr, int k) {
         int num=k;
       if(arr[0]>k){
            return k;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=num){
                num++;
            }
            else{
                break;
            }
        } return num;
    }
}