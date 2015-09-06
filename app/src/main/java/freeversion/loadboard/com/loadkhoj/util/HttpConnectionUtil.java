package freeversion.loadboard.com.loadkhoj.util;

/**
 * Created by root on 30/8/15.
 */

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Class contains the static object references.
 * 1.Gson object
 * 2.HttpURLConnection objects
 * @author LoadKhoj
 */
public class HttpConnectionUtil {
    /**
     * Static gson class object
     */
    public static final Gson gson = new Gson();

    /**
     * HttpURLConnecting methods
     */
    public static final String POST_REQUEST_METHOD = "POST";
    public static final String PUT_REQUEST_METHOD = "PUT";
    public static final String GET_REQUEST_METHOD = "GET";

    /**
     * HttpURLConnection Code Constants
     */
    public static final int GET_OK = 200;
    public static final int PUT_OK = 200;
    public static final int POST_OK = 201;
    public static final int MALFORMED_URL_EXCEPTION_CODE = 502;
    public static final int IO_EXCEPTION_CODE = 503;
    public static final int UNEXPECTED_FAILURE_CODE = 504;
    public static final int INTERNAL_SERVER_ERROR_CODE = 500;
    public static final int NOT_FOUND_EXCEPTION_CODE = 404;
    public static final int BAD_REQUEST_CODE = 400;

    public static final int USER_BLOCKED_CODE = 403;
    public static final int NO_CONTENT_FOUND_CODE = 204;
    public static final int RESOURCE_CONFLICT_CODE = 409;
    /**
     * HttpURLConnection Message Constants
     */
    public static final String MALFORMED_URL_EXCEPTION_MESSAGE = "Something went wrong. Please try again";
    public static final String IO_EXCEPTION_MESSAGE = "Something went wrong. Please try again";
    public static final String UNEXPECTED_FAILURE_MESSAGE = "Something went wrong. Please contact the customer care representative";
    public static final String INTERNAL_SERVER_ERROR_MESSAGE = "Something went wrong. Please contact the customer care representative";
    public static final String NOT_FOUND_EXCEPTION_MESSAGE = "Something went wrong. Please contact the customer care representative";
    public static final String BAD_REQUEST_MESSAGE = "Something went wrong. Check the data you entered or please try again";
    public static final String USER_BLOCKED_MESSAGE = "Something went wrong. Please contact the customer care representative";
    public static final String NO_CONTENT_FOUND_MESSAGE = "Something went wrong. Please contact the customer care representative";
    public static final String RESOURCE_CONFLICT_MESSAGE = "Something went wrong. Please contact the customer care representative";

    /**
     * Create the post connection for URL requested
     * @param URL : URL requested
     * @return HttpURLConnection : post connection for requested URL
     * @throws IOException
     */
    public static HttpURLConnection getPostConnection(String URL, long deviceId) throws IOException
    {
        java.net.URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(POST_REQUEST_METHOD);
        connection.setRequestProperty("Content-Type", "application/json");
        if(deviceId!=0) {
            connection.setRequestProperty("deviceId",deviceId+"");
        }
        connection.setConnectTimeout(15000);
        connection.setDoOutput(true);
        return connection;
    }

    /**
     * Create the Put connection for URL requested
     * @param URL : URL requested
     * @return HttpURLConnection : put connection for requested URL
     * @throws IOException
     */
    public static HttpURLConnection getPutConnection(String URL, long deviceId) throws IOException
    {
        URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(PUT_REQUEST_METHOD);
        if(deviceId!=0) {
            connection.setRequestProperty("deviceId",deviceId+"");
        }
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setConnectTimeout(10000);

        return connection;
    }

    /**
     * Create the Get connection for URL requested
     * @param URL : URL requested
     * @return HttpURLConnection : get connection for requested URL
     * @throws IOException
     */
    public static HttpURLConnection getGetConnection(String URL) throws IOException
    {
        URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(GET_REQUEST_METHOD);
        connection.setConnectTimeout(10000);
        return connection;
    }
}
