package org.example.jsonobfuscator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.jsonobfuscator.encoder.JsonStringEncoder;

public class Main {

  private static final String MAPPING_FILE_NAME = "mapping.txt";

  public static void main(final String[] args) throws IOException {
    if (args.length == 0) {
      System.out.println("No input file specified, exiting");
      return;
    }
    final String inputFilePath = args[0];
    final String mappingFileName;

    if (args.length == 2) {
      mappingFileName = args[1];
    } else {
      mappingFileName = MAPPING_FILE_NAME;
    }

    final OutputStream outputStream;
    if (args.length == 3) {
      outputStream = new FileOutputStream(args[2]);
    } else {
      outputStream = System.out;
    }

    final var mapping =
        new JsonStringEncoder().encode(new FileInputStream(inputFilePath), outputStream);
    writeMappingToFile(mapping, mappingFileName);
  }

  private static void writeMappingToFile(final Map<String, String> mapping, final String filename)
      throws IOException {
    final var result =
        mapping.entrySet().stream()
            .map(entry -> String.format("%s -> %s", entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());
    Files.write(Paths.get(filename), result);
  }
}
