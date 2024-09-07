import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratePassword extends JPanel implements ActionListener {

    JRadioButton useLower  = new JRadioButton("abcd...");
    JRadioButton useUpper  = new JRadioButton("ABCD...");
    JRadioButton useNum  = new JRadioButton("1234...");
    JRadioButton useSym  = new JRadioButton("!@#$...");
     JButton btn =  new JButton("Generate password");
     JTextField txtNumberOfChars = new JTextField("12", 10);
    JTextField passwordTxt = new JTextField(10);
    JLabel txtReturn = new JLabel();
    JLabel numOfChar = new JLabel("Enter number of characters :");


    GeneratePassword() {

        setLayout(new GridBagLayout());
        setBorder(new CompoundBorder(new TitledBorder("Generate password with"), new EmptyBorder(8, 0, 0, 0)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(8, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;

        add(numOfChar, gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNumberOfChars, gbc);


        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(useUpper, gbc);
        gbc.gridx++;
        panel.add(useLower, gbc);
        gbc.gridx++;
        panel.add(useNum, gbc);
        gbc.gridx++;
        panel.add(useSym, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(panel, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        btn.addActionListener(this);
        add(btn , gbc);


        gbc.gridy =12;
        gbc.fill= GridBagConstraints.HORIZONTAL;
        add(passwordTxt, gbc);

        gbc.gridy = 15;
        gbc.fill = GridBagConstraints.CENTER;
        add(txtReturn, gbc);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            boolean includeUpper = useUpper.isSelected();
            boolean includeLower  = useLower.isSelected();
            boolean includeNum  = useNum.isSelected();
            boolean includeSym   = useSym.isSelected();
            int length = Integer.parseInt(txtNumberOfChars.getText());
            if (!includeLower && !includeUpper && !includeNum && !includeSym) {
                passwordTxt.setText("");
                txtReturn.setVisible(true);
                txtReturn.setText("du muss mindestens ein Zeichen auswählen");
                txtReturn.setForeground(Color.RED);
                txtReturn.setFont(new Font("Serif", Font.BOLD, 14));
                return;
            }
            if (length > 30) {
                txtReturn.setText("!!!  max 30  !!!");
                passwordTxt.setText("");
                txtReturn.setVisible(true);
                txtReturn.setForeground(Color.RED);
                txtReturn.setFont(new Font("Serif", Font.BOLD, 16));
            } else {
                Generator generator = new Generator(includeUpper, includeLower, includeNum, includeSym);
                final Password password = generator.generatePassword(length);

                txtReturn.setVisible(false);
                passwordTxt.setText(password.toString());
            }

        }
    }
}
