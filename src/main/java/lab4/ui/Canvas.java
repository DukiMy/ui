/*
 * File: DrawPanel.java
 */

package lab4.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

public final class Canvas extends JComponent {

  private final String title = "Canvas";
  private final Dimension dim = new Dimension(700, 400);
  private final Border border = BorderFactory.createTitledBorder(title);

  public Canvas() {
    super();

    setPreferredSize(dim);
    setBorder(border);

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g.create();
    try {
      Insets in = getInsets();

      int x0 = in.left;
      int y0 = in.top;

      g2.setColor(new Color(0, 255, 0));
      g2.fillRect(x0, y0, 100, 50);

      g2.setColor(Color.BLACK);
      g2.drawString("Hello", x0 + 10, y0 + 20);
    } finally {
      g2.dispose();
    }
  }
}
