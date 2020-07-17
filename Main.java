package geekbrains.HomeTask_7;

import geekbrains.HomeTask_3.Stack;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');
        graph.addVertex('f');
        graph.addVertex('g');
        graph.addVertex('h');
        graph.addVertex('j');
        graph.addVertex('k');
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(4, 1);
        graph.addEdge(2, 5);
        graph.addEdge(3, 7);
        graph.addEdge(6, 8);
        graph.addEdge(7, 9);
        graph.addEdge(6, 5);
        graph.addEdge(6, 9);
        graph.addEdge(8, 9);
        graph.addEdge(6, 8);
        graph.addEdge(4, 8);
        graph.addEdge(9, 7);
        graph.addEdge(8, 6);


        Stack shortestWay = graph.shortestWay('a', 'f');
        if (shortestWay != null){
            while (!shortestWay.isEmpty()){
                System.out.print((char) shortestWay.pop());
                System.out.print(shortestWay.isEmpty() ? "" : " goto ");
            }
        }
    }
}
