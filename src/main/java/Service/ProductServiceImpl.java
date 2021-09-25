package Service;

import Model.Product;
import Repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {

        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) throws Exception {
        if (id > 0) {
            if (productRepository.existsById(id)) {
                return productRepository.getById(id);
            } else {
                throw new Exception("продукта с таким id нет. Нам очень жаль");
            }
        } else {
            throw new Exception("id не может быть отрицательным");
        }
    }

    @Override
    public void createProduct(String name, int prise) throws Exception {
        Product product = new Product(name, prise);
        productRepository.save(product);
    }

}
