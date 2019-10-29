
package prjgrupo1;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.io.File;
import java.util.Set;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        panelTraductor.setBorder(new EmptyBorder(8, 8, 8, 8));
        panelTraductor.setLayout(new BorderLayout(8,8));
        
        // Panel Central
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        
        // PanelEste
        JPanel panelEste = new JPanel();
        panelEste.setBorder(new EmptyBorder(8, 8, 8, 8));
        panelEste.setLayout(new BoxLayout(panelEste, BoxLayout.Y_AXIS));
        
        // La parte central del layout
        JLabel lblOrigen = new JLabel("Archivo de origen:");
        JTextField txtOrigen = new JTextField("ArchivoOrigen", 25);
        JLabel lblDestino = new JLabel("Archivo de destino:");
        JTextField txtDestino = new JTextField("ArchivoDestino", 25);
        String[] datos = {".txt", ".dat", ".obj", ".raf", ".xml"};
        JComboBox cbFormatoOrigen = new JComboBox(datos);
        JComboBox cbFormatoDestino = new JComboBox(datos);
        JButton btnOrigen = new JButton(" ...  ");
        JButton btnDestino = new JButton(" ... ");
        JButton btnTraducir = new JButton(" Traducir ");
        
        txtOrigen.setSize(16, 25);
        txtDestino.setSize(16, 25);
        
        
        panelTraductor.add(panelCentral, BorderLayout.CENTER);
        panelCentral.add(lblOrigen);
        panelCentral.add(txtOrigen);
        panelCentral.add(cbFormatoOrigen);
        panelCentral.add(lblDestino);
        panelCentral.add(txtDestino);
        panelCentral.add(cbFormatoDestino);
        
        // La parte este del layout
        panelTraductor.add(panelEste, BorderLayout.EAST);
        panelEste.add(btnOrigen);
        panelEste.add(Box.createRigidArea(new Dimension(0,30)));
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
    
    /*
    public void elegirArchivo()
    {
        //Creamos un objeto JFileChooser
        JFileChooser fcElegirArchivo = new JFileChooser();
        fcElegirArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        //Indica cual el la acción del usuario sobre el jfilechooser
        fcElegirArchivo.showOpenDialog(this, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
        //Obtiene el archivo seleccionado
        File archivo = fcElegirArchivo.getSelectedFile();
        
        //Muestra error si es inválido
        if((archivo == null) || (archivo.getName().equals(""))){
            
        }
        jlArchivo.setText(archivo.getAbsolutePath());
        Scanner sc = new Scanner(archivo);
        while(sc.hasNext()){
            jtaContenido.insert(sc.nextLine() + "\n", jtaContenido.getText().length());
        }
    }
    */

}
