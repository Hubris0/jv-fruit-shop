package core.basesyntax.service;

public class ReturnTransaction implements Transaction {

    @Override
    public void process(String fruitName, int amount) {
        SupplyTransaction supplyTransaction = new SupplyTransaction();
        supplyTransaction.process(fruitName, amount);
    }
}
