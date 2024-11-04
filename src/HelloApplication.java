package com.manager.gtm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class HelloApplication extends Application {

    private Task_manager tm = new Task_manager();

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
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

        show_all_tasks_button.setOnAction(event -> {

        });


        VBox root = new VBox(10, textFieldTask, task, textFieldDesc, description, textFieldDate,date, textFieldRec, recurring, plan_task_button, show_all_tasks_button);

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Task manager");
        stage.show();
    }
}