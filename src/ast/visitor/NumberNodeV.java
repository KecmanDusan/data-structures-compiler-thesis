public class NumberNodeV extends ASTNodeVisitor {
public int value;
public NumberNodeV(int value) {
    this.value = value;
}

@Override
public void accept(Visitor v) {
    v.visitNumber(this);
}

@Override
public int nodeCount() {
    return 1;
}
}