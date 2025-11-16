package benchmarks;

import graph.*;
import java.util.*;
public class GraphBenchmark {
public static void main(String[] args) {
    CFGGenerator generator = new CFGGenerator(42);
    int[] nodeCounts = {50, 100, 500, 1000, 5000};
    int iterations = 1000;
    
    System.out.println("=== CFG GRAPH BENCHMARK ===\n");
    System.out.printf("%-8s | %-6s | %-16s | %-16s | %-16s |\n", 
        "Čvorovi", "Grane", "Dodavanje (ms)", "Iteracija (ms)", "Memorija (KB)");
    System.out.printf("%-8s | %-6s | %-8s %-7s | %-8s %-7s | %-8s %-7s |\n",
        "", "", "Matrica", "Lista", "Matrica", "Lista", "Matrica", "Lista");
    System.out.println("---------|-------|------------------|------------------|------------------|");
    
    for (int n : nodeCounts) {
        List<Edge> edges = generator.generateCFG(n);
        int edgeCount = edges.size();
        
        // Matrica
        long startTime = System.nanoTime();
        GraphMatrix gMatrix = new GraphMatrix(n);
        for (Edge e : edges) {
            gMatrix.addEdge(e.from, e.to);
        }
        long matrixAddTime = (System.nanoTime() - startTime) / 1_000_000;
        
        startTime = System.nanoTime();
        for (int iter = 0; iter < iterations; iter++) {
            for (int i = 0; i < n; i++) {
                gMatrix.getSuccessors(i);
            }
        }
        long matrixIterTime = (System.nanoTime() - startTime) / 1_000_000;
        long matrixMemory = gMatrix.getMemoryUsage() / 1024;
        
        // Lista
        startTime = System.nanoTime();
        GraphList gList = new GraphList(n);
        for (Edge e : edges) {
            gList.addEdge(e.from, e.to);
        }
        long listAddTime = (System.nanoTime() - startTime) / 1_000_000;
        
        startTime = System.nanoTime();
        for (int iter = 0; iter < iterations; iter++) {
            for (int i = 0; i < n; i++) {
                gList.getSuccessors(i);
            }
        }
        long listIterTime = (System.nanoTime() - startTime) / 1_000_000;
        long listMemory = gList.getMemoryUsage() / 1024;
        
        System.out.printf("%7d | %5d | %7d %7d | %7d %7d | %7d %7d |\n",
            n, edgeCount, matrixAddTime, listAddTime,
            matrixIterTime, listIterTime, matrixMemory, listMemory);
    }
    
    System.out.println("\nKonfiguracija:");
    System.out.println("- JDK: OpenJDK 17");
    System.out.println("- Iteracije: " + iterations);
    System.out.println("- Seed: 42");
    System.out.println("- Prosečan stepen: ~1.5");
}
}