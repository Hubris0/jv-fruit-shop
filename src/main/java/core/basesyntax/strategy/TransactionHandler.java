package core.basesyntax.strategy;

public class TransactionHandler {

    public static void process(String data) {
        String[] parts = data.split(",");
        String operation = parts[0];
        String fruitName = parts[1];
        int amount = Integer.parseInt(parts[2]);

        Transactions transaction = Transactions.fromType(operation);
        transaction.getTransaction().process(fruitName, amount);
    }
}
