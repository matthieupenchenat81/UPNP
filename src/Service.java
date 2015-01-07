import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by sidya on 07/01/15.
 */
public class Service {
    private String serviceType;
    private String serviceID;
    private URL controlURL;
    private URL eventSubUrl;
    private URL descriptionURL;

    public Service(String f, String reg, String url) {
        Parser p = new Parser(f);
        for(String s : p.getContentTag("SCPDURL"))
        {
            if(s.contains(reg)) {
                try {
                    descriptionURL = new URL(url+s);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public ArrayList<String> getActions() {

        Description.description(descriptionURL.toString(), "service");
        Parser p = new Parser("service");
        return p.getContentTagOfParents("name", "action");
    }

    public URL getUrlSCPD () {
        return descriptionURL;
    }
}
