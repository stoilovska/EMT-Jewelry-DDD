package mk.ukim.finki.emt.jewelryproductcatalog.services;

import mk.ukim.finki.emt.jewelryproductcatalog.domain.models.JewelryId;
import mk.ukim.finki.emt.jewelryproductcatalog.domain.models.JewelryProduct;
import mk.ukim.finki.emt.jewelryproductcatalog.services.form.ProductForm;

import java.util.List;

public interface ProductService {
    JewelryProduct findById(JewelryId id);
    JewelryProduct createProduct(ProductForm form);
    JewelryProduct orderItemCreated(JewelryId productId, int quantity);
    JewelryProduct orderItemRemoved(JewelryId productId, int quantity);
    List<JewelryProduct> getAll();

}
