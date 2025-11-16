package benchmarks;

import symboltable.*;
import java.util.*;
public class SymbolTableBenchmark {
static void benchmarkTable(String name, int numSymbols, Runnable defineOp, Runnable lookupOp) {
    Runtime runtime = Runtime.getRuntime();
    
    // Dodavanje
    runtime.gc();
    long startTime = System.nanoTime();
    defineOp.run();
    long addTime = (System.nanoTime() - startTime) / 1_000_000;
    
    // Pretraživanje postojećih
    startTime = System.nanoTime();
    lookupOp.run();
    long lookupTime = (System.nanoTime() - startTime) / 1_000_000;
    
    System.out.printf("%-15s | %7d | %10d | %12d |\n", name, numSymbols, addTime, lookupTime);
}

public static void main(String[] args) {
    int[] sizes = {100, 1000, 10000};
    
    System.out.println("=== SYMBOL TABLE BENCHMARK ===\n");
    System.out.printf("%-15s | %-7s | %-10s | %-12s |\n", 
        "Implementacija", "Simboli", "Dodavanje", "Pretraživanje");
    System.out.println("----------------|---------|------------|--------------|");
    
    for (int size : sizes) {
        // Linear
        LinearSymbolTable linear = new LinearSymbolTable();
        benchmarkTable("Linearna lista", size,
            () -> {
                for (int i = 0; i < size; i++) {
                    linear.define(new Symbol("var_" + i, "int"));
                }
            },
            () -> {
                for (int i = 0; i < size; i++) {
                    linear.lookup("var_" + i);
                }
            });
        
        // Hash
        HashSymbolTable hash = new HashSymbolTable();
        benchmarkTable("Heš tabela", size,
            () -> {
                for (int i = 0; i < size; i++) {
                    hash.define(new Symbol("var_" + i, "int"));
                }
            },
            () -> {
                for (int i = 0; i < size; i++) {
                    hash.lookup("var_" + i);
                }
            });
        
        // Tree
        TreeSymbolTable tree = new TreeSymbolTable();
        benchmarkTable("Binarno stablo", size,
            () -> {
                for (int i = 0; i < size; i++) {
                    tree.define(new Symbol("var_" + i, "int"));
                }
            },
            () -> {
                for (int i = 0; i < size; i++) {
                    tree.lookup("var_" + i);
                }
            });
        
        // Trie
        TrieSymbolTable trie = new TrieSymbolTable();
        benchmarkTable("Trie", size,
            () -> {
                for (int i = 0; i < size; i++) {
                    trie.define(new Symbol("var_" + i, "int"));
                }
            },
            () -> {
                for (int i = 0; i < size; i++) {
                    trie.lookup("var_" + i);
                }
            });
        
        System.out.println("----------------|---------|------------|--------------|");
    }
    
    System.out.println("\nKonfiguracija:");
    System.out.println("- JDK: OpenJDK 17");
    System.out.println("- Format: var_N (N = 0 do size-1)");
}
}