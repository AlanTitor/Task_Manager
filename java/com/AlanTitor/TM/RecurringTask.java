package com.AlanTitor.TM;

public class RecurringTask extends Task{
    private final String repetition_interval;//Частота повторения задачи "Ежедневно/Еженедельно"

    public RecurringTask(String name_of_task, String description, String repetition_interval){
        super(name_of_task, description);//Наследование конктруктора
        this.repetition_interval = repetition_interval;
    }
    //Перегрузка вывода инфы
    @Override
    public String show_info(){        
        return ("The name of task is: " + this.getNameOfTask() + ". The description is: " + this.getDescription() + ". How often: " + this.repetition_interval + ". The date of beginning is on: " + this.getDateOfBeginning() + ".");
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