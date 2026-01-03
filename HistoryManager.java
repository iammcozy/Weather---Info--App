import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoryManager {

    private List<String> history = new ArrayList<>();

    public void addEntry(String city) {
        history.add(city + " - " + LocalDateTime.now());
    }

    public List<String> getHistory() {
        return history;
    }
}