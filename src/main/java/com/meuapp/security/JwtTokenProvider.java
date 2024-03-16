Service
public class JwtTokenProvider {
        
            @Value("${app.jwtSecret}")
            private String jwtSecret;
        
            @Value("${app.jwtExpirationInMs}")
            private int jwtExpirationInMs;
        
            @Autowired
            private UserDetailsService userDetailsService;
        
            @Autowired
            private UserRepository userRepository;
        
            private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
        
            public String generateToken(Authentication authentication) {
                User user = (User) authentication.getPrincipal();
        
                Date now = new Date();
                Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        
                return Jwts.builder()
                        .setSubject(Long.toString(user.getId()))
                        .setIssuedAt(new Date())
                        .setExpiration(expiryDate)
                        .signWith(SignatureAlgorithm.HS512, jwtSecret)
                        .compact();
            }
        
            public Long getUserIdFromJWT(String token) {
                Claims claims = Jwts.parser()
                        .setSigningKey(jwtSecret)
                        .parseClaimsJws(token)
                        .getBody();
        
                return Long.parseLong(claims.getSubject());
            }
        
            public boolean validateToken(String authToken) {
                try {
                    Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
                    return true;
                } catch (SignatureException ex) {
                    logger.error("Assinatura JWT inválida");
                } catch (MalformedJwtException ex) {
                    logger.error("Token JWT inválido");
                } catch (ExpiredJwtException ex) {
                    logger.error("Token JWT expirado");
                } catch (UnsupportedJwtException ex) {
                    logger.error("Token JWT não suportado");
                } catch (IllegalArgumentException ex) {
                    logger.error("String JWT vazia");
                }
                return false;
            }
        
            public UserDetails getUserDetails(String token) {
                Long userId = getUserIdFromJWT(token);
                User user = userRepository.findById(userId)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o ID : " + userId));
        
                return userDetailsService.loadUserByUsername(user.getUsername());
            }
}