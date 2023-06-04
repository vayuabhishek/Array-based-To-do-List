// package Projects.ArrayBasedTo_Do_List;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Task t1 = new Task(1, "Core Java", LocalDate.now(), false);
        Task t2 = new Task(2, "Spring Core", LocalDate.now(), false);
        to_do_list t = new to_do_list();
        t.add_Task(t1);
        t.add_Task(t2);

        t.displayTask();

        t.markTaskAsCompleted(1);
        t.remove_task(2);
        t.displayTask();

    }
}

class Task {
    private int id;
    private String task_name;
    private LocalDate due_date;
    private boolean is_completed;

    public Task(int id, String task_name, LocalDate due_date, boolean is_completed) {
        this.id = id;
        this.task_name = task_name;
        this.due_date = due_date;
        this.is_completed = is_completed;
    }

    public int getId() {
        return id;
    }

    public void set_is_completed(boolean value) {
        is_completed = value;
    }

    public String get_Task_Name() {
        return task_name;
    }

    public LocalDate get_due_date() {
        return due_date;
    }
}

class to_do_list {
    private Task[] tasks = new Task[10];
    private int count = 0;

    public void add_Task(Task t) {
        if (count < 10) {
            tasks[count] = t;
            count++;
        } else {
            int size_of_array = tasks.length;
            Task[] temp = new Task[size_of_array * 2];
            int i = 0;
            for (Task tempo : tasks) {
                temp[i] = tempo;
                i++;
            }
            tasks = temp;
            tasks[i] = t;
            count++;
        }
        System.out.println("\nSuccessfully Added Task!!!");
    }

    // findTaskIndex
    public int findTaskId(int id) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    // remove_task
    public void remove_task(int taskId) {
        int index = findTaskId(taskId);
        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                tasks[i] = tasks[i + 1];
            }
            count--;
            tasks[count] = null;
            System.out.println("\n Task Removed Successfully!!!");
        } else {
            System.out.println("\nTask not found!!!");
        }
    }

    // markTaskasCompleted
    public void markTaskAsCompleted(int task_id) {
        int index = findTaskId(task_id);
        if (index != -1) {
            tasks[index].set_is_completed(true);
            System.out.println("\n Task Completed Successfully!!!");
        } else {
            System.out.println("\nTask not found!!!");
        }
    }

    // displayTask
    public void displayTask() {
        for (int i = 0; i <= count; i++) {
            System.out.println("**********************************************");
            System.out.println("Task Id:" + tasks[i].getId());
            System.out.println("Task Name:" + tasks[i].get_Task_Name());
            System.out.println("Due Date:" + tasks[i].get_due_date());
        }
    }
}
