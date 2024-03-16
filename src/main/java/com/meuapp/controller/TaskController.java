@Controller
public class TaskController {

    @GetMapping("/tasks")
    public String tasksPage() {
        return "tasks";
    }
}
