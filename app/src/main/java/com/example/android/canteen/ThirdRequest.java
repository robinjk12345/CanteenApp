package com.example.android.canteen;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ThirdRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://robinjk12345.000webhostapp.com/Food.php";
    private Map<String, String> params;

    public ThirdRequest(String name12,String pName,  int pPrice,  Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name12", name12);
        params.put("pName", pName);
        params.put("pPrice", pPrice + "");

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }}