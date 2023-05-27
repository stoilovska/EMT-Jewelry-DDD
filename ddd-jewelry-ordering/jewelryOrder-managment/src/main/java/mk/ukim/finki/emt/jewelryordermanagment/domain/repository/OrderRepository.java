package mk.ukim.finki.emt.jewelryordermanagment.domain.repository;


import mk.ukim.finki.emt.jewelryordermanagment.domain.model.JewelryOrder;
import mk.ukim.finki.emt.jewelryordermanagment.domain.model.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<JewelryOrder, OrderId> {
}

