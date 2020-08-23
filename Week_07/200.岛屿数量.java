import sun.tools.tree.ForStatement;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

/*
*思路：1.DFS
2.并查集
*/

// @lc code=start
class Solution {
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++count;
                }
        }    
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
// @lc code=end

class SolutionOne {
    class UnionFind { 
        private int count = 0; 
        private int[] parent; 
        public UnionFind(int n) { 
            count = n; 
            parent = new int[n]; 
            for (int i = 0; i < n; i++) { 
                parent[i] = i;
              }
         } 
        public int find(int p) { 
            while (p != parent[p]) { 
                parent[p] = parent[parent[p]]; 
                   p = parent[p]; 
              }
            return p; 
         }
        public void union(int p, int q) { 
            int rootP = find(p); 
            int rootQ = find(q); 
            if (rootP == rootQ) return; 
            parent[rootP] = rootQ; 
              count--;
         }

         public int count() {
             return count;
         }

    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int zeros = 0;
        UnionFind uf = new UnionFind(m*n);
        int[][] D = {{0,1}, {1,0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') { zeros++; continue; }
                for (int[] d : D) {
                    int x = i+d[0];
                    int y = j+d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                        uf.union(i*n+j, x*n+y);
                    }
                }
            }
        } 
        return uf.count() - zeros;
    }

}