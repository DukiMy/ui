package lab4.ui;

import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import java.awt.Container;

public final class Frame extends JFrame {

  private static final String title = "LAB4";
  private Container container;
  private JComponent canvas;
  private JComponent toolbar;
  private JComponent log;

  private Frame() {
    // super();
    setTitle(title);

    toolbar = new Toolbar();
    canvas = new Canvas();

  }

  public Frame(String[] debugArg) {
    this();

    if (debugArg.length > 0) {
      log = new LogPanel();
      container = new RootContainer(toolbar, canvas, log);
    } else {
      container = new RootContainer(toolbar, canvas);
    }

    SwingUtilities.invokeLater(() -> {
      setContentPane(container);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);
      setVisible(true);
    });
  }

  public JComponent getToolbar() { return toolbar; }
  public JComponent getCanvas() { return canvas; }
  public JComponent getLog() { return log; }
}
