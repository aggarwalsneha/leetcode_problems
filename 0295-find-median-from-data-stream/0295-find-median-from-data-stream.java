class MedianFinder {
    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;
    double currMed=0;
    public MedianFinder() {
        minH=new PriorityQueue<>();
        maxH=new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        if(num>currMed){
            if(minH.size()==maxH.size() || minH.size()<maxH.size())
            minH.add(num);
            else{
                int curr=minH.poll();
                maxH.add(curr);
                minH.add(num);
            }
        }
        else{
            if(minH.size()==maxH.size() || maxH.size()<minH.size())
            maxH.add(num);
            else{
                int curr=maxH.poll();
                minH.add(curr);
                maxH.add(num);
            }
        }
        if(minH.size()==maxH.size())
            currMed=(minH.peek()+maxH.peek())*1.0/2;
        if(Math.abs(minH.size()-maxH.size())==1)
        {
            currMed=minH.size()>maxH.size()?minH.peek():maxH.peek();
        }
    }
    
    public double findMedian() {
        return currMed;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */