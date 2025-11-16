import java.util.Map;
public class BinaryOpNode extends ASTNode {
private ASTNode left, right;
private char operator;
public BinaryOpNode(ASTNode left, char operator, ASTNode right) {
    this.left = left;
    this.operator = operator;
    this.right = right;
}

public ASTNode getLeft() { return left; }
public ASTNode getRight() { return right; }
public char getOperator() { return operator; }

@Override
public int evaluate(Map<String, Integer> vars) {
    int l = left.evaluate(vars);
    int r = right.evaluate(vars);
    
    switch (operator) {
        case '+': return l + r;
        case '-': return l - r;
        case '*': return l * r;
        case '/': return r != 0 ? l / r : 0;
        default: return 0;
    }
}

@Override
public int nodeCount() {
    return 1 + left.nodeCount() + right.nodeCount();
}
}