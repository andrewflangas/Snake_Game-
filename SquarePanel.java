import java.awt.Color;
import javax.swing.JPanel;

public class SquarePanel extends JPanel {

    // Unique identifier for this class (not used in this example)
    private static final long serialVersionUID = 1L;

    // Constructor for SquarePanel, takes a Color parameter
    public SquarePanel(Color d) {

        // Set the background color of the JPanel to the Color passed in as a parameter
        this.setBackground(d);
    }

    // Method for changing the background color of the JPanel, takes a Color parameter
    public void ChangeColor(Color d) {

        // Set the background color of the JPanel to the Color passed in as a parameter
        this.setBackground(d);

        // Repaint the JPanel to reflect the new background color
        this.repaint();
    }
}