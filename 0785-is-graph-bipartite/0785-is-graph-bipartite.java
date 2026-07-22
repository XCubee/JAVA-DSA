class Solution {
    public boolean isBipartite(int[][] graph) {
        int n =graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]!=-1) continue;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        color[i]=0;

        while(!queue.isEmpty()){
            int node =queue.poll();
            for(int neighbour : graph[node]){
                if(color[neighbour] ==-1){
                    color[neighbour]=1-color[node];
                    queue.offer(neighbour);
                }else if (color[neighbour] == color[node]){
                    return false;
                }
            }
        
        } 
        
        
        
        }
        return true;
    }
}