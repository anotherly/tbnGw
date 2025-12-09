package kr.co.hivesys.gw.service;

import java.util.List;

import kr.co.hivesys.gw.vo.ReceiptAppVO;

public interface GwService { 
	void saveReceipt(ReceiptAppVO vo);
    void saveUserLoc(ReceiptAppVO vo);
	List<ReceiptAppVO> areaReceipt(ReceiptAppVO req);
	List<ReceiptAppVO> selectLocByPhone(ReceiptAppVO req);
	String findReportName(ReceiptAppVO req);
	void insertReceipt(ReceiptAppVO req);
	int updateReceiptById(ReceiptAppVO req);
	List<ReceiptAppVO> unionAppReceipt(ReceiptAppVO req);
	void updateReportReceipt(ReceiptAppVO req);
}