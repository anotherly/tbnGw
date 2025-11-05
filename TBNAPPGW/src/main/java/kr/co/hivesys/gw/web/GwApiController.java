package kr.co.hivesys.gw.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import kr.co.hivesys.gw.vo.ApiResponseVo;
import kr.co.hivesys.gw.vo.ReceiptAppVO;
import kr.co.hivesys.gw.service.GwService;

@Controller
//@RequestMapping("/tbnAppGw")
public class GwApiController {

	@Resource(name="gwService")
	private GwService gwService;
    
    public static final Logger logger = LoggerFactory.getLogger(GwApiController.class);
   
    /**
     * app 에서 gateway로 제보정보 요청 (11/04 추가)
     * 연동 순서 및 전달 데이터
     * 1 app 에서 gateway로: 허용 시간,소속지역
     * 2 gateway 에서 app 으로 : 
     * 제보 ID, 제보유형,제보내용,제보자이름(통신원), 위치(위,경도), 상황해제여부,긴급제보 여부  
    */	
    @RequestMapping(value="/tbnAppGw/list.do") 
    public ResponseEntity<?> list(@RequestBody ReceiptAppVO req) {
    	try {
        	logger.debug("/tbnAppGw/list : "+req);
            if (req.getReceiptDate() == null)
                req.setReceiptDate(new Timestamp(System.currentTimeMillis()));
            //요청정보 (제보내용 관련 ) 을 보내줌
            List<ReceiptAppVO> vo = gwService.unionAppReceipt(req);
            //조회한 데이터가 없을 경우
            if(vo.size()==0 || vo == null || vo.isEmpty()) {
            	 return ResponseEntity.ok(ApiResponseVo.noData());
            } else {
            	//요청한 제보를 송신함
            	return ResponseEntity.ok(vo);
            }
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(ApiResponseVo.error("404",e.toString()));
		}
    }

    /**
     * app 에서 저장하기 버튼 클릭 시 게이트웨이에서 저장 
     * 
     * 1 app에서 GW로 데이터 전송 : (전달값 : 제보유형, 사용자이름, 전화번호, 지역콛, 위치(위,경도) ,제보내용)
     * 2 gateway 저장 : 제보 전체
     * 3 gateway 에서 app 으로 : 제보ID, 제보유형,제보내용,제보자(통신원), 위치(위,경도), 상황해제여부,긴급제보 여부  
    */	
    @RequestMapping(value="/tbnAppGw/save.do")
    public ResponseEntity<?> save(@RequestBody ReceiptAppVO req) {
        if (req.getReceiptDate() == null)
            req.setReceiptDate(new Timestamp(System.currentTimeMillis()));
        logger.debug("/tbnAppGw/save : "+req);
        try {
            //제보내용 저장
            gwService.insertReceipt(req);
            return ResponseEntity.ok(ApiResponseVo.success("제보등록 완료"));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(ApiResponseVo.error("404",e.toString()));
		}

    }
    
    /**
     * 상황 해지 시
     * 
     * app 에서 gateway로: 제보 ID
     * gateway 저장 : 상황플래그 : 1에서 2로 업데이트 ,
     * gateway 에서 app 으로 : 정상적으로 update 될 경우 상황해지 x  
     * 
    */	
    
    @RequestMapping(value="/tbnAppGw/update.do")
    public ResponseEntity<?> update(@RequestBody ReceiptAppVO req) {
    	logger.debug("/receipt/update : "+req);
    	
    	//요청정보 (제보내용 관련 ) 을 보내줌
    	//제보 id가 유효할 경우 update
    	try {
    		if(req.getReceiptId()!=null && !req.getReceiptId().equals("")) {
        		gwService.updateReceiptById(req);
        		return ResponseEntity.ok(ApiResponseVo.success("상황해제 완료"));
        	} else {
        		return ResponseEntity.ok(ApiResponseVo.noData());
        	}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok(ApiResponseVo.error("404",e.toString()));
		}
    }
    
    
    /**
     * app 에서 gateway로 제보정보 요청 (11/04 미사용)
    */	
    @RequestMapping(value="/tbnAppGw/select.do")
    public ResponseEntity<?> select(@RequestBody ReceiptAppVO req) {
    	logger.debug("/tbnAppGw/select");
        if (req.getReceiptDate() == null)
            req.setReceiptDate(new Timestamp(System.currentTimeMillis()));
        ReceiptAppVO rvo = new ReceiptAppVO();
        //요청한 시각에 사용자 전화번호와 위치를 저장
        gwService.saveUserLoc(req);
        //요청정보 (제보내용 관련 ) 을 보내줌
        List<ReceiptAppVO> vo = gwService.areaReceipt(req);
        return ResponseEntity.ok(vo);
    }
    
    
}
