package com.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * <p>
 * An example of how this class may be used:
 * 
 * <pre>
 * EmployeeServerInterfaceService service = new EmployeeServerInterfaceService();
 * EmployeeServerInterfaceDelegate portType = service.getEmployeeServerInterfacePort();
 * portType.getRoles(...);
 * </pre>
 * 
 * </p>
 * 
 */
@WebServiceClient(name = "EmployeeServerInterfaceService", targetNamespace = "http://server.com/", wsdlLocation = "http://127.0.0.1:8080/demo/EmployeeServerInterfacePort?wsdl")
public class EmployeeServerInterfaceService extends Service {

	private final static URL EMPLOYEESERVERINTERFACESERVICE_WSDL_LOCATION;
	private final static Logger logger = Logger
			.getLogger(com.client.EmployeeServerInterfaceService.class
					.getName());

	static {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = com.client.EmployeeServerInterfaceService.class
					.getResource(".");
			url = new URL(baseUrl,
					"http://127.0.0.1:8080/demo/EmployeeServerInterfacePort?wsdl");
		} catch (MalformedURLException e) {
			logger.warning("Failed to create URL for the wsdl Location: 'http://127.0.0.1:8080/demo/EmployeeServerInterfacePort?wsdl', retrying as a local file");
			logger.warning(e.getMessage());
		}
		EMPLOYEESERVERINTERFACESERVICE_WSDL_LOCATION = url;
	}

	public EmployeeServerInterfaceService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public EmployeeServerInterfaceService() {
		super(EMPLOYEESERVERINTERFACESERVICE_WSDL_LOCATION, new QName(
				"http://server.com/", "EmployeeServerInterfaceService"));
	}

	/**
	 * 
	 * @return returns EmployeeServerInterfaceDelegate
	 */
	@WebEndpoint(name = "EmployeeServerInterfacePort")
	public EmployeeServerInterfaceDelegate getEmployeeServerInterfacePort() {
		return super.getPort(new QName("http://server.com/",
				"EmployeeServerInterfacePort"),
				EmployeeServerInterfaceDelegate.class);
	}

}
