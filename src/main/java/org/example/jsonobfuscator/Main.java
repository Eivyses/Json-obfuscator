package org.example.jsonobfuscator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.example.jsonobfuscator.encoder.JsonStringEncoder;

public class Main {

  private static final String MAPPING_FILE_NAME = "mapping.txt";

  public static void main(final String[] args) {
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

    try (final InputStream inputStream = new FileInputStream(inputFilePath);
        final OutputStream outputStream =
            args.length == 3 ? new FileOutputStream(args[2]) : System.out) {
      final var mapping = new JsonStringEncoder().encode(inputStream, outputStream);
      FileUtils.writeMappingToFile(mapping, mappingFileName);
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }
}
