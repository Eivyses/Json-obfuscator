package org.example.jsonobfuscator.encoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public interface Encoder {
  Map<String, String> encode(InputStream inputStream, OutputStream outputStream) throws IOException;
}
