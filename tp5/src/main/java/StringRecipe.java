import java.util.List;

public class StringRecipe {
    private List<StringTransformer> stringTransformers;

    public StringRecipe(List<StringTransformer> stringTransformers) {
        this.stringTransformers = stringTransformers;
    }

    public void mix(StringDrink drink) {
        for (StringTransformer transformer : stringTransformers) {
            transformer.execute(drink);
        }
    }
}
