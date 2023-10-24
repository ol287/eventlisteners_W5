import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

class UserInputSource extends Thread {
    private final List<UserInputListener> listeners = new CopyOnWriteArrayList<>();

    public void addUserInputListener(UserInputListener listener) {
        listeners.add(listener);
    }

    public void removeUserInputListener(UserInputListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("EXIT")) {
                    break;
                }
                writeInputToFile(input, "user_input.txt");
                fireEvent(new UserInputEvent(this, input));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fireEvent(UserInputEvent event) {
        for (UserInputListener listener : listeners) {
            listener.userInputReceived(event);
        }
    }

    private void writeInputToFile(String input, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(input + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
