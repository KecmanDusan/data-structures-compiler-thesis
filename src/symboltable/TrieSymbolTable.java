package symboltable;

import java.util.*;
public class TrieSymbolTable {
private TrieNode root;
private int symbolCount;
private class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    Symbol symbol = null;
}

public TrieSymbolTable() {
    this.root = new TrieNode();
    this.symbolCount = 0;
}

public void define(Symbol symbol) {
    TrieNode current = root;
    for (char c : symbol.getName().toCharArray()) {
        current = current.children.computeIfAbsent(c, k -> new TrieNode());
    }
    if (current.symbol == null) {
        symbolCount++;
    }
    current.symbol = symbol;
}

public Symbol lookup(String name) {
    TrieNode current = root;
    for (char c : name.toCharArray()) {
        current = current.children.get(c);
        if (current == null) return null;
    }
    return current.symbol;
}

public int size() {
    return symbolCount;
}
}