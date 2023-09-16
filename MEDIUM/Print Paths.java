// package MEDIUM;

// public class Print Paths {
    
// }

// Question :- Print Paths

// You are given a directed graph. The graph has N nodes numbered form 0 to N - 1.

// You are given a source node and a destination node. You have to print all the paths from the source node to the destination node.

// Note Complete the given function. The input would be handled by the driver code. You have to print the paths.

// Print the paths in lexicographical order.

// Input Format
// First line contains N, the number of nodes.

// Next line contains M, the number of edges.

// The next M line contains two integers each: u and v, which signify there is an edge between u to v.

// The next line contains the source node.

// The next line contains the destination node.

// Output Format
// Print each path in a new line. Print the paths in lexicographical order.

// Example 1
// Input

// 7
// 8
// 0 1
// 1 2
// 2 3
// 0 3
// 3 4
// 4 5
// 5 6
// 4 6
// 0
// 6
// Output

// 0123456
// 012346
// 03456
// 0346
// Explanation

// We make the graph and find all the paths to go from source 0 to destination 6.

// 0->1->2->3->4->5->6

// 0->1->2->3->4->6

// 0->3->4->5->6

// 0->3->4->6

// Example 2
// Input

// 3
// 2
// 0 1
// 1 2
// 0
// 2
// Output

// 012
// Explanation

// 0->1->2

// There is only a single path is the given grpah is a tree.

// Constraints
// 1 <= N <= 1000

// here is the Answer 



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, int n) {
        boolean[] visited = new boolean[n];
        ArrayList<Integer> path = new ArrayList<>();
        printPaths(graph, src, dest, visited, path);
    }

    public static void printPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, ArrayList<Integer> path) {
        visited[src] = true;
        path.add(src);

        if (src == dest) {
            for (int i : path) {
                System.out.print(i);
            }
            System.out.println();
        } else {
            for (Edge edge : graph[src]) {
                if (!visited[edge.nbr]) {
                    printPaths(graph, edge.nbr, dest, visited, path);
                }
            }
        }

        visited[src] = false;
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        printAllPath(graph, src, dest, vtces);
    }
}
