class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId=m;
        for(int i=0;i<n;i++){
            if(group[i]==-1){
                group[i]=groupId;
                groupId++;
            }
        }
        int[] itemIndegree=new int[n];
        int[] groupIndegree=new int[groupId];
        Map<Integer,List<Integer>>itemGraph=new HashMap<>();
        Map<Integer,List<Integer>>groupGraph=new HashMap<>();
        
        for(int i=0;i<n;i++){
            itemGraph.put(i,new ArrayList<>());
        }
        for(int i=0;i<groupId;i++){
            groupGraph.put(i,new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int j:beforeItems.get(i)){
                itemGraph.get(j).add(i);
                itemIndegree[i]++;
                if(group[i]!=group[j]){
                    groupGraph.get(group[j]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }
        
        List<Integer>itemOrder=topologicalSort(itemGraph,itemIndegree);
        List<Integer>groupOrder=topologicalSort(groupGraph,groupIndegree);
        
        if(itemOrder.isEmpty() || groupOrder.isEmpty()){
            return new int[0];
        }
        
        Map<Integer,List<Integer>>orderedGroups=new HashMap<>();
        for(int item:itemOrder){
            if(!orderedGroups.containsKey(group[item]))
                orderedGroups.put(group[item],new ArrayList<>());
            orderedGroups.get(group[item]).add(item);
        }
        List<Integer> ans=new ArrayList<>();
        for(int groupIndex:groupOrder){
            ans.addAll(orderedGroups.getOrDefault(groupIndex,new ArrayList<>()));
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    
    List<Integer> topologicalSort(Map<Integer,List<Integer>>graph,int[] indegree){
        List<Integer>visited=new ArrayList<>();
        Stack<Integer>stack=new Stack<>();
        for(int key:graph.keySet()){
            if(indegree[key]==0){
                stack.add(key);
            }
        }
        while(!stack.isEmpty()){
            Integer curr=stack.pop();
            visited.add(curr);
            for(int prev:graph.get(curr)){
                indegree[prev]--;
                if(indegree[prev]==0){
                    stack.add(prev);
                }
            }
        }
        return visited.size()==graph.size()?visited:new ArrayList<>();
    }
}