public class StringInverter implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        StringBuilder stringBuilder = new StringBuilder(drink.getText());
        drink.setText(stringBuilder.reverse().toString());
    }

    @Override
    public void undo(StringDrink drink) {
        StringBuilder stringBuilder = new StringBuilder(drink.getText());
        drink.setText(stringBuilder.reverse().toString());
    }
}
