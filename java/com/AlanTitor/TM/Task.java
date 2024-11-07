package com.AlanTitor.TM;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task implements Comparable<Task> {
    protected String name_of_task; //название задачи
    protected String description; //Описание задачи
    protected final Calendar date;//дата создания
    protected DateFormat df;//Более удобный формат даты

    public Task(String name_of_task, String description){
        this.name_of_task = name_of_task;
        this.description = description;
        this.date = new GregorianCalendar();
        this.df = new SimpleDateFormat("dd MM yyyy");
    }

    public String show_info(){        
        return ("The name of task is: " + this.name_of_task + ". The description is: " + this.description + ". The date of beginning is on: " + df.format(this.date.getTime()) + ".");
    }

    //Перерегрузка метода интерфейса для сравнивания дат
    @Override
    public int compareTo(Task other) {
        return this.date.compareTo(other.date);
    }
}

