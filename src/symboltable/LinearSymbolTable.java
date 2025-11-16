package symboltable;

import java.util.*;
public class LinearSymbolTable {
private List<Symbol> symbols;
public LinearSymbolTable() {
    this.symbols = new ArrayList<>();
}

public void define(Symbol symbol) {
    symbols.add(symbol);
}

public Symbol lookup(String name) {
    for (Symbol symbol : symbols) {
        if (symbol.getName().equals(name)) {
            return symbol;
        }
    }
    return null;
}

public int size() {
    return symbols.size();
}
}