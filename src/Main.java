/**
 * Created by sidya on 07/01/15.
 */
public class Main {
    public static void main (String[] args){

        String fileName = "description";
        String balise = "serviceId";
        String url = "http://172.31.190.168:55239/";
        Description.description(url, fileName);
        //System.out.print(new Parser().getContentTag(fileName, balise));

        System.out.println(new Service(fileName,"ContentDirectory",url).getUrlSCPD());
        System.out.println(new Service(fileName, "ContentDirectory", url).getActions());
        System.out.println(new Service(fileName, "ContentDirectory", url).getUrlControle());

    }
}
