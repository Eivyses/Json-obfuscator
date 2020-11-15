package org.example.jsonobfuscator.reader;

import java.io.IOException;
import java.io.InputStream;

public class StreamReader implements Reader {

  private final InputStream inputStream;
  private int currentCharInt;

  public StreamReader(final InputStream inputStream) {
    this.inputStream = inputStream;
  }

  @Override
  public boolean hasText() {
    return currentCharInt != -1;
  }

  @Override
  public String readUntil(final char character) throws IOException {
    final StringBuilder builder = new StringBuilder();
    char lastChar = 0;
    while (true) {
      currentCharInt = inputStream.read();
      if (currentCharInt == -1) {
        return builder.toString();
      }
      final char currentChar = (char) currentCharInt;
      if (currentChar == character && lastChar != '\\') {
        return builder.toString();
      }
      builder.append(currentChar);
      lastChar = currentChar;
    }
  }
}
