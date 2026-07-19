class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orignalcolor=image[sr][sc];
        // If color already matching 
        if(orignalcolor==color) return image;
        dfs(image,sr,sc,orignalcolor,color);
        return image;
    }
    public void dfs(int[][] image, int row, int col, int orignalcolor,int newColor){
        //boundary and color match check
        if(row<0 || row>=image.length || col<0 || col>=image[0].length) return;
        if(image[row][col] !=orignalcolor) return;

        image[row][col]=newColor;
        dfs(image,row-1,col,orignalcolor,newColor);
        dfs(image,row+1,col,orignalcolor,newColor);
        dfs(image,row,col-1,orignalcolor,newColor);
        dfs(image,row,col+1,orignalcolor,newColor);
    }
}