package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import static core.basesyntax.db.Storage.fruits;

public class BalanceTransaction implements Transaction {

    @Override
    public void process(String fruitName, int amount) {
        Fruit fruit = new Fruit();
        fruit.setName(fruitName);
        fruit.setQuantity(amount);
        fruits.add(fruit);
    }
}
