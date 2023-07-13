import javax.swing.*;

public class Window extends JFrame {

    public Window(){
        this.setSize(256,256);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.add(new Panel());
        this.setVisible(true);
    }
}
