import java.util.ArrayList;
import java.util.List;

public class ConcreteRegexBuilder implements RegexBuilder {
    private List<String> components;

    public ConcreteRegexBuilder() {
        this.components = new ArrayList<>();
    }

    @Override
    public void buildLiteral(String literal) {
        components.add(literal);
    }

    @Override
    public void buildAnyCharacter() {
        components.add(".");
    }

    @Override
    public void buildDigit() {
        components.add("\\d");
    }

    @Override
    public void buildWhitespace() {
        components.add("\\s");
    }

    @Override
    public void buildWordCharacter() {
        components.add("\\w");
    }

    @Override
    public Regex getResult() {
        return new Regex(components);
    }
}