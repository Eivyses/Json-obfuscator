package org.example.jsonobfuscator.reader;

import java.io.IOException;

public interface Reader {

  /**
   * checks if there are still bytes to read
   *
   * @return true if there are, false otherwise
   */
  boolean hasText();

  /**
   * reads bytes until a specific character is encountered
   *
   * @param character character until which to read bytes
   * @return all bytes until specified character
   * @throws IOException exception if reading fails
   */
  String readUntil(final char character) throws IOException;
}
