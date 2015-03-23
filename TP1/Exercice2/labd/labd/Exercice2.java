package labd;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Exercice2 extends 	LABDHandler {
	
	/**
	 * Evenement recu a chaque fois que l'analyseur rencontre une balise xml ouvrante.
	 * @param nameSpaceURI l'url de l'espace de nommage.
	 * @param localName le nom local de la balise.
	 * @param rawName nom de la balise en version 1.0 <code>nameSpaceURI + ":" + localName</code>
	 * @throws SAXException si la balise ne correspond pas a ce qui est attendu,
	 * comme par exemple non respect d'une dtd.
	 * @see org.xml.sax.ContentHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	public void startElement(String nameSpaceURI, String localName, String rawName, Attributes attributs) throws SAXException {
		int i= 1;
		int sum= 0;
		System.out.println("Maison"+ i+":") ;
		if (attributs.getLength() != 0) {
		for (int index = 0; index < attributs.getLength(); index++) { // on parcourt la liste des attributs
			if(attributs.getLocalName(index).equals("surface-m2"))
			sum = sum + Integer.parseInt(attributs.getValue(index));
		}
		}
		System.out.println("superficie totale :"+ sum);
		i=i+1;
	}
	
	
	public static void main(String[] args) {
		try {
			XMLReader saxReader = XMLReaderFactory.createXMLReader();
			saxReader.setContentHandler(new LABDHandler());
			saxReader.parse(args[0]);
		} catch (Exception t) {
			t.printStackTrace();
		}
	}
	
}