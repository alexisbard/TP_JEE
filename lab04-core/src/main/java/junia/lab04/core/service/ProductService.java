package junia.lab04.core.service;

import junia.lab04.core.dao.ProductDAO;
import junia.lab04.core.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private ProductDAO productDAO;


    public ProductService(final ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    public void deleteAll() {
        productDAO.deleteAll();
    }


    public void save(final Product product) {
        productDAO.save(product);
    }


    public long countAll() {
        return productDAO.count();
    }


    public List<Product> findAllProducts(){
        return productDAO.findAllProducts();
    }


    public void deleteById(final long id) {
        productDAO.deleteById(id);
    }
}
