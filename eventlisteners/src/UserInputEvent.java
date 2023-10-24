import java.util.EventObject;

class UserInputEvent extends EventObject {
    private final String input;

    public UserInputEvent(Object source, String input) {
        super(source);
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
