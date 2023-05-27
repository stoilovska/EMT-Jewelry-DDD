package mk.ukim.finki.emt.userinfo.services.form;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Address;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Role;

@Data
public class UserForm {
    private String name;
    private String surname;
    private Role role;
    private Address address;
}
