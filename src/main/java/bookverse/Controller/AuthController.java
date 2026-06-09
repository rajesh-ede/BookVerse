package bookverse.Controller;

import bookverse.BookService.AuthService;
import bookverse.Dto.LoginRequest;
import bookverse.Model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }
@PostMapping("/register")
    public User register(@RequestBody User user){
        return authService.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        return authService.login(request);
    }
}
