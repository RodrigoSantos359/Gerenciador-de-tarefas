@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public String authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return generateToken(user.getId());
        }
        return null;
    }

    private String generateToken(Long userId) {
        return Jwts.builder()
                .setSubject(userId.toString())
                .setExpiration(new Date(System.currentTimeMillis() + 15 * 60 * 1000)) // 15 minutos
                .signWith(SignatureAlgorithm.HS512, "yourSecretKey")
                .compact();
    }
}

