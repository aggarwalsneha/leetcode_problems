class Solution {
    public int totalFruit(int[] fruits) {
        int last_fruit=-1,second_last_fruit=0,curr_max=0,max=0,last_fruit_count=0;
        for(int fruit:fruits)
        {
            if(fruit==last_fruit || fruit==second_last_fruit)
                curr_max+=1;
            else
                curr_max=last_fruit_count+1;
            
            if(fruit==last_fruit)
                last_fruit_count+=1;
            else
                last_fruit_count=1;
            
            if(fruit!=last_fruit)
            {
                second_last_fruit=last_fruit;
                last_fruit=fruit;
            }
            
            max=Math.max(max,curr_max);
        }
        return max;
    }
}