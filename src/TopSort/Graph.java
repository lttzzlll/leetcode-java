package TopSort;

import java.util.LinkedList;


public class Graph {
    private int v;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    public void topoSortByKahn() {
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int v = queue.remove();
            System.out.print("->" + v);
            for (int j = 0; j < adj[v].size(); j++) {
                int vv = adj[v].get(j);
                inDegree[vv]--;
                if (inDegree[vv] == 0) {
                    queue.add(vv);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 4;
        Graph graph = new Graph(v);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 3);
        graph.topoSortByKahn();
    }
}