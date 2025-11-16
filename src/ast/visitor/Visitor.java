public interface Visitor {
    void visitNumber(NumberNodeV node);
    void visitVariable(VariableNodeV node);
    void visitBinaryOp(BinaryOpNodeV node);
}