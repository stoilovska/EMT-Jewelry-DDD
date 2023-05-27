package mk.ukim.finki.emt.jewelryproductcatalog.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.jewelryproductcatalog.domain.models.JewelryId;
import mk.ukim.finki.emt.jewelryproductcatalog.domain.models.JewelryProduct;
import mk.ukim.finki.emt.jewelryproductcatalog.domain.repository.JewelryProductRepository;
import mk.ukim.finki.emt.jewelryproductcatalog.services.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mk.ukim.finki.emt.jewelryproductcatalog.domain.models.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.jewelryproductcatalog.services.form.ProductForm;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final JewelryProductRepository productRepository;

    @Override
    public JewelryProduct findById(JewelryId id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public JewelryProduct createProduct(ProductForm form) {
        JewelryProduct p = JewelryProduct.build(form.getJewelryName(),form.getManufacturer(),form.getCategory(),form.getMoney(),form.getSales());
        productRepository.save(p);
        return p;
    }

    @Override
    public JewelryProduct orderItemCreated(JewelryId productId, int quantity) {
        JewelryProduct p = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        p.addSales(quantity);
        productRepository.saveAndFlush(p);
        return p;
    }

    @Override
    public JewelryProduct orderItemRemoved(JewelryId productId, int quantity) {
        JewelryProduct p = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        p.removeSales(quantity);
        productRepository.saveAndFlush(p);
        return p;
    }

    @Override
    public List<JewelryProduct> getAll() {
        return productRepository.findAll();
    }
}
