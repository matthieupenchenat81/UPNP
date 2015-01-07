import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by sidya on 07/01/15.
 */
public class Parser {
    public ArrayList<String> getContentTag(String fileName, String balise) {
        try {
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName(balise);

            ArrayList<String> str= new ArrayList<String>();
            for (int i= 0; i < nList.getLength(); i++){
                if(!nList.item(i).getFirstChild().getTextContent().replace(" ", "").replace("\n","").equals(""))
                    str.add(nList.item(i).getFirstChild().getTextContent());
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
