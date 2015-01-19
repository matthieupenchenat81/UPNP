/**
 *
 * @author EL HAMLAOUI
 */

import javax.xml.rpc.ParameterMode;
import org.apache.axis.encoding.XMLType;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;


public class Browse {

	public String ActionBrowse(String ObjectId, String Filter,
			String SortCriteria, String IP, String controlURL) {
		String results = "";
		try {

			String BrowseFlag = "BrowseDirectChildren";
														
			String METHOD = "Browse";
			String ACTION_URI = IP;// A définir ;
			String ACTION_URII = "urn:schemas-upnp-org:service:ContentDirectory:1";

			Service service = new Service();
			Call call = (Call) service.createCall();
			String endpoint =  IP + "/" + controlURL ;//A définir
			System.out.println("enpoint:" + endpoint);

			call.setTargetEndpointAddress(new java.net.URL(endpoint));

			call.setSOAPActionURI(ACTION_URI);

			call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);

			// SOAPHTTPConnection shc = new SOAPHTTPConnection ();
			// shc.setMaintainSession (true);

			call.setUseSOAPAction(true);
			call.setOperationStyle("rpc");
			call.setOperationName(new QName(ACTION_URII, METHOD));
			call.addParameter("ObjectID", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("BrowseFlag", XMLType.XSD_STRING,
					ParameterMode.IN);
			call.addParameter("Filter", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("SortCriteria", XMLType.XSD_STRING,
					ParameterMode.IN);
			call.addParameter("StartingIndex", XMLType.XSD_INT,
					ParameterMode.IN);
			call.addParameter("RequestedCount", XMLType.XSD_INT,
					ParameterMode.IN);
			call.addParameter("Result", XMLType.XSD_STRING, ParameterMode.OUT);
			call.addParameter("UpdateId", XMLType.XSD_INT, ParameterMode.OUT);
			call.addParameter("TotalMatches", XMLType.XSD_INT,
					ParameterMode.OUT);
			call.addParameter("NumberReturned", XMLType.XSD_INT,
					ParameterMode.OUT);
			call.setReturnType(XMLType.XSD_STRING);

			System.out.println("Encoding " + call.getEncodingStyle());
			System.out.println("soapaction uri " + call.getSOAPActionURI());
			System.out.println("target " + call.getTargetEndpointAddress());

		
			results = (String) call.invoke(new Object[] { ObjectId, BrowseFlag,
					Filter, SortCriteria, "0", "0" });

			// return results;
			// System.out.println("Retour de Hello World " + results);

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return results;
	}

	public static void main(String[] args) {
		Browse B = new Browse();
		System.out.print(B.ActionBrowse("0", "*", "", "http://172.31.190.168:56552", "_urn:schemas-upnp-org:service:ContentDirectory_control"));
	}
}
