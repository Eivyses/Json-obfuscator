# Java json text obfuscator
Simple json obfuscator that codes all strings using unicode [escape sequence](https://en.wikipedia.org/wiki/Escape_sequences_in_C#:~:text=An%20escape%20sequence%20is%20a,or%20impossible%20to%20represent%20directly.)

### Usage:
* run jar as `java -jar json-obfuscator-1.0-SNAPSHOT.jar demo.json`

### parameters:
1) input file to obfuscate
2) output mapping file name, if not specified will use `mapping.txt`
3) obfuscated json output file, if not specified will output to console 