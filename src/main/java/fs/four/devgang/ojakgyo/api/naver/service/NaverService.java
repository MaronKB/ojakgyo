package fs.four.devgang.ojakgyo.api.naver.service;

import fs.four.devgang.ojakgyo.api.common.service.ApiService;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class NaverService {
    protected static final ApiService apiService = new ApiService();
    protected static final JSONParser jsonParser = new JSONParser();

    private static final String NAVER_CLIENT_ID = "Xs8udJjhMhH_I_6pLk3F";
    private static final String NAVER_CLIENT_SECRET = "hMAAjvehvN";
    private static final String X_NCP_APIGW_API_KEY_ID = "d2682gqz4u";
    private static final String X_NCP_APIGW_API_KEY = "Tg61vLFYB0IHS6ZKYcld9EbigqnqO3E2IPUKMH8b";

    protected static String getNCloudConnection(String apiUrl) throws Exception {
        URL url = new URL(apiUrl.toString());

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("x-ncp-apigw-api-key-id", X_NCP_APIGW_API_KEY_ID);
        urlConnection.setRequestProperty("x-ncp-apigw-api-key", X_NCP_APIGW_API_KEY);

        return apiService.getDataString(urlConnection);
    }
    protected static String getOpenConnection(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("Host", "openapi.naver.com");
        urlConnection.setRequestProperty("User-Agent", "curl/7.49.1");
        urlConnection.setRequestProperty("Accept", "*/*");
        urlConnection.setRequestProperty("X-Naver-Client-Id", NAVER_CLIENT_ID);
        urlConnection.setRequestProperty("X-Naver-Client-Secret", NAVER_CLIENT_SECRET);

        return apiService.getDataString(urlConnection);
    }
}
