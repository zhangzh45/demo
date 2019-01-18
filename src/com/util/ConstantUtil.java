package com.util;

public class ConstantUtil {
    private static final String wsdlLocation = "http://192.168.0.93:8020/demo/EmployeeServerInterfacePort?wsdl";

    private static final String modifyResourceUrl = "http://192.168.0.93:3000/cache/modifyResource";

    public static String getWsdlLocation() {
        return wsdlLocation;
    }

    public static String getModifyResourceUrl() {
        return modifyResourceUrl;
    }
}
