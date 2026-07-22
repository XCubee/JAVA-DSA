class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>result = new ArrayList<>();
        int target=graph.length-1;

        Queue<List<Integer>> queue=new LinkedList<>();
        queue.offer(new ArrayList<>(List.of(0)));

        while(!queue.isEmpty()){
            List<Integer> path =queue.poll();
            int lastNode = path.get(path.size()-1);
        if(lastNode==target){
            result.add(path);
            continue;
        }
        for(int neighbour :graph[lastNode]){
            List<Integer> newPath=new ArrayList<>(path);
            newPath.add(neighbour);
            queue.offer(newPath);
        }
        }
        return result;

    }
}