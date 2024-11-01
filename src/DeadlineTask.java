import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DeadlineTask extends Task{
    private final Date date;

    public DeadlineTask(String name_of_task, String description, LocalDate date_of_deadline){
        super(name_of_task, description);//Наследование конктруктора
        //Время дедлайна
        this.date = Date.from(date_of_deadline.atStartOfDay(ZoneId.systemDefault()).toInstant());//Конвертация в удобный формат
    }
    //Перегрузка вывода инфы
    @Override
    public String show_info(){        
        return ("The name of task is: " + this.getNameOfTask() + ". The description is: " + this.getDescription() + ". The date of beginning is: " + getDateOfBeginning() + ". The deadline is on: " + super.df.format(this.date) + ".");
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