package graph;

import java.util.*;
public class CFGGenerator {
private Random rand;
public CFGGenerator(long seed) {
    this.rand = new Random(seed);
}

public List<Edge> generateCFG(int nodeCount) {
    List<Edge> edges = new ArrayList<>();
    
    for (int i = 0; i < nodeCount - 1; i++) {
        edges.add(new Edge(i, i + 1));
        
        if (rand.nextDouble() < 0.3 && i < nodeCount - 2) {
            int target = i + 2 + rand.nextInt(Math.min(3, nodeCount - i - 2));
            edges.add(new Edge(i, target));
        }
        
        if (rand.nextDouble() < 0.15 && i > 3) {
            int target = i - rand.nextInt(Math.min(3, i));
            edges.add(new Edge(i, target));
        }
    }
    
    return edges;
}
}