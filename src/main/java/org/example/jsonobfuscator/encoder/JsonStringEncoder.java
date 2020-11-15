package org.example.jsonobfuscator.encoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.example.jsonobfuscator.ObfuscatorUtil;
import org.example.jsonobfuscator.reader.Reader;
import org.example.jsonobfuscator.reader.StreamReader;

public class JsonStringEncoder implements Encoder {

  private static final char TEXT_CHARACTER = '"';

  @Override
  public Map<String, String> encode(final InputStream inputStream, final OutputStream outputStream)
      throws IOException {
    final Map<String, String> mappings = new HashMap<>();
    final Reader streamReader = new StreamReader(inputStream);

    while (streamReader.hasText()) {
      final String beforeText = streamReader.readUntil(TEXT_CHARACTER);
      final String text = streamReader.readUntil(TEXT_CHARACTER);
      outputStream.write(beforeText.getBytes());
      if (text.isBlank()) {
        break;
      }
      mappings.putIfAbsent(text, ObfuscatorUtil.asHex(text));
      outputStream.write(TEXT_CHARACTER);
      outputStream.write(ObfuscatorUtil.asUnicode(text).getBytes());
      outputStream.write(TEXT_CHARACTER);
    }
    outputStream.close();
    inputStream.close();
    return mappings;
  }
}
