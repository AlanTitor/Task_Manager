package com.AlanTitor.TM;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Recurring_DeadLine_Task extends Task{
    private final Date date; //Дада deadline
    private final String repetition_interval;//Частота повторения задачи "Ежедневно/Еженедельно"

    public Recurring_DeadLine_Task(String name_of_task, String description, String repetition_interval, LocalDate date_of_deadline){
        super(name_of_task, description);
        this.date = Date.from(date_of_deadline.atStartOfDay(ZoneId.systemDefault()).toInstant());//Конвертация в удобный формат
        this.repetition_interval = repetition_interval;
    }

    //Перегрузка вывода инфы
    @Override
    public String show_info(){
        return ("The name of task is: " + this.getNameOfTask() + ". The description is: " + this.getDescription() + ". The date of beginning is: " + getDateOfBeginning() + ". The deadline is on: " + super.df.format(this.date) + "How often: " + this.repetition_interval + ".");
    }

    public String getNameOfTask(){
        return super.name_of_task;
    }

    public String getDescription(){
        return super.description;
    }

    public String getDateOfBeginning(){
        return super.df.format(super.date.getTime());
    }
}

