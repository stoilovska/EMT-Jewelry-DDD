
package mk.ukim.finki.emt.jewelryproductcatalog.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class JewelryId extends DomainObjectId {
    private JewelryId(){
        super(JewelryId.randomId(JewelryId.class).getId());
    }

    public JewelryId(@NonNull String uuid){
        super(uuid);
    }

    public static JewelryId of(String uuid){
        JewelryId p = new JewelryId(uuid);
        return p;
    }
}
