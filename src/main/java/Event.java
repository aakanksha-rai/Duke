import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    String at;
    String parsedAt;

    /**
     * Creates event.
     * @param description contains description of event.
     */
    public Event(String[] description) {
        super(description[0]);
        assert description.length > 1 : "description is not of the right format";
        at = (description[1].split(" ", 2))[1];
        modifyDateFormat();
    }

    /**
     * Changes format of Date.
     */
    public void modifyDateFormat() {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm");
        LocalDateTime parsedDate = LocalDateTime.parse(this.at, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy HHmm");
        this.parsedAt = parsedDate.format(outputFormatter);
    }

    public Event(String description, String atDate, boolean isDone) {
        super(description, isDone);
        at = atDate;
        modifyDateFormat();
    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + " (at: " + parsedAt + ")";
    }

    @Override
    public String addToFile() {
        //format to be added to file
        return "E | " + super.addToFile() + " | " + at;
    }
}
