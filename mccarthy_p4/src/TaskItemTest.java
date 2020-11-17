import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TaskItemTest {
    //Title tests
    @Test
    void creatingTaskItemFailsWithInvalidTitle() {
        TaskItem item = new TaskItem();
        assertEquals(1, item.titleCheck(""));
    }

    @Test
    void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem item = new TaskItem();
        assertEquals(0, item.titleCheck("new task"));
    }

    @Test
    void settingTaskItemFailsWithValidTitle() {
        TaskItem item = new TaskItem();
        item.setTitle("");

        assertEquals(1, item.titleCheck(item.getTitle()));
    }

    @Test
    void settingTaskItemSucceedsWithValidTitle() {
        TaskItem item = new TaskItem();
        item.setTitle("new task");

        assertEquals(0, item.titleCheck(item.getTitle()));
    }

    //DueDate Tests

    @Test
    void creatingTaskItemFailsWithInvalidDueDate() {
        TaskItem item = new TaskItem();

        assertEquals(1, item.dateCheck("2012-10-07"));
    }

    @Test
    void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem item = new TaskItem();

        assertEquals(0, item.dateCheck("2021-10-07"));
    }

    @Test
    void settingTaskItemFailsWithInvalidDueDate() {
        TaskItem item = new TaskItem();

        item.setDueDate("2020-10-09");

        assertEquals(1, item.dateCheck(item.getDueDate()));
    }

    @Test
    void settingTaskItemSucceedsWithValidDueDate() {
        TaskItem item = new TaskItem();

        item.setDueDate("2021-10-07");

        assertEquals(0, item.dateCheck(item.getDueDate()));
    }
}
