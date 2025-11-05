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

    //  성공 응답 (msg 지정)
    public static ApiResponseVo success(String msg) {
        Map<String, Object> inner = new LinkedHashMap<>();
        inner.put("data", msg);
        return new ApiResponseVo("200", "success", inner);
    }

    // 성공 응답 (data 없음)
    public static ApiResponseVo noData() {
        Map<String, Object> inner = new LinkedHashMap<>();
        inner.put("data", "데이터 없음");
        return new ApiResponseVo("400", "success", inner);
    }

    // 에러 응답
    public static ApiResponseVo error(String code, String message) {
        return new ApiResponseVo(code, "fail", message);
    }

    // getter/setter
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }
}
