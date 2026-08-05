package core.basesyntax.service.impl;

import static core.basesyntax.db.Storage.fruits;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.Transaction;

public class PurchaseTransaction implements Transaction {

    @Override
    public void process(String fruitName, int amount) {
        int storageAmount = fruits.stream()
                .filter(fruit -> fruit.getName().equals(fruitName))
                .findFirst()
                .map(Fruit::getQuantity)
                .orElse(0);
        if (storageAmount - amount >= 0) {
            fruits.stream().filter(fruit -> fruit.getName().equals(fruitName))
                    .findFirst()
                    .ifPresent(fruit -> fruit.setQuantity(storageAmount - amount));
        } else {
            throw new RuntimeException("Not enough fruits in storage");
        }
    }
}
