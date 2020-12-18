package geeksforgeeks;

import java.util.ArrayList;

public class FindAllPossibleIslands {

    // Function to find the number of island in the given list
    // N, M: size of list row and column respectively
    static void dfs(ArrayList<ArrayList<Integer>> adj, int i, int j){
       if(i<0 || i>=adj.size() || j<0 || j>=adj.get(i).size() || adj.get(i).get(j)==0){
           return;
       }
       
       adj.get(i).set(j,0); //substituting all possible connected 1's with 0's in ArrayList
    
        dfs(adj,i-1,j);
        dfs(adj,i+1,j);
        dfs(adj,i,j-1);
        dfs(adj,i,j+1);
        dfs(adj,i-1,j-1);
        dfs(adj,i+1,j+1);
        dfs(adj,i-1,j+1);
        dfs(adj,i+1,j-1);
    }
    
    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {
        
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(list.get(i).get(j)==1){
                    
                    dfs(list,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}
