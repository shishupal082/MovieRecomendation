package com.movierecomendation.libs;

import com.movierecomendation.exception.BaseException;
import com.movierecomendation.exception.UserNotFound;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Handler;

/**
 * Created by shishupal.kumar on 27/06/15.
 */
public class CustomResponse {
    private Integer methodNotDefined = 404;
    private Integer methodNotAllowed = 405;
    public HashMap<String, String> get(String status, String reason, String message){
        HashMap<String, String> res = new HashMap<String, String>();
        res.put("status", status);
        res.put("reason", reason);
        res.put("message", message);
        return res;
    }

    public HashMap<String, String> get(String status, String reason){
        return this.get(status, reason, "");
    }

    public HashMap<String, String> get(String status){
        return this.get(status, "", "");
    }

    public HashMap<String, String> get(){
        return this.get("FAILURE", "", "");
    }

    public HashMap<String, String> getException(BaseException e){
        return this.get("FAILURE", e.getReason(), e.getMessage());
    }
}
