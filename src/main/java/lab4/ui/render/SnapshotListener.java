/**
 * SnapshotListener.java
 */

package lab4.ui.render;

@FunctionalInterface
public interface SnapshotListener {
  void snapshotChanged(WorldSnapshot snapshot);
}

