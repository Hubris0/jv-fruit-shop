package core.basesyntax;

import core.basesyntax.service.Reader;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportCreator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.TransactionHandler;
import java.util.ArrayList;

public class Main {
    public static final String FILE_NAME = "fruitOperations.csv";
    public static final String START_LINE = "type,fruit,quantity";

    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        ArrayList<String> lines = reader.readFromFile(FILE_NAME);

        for (String line : lines) {
            if (line.equals(START_LINE)) {
                continue;
            }
            TransactionHandler.process(line);
        }

        Writer writer = new WriterImpl();
        String report = ReportCreator.createReport();
        writer.writeToFile("report.csv", report);
    }
}
