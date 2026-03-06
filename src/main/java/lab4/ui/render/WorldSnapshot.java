/**
 * WorldSnapshot.java
 */

package lab4.ui.render;

import java.util.List;

public record WorldSnapshot(
  int width,
  int height,
  List<VehicleSnapshot> vehicles,
  List<GarageSnapshot> garages
) {
  public WorldSnapshot {
    vehicles = List.copyOf(vehicles);
    garages = List.copyOf(garages);
  }
}
