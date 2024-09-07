import javax.swing.*;
import java.awt.*;

public class WelcomeMsg extends JPanel {


     JLabel welcomeMsg = new JLabel("Hello, welcome to the Password Generator :)");

    public WelcomeMsg() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        add(welcomeMsg, gbc);
    }




}
