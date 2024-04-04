package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.SwingUtilities;

public class PrimeNumberController {
    private final PrimeNumberView view;
    private final PrimeNumberModel model;
    
    public PrimeNumberController(PrimeNumberView view, PrimeNumberModel model) {
        this.view = view;
        this.model = model;
        
        view.addFindListener(new FindListener());
    }
    
    class FindListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int n = view.getNumber();
                List<Integer> primeNumbers = model.getPrimeNumbers(n);
                view.setPrimeNumbers(primeNumbers);
            } catch (NumberFormatException ex) {
                view.showError("Invalid input!");
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PrimeNumberModel model = new PrimeNumberModel();
            PrimeNumberView view = new PrimeNumberView();
            PrimeNumberController controller = new PrimeNumberController(view, model);
            view.setVisible(true);
        });
    }
}

