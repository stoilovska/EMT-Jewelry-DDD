package mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class UserId extends DomainObjectId {
    private UserId(){
        super(String.valueOf(JewelryId.randomId(JewelryId.class)));
    }

    public UserId(String uuid) {
        super(uuid);
    }
}
