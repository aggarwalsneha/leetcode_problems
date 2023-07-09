/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak=peakIndex(mountainArr);
        int ans=bs(target,0,peak,mountainArr,true);
        System.out.println(ans);
        if(ans!=-1){
            return ans;
        }
        return bs(target,peak+1,mountainArr.length()-1,mountainArr,false);
    }
    
     public int peakIndex(MountainArray arr) {
        int start=0;
        int end=arr.length()-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr.get(mid)>arr.get(mid+1))
                end=mid;
            else
                start=mid+1;
        }
        return start;
    }
    
    public int bs(int target,int start,int end,MountainArray arr,boolean isAsc){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr.get(mid)==target)
                return mid;
            else if(arr.get(mid)>target){
                if(isAsc)
                    end=mid-1;
                else
                    start=mid+1;
            }
            else{
                if(isAsc)
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return -1;
    }
}