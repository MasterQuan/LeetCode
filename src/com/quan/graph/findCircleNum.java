package com.quan.graph;

public class findCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int res = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                res++;
                dfs(isConnected,i,vis);
            }
        }
        return res;
    }

    public void dfs(int[][] isConnected,int i,boolean[] vis){
        if(vis[i]) return;
        vis[i] = true;
        for(int j = 0;j<isConnected.length;j++){
            if(isConnected[i][j]==1){
                dfs(isConnected,j,vis);
            }
        }
    }
}
