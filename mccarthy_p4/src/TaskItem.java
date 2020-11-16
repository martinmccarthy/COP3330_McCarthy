import javax.swing.text.DateFormatter;
import java.time.format.*;
import java.time.LocalDate;

public class TaskItem {

    private String title;
    private String description;
    private String dueDate;
    private int taskNumber;

    public void addToTaskList(String taskString) {
        App.taskList.writeToFile(taskString);
    }

    public String concatTaskItem() {
        String taskString = taskNumber + ")" +
                "[" + dueDate + "]" +
                " " + title +
                ": " + description;
        return taskString;
    }

    // if the title is invalid, return 1 for exception handling, otherwise return 0
    public int titleCheck(String title) {
        if(title.length() == 0) {
            System.out.println("Task title requires one or more characters");
            return 1;
        }
        return 0;
    }

    public int dateCheck(String dueDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        LocalDate userDate = LocalDate.parse(dueDate);

        if(userDate.compareTo(today) < 0) {
            System.out.print("date entered is invalid, please re-enter: ");
            return 1;
        }

        return 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }
}
