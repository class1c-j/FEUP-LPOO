import java.util.ArrayDeque;
import java.util.Deque;

public class IcecreamMachine {
    private final Icecream icecream;
    Deque<Command> stack = new ArrayDeque<>();
    public IcecreamMachine(Icecream icecream) {
        this.icecream = icecream;
    }

    public IcecreamMachine executeCommand(Command command) {
        command.execute(icecream);
        stack.push(command);
        return this;
    }

    public void undoLastCommand() {
        stack.getFirst().undo(icecream);
        stack.pop();
    }
}
