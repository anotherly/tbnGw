package kr.co.hivesys.gw.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReceiptAppVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//사용자 위치정보 ID
	private Long locId;
	// 제보시각
	private Timestamp receiptDate;
	// 통신원id
	private String informerId;
	
	//아래는 app 연동시 필요 필드값
	// 제보id
	private String receiptId;	
	// 통신원(제보자) 이름
	private String informerName;
	// 제보내용
	private String commentTxt;
	// 지역코드
	private String areaCode;
	// 제보유형
	private String reportType;
	// 제보유형
	private String reportTypeName;
	// x좌표 위도
	private String xCoordinate;
	// y좌표 경도
	private String yCoordinate;
	// y좌표 경도
	private String arteryName;
	// 플래그 값(1:내주변제보인지,2:전체제보인지)
	private String flagLange;
	// 상황해제 플래그(1:상황진행,2:상황해제)
	private String flagSituEd;
	//전화번호
	private String phoneCell;
	
	public String getReportTypeName() {
		return reportTypeName;
	}
	public void setReportTypeName(String reportTypeName) {
		this.reportTypeName = reportTypeName;
	}
	public String getCommentTxt() {
		return commentTxt;
	}
	public void setCommentTxt(String commentTxt) {
		this.commentTxt = commentTxt;
	}
	public String getFlagSituEd() {
		return flagSituEd;
	}
	public void setFlagSituEd(String flagSituEd) {
		this.flagSituEd = flagSituEd;
	}
	public String getFlagLange() {
		return flagLange;
	}
	public void setFlagLange(String flagLange) {
		this.flagLange = flagLange;
	}
	public String getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}
	public Timestamp getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(Timestamp receiptDate) {
		this.receiptDate = receiptDate;
	}
	public String getInformerId() {
		return informerId;
	}
	public void setInformerId(String informerId) {
		this.informerId = informerId;
	}
	public String getInformerName() {
		return informerName;
	}
	public void setInformerName(String informerName) {
		this.informerName = informerName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(String xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public String getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(String yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public String getArteryName() {
		return arteryName;
	}
	public void setArteryName(String arteryName) {
		this.arteryName = arteryName;
	}
	public Long getLocId() {
		return locId;
	}
	public void setLocId(Long locId) {
		this.locId = locId;
	}
	public String getPhoneCell() {
		return phoneCell;
	}
	public void setPhoneCell(String phoneCell) {
		this.phoneCell = phoneCell;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
