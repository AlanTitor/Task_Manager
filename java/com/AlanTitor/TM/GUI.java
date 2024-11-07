package com.AlanTitor.TM;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class GUI extends Application {

    protected Task_manager tm = new Task_manager();

    public static void start_GUI() {
        Application.launch();
    }

    @Override
    public void start(Stage stage){
        stage.setWidth(900);
        stage.setHeight(600);
        stage.setTitle("Task manager");

        Text textFieldTask = new Text("Task");
        TextField task = new TextField();

        Text textFieldDesc = new Text("Desc");
        TextField description = new TextField();

        Text textFieldDate = new Text("Date of deadline or empty");
        TextField date = new TextField();

        Text textFieldRec = new Text("Recurring or empty");
        TextField recurring = new TextField();

        Button plan_task_button = new Button("Запланировать");
        Button show_all_tasks_button = new Button("Показать все задачи");

        //Button Запланировать
        plan_task_button.setOnAction(event -> {
            String Task = task.getText();
            String Description = description.getText();
            String Date = date.getText();
            String Recur = recurring.getText();

            if(Objects.equals(Date, "")){
                if(Objects.equals(Recur, "")){
                    tm.add_task(Task, Description);
                }else{
                    tm.add_task(Task, Description, Recur);
                }
            }else{
                tm.add_task(Task, Description, LocalDate.parse(Date));
            }
        });

        //Button показать все задачи
        show_all_tasks_button.setOnAction(event -> {
            try {
                Stage taskStage = new Stage();
                taskStage.setWidth(900);
                taskStage.setHeight(600);
                taskStage.setTitle("All Tasks");

                // Получаем список задач из Task_manager
                List<Task> tasks = tm.get_tasks();

                // Создаем ListView для отображения задач
                ListView<String> taskListView = new ListView<>();

                // Добавляем задачи в ListView
                for (Task tk : tasks) {
                    taskListView.getItems().add(tk.show_info());
                }

                // Создаем VBox и добавляем ListView в него
                VBox vbox = new VBox(10, taskListView);

                // Создаем сцену и устанавливаем ее на Stage
                Scene scene = new Scene(vbox, 900, 600);
                taskStage.setScene(scene);
                taskStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });



        VBox root = new VBox(10, textFieldTask, task, textFieldDesc, description, textFieldDate,date, textFieldRec, recurring, plan_task_button, show_all_tasks_button);

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Task manager");
        stage.show();
    }
}