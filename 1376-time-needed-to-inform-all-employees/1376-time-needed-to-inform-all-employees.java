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
        int maxTime=0;
        Queue <int[]> q= new LinkedList<>();
            q.offer(new int[] {headID,0});

            while(!q.isEmpty()){
                int[] current = q.poll();
                int node = current[0];
                int cumulative =current[1];
            
            maxTime=Math.max(maxTime,cumulative);
            
            int newTime=cumulative+informTime[node];

            for(int child:children.get(node)){
                q.offer(new int[] {child,newTime});
            }
            }
            return maxTime;
    }
}