class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        for(int i=0;i<heights.length;i++)
        {
            for(int j=i+1;j<heights.length;j++)
            {
                int temp=0;
                String tempS="";
                if(heights[i]<heights[j])
                {
                    temp=heights[i];
                    heights[i]=heights[j];
                    heights[j]=temp;
                    tempS=names[i];
                    names[i]=names[j];
                    names[j]=tempS;
                }
            }
        }
        return names;
    }
}