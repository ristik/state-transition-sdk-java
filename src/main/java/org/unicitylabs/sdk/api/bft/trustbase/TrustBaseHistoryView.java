package org.unicitylabs.sdk.api.bft.trustbase;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import org.unicitylabs.sdk.api.NetworkId;

/**
 * The read-only face of a history, as verification uses it. A session hands out a view that fails
 * with {@link HistoryConflictedException} once an authenticated fork closed the session.
 */
public interface TrustBaseHistoryView {

  /**
   * Get the network of the held entries.
   *
   * @return the network, empty when nothing is held
   */
  Optional<NetworkId> getNetworkId();

  /**
   * Get the latest held entry.
   *
   * @return the tip, empty when nothing is held
   */
  Optional<TrustBaseEntry> getTip();

  /**
   * Get a snapshot of the held entries.
   *
   * @return immutable list, ascending from the genesis
   */
  List<TrustBaseEntry> getEntries();

  /**
   * Get the held entry of an epoch.
   *
   * @param epoch the epoch (unsigned)
   * @return the entry, empty before the genesis or after the tip
   */
  Optional<TrustBaseEntry> entryForEpoch(long epoch);

  /**
   * Get the last round of an epoch.
   *
   * @param epoch the epoch (unsigned)
   * @return the round, empty when unknown (the tip's epoch is open)
   */
  OptionalLong epochEndRound(long epoch);

  /**
   * Export the held history as one complete bundle.
   *
   * @return the tag-39015 bundle
   */
  byte[] toBundle();
}
