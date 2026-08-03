package core.basesyntax.service;

import core.basesyntax.model.Fruit;

import static core.basesyntax.db.Storage.fruits;

public class ReportCreator {
    public static String createReport(){
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Fruit fruit : fruits) {
            report.append(fruit.getName())
                    .append(",")
                    .append(fruit.getQuantity())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
