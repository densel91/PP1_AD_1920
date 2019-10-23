/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjgrupo1;

import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author Vespertino
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
        
        JTextArea txtOrigen = new JTextArea();
        JTextArea txtDestino = new JTextArea();
        
        JButton btnOrigen=new JButton("Origen");
        JButton btnDestino=new JButton("Destino");
        JButton btnTraducir=new JButton("Traducir");
        
        
        panelTraductor.add(btnOrigen, panelTraductor);
        panelTraductor.add(btnDestino, panelTraductor);
        panelTraductor.add(btnTraducir, panelTraductor);
        
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
