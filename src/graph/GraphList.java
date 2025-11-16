package graph;

import java.util.*;
public class GraphList {
private List<List<Integer>> adjList;
private int nodeCount;
public GraphList(int n) {
    this.nodeCount = n;
    this.adjList = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
        adjList.add(new ArrayList<>());
    }
}

public void addEdge(int from, int to) {
    if (from >= 0 && from < nodeCount && to >= 0 && to < nodeCount) {
        if (!adjList.get(from).contains(to)) {
            adjList.get(from).add(to);
        }
    }
}

public boolean hasEdge(int from, int to) {
    return adjList.get(from).contains(to);
}

public List<Integer> getSuccessors(int node) {
    return new ArrayList<>(adjList.get(node));
}

public long getMemoryUsage() {
    long size = 0;
    for (List<Integer> list : adjList) {
        size += 24 + list.size() * 4;
    }
    return size;
}
}
