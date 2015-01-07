import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sidya on 07/01/15.
 */
public class Parser {
    private Document doc;

    public Parser(String fileName) {

        try {
            File f = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.doc = dBuilder.parse(f);
            doc.getDocumentElement().normalize();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getContentTag(String balise) {
        try {
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

    public ArrayList<String> getContentTagOfParents(String child, String parent) {

        try {
            NodeList nList = doc.getElementsByTagName(child);

            ArrayList<String> str= new ArrayList<String>();
            for (int i= 0; i < nList.getLength(); i++){
                if(!nList.item(i).getFirstChild().getTextContent().replace(" ", "").replace("\n","").equals(""))
                    if(nList.item(i).getParentNode().getNodeName().equals(parent))
                    str.add(nList.item(i).getFirstChild().getTextContent());
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
