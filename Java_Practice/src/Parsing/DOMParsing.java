package Parsing;

import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;


public class DOMParsing {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		List<Person> personList = DOMParser.parsePerson();
        for(Person p:personList) {
			System.out.println(p);
		}
	}
}
