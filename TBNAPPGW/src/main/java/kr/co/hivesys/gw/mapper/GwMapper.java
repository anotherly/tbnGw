package kr.co.hivesys.gw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.hivesys.gw.vo.ReceiptAppVO;

@Mapper("gwMapper")
public interface GwMapper {
    int insertReceipt(ReceiptAppVO vo);
    ReceiptAppVO updateReceiptById(ReceiptAppVO vo);
    List<ReceiptAppVO>  areaReceipt(ReceiptAppVO vo);
	List<ReceiptAppVO> selectLocByPhone(ReceiptAppVO vo);
	void insertUserLoc(ReceiptAppVO vo);
	String findReportName(ReceiptAppVO vo);
	List<ReceiptAppVO> unionAppReceipt(ReceiptAppVO vo);
}
