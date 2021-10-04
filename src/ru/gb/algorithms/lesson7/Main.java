package ru.gb.algorithms.lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(4,5);
        graph.addEdge(3,6);
        graph.addEdge(6,5);
        graph.addEdge(4,7);
        graph.addEdge(5,8);
        graph.addEdge(8,9);
        graph.addEdge(6,9);
        BreadthFirstPath bfp = new BreadthFirstPath(graph,0);
        System.out.println(bfp.pathTo(8));

    }
}
