package core.basesyntax.service.impl;

import core.basesyntax.service.Transaction;

import static core.basesyntax.db.Storage.fruits;

public class SupplyTransaction implements Transaction {

    @Override
    public void process(String fruitName, int amount) {
        fruits.stream()
                .filter(fruit -> fruit.getName().equals(fruitName))
                .findFirst()
                .ifPresent(fruit -> fruit.setQuantity(fruit.getQuantity() + amount));
    }
}
