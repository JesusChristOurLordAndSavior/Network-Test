import java.util.ArrayList;
import java.util.Collections;

public class checkRequests extends DDoS{

	//somehow pass in as arrayList<request> the data in the log files
	private ArrayList<request> tempRequests;
	private ArrayList<String> tempIPs;
	private int phaseIterations;
	private boolean isChanged;
	
	public void runCheckRequests(){
		phaseIterations++;
		if(isChanged)
		{
			createCount();
			checkList();
			setIsChanged(false);
			
		}
		refreshList();
	}
	
	public boolean isOverThreshHold(int threshHold){
		if(tempRequests.size()>=threshHold){
			return true;
		}
		return false;
	}
	public void setIsChanged(boolean b){
		isChanged=b; 
	}
	
	public checkRequests(){
		tempRequests= new ArrayList<request>();
		tempIPs = new ArrayList<String>();
		phaseIterations=-1;
	}
	//each new input in the 
	public void addToTRequests(request newRequest){
		tempRequests.add(newRequest);
		tempIPs.add(newRequest.getIP());	
		setIsChanged(true);
	}
	public ArrayList<request> getTempRequests(){
		return tempRequests;
	}
	public void createCount(){
		int length=tempRequests.size();
		for (int i=0;i<length;i++)
		{
			if (tempRequests.get(i).getCount()!=Collections.frequency(tempIPs,tempRequests.get(i).getIP())){
				tempRequests.get(i).setCount(Collections.frequency(tempIPs,tempRequests.get(i).getIP()));
			}
		}
	}
	public void checkList(){
		for (int i=0;i<tempRequests.size();i++)
		{
			if(tempRequests.get(i).getCount()>=3)
			{
				addToSusp(tempRequests.get(i));
			}
		}
	}
	public void refreshList(){
		if(phaseIterations==300){
		tempRequests = new ArrayList<request>();
		phaseIterations=-1;
		setIsChanged(true);
		}
		}
	public String toString(){
		String s = "temporary arraylist size ="+tempRequests.size(); 
				for(int i=0;i<tempRequests.size();i++){
					s += tempRequests.get(i).getIP(); 
				}
		return s;
	}
	
}
