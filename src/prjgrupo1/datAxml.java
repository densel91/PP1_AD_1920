/*
 * Esta clase se dedica a pasar de archivos .dat a archivos .xml
 */
package prjgrupo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Lara Paños
 */
public class datAxml {
    public static void main(String args[]) throws FileNotFoundException{
        // Abrimos fichero de Empleados creado con ObjectOutputStream
        File fichero = new File("Producto.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int tamanoRegistro = 36;
        int id, grupo, posicion = 0; //para situarnos al principio del fichero        
        Double precio;
        char nombre[] = new char[10], aux;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Productos", null);
            document.setXmlVersion("1.0");

            for (;;) {
                file.seek(posicion); //nos posicionamos 
                id = file.readInt();   // obtengo id de empleado	  	  
                for (int i = 0; i < nombre.length; i++) {
                    aux = file.readChar();
                    nombre[i] = aux;
                }
                String nombres = new String(nombre);
                grupo = file.readInt();
                precio = file.readDouble();

                if (id > 0) { //id validos a partir de 1
                    Element raiz = document.createElement("producto"); //nodo empleado
                    document.getDocumentElement().appendChild(raiz);
                    //anadir ID                       
                    CrearElemento("id", Integer.toString(id), raiz, document);
                    //Anadir nombre
                    CrearElemento("apellido", nombres.trim(), raiz, document);
                    //anadir grupo
                    CrearElemento("dep", Integer.toString(grupo), raiz, document);
                    //anadir precio
                    CrearElemento("salario", Double.toString(precio), raiz, document);
                }
                
                posicion = posicion + tamanoRegistro; // me posiciono para el sig empleado	  	  
                if (file.getFilePointer() == file.length()) {
                    break;
                }

            }//fin del for que recorre el fichero

            // Almacenamos 
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Productos.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

            file.close();  //cerrar fichero
        
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
 	
    }//fin de main
    
    //Insercion de los datos del empleado
    static void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmple);
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor		 	
    }
}//fin de la clase