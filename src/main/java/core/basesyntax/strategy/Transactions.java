package core.basesyntax.strategy;

import core.basesyntax.service.*;

public enum Transactions {
    BALANCE("b", new BalanceTransaction()),
    SUPPLY("s", new SupplyTransaction()),
    PURCHASE("p", new PurchaseTransaction()),
    RETURN("r", new ReturnTransaction());

    private final String transactionType;
    private final Transaction transaction;

    Transactions(String transactionType, Transaction transaction) {
        this.transactionType = transactionType;
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public static Transactions fromType(String transactionType) {
        for (Transactions type : values()) {
            if (type.transactionType.equals(transactionType)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid transaction type: " + transactionType);
    }
}
