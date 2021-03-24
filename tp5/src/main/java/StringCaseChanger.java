public class StringCaseChanger implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        String inverted = "";
        for (int i = 0; i < drink.getText().length(); ++i) {
            if (Character.isLowerCase(drink.getText().charAt(i))) {
                inverted += Character.toUpperCase(drink.getText().charAt(i));
            } else {
                inverted += Character.toLowerCase(drink.getText().charAt(i));
            }
        }
        drink.setText(inverted);
    }

    @Override
    public void undo(StringDrink drink) {
        String inverted = "";
        for (int i = 0; i < drink.getText().length(); ++i) {
            if (Character.isLowerCase(drink.getText().charAt(i))) {
                inverted += Character.toUpperCase(drink.getText().charAt(i));
            } else {
                inverted += Character.toLowerCase(drink.getText().charAt(i));
            }
        }
        drink.setText(inverted);
    }
}
