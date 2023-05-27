package mk.ukim.finki.emt.userinfo.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.userinfo.domain.models.User;
import mk.ukim.finki.emt.userinfo.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user_info")
@AllArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

}

