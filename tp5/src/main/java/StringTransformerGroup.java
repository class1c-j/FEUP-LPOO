import java.util.List;
import java.util.Stack;

public class StringTransformerGroup implements StringTransformer {
    private final List<StringTransformer> transformers;

    public StringTransformerGroup(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    public void execute(StringDrink drink) {
        for (StringTransformer transformer : transformers) {
            transformer.execute(drink);
        }
    }

    @Override
    public void undo(StringDrink drink) {
        for (StringTransformer transformer : transformers) {
            transformer.undo(drink);
        }
    }
}
