@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return taskService.getAllTasksByUser(user);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Task createdTask = taskService.createTask(task, user);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Task updatedTask = taskService.updateTask(id, task, user);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        taskService.deleteTask(id, user);
        return ResponseEntity.ok("Tarefa deletada com sucesso!");
    }
}
