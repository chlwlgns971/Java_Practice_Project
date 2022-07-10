package Parsing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DOMParser {
	public static List<Person> parsePerson() throws ParserConfigurationException, SAXException, IOException
	   {
	      //Person객체 정보를 담을 리스트 생성
	      List<Person> personList = new ArrayList<Person>();
	      Person person=null;
	       
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      Document document = builder.parse(new File("src/Parsing/ParsingTest.xml"));
	      document.getDocumentElement().normalize();
	      NodeList nList = document.getElementsByTagName("person");
	      for (int temp = 0; temp < nList.getLength(); temp++)
	      {
	         Node node = nList.item(temp);
	         if (node.getNodeType() == Node.ELEMENT_NODE)
	         {
	            Element eElement = (Element) node;
	            //Create new Employee Object
	            person = new Person();
	            person.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
	            person.setGender(eElement.getElementsByTagName("gender").item(0).getTextContent());
	            person.setJob(eElement.getElementsByTagName("job").item(0).getTextContent());
	             
	            //Add Employee to list
	            personList.add(person);
	         }
	      }
	      return personList;
	   }
}
