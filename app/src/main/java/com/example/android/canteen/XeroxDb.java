package com.example.android.canteen;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class XeroxDb extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://robinjk12345.000webhostapp.com/Xerox.php";
    private Map<String, String> params;

    public XeroxDb(String name, int pages,int copies,int cost, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("pages", pages + "");
        params.put("copies",copies + "");
        params.put("cost", cost + "");

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
