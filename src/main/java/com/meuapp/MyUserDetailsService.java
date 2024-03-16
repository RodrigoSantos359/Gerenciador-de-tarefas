@Service
public class MyUserDetailsService implements UserDetailsService {
    
        @Autowired
        private UserRepository userRepository;
    
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<User> user = userRepository.findByUsername(username);
            
            user.orElseThrow(() -> new UsernameNotFoundException("Não foi possível encontrar o usuário com o nome: " + username));
            
            return user.map(MyUserDetails::new).get();
        }
}

