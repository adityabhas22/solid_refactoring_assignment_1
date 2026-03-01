import java.util.*;

//Holds a list of events that have been created
//Returns count of number of events.
public class EventPlanner {
    private final List<String> events = new ArrayList<>();
    public void create(String name, double budget) {
        events.add(name);
        System.out.println("Event created: " + name + " (budget=" + (int)budget + ")");
    }
    public int count() { return events.size(); }
}
