package Model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orderItems")
public class OrderItems {
    @Id
    @Column(name = "id")
    private int orderId;
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private int product_id;


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            //я понимаю, что хорошо бы бростать исключение. сделаю, если успею. благодарю з апонимание
            System.out.println("Количество не может быть отрицательным");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItems that = (OrderItems) o;
        return orderId == that.orderId;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "orderId=" + orderId +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
        '}';
    }

    @Override
    public int hashCode() {
        return orderId;
    }
}
