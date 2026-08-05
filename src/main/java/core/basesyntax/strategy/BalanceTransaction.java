package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

import static core.basesyntax.db.Storage.*;

public class BalanceTransaction implements Transaction {

    @Override
    public void process(String fruitName, int amount) {
        if (getFruits().stream().anyMatch(fruit -> fruit.getName().equals(fruitName))) {
            getFruits().stream()
                    .filter(fruit -> fruit.getName().equals(fruitName))
                    .findFirst()
                    .ifPresent(fruit -> fruit.setQuantity(amount));
            return;
        }
        Fruit fruit = new Fruit();
        fruit.setName(fruitName);
        fruit.setQuantity(amount);
        addFruit(fruit);
    }
}
