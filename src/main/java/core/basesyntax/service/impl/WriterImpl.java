package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriterImpl implements Writer {
    @Override
    public void writeToFile(String fileName, String data) {
        try {
            Files.write(Paths.get(fileName), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write to file",e);
        }
    }
}
