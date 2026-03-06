/**
 * Frame.java
 */

package lab4.ui;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;

public final class Frame extends JFrame {

  private static final String TITLE = "LAB4";
  public Frame(JComponent toolbar, JComponent canvas) {
    super(TITLE);
    setContentPane(new RootContainer(toolbar, canvas));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setTheme();
  }

  private void setTheme() {
    FlatGradiantoMidnightBlueIJTheme.setup();
    SwingUtilities.updateComponentTreeUI(this);
  }
}
