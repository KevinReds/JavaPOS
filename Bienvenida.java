
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bienvenida extends JFrame implements ActionListener {

    private JTextField textfield1;
    private JLabel label1, label2, label3, label4;
    private JButton boton1;

    public Bienvenida() {
        setLayout(null);
        setTitle("Bienvenida");
        getContentPane().setBackground(new Color(64, 64, 64));
        setIconImage(new ImageIcon(getClass().getResource("imagenes/icon.jpg")).getImage());

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("imagenes/icon.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        label1 = new JLabel(scaledImageIcon);
        label1.setBounds(100, 15, 150, 150);
        add(label1);

        label2 = new JLabel("¡Facturar nunca ha sido tan facil!");
        label2.setBounds(30, 120, 320, 150);
        label2.setFont(new Font("Andale Mono", 3, 18));
        label2.setForeground(new Color(255, 255, 255));
        add(label2);

        label3 = new JLabel("Ingrese su nombre");
        label3.setBounds(45, 221, 200, 30);
        label3.setFont(new Font("Andale Mono", 1, 12));
        label3.setForeground(new Color(255, 255, 255));
        add(label3);

        label4 = new JLabel("@2024 mallie POS");
        label4.setBounds(85, 375, 300, 30);
        label4.setFont(new Font("Andale Mono", 1, 12));
        label4.setForeground(new Color(255, 255, 255));
        add(label4);

        textfield1 = new JTextField();
        textfield1.setBounds(45, 250, 255, 25);
        textfield1.setBackground(new Color(244, 244, 244));
        textfield1.setFont(new Font("Andale Mono", 1, 14));
        textfield1.setForeground(new Color(255, 0, 0));
        add(textfield1);

        boton1 = new JButton("Ingresar");
        boton1.setBounds(125, 280, 100, 30);
        boton1.setBackground(new Color(255, 255, 255));
        boton1.setFont(new Font("Andale Mono", 1, 14));
        boton1.setForeground(new Color(64, 64, 64));
        boton1.addActionListener(this);
        add(boton1);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            String nombre = textfield1.getText();
            JOptionPane.showMessageDialog(this, "Bienvenido, " + nombre + "!");
        }
    }

    public static void main(String args[]) {
        Bienvenida ventanaBienvenida = new Bienvenida();
        ventanaBienvenida.setBounds(0, 0, 350, 450);
        ventanaBienvenida.setResizable(false);
        ventanaBienvenida.setVisible(true);
        ventanaBienvenida.setLocationRelativeTo(null);
    }
}
