import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by malibu on 1/7/15.
 */
public class Description {

    public static void description(String URL, String fileName) {

        URL url = null;
        try {
            url = new URL(URL);
            URLConnection uc = url.openConnection();

            PrintWriter fw = new PrintWriter(fileName, "UTF-8");
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                fw.println(inputLine);
            }
            fw.close();
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
