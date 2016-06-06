import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Yixuan
 *
 */
public class DDoS extends mainData {
	
	private ArrayList<request> suspList;
	public DDoS(){
		suspList= new ArrayList<request>();
	}
	
	public void checkThreshholds(){
		//check threshholds in descending order
		//if added to an arraylist set the boolean of isChanged of that arraylist to be true
		for (int i=0; i<suspList.size();i++)
		{
			request r = suspList.get(i);
			if(r.getCount()>10)
			{
				addToImm(r);
				for(int j=0;j<suspList.size();j++){
					request q= new request();
					if(suspList.get(j).getIP().equals(r.getIP())){
						suspList.remove(j);
						j--;
					}
				}
				setIsImmChanged(true);
			}
			else if (r.getCount()>7)
			{
				if(r.getStkCount()>=3)
				{
					addToBlack(r);
					for(int j=0;j<suspList.size();j++){						
						if(suspList.get(j).getIP().equals(r.getIP())){
							suspList.remove(j);
							j--;
						}
					setIsBlackChanged(true);
				}
				suspList.get(i).setCount(r.getCount()+1);
			}
			else if (r.getCount()>4){
				addToTemp(r);
				for(int j=0;j<suspList.size();j++){
					if(suspList.get(j).getIP().equals(r.getIP())){
						suspList.remove(j);
						j--;
					}
				setIsTempChanged(true);
			}
		}
	}
	}
	}
	
	public void addToSusp(request r){
		suspList.add(r); 
	}
}
