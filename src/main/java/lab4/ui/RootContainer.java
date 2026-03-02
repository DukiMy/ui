package lab4.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;

public final class RootContainer extends JComponent {

  private static final int B_SIZE = 8;
  private final LayoutManager layout = new BorderLayout(B_SIZE, B_SIZE);
  private final Border border = BorderFactory.createEmptyBorder(B_SIZE, B_SIZE, B_SIZE, B_SIZE);

  public RootContainer(Component top, Component center) {
    super();

    setLayout(layout);
    setDoubleBuffered(true);
    setBorder(border);

    add(top, NORTH);
    add(center, CENTER);
  }

  public RootContainer(Component top, Component center, Component bottom) {
    this(top, center);

    add(bottom, SOUTH);
  }
}
