package com.virtualpairprogrammers.filters;

import com.virtualpairprogrammers.data.MenuDataService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PriceCorrectionRequestWrapper extends HttpServletRequestWrapper {

    PriceCorrectionRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String key) {
        return key.equals("maxPrice") ? super.getParameter(key) : "maxPrice";

    }

}
