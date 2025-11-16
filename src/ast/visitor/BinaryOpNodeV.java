public class BinaryOpNodeV extends ASTNodeVisitor {
public ASTNodeVisitor left, right;
public char operator;
public BinaryOpNodeV(ASTNodeVisitor left, char operator, ASTNodeVisitor right) {
    this.left = left;
    this.operator = operator;
    this.right = right;
}

@Override
public void accept(Visitor v) {
    v.visitBinaryOp(this);
}

@Override
public int nodeCount() {
    return 1 + left.nodeCount() + right.nodeCount();
}
}