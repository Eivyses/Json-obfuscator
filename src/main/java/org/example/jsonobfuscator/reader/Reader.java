package org.example.jsonobfuscator.reader;

import java.io.IOException;

public interface Reader {
  boolean hasText();

  String readUntil(final char character) throws IOException;
}
