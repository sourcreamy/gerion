package kr.co.gerion.vo;

public class ItemVO {

	private String admisuYn;					//관리종목여부
	private String haltYn;						//거래정지여부
	private String idxIndMidclssCd;			//업종분류코드
	private String itemCd;						//종목(표준)코드
	private String itemName;					//종목명
	private String itemSrtCd;				   //종목(단축)코드
	private String kospiYn;                   //(유가)kospi여부,(코스닥)프리미어여부
	private String kospi100Yn;              //(유가)KOSPI100여부
	private String kospi50Yn;                //(유가)KOSPI50여부
	private String listDd;                      //상장일자
	private String listShrs;                    //상장주식수,상장증권수
	private String lwlmtprc;                   //하한가
	private String marketCd;                 //시장구분코드
	private String mfindYn;                   //(유가)제조업여부
	private String midclssName;            //업종명
	private String nowPrc;                     //실시간 현재가
	private String prevddClsprc;             //전일종가
	private String regDt;                       //등록일
	private String smeYn;                     //(코스닥)중소기업여부
	private String uplmtprc;                  	
	private String eps;							//주당순이익
	private String per;							//주가수익률
	private String pbr;							//주당순자산비율
	private String bps;							//주당순자산가치
	private String dps;							//주당배당금액
	private String divYd;						//배당수익률
	
	public void init(){
		
		this.admisuYn="";			
		this.haltYn="";				
		this.idxIndMidclssCd="";	
		this.itemCd="";				
		this.itemName="";			
		this.itemSrtCd="";			
		this.kospiYn="";            
		this.kospi100Yn="";         
		this.kospi50Yn="";          
		this.listDd="";             
		this.listShrs="";           
		this.lwlmtprc="";           
		this.marketCd="";           
		this.mfindYn="";            
		this.midclssName="";        
		this.nowPrc="";             
		this.prevddClsprc="";       
		this.regDt="";              
		this.smeYn="";              
		this.uplmtprc="";
		this.eps="";
		this.per="";
		this.pbr="";
		this.bps="";
		this.dps="";
		this.divYd="";
		
	}
	
	
	public String getAdmisuYn() {
		return admisuYn;
	}
	public void setAdmisuYn(String admisuYn) {
		this.admisuYn = admisuYn;
	}
	public String getHaltYn() {
		return haltYn;
	}
	public void setHaltYn(String haltYn) {
		this.haltYn = haltYn;
	}
	public String getIdxIndMidclssCd() {
		return idxIndMidclssCd;
	}
	public void setIdxIndMidclssCd(String idxIndMidclssCd) {
		this.idxIndMidclssCd = idxIndMidclssCd;
	}
	public String getItemCd() {
		return itemCd;
	}
	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemSrtCd() {
		return itemSrtCd;
	}
	public void setItemSrtCd(String itemSrtCd) {
		this.itemSrtCd = itemSrtCd;
	}
	public String getKospiYn() {
		return kospiYn;
	}
	public void setKospiYn(String kospiYn) {
		this.kospiYn = kospiYn;
	}
	public String getKospi100Yn() {
		return kospi100Yn;
	}
	public void setKospi100Yn(String kospi100Yn) {
		this.kospi100Yn = kospi100Yn;
	}
	public String getKospi50Yn() {
		return kospi50Yn;
	}
	public void setKospi50Yn(String kospi50Yn) {
		this.kospi50Yn = kospi50Yn;
	}
	public String getListDd() {
		return listDd;
	}
	public void setListDd(String listDd) {
		this.listDd = listDd;
	}
	public String getListShrs() {
		return listShrs;
	}
	public void setListShrs(String listShrs) {
		this.listShrs = listShrs;
	}
	public String getLwlmtprc() {
		return lwlmtprc;
	}
	public void setLwlmtprc(String lwlmtprc) {
		this.lwlmtprc = lwlmtprc;
	}
	public String getMarketCd() {
		return marketCd;
	}
	public void setMarketCd(String marketCd) {
		this.marketCd = marketCd;
	}
	public String getMfindYn() {
		return mfindYn;
	}
	public void setMfindYn(String mfindYn) {
		this.mfindYn = mfindYn;
	}
	public String getMidclssName() {
		return midclssName;
	}
	public void setMidclssName(String midclssName) {
		this.midclssName = midclssName;
	}
	public String getNowPrc() {
		return nowPrc;
	}
	public void setNowPrc(String nowPrc) {
		this.nowPrc = nowPrc;
	}
	public String getPrevddClsprc() {
		return prevddClsprc;
	}
	public void setPrevddClsprc(String prevddClsprc) {
		this.prevddClsprc = prevddClsprc;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getSmeYn() {
		return smeYn;
	}
	public void setSmeYn(String smeYn) {
		this.smeYn = smeYn;
	}
	public String getUplmtprc() {
		return uplmtprc;
	}
	public void setUplmtprc(String uplmtprc) {
		this.uplmtprc = uplmtprc;
	}


	public String getEps() {
		return eps;
	}


	public void setEps(String eps) {
		this.eps = eps;
	}


	public String getPer() {
		return per;
	}


	public void setPer(String per) {
		this.per = per;
	}


	public String getPbr() {
		return pbr;
	}


	public void setPbr(String pbr) {
		this.pbr = pbr;
	}


	public String getBps() {
		return bps;
	}


	public void setBps(String bps) {
		this.bps = bps;
	}


	public String getDps() {
		return dps;
	}


	public void setDps(String dps) {
		this.dps = dps;
	}


	public String getDivYd() {
		return divYd;
	}


	public void setDivYd(String divYd) {
		this.divYd = divYd;
	}
	
	
	
}
