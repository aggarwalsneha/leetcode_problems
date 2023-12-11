class Solution {
    public int findSpecialInteger(int[] arr) {
        int c=arr.length/4;
        for(int i=0;i<arr.length-c;i++){
            if(arr[i]==arr[i+c])
                return arr[i];
        }
        return -1;
    }
}