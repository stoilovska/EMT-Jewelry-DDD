package mk.ukim.finki.emt.userinfo.domain.models.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Address;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Role;
import mk.ukim.finki.emt.userinfo.domain.models.User;
import mk.ukim.finki.emt.userinfo.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final UserRepository productRepository;

    @PostConstruct
    public void initData() {
        User p1 = User.build("Teodora", "Stoilovska", Role.ADMIN_ROLE,new Address("MKD","Street","123"));
        User p2 = User.build("Ime", "Prezime" ,Role.ADMIN_ROLE,new Address("MKD","Street1","123456789"));
        if (productRepository.findAll().isEmpty()) {
            productRepository.saveAll(Arrays.asList(p1,p2));
        }
    }
}
