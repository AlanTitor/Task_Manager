import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        Task_manager tm = new Task_manager();
        tm.add_task("take out garbage", "Help to take out garbage");
        tm.add_task("go to dinner", "go to dinner with girlfriend", LocalDate.parse("2024-10-31"));
        tm.add_task("study", "study to code", "Everyday");
        tm.show_tasks();
        System.out.println("------------------------------------------------------------------------------");
        tm.dell_task(1);
        tm.show_tasks();
        System.out.println("------------------------------------------------------------------------------");
        tm.show_one_task(2);
    }
}
