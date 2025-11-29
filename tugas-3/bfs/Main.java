import java.util.*;

class Node {
    String label;
    int value;

    Node(String label, int value) {
        this.label = label;
        this.value = value;
    }
}

class Graph {

    private Map<String, List<String>> adj = new HashMap<>();
    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label, int value) {
        nodes.put(label, new Node(label, value));
        adj.put(label, new ArrayList<>());
    }

    public void addEdge(String a, String b) {
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    public List<String> bfs(String start, int target) {

        Queue<String> q = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();

        q.add(start);
        visited.add(start);
        parent.put(start, null);

        while (!q.isEmpty()) {
            String cur = q.poll();
            Node n = nodes.get(cur);

            if(n.value == target) {
                return buildPath(parent, cur);
            }

            for(String neighbor : adj.get(cur)) {
                if(visited.add(neighbor)) {
                    parent.put(neighbor, cur);
                    q.add(neighbor);
                }
            }

        }

        return null;
    }

    private List<String> buildPath(Map<String, String> parent, String end) {

        List<String> path = new ArrayList<>();

        while(end != null) {
            path.add(end);
            end = parent.get(end);
        }

        Collections.reverse(path);
        return path;
    }



}


public class Main {

    public static void main(String[] args) {

        Graph g = new Graph();

        String[] labels = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8"};
        int[] values = {10, 7, 5, 12, 3, 13, 7, 20};

        for(int i = 0; i < labels.length; i++) {
            g.addNode(labels[i], values[i]);
        }

        g.addEdge("a1", "a2");
        g.addEdge("a1", "a3");
        g.addEdge("a2", "a4");
        g.addEdge("a2", "a5");
        g.addEdge("a3", "a6");
        g.addEdge("a5", "a6");
        g.addEdge("a4", "a7");
        g.addEdge("a6", "a8");

        System.out.println("Temukan nilai 13");
        System.out.println(g.bfs("a1", 13));


    }

}

/*

            a1(10)
            |    \
          a2(7)  a3(5)
            |   \    \
        a4(12) a5(3)  a6(13)
           |            \
         a7(7)          a8(20) 

*/


/*
    
    Referensi:

    GeeksforGeeks. (2025, November 1). Difference between BFS and DFS. GeeksforGeeks. https://www-geeksforgeeks-org.translate.goog/dsa/difference-between-bfs-and-dfs/?_x_tr_sl=auto&_x_tr_tl=id&_x_tr_hl=id
    
    GeeksforGeeks. (2025, October 25). Breadth first search or BFS for a graph. GeeksforGeeks. https://www.geeksforgeeks.org/dsa/breadth-first-search-or-bfs-for-a-graph/

    Bro Code. (2021, November 5). Learn Breadth First Search in 6 minutes ↔️ [Video]. YouTube. https://www.youtube.com/watch?v=7Cox-J7onXw

*/

