
public class request {
	
	private String ip, userid, cRequest, sResponse;
	private int instCount, stkCount, timeStamp;  
	//empty constructor
	public request(){
		this.ip="";
		this.userid="";
		this.setcRequest("");
		this.setsResponse("");
		this.instCount=0;
		this.setStkCount(0);
		this.timeStamp=0;
		
	}
	
	//constructor w/ data from log files

	public request(String ip, String userid, int time, String cRequest, String sResponse){
		this.ip=ip;
		this.userid=userid;
		this.timeStamp=time;
		this.setcRequest(cRequest); 
		this.setsResponse(sResponse);
		this.instCount=0;
		this.setStkCount(0);
		this.timeStamp=0;
	}
	//methods for accessing from instances
	public String getIP(){
		return ip;
	}
	public int getStkCount(){
		return stkCount;
	}
	public String getUserId(){
		return userid;
	}
	public int getTime(){
		return timeStamp;
	}
	public int getCount(){
		return instCount;
	}
	public String getsResponse() {
		return sResponse;
	}
	public String getcRequest() {
		return cRequest;
	}
	public void setCount(int count){
		this.instCount=count; 
	}
	public void setStrike(int strikes){
		this.setStkCount(strikes);
	}
	public void setStkCount(int stkCount) {
		this.stkCount = stkCount;
	}
	public void setsResponse(String sResponse) {
		this.sResponse = sResponse;
	}
	public void setcRequest(String cRequest) {
		this.cRequest = cRequest;
	}
	public void setIp(String ip){
		this.ip=ip;
	}
	public void setUserId(String userid){
		this.userid=userid;
	}
	
}
