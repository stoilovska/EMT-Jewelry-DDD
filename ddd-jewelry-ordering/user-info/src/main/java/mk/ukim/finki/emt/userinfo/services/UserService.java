package mk.ukim.finki.emt.userinfo.services;

import mk.ukim.finki.emt.userinfo.domain.models.User;
import mk.ukim.finki.emt.userinfo.domain.models.UserId;
import mk.ukim.finki.emt.userinfo.services.form.UserForm;

import java.util.List;

public interface UserService {
    User findById(UserId id);
    User createUser(UserForm form);
    User orderItemCreated(UserId productId, int quantity);
    User orderItemRemoved(UserId productId, int quantity);
    List<User> getAll();

}
