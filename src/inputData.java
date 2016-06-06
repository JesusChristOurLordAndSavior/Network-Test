
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class inputData extends checkRequests{
	FileReader input;
	BufferedReader bufRead;
	String myLine;
	//check for changes in excel document
	//create ArrayList of requests 
	public void readInput(String inputer) throws IOException{
		input = new FileReader(inputer);
		bufRead = new BufferedReader(input);
       myLine= null;
	
		while( (myLine=bufRead.readLine())!= null)
			{
			
				String[] array1=myLine.split("	");
				for(int i=0;i<array1.length;i++){
					if(i%21==10){
					
						request r = new request();
						r.setIp(array1[i]);
						super.addToTRequests(r);
					
						
						//System.out.println(array1[i]);
					}
				}
				}
			}

	}
	
	//put new line into request
	

