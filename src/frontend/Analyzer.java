package frontend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Analyzer 
{
	File mySalesData;
	ArrayList<Sale> mySales;
	
	public Analyzer(String fileName)
	{
		mySales = new ArrayList<Sale>();
		mySalesData = new File(fileName);
		analyze();
	}
	
	public Analyzer(File file)
	{
		mySales = new ArrayList<Sale>();
		mySalesData = file;
		analyze();
	}
	
	private void analyze()
	{
		try(BufferedReader br = new BufferedReader(new FileReader(mySalesData)))
		{
			String line;
			String saleName = "";
			double saleMoney = 0;
			boolean doingSale = false;
			
			while((line = br.readLine()) != null)
			{
				if(line.contains("<RPTSalesProductItem>") && doingSale == false)
				{
					doingSale = true;
				}
				else
				{
					if(doingSale && line.contains("<ProductName>"))
					{
						saleName = line.substring(line.indexOf(">")+1,line.indexOf("</"));
						System.out.println(saleName);
					}
					else if (doingSale && line.contains("<TotalAmount>"))
					{
						saleMoney = Double.valueOf(line.substring(line.indexOf(">")+1,line.indexOf("</")));
						mySales.add(new Sale(saleName, saleMoney));
						doingSale = false;
						System.out.println(saleMoney);
						saleName = "";
						saleMoney = 0;
					}
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Sale> getSales()
	{
		return mySales;
	}
}
