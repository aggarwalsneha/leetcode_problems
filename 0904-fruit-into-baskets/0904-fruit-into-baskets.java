class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer>basket=new HashMap<>();
        int i=0,j=0,max=0;
        for(j=0;j<fruits.length;j++)
        {
            basket.put(fruits[j],basket.getOrDefault(fruits[j],0)+1);
            while(basket.size()>2)
            {
                basket.put(fruits[i],basket.get(fruits[i])-1);
                if(basket.get(fruits[i])==0)
                    basket.remove(fruits[i]);
                    i++;
            }
            max=Math.max(max,j-i+1);
        }
        return max;
    }
}