package Parsing;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
	//	Simple API for XML Parser의 약어로, 자바 API에서 제공한다.
	//
	//	기본적으로 SAX 파서는 문서를 순회하며 event가 발생하면서 순차적으로 파싱을 하게 된다.
	//
	//	SAX는 XML 문서를 읽어들여서 어떤 태그를 만나면 그에 따라 이벤트를 생성한다.
	//
	//	SAX에는 기본적으로 세가지 이벤트가 발생하고, 각각의 메소드는 아래와 같다.
	//
	//	startElement() : 태그를 처음 만나면, 발생하는 이벤트
	//
	//	endElement() : 닫힌 태그를 만나면 발생하는 이벤트
	//
	//	characters() : 태그와 태그 사이의 text(내용)을 처리하기 위한 이벤트
	//파싱한 사람객체를 넣을 리스트
		private List<Person> personList;
		//파싱한 사람 객체
		private Person person;
		//character 메소드에서 저장할 문자열 변수
		private String str;
		
		public SaxHandler() {
			personList = new ArrayList<>();
		}
		
		public void startElement(String uri, String localName, String name, Attributes att) {
			//시작 태그를 만났을 때 발생하는 이벤트
			if(name.equals("person")) {
				person = new Person();
				personList.add(person);
			}
		}
		public void endElement(String uri, String localName, String name) {
			//끝 태그를 만났을 때,
			if(name.equals("name")) {
				person.setName(str);
			}else if(name.equals("gender")) {
				person.setGender(str);
			}else if(name.equals("job")) {
				person.setJob(str);
			}
		}
		public void characters(char[] ch, int start, int length) {
			//태그와 태그 사이의 내용을 처리
			str = new String(ch,start,length);
		}
	    public List<Person> getPersonList(){
			return personList;
		}
		public void setPersonList(List<Person> personList) {
			this.personList=personList;
		}
	
}
