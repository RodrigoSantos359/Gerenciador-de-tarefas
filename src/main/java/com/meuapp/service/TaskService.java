@Service
public class TaskService {
    
        @Autowired
        private TaskRepository taskRepository;
    
        public void completeTask(Long taskId) {
            // Busque a tarefa pelo ID
            Task task = taskRepository.findById(taskId)
                    .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com o ID " + taskId));
    
            // Marque a tarefa como concluída
            task.setCompleted(true);
    
            // Salve a tarefa atualizada
            taskRepository.save(task);
        }
    
        public List<Task> getPendingTasks(String username, String priority) {
            // Se a prioridade não for fornecida, busque todas as tarefas pendentes
            if (priority == null) {
                return taskRepository.findByUserUsernameAndCompletedFalse(username);
            }
    
            // Busque todas as tarefas pendentes com a prioridade fornecida
            return taskRepository.findByUserUsernameAndPriorityAndCompletedFalse(username, priority);
        }
}