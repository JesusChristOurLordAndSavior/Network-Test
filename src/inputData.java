
import java.io.File;
import java.io.IOException;

import jxl.Cell;
//import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class inputData extends checkRequests{
	private String inputFile;
	//check for changes in excel document
	//create ArrayList of requests 
	public void setInputFile(String inputFile){
		this.inputFile=inputFile;
	}
	public String getInputFile(){
		return inputFile;
	}
	public void read() throws IOException{
		File inputWorkbook = new File(getInputFile());
		Workbook w;
		try{
			w=Workbook.getWorkbook(inputWorkbook);
			//get first sheet
			Sheet sheet=w.getSheet(0);
			
			//create requests and put them into Arraylists while filling property of ip address
			//loop through Column 11 (ip addresses)
			
			for(int i=0;i<sheet.getRows();i++){
				Cell cell=sheet.getCell(11,i);
				request r= new request();
				r.setIp((String)cell.getContents());
				addToTRequests(r);				
			}
			//loop through column 2 (userids )
			/*for(int i=0;i<sheet.getRows();i++){
				Cell cell = sheet.getCell(1,i);
				getTempRequests().get(i).setUserId((String)cell.getContents());
			}*/
		}
		catch (BiffException e){
			e.printStackTrace();
		}
	}
	
	//put new line into request
	
}
