class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<Integer> start=new ArrayList();
        List<Integer> end=new ArrayList();
        for(int[] n:flowers){
            start.add(n[0]);
            end.add(n[1]);
        }
        Collections.sort(start);
        Collections.sort(end);
        int[] ans=new int[people.length];
        for(int i=0;i<people.length;i++){
            int person=people[i];
            int f=binarySearch(start,person);
            int s=binarySearch1(end,person);
            ans[i]=f-s;
        }
        return ans;
    }
    public int binarySearch(List<Integer> arr,int target){
        int left=0;
        int right=arr.size();
        while(left<right){
            int mid=(left+right)/2;
            if(target<arr.get(mid))
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }
    public int binarySearch1(List<Integer> arr,int target){
        int left=0;
        int right=arr.size();
        while(left<right){
            int mid=(left+right)/2;
            if(target<=arr.get(mid))
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }
}