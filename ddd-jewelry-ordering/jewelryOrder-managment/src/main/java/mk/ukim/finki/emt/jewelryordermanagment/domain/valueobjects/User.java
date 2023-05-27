package mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Address;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Role;

import javax.persistence.*;

@Getter
public class User {

    private final UserId userId;

    private String name;

    private String surname;

    private Role role;

    private Address address;

    protected User() {
        this.userId = UserId.randomId(UserId.class);
        this.name = "";
        this.surname = "";
        this.role = Role.USER_ROLE;
        this.address = new Address("Macedonia", "Street1", "Number201076");
    }

    @JsonCreator
    public User(@JsonProperty("id") UserId userId,
                @JsonProperty("name") String name,
                @JsonProperty("surname") String surname,
                @JsonProperty("role") Role role,
                @JsonProperty("address") Address address) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.address = address;
    }
}
