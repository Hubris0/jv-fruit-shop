package core.basesyntax.service.impl;

import static core.basesyntax.db.Storage.fruits;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Transaction;

public class BalanceTransaction implements Transaction {

    @Override
    public void process(String fruitName, int amount) {
        if (fruits.stream().anyMatch(fruit -> fruit.getName().equals(fruitName))) {
            fruits.stream()
                    .filter(fruit -> fruit.getName().equals(fruitName))
                    .findFirst()
                    .ifPresent(fruit -> fruit.setQuantity(amount));
            return;
        }
        Fruit fruit = new Fruit();
        fruit.setName(fruitName);
        fruit.setQuantity(amount);
        fruits.add(fruit);
    }
}
