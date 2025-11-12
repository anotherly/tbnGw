package kr.co.hivesys.gw.vo;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApiResponseVo {
    private String code;
    private String message;
    private Object data;

    public ApiResponseVo() {}
    public ApiResponseVo(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 성공 응답 (msg 지정) 
    public static ApiResponseVo success(String msg) { 
    	Map<String, Object> inner = new LinkedHashMap<>(); 
    	inner.put("data", msg); 
    	return new ApiResponseVo("200", "success", inner); 
    }
    
    //  성공 응답 (keytype, msg 지정) 오버로딩
    public static ApiResponseVo success(String keytype,String msg) {
        Map<String, Object> inner = new LinkedHashMap<>();
        if(!keytype.equals("") && keytype != null) {
        	inner.put(keytype, msg);
        }else {
        	inner.put("data", msg);
        }
        return new ApiResponseVo("200", "success", inner);
    }

    // 연동은 성공했지만 데이터변경 x 또는 조회데이터 x
    public static ApiResponseVo noData(String msg) {
        Map<String, Object> inner = new LinkedHashMap<>();
        inner.put("data", msg);
        return new ApiResponseVo("400", "success", inner);
    }

    // 에러 응답
    public static ApiResponseVo error(String message) {
        return new ApiResponseVo("404", "fail", message);
    }

    // getter/setter
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }
}
