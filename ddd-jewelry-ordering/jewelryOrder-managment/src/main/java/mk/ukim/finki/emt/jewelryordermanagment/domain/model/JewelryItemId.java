package mk.ukim.finki.emt.jewelryordermanagment.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class JewelryItemId extends DomainObjectId {
    private JewelryItemId() {
        super(JewelryItemId.randomId(JewelryItemId.class).getId());
    }

    public JewelryItemId(String uuid) {
        super(uuid);
    }

}
