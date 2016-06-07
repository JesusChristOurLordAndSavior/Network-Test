import java.io.IOException;

public class mainProgram {
	
	
		public static void main (String[] args)throws IOException{
			
			inputData test = new inputData();
			
			test.readInput("samplelog.txt");
			test.createCount();
			test.runCheckRequests();
			test.checkThreshholds();
			test.writeLists();
			//System.out.println(checkOne.getTempRequests().size());
			
			test.displayLists();
			
			
			while(true){
				if (test.isOverThreshHold(1000)){
					break;
				}
				
			//dataInputOne.updateLists();
			
			}
		}

	}

