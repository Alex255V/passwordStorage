import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

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

        if (OK.equals(cmd)) { //Process the password.
            char[] input = passwordField.getPassword();
            if (isPasswordCorrect(input)) {
//                JOptionPane.showMessageDialog(controllingFrame,
//                        "Success! You typed the right password.");
                controllingFrame.dispose();
                menuPro.mp.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(controllingFrame,
                        "ERROR INPUT PASSWORD\n" + "try again",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
            Arrays.fill(input, '0');

            passwordField.selectAll();
            resetFocus();
        }

    }

    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect;
        char[] correctPassword = {'1', '2', '3', '4', '5'};

        isCorrect = input.length == correctPassword.length && Arrays.equals(input, correctPassword);

        //Zero out the password.
        Arrays.fill(correctPassword, '0');

        return isCorrect;
    }

    //Must be called from the event dispatch thread.
    private void resetFocus() { passwordField.requestFocusInWindow(); }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("initialization");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final PasswordStorage newContentPane = new PasswordStorage(frame);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        frame.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                newContentPane.resetFocus();
            }
        });
        frame.setVisible(true);
    }

    public static void main(String [] args) {
        SwingUtilities.invokeLater(() -> {
            //Turn off metal's use of bold fonts
            UIManager.put("swing.boldMetal", Boolean.FALSE);
            createAndShowGUI();
        });
    }
}

//---------------------------next window----------->menuPro-------------------------------------------------\\

class menuPro extends JFrame  {

    static menuPro mp = new menuPro();

    private static JButton addRecord;
    private static JButton rmRecord;
    private static JButton search;
    private static JTextField enterSearch;


}