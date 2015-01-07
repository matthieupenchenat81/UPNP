/**
 * Created by sidya on 07/01/15.
 */
public class Main {
    public static void main (String[] args){

        String fileName = "description";
        String balise = "serviceId";
        Description.description("http://172.31.190.168:55239", fileName);
        System.out.print(new Parser().getContentTag(fileName, balise));
    }
}
