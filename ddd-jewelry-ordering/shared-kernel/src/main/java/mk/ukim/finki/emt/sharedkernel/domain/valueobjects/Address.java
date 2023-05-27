package mk.ukim.finki.emt.sharedkernel.domain.valueobjects;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address implements ValueObject {

    private final String country;
    private final String street;
    private final String number;

    protected Address() {
        this.country = "";
        this.street = "";
        this.number = "";
    }

    public Address(@NonNull String country, @NonNull String street,@NonNull String number) {
        this.country = country;
        this.street =street;
        this.number = number;
    }

    public static Address valueOf(String country, String street, String number) {
        return new Address(country,street,number);
    }
}
