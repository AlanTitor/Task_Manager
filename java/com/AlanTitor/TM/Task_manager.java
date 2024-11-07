    package com.AlanTitor.TM;

    import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;


    public class Task_manager {

        private static int count_of_tasks = 0;
        private final List<Task> tasks = new ArrayList<>();

        //Перегрезка методов по добавлению задач
        //Обычная Task
        public void add_task(String name_of_task, String description){
            count_of_tasks++;
            tasks.add(new Task(name_of_task, description));
            sort_tasks();
        }
        //Задача с deadline
        public void add_task(String name_of_task, String description, LocalDate date_of_deadline){
            count_of_tasks++;
            tasks.add(new DeadlineTask(name_of_task, description, date_of_deadline));
            sort_tasks();
        }
        //Задача с повторениями
        public void add_task(String name_of_task, String description, String repetition_interval){
            count_of_tasks++;
            tasks.add(new RecurringTask(name_of_task, description, repetition_interval));
            sort_tasks();
        }
        //Задача с повторениями И дедлайном
        public void add_task(String name_of_task, String description, String repetition_interval, LocalDate date_of_deadline){
            count_of_tasks++;
            tasks.add(new RecurringTask(name_of_task, description, repetition_interval));
            sort_tasks();
        }

        //отображение всех задач и их колличества
        public void show_tasks(){
            System.out.println("All tasks:");

            for(Task task : tasks){
                System.out.println(task.show_info());
            }

            System.out.println("There are " + count_of_tasks + " tasks.");
        }

        //отображение всех задач и их колличества
        public List<Task> get_tasks(){
            return new ArrayList<>(tasks);
        }

        //Сортирока задач по времени. Реализован с имплементированным интерфейсом Comparable
        private void sort_tasks(){
            Collections.sort(tasks);
        }

        public void dell_task(int index_to_delete){
            //Декрементируем, так как пользователь считает от 1, а не от 0
            index_to_delete--;

            if (index_to_delete < 0 || index_to_delete > tasks.size()-1){
                System.out.println("There is no such task that you try to delete!");
                return;
            }

            //Уменьшаем колличество задач
            count_of_tasks--;
            tasks.remove(index_to_delete);
        }

        public void show_one_task(int index_of_task){
            //Декрементируем, так как пользователь считает от 1, а не от 0
            index_of_task--;

            if (index_of_task < 0 || index_of_task > tasks.size()-1){
                System.out.println("There is no such task!");
                return;
            }

            Task one_task = tasks.get(index_of_task);
            System.out.println(one_task.show_info());
        }
    }
