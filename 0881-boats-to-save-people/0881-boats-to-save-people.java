class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int i=0,j=people.length-1,count=0,sum;
        Arrays.sort(people);
        while(i<=j) {
            sum=people[i]+people[j];
            count++;
            if(sum<=limit){
                i++;
            }
                j--;
        }
        return count;
    }
}