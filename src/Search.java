/**
 *
 * @author EL HAMLAOUI
 */

import java.net.*;
//import java.util.*;
//import org.apache.soap.*;
//import org.apache.soap.encoding.SOAPMappingRegistry;
//import org.apache.soap.encoding.soapenc.BeanSerializer;
//import org.apache.soap.rpc.*;
import javax.xml.rpc.ParameterMode;
import org.apache.axis.encoding.XMLType;
//import org.apache.axis.utils.Options;




import org.apache.axis.client.*;
import javax.xml.namespace.*;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Vector;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import org.apache.axis.transport.http.HTTPConstants;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.encoding.ser.ArrayDeserializerFactory;
import org.apache.axis.encoding.ser.ArraySerializerFactory;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.handlers.soap.SOAPService;
//import org.apache.soap.transport.http.SOAPHTTPConnection;

public class Search {


  public String ActionSearch(String ContainerID,String SearchCriteria,String Filter,String SortCriteria,String IP,String controlURL){

			String results="";
			try {

			String METHOD = "Search";
			String ACTION_URI = "urn:schemas-upnp-org:service:ContentDirectory:1#Search";
			String ACTION_URII = "urn:schemas-upnp-org:service:ContentDirectory:1";
	
			Service service = new Service();
			Call call = (Call)service.createCall();
			String endpoint = IP+"/"+controlURL;
			System.out.println("enpoint:"+endpoint);

			call.setTargetEndpointAddress( new URL(endpoint));

			call.setSOAPActionURI(ACTION_URI);

			call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);

			//SOAPHTTPConnection shc = new SOAPHTTPConnection ();
			//	shc.setMaintainSession (true);

			      call.setUseSOAPAction(true);
				  call.setOperationStyle("rpc");
				  call.setOperationName(new QName(ACTION_URII, METHOD));
				  call.addParameter("ContainerID", XMLType.XSD_STRING, ParameterMode.IN);
				  call.addParameter("SearchCriteria", XMLType.XSD_STRING, ParameterMode.IN);
				  call.addParameter("Filter", XMLType.XSD_STRING, ParameterMode.IN);
				  call.addParameter("StartingIndex", XMLType.XSD_INT, ParameterMode.IN);
				  call.addParameter("RequestedCount", XMLType.XSD_INT, ParameterMode.IN);
				  call.addParameter("SortCriteria", XMLType.XSD_STRING, ParameterMode.IN);
				  call.addParameter("Result", XMLType.XSD_STRING, ParameterMode.OUT);
				  call.addParameter("UpdateId", XMLType.XSD_INT, ParameterMode.OUT);
				  call.addParameter("TotalMatches", XMLType.XSD_INT, ParameterMode.OUT);
				  call.addParameter("NumberReturned", XMLType.XSD_INT, ParameterMode.OUT);
	              call.setReturnType(XMLType.XSD_STRING);
	   
    
				 System.out.println("Encoding " + call.getEncodingStyle());
				 System.out.println("soapaction uri " + call.getSOAPActionURI());
				 System.out.println("target " + call.getTargetEndpointAddress());
					

			    results = (String) call.invoke (new Object [] {ContainerID,SearchCriteria,Filter,"0","0",SortCriteria});
			
            }
			  catch( ServiceException e )
			  {
//				 TODO Auto-generated catch block
			  e.printStackTrace();
			  }
			  catch( RemoteException e )
			  {
//				 TODO Auto-generated catch block
			  e.printStackTrace();
			  }
			  catch( MalformedURLException e )
			  {
//				 TODO Auto-generated catch block
			  e.printStackTrace();

			}
			                                                                               
         return results;   }

}
