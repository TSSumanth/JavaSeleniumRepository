package BasicTests;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadDataFromXML {
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		
	
		File xmlfile = new File("automationconfig.xml");
		DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbfact.newDocumentBuilder();
		Document doc = db.parse(xmlfile);
		
		//Read Root Element - in our case root element is Configuration
		System.out.println("Root Element:  "+ doc.getDocumentElement().getNodeName()); //Configuration
		
		//Get child node
		NodeList nodes = doc.getElementsByTagName("EnvironmentDetails");
		System.out.println(nodes.getLength());
		System.out.println(nodes.item(0).getNodeName()); //EnvironmentDetails
		System.out.println(nodes.item(0).getNodeValue()); //null
		
		Element ele= (Element) nodes.item(0);
		NodeList ApplicationURLNode =  ele.getElementsByTagName("ApplicationURL");
		if(ApplicationURLNode.getLength() == 1)
		{
			String ApplicationURL = ApplicationURLNode.item(0).getTextContent();
			System.out.println(ApplicationURL); //"WWW.google.com"
		}
		
		NodeList RestURLnode =  ele.getElementsByTagName("RestURL");
		if(RestURLnode.getLength() == 1)
		{
			String RestURL = RestURLnode.item(0).getTextContent();
			System.out.println(RestURL);  //"WWW>goofle.com"
		}
		
		//Negative scenario
		NodeList negativecheck =  ele.getElementsByTagName("negativecheck");
		
		if(negativecheck.getLength() == 1)
		{
			//this block of code will not be executed as getLengthReturns 0
			String negchek = negativecheck.item(0).getTextContent();
			System.out.println(negchek);  //value if available
		}
		
		//Similarly we can use this for other Elements as well
		
		
	}
}