/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prjgrupo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Vespertino
 */
public class Formulario extends JFrame{
 
    private JTabbedPane pestanas;
    private JPanel panelTraductor, panelResultado, panelConsultas;
    private JButton btnOrigen, btnDestino, btnTraducir;
    private JTextField jtOrigen, jtDestino;
 
    public Formulario()
    {
        //super("Traductor");
        inicializarComponenetes();
        crearPestanas();
        opcionesVentana();
    }
    
    public void inicializarComponenetes(){
        pestanas = new JTabbedPane();
        panelTraductor = new JPanel();
        btnOrigen=new JButton("Origen");
        btnDestino=new JButton("Destino");
        btnTraducir=new JButton("Traducir");
        panelResultado = new JPanel();
        panelConsultas = new JPanel();
        jtOrigen = new JTextField();
        jtDestino = new JTextField();
        crearPestanas();
    }
    
    public void crearPestanas()
    {
        //pestanas = new JTabbedPane(); // Creamos un conjunto de pestanas 
        crearPestanaTraductor();
        crearPestanaResultado();
        crearPestanaConsultas();
        add(pestanas);
        
    }
    
    public void crearPestanaTraductor(){
        /*JPanel panelTraductor = new JPanel();
        JButton btnOrigen=new JButton("Origen");
        JButton btnDestino=new JButton("Destino");
        JButton btnTraducir=new JButton("Traducir");*/
        panelTraductor.add(btnOrigen, panelTraductor);
        panelTraductor.add(btnDestino, panelTraductor);
        panelTraductor.add(btnTraducir, panelTraductor);
        
        pestanas.addTab("Traducir", panelTraductor);
        
    }
    
    public void crearPestanaResultado(){
        //JPanel panelResultado = new JPanel();
        pestanas.addTab("Resultado", panelResultado);
    }
    
    public void crearPestanaConsultas(){
        //JPanel panelConsultas = new JPanel();
        pestanas.addTab("Consultas", panelConsultas);
    }
    
    public void opcionesVentana()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public void clickEnBotonOrigen(ActionEvent e){
          if (e.getSource() == btnOrigen) {
       
        } else  {
             System.exit(0);
        }
    }
    
    public void clickEnBotonDestino(ActionEvent e){
          if (e.getSource() == btnDestino) {
       
        } else  {
             System.exit(0);
        }
    }
    
    public void clickEnBotonTraducir(ActionEvent e){
          if (e.getSource() == btnTraducir) {
       
        } else  {
             System.exit(0);
        }
    }
    
    public void eventos(){
        btnOrigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //clickEnBotonOrigen(e);
            }
        });
        btnDestino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //clickEnBotonDestino(e);
            }
        });
        
        btnTraducir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //clickEnBotonTraducir(e);
            }
        });
    }
               
}
