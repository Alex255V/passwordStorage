import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 12.01.2017.
 * Create to save passwords
 */
public class PasswordStorage extends JPanel implements ActionListener {
    private static final String OK = "ok";
    private JFrame controllingFrame;
    private JPasswordField passwordField;

    private PasswordStorage(JFrame f) {
        controllingFrame = f;

        f.setSize(300,90);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        passwordField = new JPasswordField(25);
        passwordField.setEchoChar('*');
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this);
        JComponent buttonPane = createButtonPanel();
        setBackground(new Color(56,15,41));
        add(passwordField);
        add(buttonPane);
    }

    private JComponent createButtonPanel() {
        JPanel p = new JPanel(new GridLayout(0,1));
        JButton confirm = new JButton();
        confirm.setText("confirm");
        confirm.setActionCommand(OK);
        confirm.setBounds(60,40,75,90);
        confirm.addActionListener(this);
        confirm.setBackground(new Color(0,0,255));
        p.add(confirm);
        return p;
    }

    public void  actionPerformed (ActionEvent ae) {
        String cmd = ae.getActionCommand();

    }

    public static void main(String [] args) {

    }
}
