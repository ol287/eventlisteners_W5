import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        UserInputSource userInputSource = new UserInputSource();
        EventLogger eventLogger = new EventLogger("event_log.txt");
        KeywordListener keywordListener1 = new KeywordListener("university", "university_log.txt");
        KeywordListener keywordListener2 = new KeywordListener("exeter", "exeter_log.txt");

        userInputSource.addUserInputListener(eventLogger);
        userInputSource.addUserInputListener(keywordListener1);
        userInputSource.addUserInputListener(keywordListener2);

        userInputSource.start();
        userInputSource.wait(10000000);
        userInputSource.stop();
    }
}
