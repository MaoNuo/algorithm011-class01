class Solution {
//    public int findCircleNum(int[][] M) {
//        if (M == null || M.length == 0 || M[0].length == 0) { return 0; }
//        int ret = 0;
//        boolean[] visited = new boolean[M.length];
//        for (int i = 0; i < M.length; i++) {
//            if (!visited[i]) {
//                dfs(M, i, visited);
//                ret++;
//            }
//        }
//        return ret;
//    }
//
//    private void dfs(int[][] m, int i, boolean[] visited) {
//        for (int j = 0; j < m[i].length; j++) {
//            if (m[i][j] == 1 && !visited[j]) {
//                visited[j] = true;
//                dfs(m, j, visited);
//            }
//        }
//    }

    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    class UnionFind {
        int count;
        int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }

            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) { return; }
            parent[rootQ] = rootP;
            count--;
        }
    }

}
