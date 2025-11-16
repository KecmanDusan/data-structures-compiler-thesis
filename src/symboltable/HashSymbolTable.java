package symboltable;

import java.util.*;
public class HashSymbolTable {
private Map<String, Symbol> symbols;
public HashSymbolTable() {
    this.symbols = new HashMap<>();
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