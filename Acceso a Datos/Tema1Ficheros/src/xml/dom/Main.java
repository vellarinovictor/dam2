package xml.dom;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.nio.file.Path;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {
		leer();
	}
	
	

	private static void leer() {
		Path path = Path.of("ficheros/ms.xml");
		File xml=  path.toFile();
		DocumentBuilder builder = createBuilder();
		Document document = null;
		try {
			document = builder.parse(xml);
		} catch (SAXException e) {
			System.err.println("Error al crear el Document");
			System.err.println(e.getMessage());
			System.exit(-2);
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
		//PASO 4 : Leer el xml, el especifico del fichero a tratar
		NodeList listaInicial = document.getElementsByTagName("Tests").item(0).getChildNodes();
		//PASO 5 : Procesar nodo a nodo en funcion deque nodo este procesando
		switchNodos(listaInicial);
	}



	private static void switchNodos(NodeList lista) {
		for (int i = 0; i < lista.getLength(); i++) {
			Node node = lista.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				switch (node.getNodeName()) {
				case "Test":
					String id = node.getAttributes().getNamedItem("TestId").getNodeValue();
					String type = node.getAttributes().getNamedItem("TestType").getNodeValue();
					System.out.printf("%s\t-\t%s\n",node.getNodeName(),node.getNodeType());
					NodeList listaHijos = node.getChildNodes();
					switchNodos(listaHijos);
					
					break;

				default:
					System.out.println("\t"+node.getNodeName()+" --> "+node.getTextContent());
				break;
				}
				
			}
		} 
	}



	private static DocumentBuilder createBuilder() {
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.err.println("Error al crear el DocumentBuilderFactory");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		return builder;
	}

}
