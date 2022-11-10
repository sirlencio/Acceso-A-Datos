import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

public class ejercicio5 {
    public static ArrayList<Element> array = new ArrayList<>();

    //Crea una aplicación que sea capaz de importar un fichero XML con información de un catálogo de películas
    // (título, fecha, genero, sinopsis y actores principales).
    // Diseña la GUI para que se pueda visualizar toda la información de cada una de las películas importadas

    public static void main(String[] args) {
        JFrame frame = new JFrame("Peliculas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public static void almacenarXML(File f) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(f);
            document.getDocumentElement().normalize();

            System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());
            //crea una lista con todos los nodos empleado
            NodeList peliculas = document.getElementsByTagName("Pelicula");
            System.out.printf("Nodos pelicula a recorrer: %d %n", peliculas.getLength());

            array.clear();
            //recorrer la lista
            for (int i = 0; i < peliculas.getLength(); i++) {
                Node prod = peliculas.item(i); //obtener un nodo producto
                if (prod.getNodeType() == Node.ELEMENT_NODE) {//tipo de nodo
                    //obtener los elementos del nodo
                    Element elemento = (Element) prod;
                    array.add(elemento);
                    MyPanel.cmbox.addItem(elemento.getElementsByTagName("Titulo").item(0).getTextContent());
                    /*System.out.printf("Titulo: %s %n", elemento.getElementsByTagName("Titulo").item(0).getTextContent());
                    System.out.printf(" * Fecha: %s %n", elemento.getElementsByTagName("Fecha").item(0).getTextContent());
                    System.out.printf(" * Director: %s %n", elemento.getElementsByTagName("Director").item(0).getTextContent());
                    System.out.printf(" * Actores: %s %n", elemento.getElementsByTagName("Actores").item(0).getTextContent());*/
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void actualiza(){
        Element ele = array.get(MyPanel.cmbox.getSelectedIndex());
        MyPanel.txtTitulo.setText(ele.getElementsByTagName("Titulo").item(0).getTextContent());
        MyPanel.txtFecha.setText(ele.getElementsByTagName("Fecha").item(0).getTextContent());
        MyPanel.txtGenero.setText(ele.getElementsByTagName("Genero").item(0).getTextContent());
        MyPanel.txtSinopsis.setText(ele.getElementsByTagName("Actores").item(0).getTextContent());
    }
}

class MyPanel extends JPanel {
    private JButton btn;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JLabel jcomp4;
    private JLabel jcomp5;
    public static JTextArea txtSinopsis;
    public static JTextField txtTitulo;
    public static JTextField txtFecha;
    public static JTextField txtGenero;
    public static JComboBox cmbox;

    public MyPanel() {
        //construct preComponents
        String[] cmboxItems = {};

        //construct components
        btn = new JButton("Importar");
        jcomp2 = new JLabel("Titulo:");
        jcomp3 = new JLabel("Fecha: ");
        jcomp4 = new JLabel("Genero: ");
        jcomp5 = new JLabel("Actores: ");
        txtSinopsis = new JTextArea(5, 5);
        txtTitulo = new JTextField(5);
        txtFecha = new JTextField(5);
        txtGenero = new JTextField(5);
        cmbox = new JComboBox (cmboxItems);

        btn.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File f = chooser.getSelectedFile();
                ejercicio5.almacenarXML(f);
            }
        });
        cmbox.addActionListener(e ->{
            ejercicio5.actualiza();
        });
        //adjust size and set layout
        setPreferredSize(new Dimension(510, 366));
        setLayout(null);

        //add components
        add(btn);
        add(jcomp2);
        add(jcomp3);
        add(jcomp4);
        add(jcomp5);
        add(txtSinopsis);
        add(txtTitulo);
        add(txtFecha);
        add(txtGenero);
        add(cmbox);

        //set component bounds (only needed by Absolute Positioning)
        btn.setBounds(200, 300, 100, 20);
        jcomp2.setBounds(60, 35, 100, 25);
        jcomp3.setBounds(55, 85, 100, 25);
        jcomp4.setBounds(50, 130, 100, 25);
        jcomp5.setBounds(40, 175, 100, 25);
        txtSinopsis.setBounds(100, 180, 200, 75);
        txtTitulo.setBounds(100, 35, 200, 25);
        txtFecha.setBounds(100, 85, 100, 25);
        txtGenero.setBounds(100, 133, 150, 25);
        cmbox.setBounds (345, 85, 150, 25);

    }
}