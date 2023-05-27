package mk.ukim.finki.emt.jewelryproductcatalog.domain.repository;

import mk.ukim.finki.emt.jewelryproductcatalog.domain.models.JewelryId;
import mk.ukim.finki.emt.jewelryproductcatalog.domain.models.JewelryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelryProductRepository extends JpaRepository<JewelryProduct, JewelryId> {
}
