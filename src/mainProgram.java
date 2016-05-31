import java.io.IOException;

public class mainProgram {
	
	
		public static void main (String[] args)throws IOException{
			inputData test = new inputData();
			checkRequests checkOne = new checkRequests();
			DDoS checkTwo = new DDoS();
			mainData dataInputOne = new mainData();				
			test.setInputFile("c:/Users/Yixuan/Desktop/samplelog.xls");
			dataInputOne.displayLists();
			System.out.println(checkOne);
			while(true){
				if (checkOne.isOverThreshHold(100)){
					break;
				}
			
			test.read();
			checkOne.runCheckRequests(); 
			checkTwo.checkThreshholds();
			dataInputOne.updateLists();
			
			}
		}

	}

