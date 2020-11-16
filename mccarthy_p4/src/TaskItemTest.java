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

}
