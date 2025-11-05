package kr.co.hivesys.gw.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

import kr.co.hivesys.gw.vo.ReceiptAppVO;
import kr.co.hivesys.gw.mapper.GwMapper;
import kr.co.hivesys.gw.service.GwService;

/**
 * 게이트웨이 서비스 구현부
 */
@Service("gwService")
public class GwServiceImpl implements GwService {

	@Resource(name="gwMapper")
    private GwMapper gwMapper;

    /** 제보 데이터 저장 */
    @Override
    public void saveReceipt(ReceiptAppVO vo) {
        gwMapper.insertReceipt(vo);
    }

    /** 사용자 위치이력 저장 */
    @Override
    public void saveUserLoc(ReceiptAppVO vo) {
    	gwMapper.insertUserLoc(vo);
    }

	@Override
	public List<ReceiptAppVO> areaReceipt(ReceiptAppVO vo) {
		return gwMapper.areaReceipt(vo);
	}

	@Override
	public List<ReceiptAppVO> selectLocByPhone(ReceiptAppVO vo) {
		return gwMapper.selectLocByPhone(vo);
	}

	@Override
	public void insertReceipt(ReceiptAppVO vo) {
		gwMapper.insertReceipt(vo);
	}

	@Override
	public void updateReceiptById(ReceiptAppVO vo) {
		gwMapper.updateReceiptById(vo);
	}

	@Override
	public String findReportName(ReceiptAppVO vo) {
		return gwMapper.findReportName(vo);
	}

	@Override
	public List<ReceiptAppVO> unionAppReceipt(ReceiptAppVO vo) {
		return gwMapper.unionAppReceipt(vo);
	}
}
