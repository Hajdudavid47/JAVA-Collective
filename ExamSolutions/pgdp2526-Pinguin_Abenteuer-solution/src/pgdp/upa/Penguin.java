package pgdp.upa;

public class Penguin {
    private int stones;
    private Item currentItem;

    public Penguin() {
        stones = 0;
    }

    public int getStones() {
        return stones;
    }

    public void findStones(int amount) {
        stones += amount;
    }

    public void findItem(Item item) {
        currentItem = item;
    }

    public boolean loseItem() {
        if (currentItem != null) {
            currentItem = null;
            return true;
        }
        return false;
    }

    public String currentItemKind() {
        if (currentItem != null) {
            return currentItem.getKind();
        }
        return null;
    }

    public int netWorth() {
        if (currentItem == null) {
            return stones;
        }
        return stones + currentItem.getPrice();
    }

    public boolean tradeWith(Penguin penguin) {
        if (this.currentItem != null && penguin.currentItem != null ||
                this.currentItem == null && penguin.currentItem == null) {
            return false;
        }
        if (currentItem != null) {
            return trade(this, penguin);
        } else {
            return trade(penguin, this);
        }
    }

    private static boolean trade(Penguin seller, Penguin buyer) {
        int price = seller.currentItem.getPrice() + 1;
        if (!(buyer.stones >= price)) {
            return false;
        }
        buyer.stones -= price;
        seller.stones += price;
        buyer.currentItem = seller.currentItem;
        seller.currentItem.setPrice(price);

        seller.currentItem = null;
        return true;
    }
}
