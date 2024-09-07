import javax.swing.*;
import java.awt.*;

public class GeneratorGui extends JPanel {

    final WelcomeMsg welcomeMsg;
    final GeneratePassword generatePassword;
    final CheckPassword checkPassword;

    GeneratorGui () {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.33;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(4, 4, 4, 4);

        add((welcomeMsg = new WelcomeMsg()), gbc);
        gbc.gridy++;
        add((generatePassword = new GeneratePassword()), gbc);
        gbc.gridy++;
        add((checkPassword = new CheckPassword()), gbc);

    }

}
