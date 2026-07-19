class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orignalcolor=image[sr][sc];
        if(orignalcolor==color) return image;

        int rows=image.length;
        int cols= image[0].length;

        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};

        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        image[sr][sc]=color;

        while(!queue.isEmpty()){
            int[] pixel = queue.poll();
            for(int[] dir : directions){
                int newRow=pixel[0] +dir[0];
                int newCol=pixel[1]+dir[1];
                if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && image[newRow][newCol]==orignalcolor){
                    image[newRow][newCol] = color;
                    queue.offer(new int[] {newRow,newCol});
                }
            }
        }
        return image;
    }
}