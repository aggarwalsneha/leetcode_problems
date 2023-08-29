class Solution {
    public int bestClosingTime(String customers) {
        int max=0,curr=0,ans=0;
        for(int i=0;i<customers.length();i++){
            char ch=customers.charAt(i);
            if(ch=='Y')
                curr++;
            else
                curr--;
            if(curr>max){
                ans=i+1;
                max=curr;
            }
        }
        return ans;
    }
}