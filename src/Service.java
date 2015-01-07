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

    public Service(String f, String reg) {
        Parser p = new Parser();
        for(String s : p.getContentTag(f, "SCPDURL"))
        {
            if(f.contains(reg)) {
                try {
                    descriptionURL = new URL(s);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public URL getUrlSCPD () {
        return descriptionURL;
    }
}
