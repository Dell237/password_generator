import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public  Main() {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                JFrame frame = new JFrame("Password services");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.add( new GeneratorGui());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setSize(420,420);
                frame.setVisible(true);
            }
        });
    }

}