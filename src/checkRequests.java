import java.util.ArrayList;
import java.util.Collections;

public class checkRequests extends DDoS{

	//somehow pass in as arrayList<request> the data in the log files
	public ArrayList<request> tempRequests;
	private ArrayList<String> tempIPs;
	private int phaseIterations;
	private boolean isChanged;
	
	public checkRequests(){
		tempRequests= new ArrayList<request>();
		tempIPs = new ArrayList<String>();
		phaseIterations=-1;
	}
	
	public void runCheckRequests(){
		phaseIterations++;
		createCount();
		checkList();
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
	
	
	//each new input into a temporary arraylist of requests and a temporary list of ips for those requests
	public void addToTRequests(request newRequest){
		tempRequests.add(newRequest);
		tempIPs.add(newRequest.getIP());	
		setIsChanged(true);
	}
	public ArrayList<request> getTempRequests(){
		return tempRequests;
	}
	public void createCount(){
		//loops through tempRequests for updates. If the count variable of any request object is not equal to the frequency of the object
		//in the ArrayList, set the count integer to the frequency
		for (int i=0;i<tempRequests.size()-10;i++)
		{

			if (tempRequests.get(i).getCount()!=Collections.frequency(tempIPs,tempRequests.get(i).getIP())){
				System.out.println("Previous count of IP:" + tempRequests.get(i).getIP()+ "\n is:" +tempRequests.get(i).getCount());
				tempRequests.get(i).setCount(Collections.frequency(tempIPs,tempRequests.get(i).getIP()));
				System.out.println("New count of IP:" + tempRequests.get(i).getIP()+ "\n is:" +tempRequests.get(i).getCount());
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
