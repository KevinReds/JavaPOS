
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.management.MBeanAttributeInfo;

public class Principal extends JFrame implements ActionListener {

    private JMenuBar mb;
    private JMenu menuOpciones, menuCalcular, menuAcercaDe, menuColorFondo;
    private JMenuItem miCalculo, miRojo, miNegro, miMorado, miElCreador, miSalir, miNuevo;
    private JLabel labelLogo, labelBienvenido, labelTitle, labelNombre, labelAPaterno, labelAMaterno, labelDepartamento, labelAntiguedad, labelResultado, labelFooter;
    private JTextField txtNombreTrabajador, txtAPaternoTrabajador, txtAMaternoTrabajador;
    private JComboBox comboDepartamento, comboAntiguedad;
    private JScrollPane scrollpane1;
    private JTextArea textArea1;

    public Principal() {
        setLayout(null);
        setTitle("Pantalla Principal");
        getContentPane().setBackground(new Color(255, 0, 0));
        setIconImage(new ImageIcon(getClass().getResource("imagenes/icon.jpg")).getImage());
    }
    mb  = new JMenuBar();

    mb.setBackground (

    new Color(255,0,0));
    setJMenubar(mb);

    menuOpciones  = new JMenu("Opciones");

    menuOpciones.setBackground (

    new Color(255, 0, 0));
    menuOpciones.setFont (

    new Font("Andale Mono", 1, 14));
    menuOpciones.setForeground (

    new Color (255, 255, 255));
    mb.add (menuOpciones);

    menuCalcular  = new JMenu("Calcular");

    menuCalcular.setBackground (

    new Color(255, 0, 0));
    menuCalcular.setFont (

    new Font("Andale Mono", 1, 14));
    menuCalcular.setForeground (

    new Color (255, 255, 255));
    mb.add (menuCalcular);

    menuAcercaDe  = new JMenu("Acerca De");

    menuAcercaDe.setBackground (

    new Color(255, 0, 0));
    menuAcercaDe.setFont (

    new Font("Andale Mono", 1, 14));
    menuAcercaDe.setForeground (

    new Color (255, 255, 255));
    mb.add (menuAcercaDe);

    menuColorFondo  = new JMenu("Color de Fondo");

    menuColorFondo.setBackground (

    new Color(255, 0, 0));
    menuColorFondo.setFont (

    new Font("Andale Mono", 1, 14));
    menuColorFondo.setForeground (

    new Color (255, 255, 255));
    mb.add (menuColorFondo);

    miCalculo  = new JMenuItem("Vacaciones");

    miCalculo.setFont (

    new Font("Andale Mono", 1, 14));
    miCalculo.setForeground (

    new Color(255, 0, 0));
    menuCalcular.add (miCalculo);

    miCalculo.addActionListener (

this);
}
