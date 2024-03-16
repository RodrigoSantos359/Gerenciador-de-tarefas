@RunWith(MockitoJUnitRunner.class)
public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthService authService;

    @Test
    public void testAuthenticate_ValidCredentials_ReturnsToken() {
        // Arrange
        String email = "test@example.com";
        String password = "password";
        User user = new User();
        user.setId(1L);
        user.setPassword(password);
        Mockito.when(userRepository.findByEmail(email)).thenReturn(user);

        // Act
        String token = authService.authenticate(email, password);

        // Assert
        assertNotNull(token);
    }

    @Test
    public void testAuthenticate_InvalidCredentials_ReturnsNull() {
        // Arrange
        String email = "test@example.com";
        String password = "password";
        Mockito.when(userRepository.findByEmail(email)).thenReturn(null);

        // Act
        String token = authService.authenticate(email, password);

        // Assert
        assertNull(token);
    }
}@RunWith(MockitoJUnitRunner.class)
public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthService authService;

    @Test
    public void testAuthenticate_ValidCredentials_ReturnsToken() {
        // Arrange
        String email = "test@example.com";
        String password = "password";
        User user = new User();
        user.setId(1L);
        user.setEmail(email);
        user.setPassword(password);
        when(userRepository.findByEmail(email)).thenReturn(user);

        // Act
        String token = authService.authenticate(email, password);

        // Assert
        assertNotNull(token);
        // Add more assertions if needed
    }

    @Test
    public void testAuthenticate_InvalidCredentials_ReturnsNull() {
        // Arrange
        String email = "test@example.com";
        String password = "password";
        when(userRepository.findByEmail(email)).thenReturn(null);

        // Act
        String token = authService.authenticate(email, password);

        // Assert
        assertNull(token);
        // Add more assertions if needed
    }

    // Add more test cases for different scenarios

}