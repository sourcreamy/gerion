package kr.co.gerion.vo;

public class UserVO {

	
	
	private String accessDt;							//최근접속
	private String accessToken;                        //엑세스 토큰(카카오)
	private String adviserYn;                          //전문가여부 Y:전문가
	private String expiresIn;                          //토큰 만료시간(카카오 초단위)
	private String mainMenu;                           //사용자의 주사용메뉴
	private String refreshToken;                       //리프레쉬 토큰(카카오 토큰 갱신시 사용)
	private String regDt;                              //등록일
	private String thumbnailImageUrl;                 //사용자썸네일이미지(카카오)
	private String tokenType;                          // 토큰타입(카카오)
	private String userGrade;                          //사용자등급 일반:0, vip:1 , vvip:2
	private String userId;                              //사용자 아이디(카카오톡으로 로그인시 가져올 수 있는 사용자의 id)
	private String userNick;                            //닉네임(카카오)
	private String userRole;                            //사용자권한 일반:0, 관리자:1
	private String userStatus;                          //사용자 상태 0:정상 1:정지
	public String getAccessDt() {
		return accessDt;
	}
	public void setAccessDt(String accessDt) {
		this.accessDt = accessDt;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getAdviserYn() {
		return adviserYn;
	}
	public void setAdviserYn(String adviserYn) {
		this.adviserYn = adviserYn;
	}
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(String mainMenu) {
		this.mainMenu = mainMenu;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getThumbnailImageUrl() {
		return thumbnailImageUrl;
	}
	public void setThumbnailImageUrl(String thumbnailImageUrl) {
		this.thumbnailImageUrl = thumbnailImageUrl;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public String getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
