package Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "productsStatus")
    private ProductsStatus productsStatus;
    @ManyToOne
    @JoinColumn(name = "orderItems_id")
    private OrderItems orderItems;

    public Product() {
    }

    public Product(String name, int price) throws Exception {
        setName(name);
        setPrice(price);

    }

    public OrderItems getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItems orderItems) {
        this.orderItems = orderItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws Exception {
        if (price > 0) {
            this.price = price;
        } else {
            throw  new Exception("Цена не может быть меньше нуля. пожалуйста, установите цену");
        }
    }

    public ProductsStatus getProductsStatus() {
        return productsStatus;
    }

    public void setProductsStatus(ProductsStatus productsStatus) {
        this.productsStatus = productsStatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productsStatus=" + productsStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
