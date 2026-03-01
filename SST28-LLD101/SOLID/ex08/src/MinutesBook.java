import java.util.*;

//Holds an array of strings that represent the summary of the meeting
public class MinutesBook {
    private final List<String> items = new ArrayList<>();
    public void add(String text) {
        items.add(text);
        System.out.println("Minutes added: \"" + text + "\"");
    }
    public int count() { return items.size(); }
}
