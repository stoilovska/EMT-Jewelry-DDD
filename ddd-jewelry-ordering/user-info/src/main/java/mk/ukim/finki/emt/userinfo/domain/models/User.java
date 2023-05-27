package mk.ukim.finki.emt.userinfo.domain.models;

import javax.persistence.*;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Address;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Role;

@Entity
@Table(name = "user_order")
@Getter
public class User extends AbstractEntity<UserId> {
    private String name;

    private String surname;

    @Enumerated(EnumType.STRING)
    private Role role;

    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "address_country")),
            @AttributeOverride(name = "street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "number", column = @Column(name = "address_number"))
    })
    private Address address;

    protected User() {
        super(UserId.randomId(UserId.class));
    }

    public static User build(String name, String surname, Role role, Address address) {
        User p = new User();
        p.name = name;
        p.surname = surname;
        p.role = role;
        p.address = address;
        return p;
    }

}
