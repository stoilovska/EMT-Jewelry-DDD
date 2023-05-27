package mk.ukim.finki.emt.userinfo.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.userinfo.domain.models.User;
import mk.ukim.finki.emt.userinfo.domain.models.UserId;
import mk.ukim.finki.emt.userinfo.domain.repository.UserRepository;
import mk.ukim.finki.emt.userinfo.services.UserService;
import mk.ukim.finki.emt.userinfo.services.form.UserForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(UserId id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User createUser(UserForm form) {
        User p = User.build(form.getName(),form.getSurname(),form.getRole(),form.getAddress());
        userRepository.save(p);
        return p;
    }

    @Override
    public User orderItemCreated(UserId userId, int quantity) {
        User p = userRepository.findById(userId).orElseThrow();
//        p.addSales(quantity);
        userRepository.saveAndFlush(p);
        return p;
    }

    @Override
    public User orderItemRemoved(UserId productId, int quantity) {
        User p = userRepository.findById(productId).orElseThrow();
//        p.removeSales(quantity);
        userRepository.saveAndFlush(p);
        return p;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
