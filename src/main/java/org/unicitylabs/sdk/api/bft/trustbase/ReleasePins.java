package org.unicitylabs.sdk.api.bft.trustbase;

import java.util.Collections;
import java.util.List;

/**
 * The release table of this SDK build, one row per public network. It is empty until the release
 * assets are generated and approved (PR 8 of the Java parity stack); a session can still be opened
 * over an explicit table, a private pin or a local bundle.
 */
public final class ReleasePins {

  /** The rows of the built-in table. */
  public static final List<ReleasePin> ROWS = Collections.emptyList();

  private ReleasePins() {
  }
}
