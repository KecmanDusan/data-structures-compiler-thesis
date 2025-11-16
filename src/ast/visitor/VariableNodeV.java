public class VariableNodeV extends ASTNodeVisitor {
public String name;
public VariableNodeV(String name) {
    this.name = name;
}

@Override
public void accept(Visitor v) {
    v.visitVariable(this);
}

@Override
public int nodeCount() {
    return 1;
}
}