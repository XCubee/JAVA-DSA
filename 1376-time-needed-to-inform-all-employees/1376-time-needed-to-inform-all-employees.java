import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> children = new ArrayList<>();
        for(int i=0;i<n;i++){
            children.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(manager[i]!=-1){
                children.get(manager[i]).add(i);
            }

        }
        return dfs(headID,0,children,informTime);

    }
    private int dfs(int node , int cumulative, List<List<Integer>> children, int[] informTime){
        if(children.get(node).isEmpty()){
            return cumulative;
        }
        int maxTime=0;
        int newTime=cumulative+informTime[node];

        for(int child: children.get(node)){
            maxTime=Math.max(maxTime,dfs(child,newTime,children,informTime));
        }
        return maxTime;
    }
}