package core.basesyntax.service.impl;

import core.basesyntax.service.Transaction;

public class ReturnTransaction implements Transaction {

    @Override
    public void process(String fruitName, int amount) {
        SupplyTransaction supplyTransaction = new SupplyTransaction();
        supplyTransaction.process(fruitName, amount);
    }
}
