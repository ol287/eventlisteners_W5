import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

class KeywordListener implements UserInputListener {
    private String keyword;
    private String filename;

    public KeywordListener(String keyword, String filename) {
        this.keyword = keyword;
        this.filename = filename;
    }

    @Override
    public void userInputReceived(UserInputEvent event) {
        if (event.getInput().toLowerCase().contains(keyword.toLowerCase())) {
            try (FileWriter writer = new FileWriter(filename, true)) {
                String logMessage = String.format("[%s] - Keyword: %s, Input: %s\n",
                        new Date(), keyword, event.getInput());
                writer.write(logMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
