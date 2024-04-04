package demo;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PrimeNumberView extends JFrame {
    private final JTextField numberTextField;
    private final JButton findButton;
    private final JList<Integer> primeNumberList;
    
    public PrimeNumberView() {
        super("Find Prime Numbers");
        setLayout(new BorderLayout());
        
        numberTextField = new JTextField(10);
        findButton = new JButton("Find");
        primeNumberList = new JList<>();
        
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Number of prime numbers to find: "));
        topPanel.add(numberTextField);
        topPanel.add(findButton);
        
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(primeNumberList), BorderLayout.CENTER);
        
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public int getNumber() {
        return Integer.parseInt(numberTextField.getText());
    }
    
    public void setPrimeNumbers(List<Integer> primeNumbers) {
        primeNumberList.setListData(primeNumbers.toArray(new Integer[primeNumbers.size()]));
    }
    
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void addFindListener(ActionListener listener) {
        findButton.addActionListener(listener);
    }
}
