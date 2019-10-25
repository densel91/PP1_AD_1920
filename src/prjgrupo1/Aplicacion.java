
package prjgrupo1;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.util.Set;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author PPJ_G1
 */
public class Aplicacion extends JFrame{
 
    private JTabbedPane pestanas;
    
    public Aplicacion()
    {
        super("Traductor");
        crearPestanas();
        opcionesVentana();
    }
    
    public void crearPestanas()
    {
        pestanas = new JTabbedPane(); // Creamos un conjunto de pestanas 
        crearPestanaTraductor();
        crearPestanaResultado();
        crearPestanaConsultas();
        add(pestanas);
        
    }
    
    public void crearPestanaTraductor(){
        JPanel panelTraductor = new JPanel();
        panelTraductor.setBorder(new EmptyBorder(6, 6, 6, 6));
        panelTraductor.setLayout(new BorderLayout(6, 6));
        
        // Panel Central
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        
        // PanelEste
        JPanel panelEste = new JPanel();
        panelEste.setBorder(new EmptyBorder(6, 0, 0, 6));
        panelEste.setLayout(new BoxLayout(panelEste, BoxLayout.Y_AXIS));
        
        // La parte central del layout
        JTextField txtOrigen = new JTextField("ArchivoOrigen", 25);
        JTextField txtDestino = new JTextField("ArchivoDestino", 25);
        String[] datos = {".txt", ".dat", ".obj", ".raf", ".xml"};
        JComboBox cbFormatoOrigen = new JComboBox(datos);
        JComboBox cbFormatoDestino = new JComboBox(datos);
        JButton btnOrigen=new JButton(" Origen  ");
        JButton btnDestino=new JButton(" Destino ");
        JButton btnTraducir=new JButton(" Traducir ");
        
        panelTraductor.add(panelCentral, BorderLayout.CENTER);
        panelCentral.add(txtOrigen);
        panelCentral.add(cbFormatoOrigen);
        panelCentral.add(txtDestino);
        panelCentral.add(cbFormatoDestino);
        
        // La parte este del layout
        panelTraductor.add(panelEste, BorderLayout.EAST);
        panelEste.add(btnOrigen);
        panelEste.add(Box.createRigidArea(new Dimension(0,15)));
        panelEste.add(btnDestino);
        
        // Panel sur --------------------------------------
        panelTraductor.add(btnTraducir, BorderLayout.SOUTH);
        pestanas.addTab("Traducir", panelTraductor);
    }
    
    public void crearPestanaResultado(){
        JPanel panelResultado = new JPanel();
        pestanas.addTab("Resultado", panelResultado);
    }
    
    public void crearPestanaConsultas(){
        JPanel panelConsultas = new JPanel();
        pestanas.addTab("Consultas", panelConsultas);
    }
    
    public void opcionesVentana()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

}
