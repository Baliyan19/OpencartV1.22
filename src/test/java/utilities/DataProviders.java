package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	//DataProvider1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path="C:\\Users\\kashi\\eclipse-workspace\\OpenCartV1.21\\testData\\OpenCartDataDriven.xlsx";
		ExcelUtilities xutil=new ExcelUtilities(path,"Sheet1");
		
		int totalrows=xutil.getRowCount();
		int totalcols=xutil.getCellCount(1);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for (int i =1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xutil.getCellData(i, j);
			}
		}
		
		return logindata;
		
	}
	
	//DataProvider2
	
}
