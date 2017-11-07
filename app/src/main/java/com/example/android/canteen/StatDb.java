package com.example.android.canteen;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class StatDb extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://robinjk12345.000webhostapp.com/Stat.php";
    private Map<String, String> params;

    public StatDb(String name,int BundlePapers, int HardBound,int IndexGraph,int cost, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("BundlePapers", BundlePapers+ "");
        params.put("HardBound",HardBound + "");
        params.put("IndexGraph",IndexGraph + "");
        params.put("cost", cost + "");

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

