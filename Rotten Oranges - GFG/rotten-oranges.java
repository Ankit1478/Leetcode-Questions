//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    static class pair{
        int row;
        int col;
        int time ;
        pair(int row, int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
       int n =grid.length;
       int m = grid[0].length;
       Queue<pair>q = new LinkedList<>();
       int vis[][]= new int[n][m];
       int countfrsh=0;
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j]==2){
                   q.add(new pair(i,j,0));
                   vis[i][j]=2;
               }
               else if(grid[i][j]==1) countfrsh++;
           }
          
       }
       
       int timesss=0;
       int cnt=0;
       int gridrow[]={-1,0,1,0};
       int gridcol[]={0,1,0,-1};
       
       while(!q.isEmpty()){
           int r =q.peek().row;
           int c =q.peek().col;
           int t=q.peek().time;
           timesss=Math.max(timesss,t);
           q.remove();
           
           for(int i=0;i<4;i++){
               int nrow=r+gridrow[i];
               int ncol=c+gridcol[i];
               
              if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                  q.add(new pair (nrow,ncol,t+1));
                  vis[nrow][ncol]=2;
                  cnt++;
              }
           }

       }
         if(cnt!=countfrsh) return -1;
           return timesss;
    }
}