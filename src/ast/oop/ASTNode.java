import java.util.Map;
public abstract class ASTNode {
    public abstract int evaluate(Map<String, Integer> vars);
    public abstract int nodeCount();
}