package core.basesyntax.service;

import static core.basesyntax.db.Storage.fruits;

public class PurchaseTransaction implements Transaction {

    @Override
    public void process(String fruitName, int amount) {
        fruits.stream()
                .filter(fruit -> fruit.getName().equals(fruitName))
                .findFirst()
                .ifPresent(fruit -> fruit.setQuantity(fruit.getQuantity() - amount));
    }
}
