public class AddScoopCommand extends Command {
    private final Flavor scoop;

    public AddScoopCommand(Flavor flavor) {
        this.scoop = flavor;
    }

    @Override
    public void execute(Icecream icecream) {
        icecream.addScoop(scoop);
    }

    @Override
    public void undo(Icecream icecream) {
        icecream.removeScoop(scoop);
    }
}
