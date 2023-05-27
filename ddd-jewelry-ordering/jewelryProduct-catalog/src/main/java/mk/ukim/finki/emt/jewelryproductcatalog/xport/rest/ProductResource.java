package mk.ukim.finki.emt.jewelryproductcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.jewelryproductcatalog.domain.models.JewelryProduct;
import mk.ukim.finki.emt.jewelryproductcatalog.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jewelryProduct")
@AllArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @GetMapping
    public List<JewelryProduct> getAll() {
        return productService.getAll();
    }

}

