package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="login_data")
	public String [][] getLoginData() throws IOException
	{
		String  path=".\\testData\\Opencart_LoginData.xlsx";
		
		Excelutility xutil = new Excelutility(path);
		
		int totalRows = xutil.getRowCount("Sheet1");
		int totalCols =xutil.getCellCount("Sheet1", 1);
		
	    String loginData[][] = new String[totalRows][totalCols];
	    
	    for(int i = 1 ; i <= totalRows; i++) {//getrows 
	    	for(int j = 0;j < totalCols; j++) {//get coloumn
	    	    loginData[i-1][j] = xutil.getCellData("Sheet1", i, j);
	    	}
	    }
	    return loginData;//returning two dimensional array 
	}

}  
 