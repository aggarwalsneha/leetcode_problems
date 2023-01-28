class SummaryRanges {
    Set<Integer> l;
    public SummaryRanges() {
        l=new TreeSet<>();
    }
    
    public void addNum(int value) {
        l.add(value);
    }
    
    public int[][] getIntervals() {
        List<int[]> intervals=new ArrayList<>();
        int left=-1,right=-1;
        for(Integer num:l)
        {
            if(left<0)
                left=right=num;
            else if(num==right+1)
                right=num;
            else{
                intervals.add(new int[]{left,right});
                left=right=num;
                }
        }
        intervals.add(new int[]{left,right});
        return intervals.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */