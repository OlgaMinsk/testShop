package Service;

import Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getProductById(int id) throws Exception;
    void createProduct(String name, int prise) throws Exception;
}
