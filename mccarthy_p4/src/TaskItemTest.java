import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskItemTest {
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
}
