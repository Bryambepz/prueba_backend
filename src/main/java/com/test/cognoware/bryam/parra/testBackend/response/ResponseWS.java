package com.test.cognoware.bryam.parra.testBackend.response;

public class ResponseWS {
    
    private Integer statusCode;
    private String message;
    private String error;
    private Object body;
    
    public ResponseWS(Integer statusCode, String message, String error, Object body) {
        this.statusCode = statusCode;
        this.message = message;
        this.error = error;
        this.body = body;
    }
    
    public ResponseWS(Integer statusCode, String message, String error) {
        this.statusCode = statusCode;
        this.message = message;
        this.error = error;
    }

    public ResponseWS(Integer statusCode, String message, Object body) {
        this.statusCode = statusCode;
        this.message = message;
        this.body = body;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public Object getBody() {
        return body;
    }
    public void setBody(Object body) {
        this.body = body;
    }

}
