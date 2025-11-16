import java.util.Map;
public class VariableNode extends ASTNode {
    private String name;
    public VariableNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int evaluate(Map<String, Integer> vars) {
        return vars.getOrDefault(name, 0);
    }

    @Override
    public int nodeCount() {
        return 1;
    }
}