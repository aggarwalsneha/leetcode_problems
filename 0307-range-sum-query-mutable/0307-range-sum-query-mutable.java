class NumArray {
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        n=nums.length;
        int height=(int)(Math.ceil(Math.log(n)/Math.log(2)));
        tree=new int[(int)Math.pow(2,height+1)-1];
        buildtree(0,0,n-1,nums);
    }
    
    public void buildtree(int ind,int low,int high,int[] nums){
        if(low==high){
            tree[ind]=nums[low];
            return;
        }
        int mid=(low+high)/2;
        buildtree(2*ind+1,low,mid,nums);
        buildtree(2*ind+2,mid+1,high,nums);
        
        tree[ind]=tree[2*ind+1]+tree[2*ind+2];
    }
    
    public void update(int index, int val) {
        modify(0,0,n-1,index,val);
    }
    
    public void modify(int ind,int low,int high,int pos,int val){
        if(low==high){
            tree[ind]=val;
            return;
        }
        int mid=(low+high)/2;
        if(pos<=mid)
            modify(2*ind+1,low,mid,pos,val);
        else
            modify(2*ind+2,mid+1,high,pos,val);
        tree[ind]=tree[2*ind+1]+tree[2*ind+2];
    } 
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }
    
    public int query(int ind,int low,int high,int l,int r){
        if(r<low || l>high)
            return 0;
        if(low>=l && high<=r)
            return tree[ind];
        int mid=(low+high)/2;
        int left=query(2*ind+1,low,mid,l,r);
        int right=query(2*ind+2,mid+1,high,l,r);
        return left+right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */