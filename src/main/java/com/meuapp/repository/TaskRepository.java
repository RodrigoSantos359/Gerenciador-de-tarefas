public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserUsernameAndCompletedFalse(String username);
    List<Task> findByUserUsernameAndPriorityAndCompletedFalse(String username, Priority priority);
}
