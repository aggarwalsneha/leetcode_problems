class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        Pair<Integer,Integer>[] cells=new Pair[n*n+1];
        int label=1;
        Integer[] col=new Integer[n];
        for(int i=0;i<n;i++)
            col[i]=i;
        for(int r=n-1;r>=0;r--){
            for(int c:col){
                cells[label++]=new Pair<>(r,c);
            }
        Collections.reverse(Arrays.asList(col));
        }
        int[]dist=new int[n*n+1];
        Arrays.fill(dist,-1);
        Queue<Integer>q=new LinkedList<Integer>();
        dist[1]=0;
        q.add(1);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int next=curr+1;next<=Math.min(curr+6,n*n);next++){
                int row=cells[next].getKey();
                int column=cells[next].getValue();
                int dest=board[row][column]!=-1?board[row][column]:next;
                if(dist[dest]==-1){
                    dist[dest]=dist[curr]+1;
                    q.add(dest);
                }
            }
        }
        return dist[n*n];
    }
}