package bookverse.BookService;

import bookverse.Dto.LoginRequest;
import bookverse.Model.User;
import bookverse.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JWtService jWtService;


    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder, JWtService jWtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jWtService = jWtService;
    }

    public User register(User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }
    public String login(LoginRequest request){

        User user = userRepository.findByUsername(
                request.getUsername()
        ).orElseThrow(() ->
                new RuntimeException("User Not Found"));

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if(matches){
            return jWtService.generateToken(
                    user.getUsername()

            );
        }

        throw new RuntimeException("Invalid Password");
    }
}
