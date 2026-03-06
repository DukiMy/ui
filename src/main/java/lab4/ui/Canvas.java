/**
 * Canvas.java
 */

package lab4.ui;

import lab4.ui.render.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public final class Canvas extends JComponent implements SnapshotListener {

  private final Border border = BorderFactory.createTitledBorder("Canvas");
  private final SpriteStore sprites = new SpriteStore();

  private volatile WorldSnapshot snapshot =
    new WorldSnapshot(0, 0, List.of(), List.of());

  public Canvas(int width, int height) {
    setPreferredSize(new Dimension(width, height));
    setBorder(border);
    setOpaque(true);
  }

  @Override
  public void snapshotChanged(WorldSnapshot snapshot) {
    this.snapshot = snapshot;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g.create();
    try {
      Insets in = getInsets();
      int ox = in.left;
      int oy = in.top;

      int w = getWidth() - in.left - in.right;
      int h = getHeight() - in.top - in.bottom;

      g2.setColor(new Color(0, 255, 0));
      g2.fillRect(ox, oy, w, h);

      // garages
      g2.setColor(Color.DARK_GRAY);
      for (GarageSnapshot gr : snapshot.garages()) {
        int x = ox + (int) gr.x();
        int y = oy + (int) gr.y();

        Image img = sprites.get(gr.spriteId());
        if (img != null) {
          g2.drawImage(img, x, y, 60, 60, this);
        }
      }

      // vehicles (sprites)
      for (VehicleSnapshot v : snapshot.vehicles()) {
        int x = ox + (int) v.x();
        int y = oy + (int) v.y();

        Image img = sprites.get(v.spriteId());
        if (img != null) {
          g2.drawImage(img, x, y, 60, 60, this);
        }
      }
    } finally {
      g2.dispose();
    }
  }
}
