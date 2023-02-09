class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured==0)
            return 0;
        List<Double> arr=new ArrayList<>();
        arr.add((double)poured);
        while(query_row-->0)
        {
            List<Double>temp=new ArrayList<Double>();
            double t=Math.max(0,(arr.get(0)-1)/2); 
            temp.add(t);
            for(int i=1;i<arr.size();i++)
            {
                temp.add(Math.max(0,(arr.get(i-1)-1)/2)+Math.max(0,(arr.get(i)-1)/2));  
            }
            temp.add(t);
            arr=temp;
        }
        return Math.min(1.0,arr.get(query_glass));
    }
}