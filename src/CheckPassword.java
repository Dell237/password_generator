import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckPassword extends JPanel implements ActionListener {

    JLabel  enterPassword = new JLabel("Enter your password:  ");
    JTextField txtEnterPassword = new JTextField();
    JButton btn = new JButton("check now");
    JLabel txtReturn = new JLabel();

    public CheckPassword() {
        setLayout(new GridBagLayout());
        setBorder(new CompoundBorder(new TitledBorder("check you password"), new EmptyBorder(8, 0, 0, 0)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(enterPassword, gbc);

        gbc.gridx++;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtEnterPassword, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.insets = new Insets(8, 0, 0, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        btn.addActionListener(this);
        add(btn, gbc);


        gbc.gridy++;
        gbc.fill = GridBagConstraints.CENTER;
        add(txtReturn, gbc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            if (txtEnterPassword.getText().length() <= 0){
                txtReturn.setText("Please enter you password");
            } else {
                String length = txtEnterPassword.getText();
                final Password password = new Password(length);
                txtReturn.setText(password.calculateScore());
            }
        }
    }
}
