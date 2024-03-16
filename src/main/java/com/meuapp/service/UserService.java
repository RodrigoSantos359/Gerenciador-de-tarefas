@Service
public class UserService {
    
        @Autowired
        private UserRepository userRepository;
    
        public User saveUser(User user) {
            return userRepository.save(user);
        }
    
        public Optional<User> findByUsername(String username) {
            return userRepository.findByUsername(username);
        }
    
        public List<User> findAllUsers() {
            return userRepository.findAll();
        }
    
        public User updateUser(User user) {
            return userRepository.save(user);
        }
    
        public void deleteUser(Long userId) {
            userRepository.deleteById(userId);
        }
}
