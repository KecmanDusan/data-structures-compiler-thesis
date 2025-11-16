import java.util.*;
public class EvaluatorVisitor implements Visitor {
private Stack<Integer> stack = new Stack<>();
private Map<String, Integer> vars;
public EvaluatorVisitor(Map<String, Integer> vars) {
    this.vars = vars;
}

public int evaluate(ASTNodeVisitor node) {
    stack.clear();
    node.accept(this);
    return stack.pop();
}

@Override
public void visitNumber(NumberNodeV node) {
    stack.push(node.value);
}

@Override
public void visitVariable(VariableNodeV node) {
    stack.push(vars.getOrDefault(node.name, 0));
}

@Override
public void visitBinaryOp(BinaryOpNodeV node) {
    node.left.accept(this);
    int left = stack.pop();
    node.right.accept(this);
    int right = stack.pop();
    
    int result = 0;
    switch (node.operator) {
        case '+': result = left + right; break;
        case '-': result = left - right; break;
        case '*': result = left * right; break;
        case '/': result = right != 0 ? left / right : 0; break;
    }
    stack.push(result);
}
}