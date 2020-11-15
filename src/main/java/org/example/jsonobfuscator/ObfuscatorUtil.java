package org.example.jsonobfuscator;

import static java.util.stream.Collectors.joining;

import java.util.function.IntFunction;

public class ObfuscatorUtil {

  public static String asHex(final String text) {
    return asFormat(text, ObfuscatorUtil::asHex);
  }

  public static String asUnicode(final String text) {
    return asFormat(text, ObfuscatorUtil::asUnicode);
  }

  private static String asFormat(final String text, final IntFunction<String> mappingFun) {
    return text.chars().mapToObj(mappingFun).collect(joining());
  }

  public static String asHex(final int letter) {
    return asFormat(letter, "\\x%02x");
  }

  public static String asUnicode(final int letter) {
    return asFormat(letter, "\\u%04x");
  }

  private static String asFormat(final int letter, final String format) {
    return String.format(format, letter);
  }
}
