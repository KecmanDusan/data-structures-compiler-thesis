import java.util.Map;
public class NumberNode extends ASTNode {
private int value;
public NumberNode(int value) {
    this.value = value;
}

public int getValue() {
    return value;
}

@Override
public int evaluate(Map<String, Integer> vars) {
    return value;
}

@Override
public int nodeCount() {
    return 1;
}
}