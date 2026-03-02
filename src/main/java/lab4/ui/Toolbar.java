package lab4.ui;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import static java.awt.FlowLayout.LEFT;

public class Toolbar extends JPanel {

  private static final String TITLE = "Toolbar";

  private final Border border = BorderFactory.createTitledBorder(TITLE);
  private final LayoutManager layout = new FlowLayout(LEFT, 8, 0);
  private final JButton btnStart = new JButton("Start");
  private final JButton btnStop = new JButton("Stop");
  private final JButton btnAction = new JButton("Action");
  private final JButton btnTurnLeft = new JButton("Turn left");
  private final JButton btnTurnRight = new JButton("Turn right");
  private final JButton addVolvo240 = new JButton("Add Volvo240");
  private final JButton addSaab95 = new JButton("Add Saab95");
  private final JButton addScania = new JButton("Add Scania");
  private final JButton addVolvoFH16 = new JButton("Add VolvoFH16");

  public Toolbar() {
    super();

    setLayout(layout);
    setBorder(border);

    add(btnStart);
    add(btnStop);
    add(btnAction);
    add(btnTurnLeft);
    add(btnTurnRight);
    add(addVolvo240);
    add(addSaab95);
    add(addScania);
    add(addVolvoFH16);
  }

  public void setStartAction(Action a) { btnStart.setAction(a); }
  public void setStopAction(Action a) { btnStop.setAction(a); }
  public void setActionAction(Action a) { btnAction.setAction(a); }

  public void setTurnLeftAction(Action a) { btnTurnLeft.setAction(a); }
  public void setTurnRightAction(Action a) { btnTurnRight.setAction(a); }
  public void setAddVolvo240Action(Action a) { addVolvo240.setAction(a); }

  public void setAddSaab95Action(Action a) { addSaab95.setAction(a); }
  public void setAddScaniaAction(Action a) { addScania.setAction(a); }
  public void setAddVolvoFH16Action(Action a) { addVolvoFH16.setAction(a); }
}
