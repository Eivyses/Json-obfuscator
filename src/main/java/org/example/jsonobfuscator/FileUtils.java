package org.example.jsonobfuscator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class FileUtils {

  public static void writeMappingToFile(final Map<String, String> mapping, final String filename)
      throws IOException {
    final var result =
        mapping.entrySet().stream()
            .map(entry -> String.format("%s -> %s", entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());
    Files.write(Paths.get(filename), result);
  }
}
