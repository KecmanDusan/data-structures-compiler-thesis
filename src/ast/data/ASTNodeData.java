import java.util.Map;
public class ASTNodeData {
public NodeType type;
public int numberValue;
public String varName;
public char operator;
public ASTNodeData left, right;
public static ASTNodeData createNumber(int value) {
    ASTNodeData node = new ASTNodeData();
    node.type = NodeType.NUMBER;
    node.numberValue = value;
    return node;
}

public static ASTNodeData createVariable(String name) {
    ASTNodeData node = new ASTNodeData();
    node.type = NodeType.VARIABLE;
    node.varName = name;
    return node;
}

public static ASTNodeData createBinaryOp(ASTNodeData left, char op, ASTNodeData right) {
    ASTNodeData node = new ASTNodeData();
    node.type = NodeType.BINARY_OP;
    node.operator = op;
    node.left = left;
    node.right = right;
    return node;
}

public int evaluate(Map<String, Integer> vars) {
    switch (type) {
        case NUMBER:
            return numberValue;
        case VARIABLE:
            return vars.getOrDefault(varName, 0);
        case BINARY_OP:
            int l = left.evaluate(vars);
            int r = right.evaluate(vars);
            switch (operator) {
                case '+': return l + r;
                case '-': return l - r;
                case '*': return l * r;
                case '/': return r != 0 ? l / r : 0;
            }
    }
    return 0;
}

public int nodeCount() {
    if (type == NodeType.BINARY_OP) {
        return 1 + left.nodeCount() + right.nodeCount();
    }
    return 1;
}
}