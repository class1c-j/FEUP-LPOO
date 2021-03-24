import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {
    private final List<StringDrink> wantedDrinkList = new ArrayList<>();
    private final List<StringRecipe> wantedRecipeList = new ArrayList<>();

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour()) {
            bar.order(drink, recipe);
        } else {
            wantedDrinkList.add(drink);
            wantedRecipeList.add(recipe);
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for (int i = 0; i < wantedRecipeList.size(); ++i) {
            bar.order(wantedDrinkList.get(i), wantedRecipeList.get(i));
        }
        wantedRecipeList.clear();
        wantedDrinkList.clear();
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
