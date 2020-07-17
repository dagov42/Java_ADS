package geekbrains.HomeTask_7;

import geekbrains.HomeTask_3.Queue;
import geekbrains.HomeTask_3.Stack;

public class Graph {
    private class Vertex {
        char label;
        Vertex vertex;
        boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "label=" + label +
                    '}';
        }
    }

    private final int MAX_VERTICES = 32;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int size;

    public Graph() {
        vertexList = new Vertex[MAX_VERTICES];
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        size = 0;
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex]);
    }

    private int getUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMatrix[ver][i] == 1 && !vertexList[i].wasVisited)
                return i;
        }
        return -1;
    }

    public void depthTraverse() {
        Stack stack = new Stack(MAX_VERTICES);
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        resetFlags();
    }

    public void widthTraverse() {
        Queue queue = new Queue(MAX_VERTICES);
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);
        while (!queue.isEmpty()) {
            int vCurrent = queue.remove();
            displayVertex(vCurrent);
            int vNext;
            while ((vNext = getUnvisitedVertex(vCurrent)) != -1) {
                vertexList[vNext].wasVisited = true;
                queue.insert(vNext);
            }
        }

    }

    private void resetFlags() {
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    private int getIndex(int current) {
        for (int i = 0; i < vertexList.length; i++) {
            if (vertexList[i].label == current)
                return i;
        }
        return -1;
    }

    Stack shortestWay(int source, int target) {
        Stack result = new Stack(MAX_VERTICES);
        Queue queue = new Queue(MAX_VERTICES);

        int start = getIndex(source);
        int stop = getIndex(target);
        if (start == -1 || stop == -1 || start == stop)
            return null;

        vertexList[start].wasVisited = true;
        queue.insert(start);
        while (!queue.isEmpty()) {
            int vCur = queue.remove();
            int vNxt;
            while ((vNxt = getUnvisitedVertex(vCur)) != -1) {
                vertexList[vNxt].vertex = vertexList[vCur];
                vertexList[vNxt].wasVisited = true;
                if (vNxt == stop) break;
                queue.insert(vNxt);
            }
            if (vNxt == stop) break;
        }
        if (!vertexList[stop].wasVisited) return null;

        result.push(vertexList[stop].label);
        int current = stop;
        while (vertexList[current].vertex != null)
            for (int i = 0; i < vertexList.length; i++)
                if(vertexList[current].vertex == vertexList[i]) {
                    result.push(vertexList[i].label);
                    current = i;
                    break;
                }

        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
            vertexList[i].vertex = null;
        }
        return result;
    }
}
