package edmond.service;

import edmond.repository.ToDo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private static List<ToDo> toDoList = new ArrayList<>();
    private static int todoCount = 0;

    static {
        toDoList.add(new ToDo(++todoCount, "edi", "Learn Spring MVC",
                false, LocalDate.now().plusDays(20L)));

        toDoList.add(new ToDo(++todoCount, "edi", "Learn AWS",
                false, LocalDate.now().plusDays(30L)));

        toDoList.add(new ToDo(++todoCount, "edi", "Learn Hibernate",
                false, LocalDate.now().plusDays(2L)));
    }

    public static List<ToDo> findAll() {
        return toDoList;
    }

    public static void addToDo(String username, String description, boolean done, LocalDate targetDate) {
        toDoList.add(new ToDo(++todoCount, username, description, done, targetDate));
    }
}
