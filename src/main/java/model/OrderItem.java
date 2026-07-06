package model;

public class OrderItem {
    private FoodItem foodItem;
    private int quantity;

    public OrderItem(){}

    public OrderItem(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return foodItem.getPrice() * quantity;
    }


    @Override
    public String toString() {
        return "OrderItem{" +
                "FoodName= " + foodItem.getFoodName() +
                "Price= "+foodItem.getPrice()+
                ", quantity=" + quantity +
                "SubTotal= "+ getSubTotal()+
                '}';
    }
}
