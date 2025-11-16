public abstract class ASTNodeVisitor {
    public abstract void accept(Visitor v);
    public abstract int nodeCount();
}