class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
    int n=accounts.size();
    Map<String,Integer>hm=new HashMap<>();
    DisjointSet ds=new DisjointSet(n);
    for(int i=0;i<n;i++){
        for(int j=1;j<accounts.get(i).size();j++){
            String mail=accounts.get(i).get(j);
            if(!hm.containsKey(mail))
            hm.put(mail,i);
            else
            ds.unionBySize(i,hm.get(mail));
        }
    }
    ArrayList<String>[] merge=new ArrayList[n];
    for(int i=0;i<n;i++){
        merge[i]=new ArrayList<String>();
    }
    for(Map.Entry<String,Integer> e:hm.entrySet()){
        String mail=e.getKey();
        int node=ds.findUpar(e.getValue());
        merge[node].add(mail);
    }
    List<List<String>>ans=new ArrayList<>();
    for(int i=0;i<n;i++){
        if(merge[i].size()==0){
        continue;
        }
        Collections.sort(merge[i]);
        List<String>temp=new ArrayList<>();
        temp.add(accounts.get(i).get(0));
        for(String it:merge[i]){
            temp.add(it);
        }
        ans.add(temp);
    }
    return ans;

    }
}

class DisjointSet{
    List<Integer>parent=new ArrayList<>();
    List<Integer>size=new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    int findUpar(int node){
        if(node==parent.get(node))
        return node;
        int ulp=findUpar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    
    void unionBySize(int u,int v){
        int ulp_u=findUpar(u);
        int ulp_v=findUpar(v);
        
        if(ulp_u==ulp_v)
        return;
        
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u ,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}