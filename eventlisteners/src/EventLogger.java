import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

class EventLogger implements UserInputListener {
    private String filename;

    public EventLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void userInputReceived(UserInputEvent event) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            String logMessage = String.format("[%s] - Event: %s, Input: %s\n",
                    new Date(), event.getSource(), event.getInput());
            writer.write(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
