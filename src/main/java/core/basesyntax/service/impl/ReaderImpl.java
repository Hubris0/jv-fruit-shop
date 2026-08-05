package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
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
            throw new RuntimeException("input file not found", e);
        }
    }
}
