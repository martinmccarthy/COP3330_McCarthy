import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TaskListTest {
    @Test
    void newTaskListIsEmpty() {
        TaskList taskList = new TaskList();

        taskList.setFileName("test-list.txt");
        taskList.createTaskList();
        assertEquals(0, taskList.getTotalTasks());
    }

    @Test
    void renameTaskListFailsWithInvalidTitleName() {
        TaskList taskList = new TaskList();

        taskList.setFileName("test-list.txt");
        String newFileName = "";
        assertEquals(1, taskList.renameFileCheck(newFileName));
    }

    @Test
    void renameTaskListSucceedsWithValidTitleName() {
        TaskList taskList = new TaskList();
        
        taskList.setFileName("test-list.txt");
        String newFileName = "hello.txt";
        assertEquals(0, taskList.renameFileCheck(newFileName));
    }
}
