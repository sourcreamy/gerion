package kr.co.gerion.utils;

public class ResultApi {

	public static final String DEFAULT_ERROR_CODE = "E001";

	private String resultCode = "0000";
	
	private String resultMsg = "OK";
	
	private Object resultData;

	private Object resultDataSub;
	
	private Object resultDataThird;
	
	private String sportsCd;
	private String timeDiff;
	private String gameType;
	
	
	
	
	public Object getResultDataThird() {
		return resultDataThird;
	}

	public void setResultDataThird(Object resultDataThird) {
		this.resultDataThird = resultDataThird;
	}

	public Object getResultDataSub() {
		return resultDataSub;
	}

	public void setResultDataSub(Object resultDataSub) {
		this.resultDataSub = resultDataSub;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}

	public String getSportsCd() {
		return sportsCd;
	}

	public void setSportsCd(String sportsCd) {
		this.sportsCd = sportsCd;
	}

	public String getTimeDiff() {
		return timeDiff;
	}

	public void setTimeDiff(String timeDiff) {
		this.timeDiff = timeDiff;
	}
	
	
	
}
