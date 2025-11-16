package graph;

import java.util.*;
public class GraphMatrix {
private boolean[][] matrix;
private int nodeCount;
public GraphMatrix(int n) {
    this.nodeCount = n;
    this.matrix = new boolean[n][n];
}

public void addEdge(int from, int to) {
    if (from >= 0 && from < nodeCount && to >= 0 && to < nodeCount) {
        matrix[from][to] = true;
    }
}

public boolean hasEdge(int from, int to) {
    return matrix[from][to];
}

public List<Integer> getSuccessors(int node) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nodeCount; i++) {
        if (matrix[node][i]) {
            result.add(i);
        }
    }
    return result;
}

public long getMemoryUsage() {
    return (long) nodeCount * nodeCount + 24;
}
}
