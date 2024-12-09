package fs.four.devgang.ojakgyo.api.tmap.service;

import fs.four.devgang.ojakgyo.api.common.service.ApiService;

import java.net.HttpURLConnection;
import java.net.URL;

public class TmapService {
    protected static final ApiService apiService = new ApiService();

    protected static final String POI_API_URL = "https://apis.openapi.sk.com/tmap/pois/search/around?";
    protected static final String API_KEY = "FlBqQ3EMhH4tOxopVXfK1QLIklZrFPz58pAjJJha";
    protected static final String VERSION = "1";
    protected static final String PAGE = "1";
    protected static final String COUNT = "8";
    protected static final String REQ_COORD_TYPE = "WGS84GEO";
    protected static final String RES_COORD_TYPE = "WGS84GEO";

    protected String getJSON(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("Accept", "application/json");
        urlConnection.setRequestProperty("appKey", API_KEY);

        return apiService.getDataString(urlConnection);
    }
}
