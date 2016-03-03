package com.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.client package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _GetEmployeeResponse_QNAME = new QName(
			"http://server.com/", "getEmployeeResponse");
	private final static QName _GetEmpfromrole_QNAME = new QName(
			"http://server.com/", "getEmpfromrole");
	private final static QName _GetRolesResponse_QNAME = new QName(
			"http://server.com/", "getRolesResponse");
	private final static QName _GetEmpfromroleResponse_QNAME = new QName(
			"http://server.com/", "getEmpfromroleResponse");
	private final static QName _GetRoles_QNAME = new QName(
			"http://server.com/", "getRoles");
	private final static QName _GetEmployee_QNAME = new QName(
			"http://server.com/", "getEmployee");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.client
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link GetRoles }
	 * 
	 */
	public GetRoles createGetRoles() {
		return new GetRoles();
	}

	/**
	 * Create an instance of {@link GetEmpfromroleResponse }
	 * 
	 */
	public GetEmpfromroleResponse createGetEmpfromroleResponse() {
		return new GetEmpfromroleResponse();
	}

	/**
	 * Create an instance of {@link GetEmployee }
	 * 
	 */
	public GetEmployee createGetEmployee() {
		return new GetEmployee();
	}

	/**
	 * Create an instance of {@link GetEmployeeResponse }
	 * 
	 */
	public GetEmployeeResponse createGetEmployeeResponse() {
		return new GetEmployeeResponse();
	}

	/**
	 * Create an instance of {@link GetEmpfromrole }
	 * 
	 */
	public GetEmpfromrole createGetEmpfromrole() {
		return new GetEmpfromrole();
	}

	/**
	 * Create an instance of {@link GetRolesResponse }
	 * 
	 */
	public GetRolesResponse createGetRolesResponse() {
		return new GetRolesResponse();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetEmployeeResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://server.com/", name = "getEmployeeResponse")
	public JAXBElement<GetEmployeeResponse> createGetEmployeeResponse(
			GetEmployeeResponse value) {
		return new JAXBElement<GetEmployeeResponse>(_GetEmployeeResponse_QNAME,
				GetEmployeeResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetEmpfromrole }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://server.com/", name = "getEmpfromrole")
	public JAXBElement<GetEmpfromrole> createGetEmpfromrole(GetEmpfromrole value) {
		return new JAXBElement<GetEmpfromrole>(_GetEmpfromrole_QNAME,
				GetEmpfromrole.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetRolesResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://server.com/", name = "getRolesResponse")
	public JAXBElement<GetRolesResponse> createGetRolesResponse(
			GetRolesResponse value) {
		return new JAXBElement<GetRolesResponse>(_GetRolesResponse_QNAME,
				GetRolesResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link GetEmpfromroleResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://server.com/", name = "getEmpfromroleResponse")
	public JAXBElement<GetEmpfromroleResponse> createGetEmpfromroleResponse(
			GetEmpfromroleResponse value) {
		return new JAXBElement<GetEmpfromroleResponse>(
				_GetEmpfromroleResponse_QNAME, GetEmpfromroleResponse.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetRoles }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://server.com/", name = "getRoles")
	public JAXBElement<GetRoles> createGetRoles(GetRoles value) {
		return new JAXBElement<GetRoles>(_GetRoles_QNAME, GetRoles.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployee }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://server.com/", name = "getEmployee")
	public JAXBElement<GetEmployee> createGetEmployee(GetEmployee value) {
		return new JAXBElement<GetEmployee>(_GetEmployee_QNAME,
				GetEmployee.class, null, value);
	}

}
