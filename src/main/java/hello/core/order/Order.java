package hello.core.order;

public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int disconutPrice;

    public Order(Long memberId, String itemName, int itemPrice, int disconutPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.disconutPrice = disconutPrice;
    }

    public int calculatePrice(){
        return itemPrice - disconutPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDisconutPrice() {
        return disconutPrice;
    }

    public void setDisconutPrice(int disconutPrice) {
        this.disconutPrice = disconutPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", disconutPrice=" + disconutPrice +
                '}';
    }
}
