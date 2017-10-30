package com.util;
 
import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
 
public class HttpRequestUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class);    //日志记录
 
    /**
     * httpPost
     * @param url  路径
     * @param jsonParam 参数
     * @return
     */
    public static JSONObject httpPost(String url,JSONObject jsonParam){
        return httpPost(url, jsonParam, true);
    }
 
    /**
     * post请求
     * @param url         url地址
     * @param jsonParam     参数
     * @param noNeedResponse    不需要返回结果
     * @return
     */
    public static JSONObject httpPost(String url,JSONObject jsonParam, boolean noNeedResponse){
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
              //  entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            	System.out.println("********发送成功！********");
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    if (noNeedResponse) {
                        return null;
                    }
                    /**把json字符串转换成json对象**/
                    jsonResult = JSONObject.fromObject(str);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        }
        return jsonResult;
    }
 
 
    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static JSONObject httpGet(String url){
        //get请求返回结果
        JSONObject jsonResult = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
 
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            	System.out.println("********发送成功！********");
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                /**把json字符串转换成json对象**/
                jsonResult = JSONObject.fromObject(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
        }
        return jsonResult;
    }
    
    /**
     * 向rancher服务器发送请求
     * @param url 服务器地址
     * @param jsonParam 请求参数
     * @param httpMethod 请求方法
     * @param noNeedResponse 是否需要响应
     * @return
     */
    public static String sendToRancher(String url, JSONObject jsonParam, String httpMethod, boolean noNeedResponse){
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpResponse result = null;
        String jsonResult = null;    //请求返回结果
        //String auth = "1477356FAC57627DB36C:KMPUFAwMxceHEp6ANvBCRG4EPhTgDK5xAXUfFbqL";  //rancher api keys
        String auth = "A14BBCB29EB66268FD87:2iTtn7MTQgJPU87EkMXdXvfcpVmUuqJn7DWVcDCA";  //rancher api keys
	    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
	    String authHeader = "Basic " + new String(encodedAuth);
	    System.out.println(authHeader);
        try {
        	if(httpMethod.equalsIgnoreCase("POST")){
        		HttpPost method = new HttpPost(url);
                method.setHeader("Authorization", authHeader);
                if(null != jsonParam){
                	//解决中文乱码问题
                    StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                  //  entity.setContentEncoding("UTF-8");
                    entity.setContentType("application/json");
                    method.setEntity(entity);
                }
                result = httpClient.execute(method);
        	}
        	else if(httpMethod.equalsIgnoreCase("PUT")){
        		HttpPut method = new HttpPut(url);
                method.setHeader("Authorization", authHeader);
                if(null != jsonParam){
                	//解决中文乱码问题
                    StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                  //  entity.setContentEncoding("UTF-8");
                    entity.setContentType("application/json");
                    method.setEntity(entity);
                }
                result = httpClient.execute(method);
        	}
        	else if(httpMethod.equalsIgnoreCase("GET")){   //发送get请求
        		HttpGet method = new HttpGet(url);
        		method.setHeader("Authorization", authHeader);
                System.out.println("get:"+authHeader);
                result = httpClient.execute(method);
        	}
        	else if(httpMethod.equalsIgnoreCase("DELETE")){   //发送DELETEget请求
        		HttpDelete method = new HttpDelete(url);
        		method.setHeader("Authorization", authHeader);
                System.out.println("get:"+authHeader);
                result = httpClient.execute(method);
        	}
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            String statusCode = result.getStatusLine().getStatusCode() + "";
            if (statusCode.startsWith("2")) {
            	System.out.println("********发送成功！********");
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                	jsonResult = EntityUtils.toString(result.getEntity());
                    if (noNeedResponse) {
                        return null;
                    }
                } catch (Exception e) {
                	System.out.println("请求提交失败:" + url);
                }
            }
            else{
            	System.out.println(result.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
        	System.out.println("请求提交失败:" + url);
        }
        return jsonResult;
    }
}