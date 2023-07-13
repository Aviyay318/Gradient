import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Panel extends JPanel {

    private GradientPaint gradientPaint;
    private Rectangle rectangle;
    private int red;
    private int green;
    private int blue;
    private int maxR;
    private int maxG;
    private BufferedImage bufferedImage;
    private MouseListener mouseListener;
    public Panel(){
        Random random = new Random();
        this.red = random.nextInt(0,136);
        this.green = random.nextInt(0,136);
        this.maxR = this.red+120;
        this.maxG = this.green+120;
        this.bufferedImage = createImage();
        this.setBounds(0,0,256,256);
        this.addMouseListener();
        this.setFocusable(true);
        this.requestFocus(true);
        this.addMouseListener(this.mouseListener);
//        this.gradientPaint = new GradientPaint(0,0,Color.black,256,256,Color.yellow);
//        this.rectangle = new Rectangle(256,256);
//        this.rectangle.setLocation(0,0);
        this.setVisible(true);
    }

    private void addMouseListener() {
        this.mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Random random = new Random();
                red = random.nextInt(0, 136);
                green = random.nextInt(0, 136);
                maxR = red+120;
                maxG = green+120;
                bufferedImage = createImage();
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }

    private BufferedImage createImage() {
        BufferedImage gradient = new BufferedImage(256,256,BufferedImage.TYPE_INT_BGR);
        Color color ;
        for (int i=0;i<255;i++){
            for (int j=0;j<255;j++){
                this.blue = (this.red+this.green)/2;
                color = new Color(this.red,this.green,this.blue);
                gradient.setRGB(i,j, color.getRGB());
                if (this.red<this.maxR){
                    this.red++;
                }else {
                    // this.red=this.maxR-120;
                }
            }
            this.red=this.maxR-120;

            if (this.green<this.maxG){
                this.green++;
            }

        }
        return gradient;
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(this.bufferedImage,0,0,256,256,null);
    }
}
