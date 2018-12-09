package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * in directional graph
 */
public class Graph {
    /**
     * vertex number
     */
    private int v;
    /**
     * adjcent linked list
     */
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * add edge to graph
     * 
     * @param s edge s
     * @param t edge t
     */
    public void addEdge(int s, int t) {
        this.adj[s].add(t);
        this.adj[t].add(s);
    }

    /**
     * iterate graph from vertex s to t
     * 
     * @param s vertex s
     * @param t vertex t
     */
    public void bfs(int s, int t) {
        if (s == t)
            return;
        boolean[] visited = new boolean[this.v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * print the iterate path from vertex s to vertex t
     * 
     * @param prev containing iterate path
     * @param s    vertex s
     * @param t    vertex t
     */
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    boolean found = false;

    /**
     * iterate graph from vertex s to vertex t using Deep Frist Search
     * 
     * @param s vertex s
     * @param t vertex t
     */
    public void dfs(int s, int t) {
        boolean[] visited = new boolean[this.v];
        int[] prev = new int[this.v];
        for (int i = 0; i < this.v; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    /**
     * iterate graph from vertex w to vertex t using Deep First Search
     * 
     * @param w       vertex w
     * @param t       vertex t
     * @param visited mark if visited
     * @param prev    containg iterate path
     */
    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found)
            return;
        visited[w] = true;
        if (w == t) {
            this.found = true;
            return;
        }
        for (int i = 0; i < this.adj[w].size(); i++) {
            int q = this.adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    /**
     * Counting User Current Level
     */
    class UserCount {
        // represent wechat user
        private int node;
        // represent wechat user current level
        private int level;

        public UserCount(int node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    /**
     * search wechat user s K-friends using Breadth First Search
     * 
     * @param s wechat user s
     * @param t K friends
     * @return all matched friends
     */
    public List<Integer> WechatBfs(int s, int k) {
        // using set to keep each friends are unique
        Set<Integer> friends = new HashSet<>();
        Queue<UserCount> queue = new LinkedList<>();
        queue.add(new UserCount(s, 0));
        while (!queue.isEmpty()) {
            UserCount u = queue.poll();
            if (i.level == k)
                continue;
            for (int i = 0; i < this.adj[w].size(); i++) {
                int q = this.adj[w].get(i);
                if (friends.contains(q))
                    continue;
                queue.add(new UserCount(q, u.level + 1));
            }
        }
        return friends;
    }

    /**
     * search wechat user s K-friends using Deep First Search
     * 
     * @param s wechat user s
     * @param k k friends
     * @return all matched friends
     */
    public List<Integer> WechatDfs(int s, int k) {
        Set<Integer> friends = new HashSet<>();
        level = 0;
        recurWechatDfs(s, level, k, friends);
    }

    /**
     * deep search for wechat user k-friends implementation
     * @param s
     * @param l
     * @param k
     * @param friends
     */
    private void recurWechatDfs(int s, int l, int k, Set<Integer> friends) {
        if (l == k)
            return;
        for (int i = 0; i < this.adj[s].size(); i++) {
            int q = this.adj[s].get(i);
            if (friends.contains(q))
                continue;
            recurWechatDfs(q, l + 1, k, friends);
        }
    }

}