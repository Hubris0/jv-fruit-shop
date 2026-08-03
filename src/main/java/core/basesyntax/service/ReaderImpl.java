package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    public ArrayList<String> readFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            return new ArrayList<>(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
