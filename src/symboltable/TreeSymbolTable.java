package symboltable;

import java.util.*;
public class TreeSymbolTable {
private TreeMap<String, Symbol> symbols;
public TreeSymbolTable() {
    this.symbols = new TreeMap<>();
}

public void define(Symbol symbol) {
    symbols.put(symbol.getName(), symbol);
}

public Symbol lookup(String name) {
    return symbols.get(name);
}

public int size() {
    return symbols.size();
}
}