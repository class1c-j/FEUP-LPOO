public class StringReplacer implements StringTransformer {
    private final Character c1;
    private final Character c2;

    public StringReplacer(char c1, char c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void execute(StringDrink drink) {
        drink.setText(drink.getText().replace(this.c1, this.c2));
    }

    @Override
    public void undo(StringDrink drink) {
        drink.setText(drink.getText().replace(this.c2, this.c1));
    }
}
