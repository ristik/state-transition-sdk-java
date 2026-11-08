# Changes

## UTB v2

- `CborDeserializer.decodeTextString` is strict UTF-8: malformed or unmappable input is an error
  instead of being replaced with U+FFFD, and the platform default charset is never used.
