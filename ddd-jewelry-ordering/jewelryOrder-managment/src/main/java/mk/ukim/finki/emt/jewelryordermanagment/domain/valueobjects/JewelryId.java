package mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class JewelryId extends DomainObjectId {

    protected JewelryId(){
        super(String.valueOf(JewelryId.randomId(JewelryId.class)));
    }

    public JewelryId(String uuid) {
        super(uuid);
    }

}
