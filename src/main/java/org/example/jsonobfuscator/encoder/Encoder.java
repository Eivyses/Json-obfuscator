package org.example.jsonobfuscator.encoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public interface Encoder {

  /**
   * Encodes input file
   *
   * @param inputStream data of file to encode
   * @param outputStream data of encoded file
   * @return encoded values and their equivalent code
   * @throws IOException if reading/writing to streams failed
   */
  Map<String, String> encode(InputStream inputStream, OutputStream outputStream) throws IOException;
}
