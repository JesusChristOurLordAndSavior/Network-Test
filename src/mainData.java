
import java.util.ArrayList;

public class mainData extends mainProgram {
	private ArrayList<request> blackList, immList, tempList;
	private boolean isBlackChanged, isImmChanged, isTempChanged; 
	
	public mainData(){
		blackList= new ArrayList<request>();
		immList= new ArrayList<request>();
		tempList= new ArrayList<request>();
		isBlackChanged=false;
		isImmChanged=false;
		isTempChanged=false;
	}	
	
	void addToBlack(request threeStrikesAndYoureOut){
		blackList.add(threeStrikesAndYoureOut);
	}
	
	void addToImm(request DDoS){
		immList.add(DDoS);
	}
	void addToTemp(request possible){
		tempList.add(possible);
	}
	public boolean isChanged(){
		return isTempChanged||isBlackChanged||isImmChanged; 
	}
	public boolean isBlackChanged(){
		return isBlackChanged;
	}
	public boolean isImmChanged(){
		return isImmChanged;
	}
	public boolean isTempChanged(){
		return isTempChanged;
	}
	public void setIsBlackChanged(boolean b){
		isBlackChanged=b; 
	}
	public void setIsImmChanged(boolean b){
		isImmChanged=b; 
	}
	public void setIsTempChanged(boolean b){
		isTempChanged=b; 
	}
	
	
	public void displayLists(){
		System.out.println("List of Temporarily Banned IP addresses: \n\n");
		for (int i=0; i<tempList.size();i++){
			System.out.println(tempList.get(i));
		}
		System.out.println("\n\n List of Immediately and Permanently Banned IP addresses:  \n\n");
		for(int i=0;i<immList.size();i++){
			System.out.println(immList.get(i));
		}
		System.out.println("\n\n List of 3 Strike Banned IP addresses");
		for (int i=0;i<blackList.size();i++){
			System.out.println(blackList.get(i));
		}
		System.out.println("\n This program is presented to you by Universal Studios, thanks Obama");
	}
	public void updateLists(){
		if(isChanged()){	
			System.out.print('\f');
			displayLists();
		}
	}
}

