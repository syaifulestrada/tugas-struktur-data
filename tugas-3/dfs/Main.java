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
    Map<String, List<String>> adj = new HashMap<>();
    Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label, int value) {
        nodes.put(label, new Node(label, value));
        adj.put(label, new ArrayList<>());
    }

    public void addEdge(String a, String b) {
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    public boolean dfsSearch(String start, int target) {

        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        stack.push(start);

        while(!stack.isEmpty()) {
            String current = stack.pop();

            if(visited.contains(current)) continue;
            visited.add(current);


            Node n = nodes.get(current);
            System.out.println("Mengunjungi: " + current + " Nilai = " + n.value + ")");

            if(n.value == target) {
                System.out.println(">> Target " + target + " ditemukan di node " + current);
                return true;
            }


            for(String neighbor : adj.get(current)) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }

        }

        System.out.println(">> Target " + target + " tidak ditemukan di graf");

        return false;
    }


}

public class Main {

        public static void main(String[] args) {
            Graph g = new Graph();

            g.addNode("a1", 5);
            g.addNode("a2", 3);
            g.addNode("a3", 7);
            g.addNode("a4", 2);
            g.addNode("a5", 9);
            g.addNode("a6", 1);
            g.addNode("a7", 4);
            g.addNode("a8", 8);

            g.addEdge("a1", "a2");
            g.addEdge("a1", "a3");
            g.addEdge("a2", "a4");
            g.addEdge("a2", "a5");
            g.addEdge("a3", "a6");
            g.addEdge("a3", "a7");
            g.addEdge("a5", "a8");

            int target = 8;

            System.out.println("Pencarian DFS untuk angka: " + target);
            g.dfsSearch("a1", target);

        }

}

/*
    
                a1(5)
                |     \
            a2(3)      a3(7)
            |  \         | \
         a4(2) a5(9)   a6(8) a5(9)
                |
                a8(8)
*/

/*
    
    Referensi: 

    GeeksforGeeks. (2025, November 1). Difference between BFS and DFS. GeeksforGeeks. https://www-geeksforgeeks-org.translate.goog/dsa/difference-between-bfs-and-dfs/?_x_tr_sl=auto&_x_tr_tl=id&_x_tr_hl=id
        
    GeeksforGeeks. (2025, October 25). Depth first search or DFS for a graph. GeeksforGeeks. https://www.geeksforgeeks.org/dsa/depth-first-search-or-dfs-for-a-graph/

    Bro Code. (2021, November 4). Learn Depth First Search in 7 minutes ⬇️ [Video]. YouTube. https://www.youtube.com/watch?v=by93qH4ACxo

    

*/


