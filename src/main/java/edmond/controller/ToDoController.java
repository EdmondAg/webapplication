package edmond.controller;

import edmond.service.ToDoService;
import edmond.repository.ToDo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

@Controller
@SessionAttributes("name")
public class ToDoController {

    ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping("/todo")
    public String goAtToDo(ModelMap modelMap) {
        modelMap.addAttribute("todoList", ToDoService.findAll());
        return "todo";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.GET)
    public String addNewTodo(ModelMap modelMap) {
        String username = (String) modelMap.get("name");
        ToDo toDo = new ToDo(1, username, "default", false, LocalDate.now());
        modelMap.put("todo", toDo);
        return "add-todo";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.POST)
    public String goBackAtTodo(@Validated ToDo toDo, BindingResult result, ModelMap modelMap) {
        String username = (String) modelMap.get("name");

//        if (result.hasErrors()) {
//            modelMap.put("error", "Invalid input: " + toDo.getId() + " " + toDo.getUsername() + " " + toDo.getDescription() + " " + toDo.isDone() + " " + toDo.getTargetDate());
//            System.out.println(toDo.getId() + " " + toDo.getUsername() + " " + toDo.getDescription() + " " + toDo.isDone() + " " + toDo.getTargetDate());
//            return "add-todo";
//        }
//        System.out.println("\nno error");
//        System.out.println(toDo.getId());
//        System.out.println(toDo.getUsername());
//        System.out.println(toDo.getDescription());
//        System.out.println(toDo.isDone());
//        System.out.println(toDo.getTargetDate());

        ToDoService.addToDo(username, toDo.getDescription(), false, LocalDate.now().plusDays(20L));

        return "redirect:todo";
    }
}


