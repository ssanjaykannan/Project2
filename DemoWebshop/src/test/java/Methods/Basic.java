package Methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class Basic {

    public static WebDriver driver;	
	public static Properties P=new Properties();
	public static int Imp_Time=10;
	public static Basic Basic=new Basic();
	
	public void Type(String xpath,String Content) throws Exception {
		FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
		P.load(fis);
		try {
		    driver.findElement(By.xpath(P.getProperty(xpath))).sendKeys(P.getProperty(Content));
		}
		catch (Exception e) {
			driver.findElement(By.xpath(P.getProperty(xpath))).sendKeys(Content);
		}
	}
	
	public void Type_Content(String xpath,String Content) throws Exception {
		FileInputStream fis=new FileInputStream("Resources\\Sample1..properties");
		P.load(fis);
		 try {
		 driver.findElement(By.xpath(P.getProperty(xpath))).sendKeys(Content);
	     }
		 catch (Exception e) {
		 System.out.println(e);
	}
	}
	
	public void Click(String xpath) throws Exception  {
		FileInputStream fis=new FileInputStream("Resources\\Sample1..properties");
		P.load(fis);
		try {
			driver.findElement(By.xpath(P.getProperty(xpath))).click();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}


	public void LaunchURL() throws Exception {
		FileInputStream fis=new FileInputStream("Resources\\Sample1..properties");
		P.load(fis);
		String Browser=P.getProperty("Browser");
		if(Browser.equals("Chrome")) {
		    System.setProperty("webdriver.chrome.driver","WebDriver/chromedriver.exe");
		    driver = new ChromeDriver();
		}
		else if (Browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver","WebDriver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
        driver.get(P.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public void Clear(String xpath) throws Exception  {
		FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
		P.load(fis);
		 try {
			driver.findElement(By.xpath(P.getProperty(xpath))).clear();
		 }
		 catch (Exception e) {
			 System.out.println(e);
		}
	}
	
	
	
	public void Access_dropdown(String xpath, String value) throws Exception {
		FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
		P.load(fis);
		WebElement dropdown;
		Select select;
		try {
			 dropdown = driver.findElement(By.xpath(P.getProperty(xpath)));
				select = new Select(dropdown);
				select.selectByVisibleText(value);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void Access_dropdown_property(String xpath, String value) throws Exception {
		FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
		P.load(fis);
		WebElement dropdown;
		Select select;
		try {
			dropdown = driver.findElement(By.xpath(P.getProperty(xpath)));
		    select = new Select(dropdown);
		    select.selectByVisibleText(P.getProperty(value));
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public String getText(String xpath) throws Exception {
		FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
		P.load(fis);
		String Content=null;
		
		try {
		
			Content=driver.findElement(By.xpath(P.getProperty(xpath))).getText();
			return Content;
		}
		catch (Exception e) {
       System.out.println(e);
       return Content;
		}
		
	}
	
	public String getvalue(String xpath) throws Exception {
		FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
		P.load(fis);
		String Content=null;
		try {
			Content=driver.findElement(By.xpath(P.getProperty(xpath))).getAttribute("value");
			return Content;
		}
		catch (Exception e) {
       System.out.println(e);
       return Content;
		}
		
	}
	  
	  public void Delete_existFile(String downloadPath, String fileName) throws Exception {
	    	FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
			P.load(fis);
			
			String Download="C:\\Users\\"+System.getProperty("user.name")+"\\Downloads";
			
			System.out.println("Download Path  "+P.getProperty(downloadPath));
	    	File dir = new File(P.getProperty(downloadPath));
	    	  File[] dirContents = dir.listFiles();
             System.out.println("Delete Operation Started");
	    	  for (int i = 0; i < dirContents.length; i++) {
	    	      if (dirContents[i].getName().startsWith(fileName)) {
	    	          dirContents[i].delete();
	    	          System.out.println("Delete Successful");
	    	      }
	    	      
	    	    }
	    	   
	    	  }
	  
	  public Boolean Verify_existFile(String downloadPath, String fileName) throws Exception {
	    	FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
			P.load(fis);
			
			String Download="C:\\Users\\"+System.getProperty("user.name")+"\\Downloads";
			
	     	File dir = new File(P.getProperty(downloadPath));
	   	   System.out.println(dir);
	   	   File[] dirContents = dir.listFiles();
           int Count=0;
           System.out.println("Verify File Started");
	   	  for (int i = 0; i < dirContents.length; i++) {
	   	      if (dirContents[i].getName().startsWith(fileName)) {
	   	       System.out.println("File Exist");
	   	       Count=Count+1;
	   	      }
	   	  }
	   	  
	   	  System.out.println("Export Count"+Count);
	   	  if(Count==1) {
	   		  return true;
	   	  }
	   	  else {
	   		  return false;
	   	  }
		
		
	    }	
	    
	    public Boolean Verify_Parameter(String xpath,String Expected) throws Exception {
	    	FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
			P.load(fis);
			
	    	try {
		
			String Actual=driver.findElement(By.xpath(P.getProperty(xpath))).getText();
			System.out.println("Actual Value  "+Actual);
			if(Actual.contentEquals(Expected)) {
				return true;
			}else {
				return false;
			}
			}
			catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
	    
	    public Boolean Verify_Parameter_text(String xpath,String Expected) throws Exception {
	    	FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
			P.load(fis);
			
	    	try {
			
			String Actual=driver.findElement(By.xpath(P.getProperty(xpath))).getText();
			System.out.println("\n");
			System.out.println("Actual"+Actual);
			System.out.println("Expected"+P.getProperty(Expected));
			System.out.println("\n");
			if(Actual.contentEquals(P.getProperty(Expected))) {
				return true;
			}else {
				return false;
			}
			}
			catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
	
	    public Boolean Verify_Parameter_Valueofinput(String xpath,String Expected) throws Exception {
	    	FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
			P.load(fis);
			
	    	try {
			
			String Actual=driver.findElement(By.xpath(P.getProperty(xpath))).getAttribute("value");
		    System.out.println("Actual"+Actual);
			System.out.println("Expected "+ Expected);
			
			if(Actual.contentEquals(Expected)) {
				return true;
			}else {
				return false;
			}
			}
			catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
	    
	    public Boolean Verify_Parameter_Value(String xpath,String Expected) throws Exception {
	    	FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
			P.load(fis);
			
	    	try {
			
			String Actual=driver.findElement(By.xpath(P.getProperty(xpath))).getAttribute("value");
			System.out.println("\n");
		    System.out.println("Actual"+Actual);
			System.out.println("Expected"+P.getProperty(Expected));
			System.out.println("\n");
			
			if(Actual.contentEquals(P.getProperty(Expected))) {
				return true;
			}else {
				return false;
			}
			}
			catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
	    
	    public Boolean Slider(String xpath,String Expected) throws Exception {
	    	FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
			P.load(fis);
			
	     try {
			
			String Actual=driver.findElement(By.xpath(P.getProperty(xpath))).getAttribute("class");
			String Yes="toggle-switch on";
			String No="toggle-switch";
			String Status = "Fail";
			
			if(Actual.equals(Yes)) {
			
				if(P.getProperty(Expected).equals("Yes")) {
					Status="Pass";
				}
				else if(P.getProperty(Expected).equals("No")){
					Status="Fail";
				}
			}
			else if(Actual.equals(No)) {
				if(P.getProperty(Expected).equals("No")) {
					Status="Pass";
				}
				else if(P.getProperty(Expected).equals("Yes")){
					Status="Fail";
				}
			}
			
			if(Status.equals("Pass")) {
				System.out.println("\n");
				System.out.println("Slider successful");
				return true;
			}
			
			else {
				System.out.println("\n");
				System.out.println("Slider Unsuccessful");
				return false;
			}
			
	    }
	  catch (Exception e) {
		return false;
	}
	
	    }
	    
	    
	    
	    public Boolean Verify_checkbox(String xpath,String Expected) throws Exception {
	    	FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
			P.load(fis);
			
	    	try {
			Boolean Actual=driver.findElement(By.xpath(P.getProperty(xpath))).isSelected();
			
			Boolean Status = false;
			if(Expected.equals("Enabled")) {
				Status=true;
			}
			else if(Expected.equals("Disabled")) {
				Status=false;
			}
			if(Actual==Status) {
				System.out.println("\n");
				System.out.println("Checkbox Successful");
				return true;
			}else {
				System.out.println("\n");
				System.out.println("Checkbox Unsuccessful");
				return false;
			}
			}
			catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
	    
	    
	    public Boolean Verify_checkbox_PropertyInput(String xpath,String Expected) throws Exception {
	    	FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
			P.load(fis);
			
	    	try {
			Boolean Actual=driver.findElement(By.xpath(P.getProperty(xpath))).isSelected();
			
			Boolean Status = false;
			if(P.getProperty(Expected).equals("Enabled")) {
				Status=true;
			}
			else if(P.getProperty(Expected).equals("Disabled")) {
				Status=false;
			}
			if(Actual==Status) {
				System.out.println("\n");
				System.out.println("Checkbox Successful");
				return true;
			}else {
				System.out.println("\n");
				System.out.println("Checkbox Unsuccessful");
				return false;
			}
			}
			catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
	    public Boolean Verify_dropdown(String xpath,String Expected) throws Exception {
	    	FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
			P.load(fis);
			
	    	try {
	    		WebElement selectElement = driver.findElement(By.xpath(P.getProperty(xpath)));
	    		Select select = new Select(selectElement);
	    		
	    		  WebElement option = select.getFirstSelectedOption();
	 			  String Value=option.getText();

	    		if(Value.equals(P.getProperty(Expected))) {
	    			return true;
	    		}
	    		else {
	    			return false;
	    		}

	    	}
			catch (Exception e) {
				System.out.println(e);
				return false;
			}
	    	
		
	    	
	    }
	    
	    
	    public Boolean Verify_dropdown_Value(String xpath,String Expected) throws Exception {
	    	FileInputStream fis=new FileInputStream("Resources\\Sample1.properties");
			P.load(fis);
			
	    	try {
	    		WebElement selectElement = driver.findElement(By.xpath(P.getProperty(xpath)));
	    		Select select = new Select(selectElement);

	               WebElement option = select.getFirstSelectedOption();
	 			  String Value=option.getText();
	    		
	    		if(Value.equals(Expected)) {
	    			return true;
	    		}
	    		else {
	    			return false;
	    		}

	    	}
			catch (Exception e) {
				System.out.println(e);
				return false;
			}
	    	
	    }
	    
	    
	       public boolean stringCompare(String ele1, String ele2, ExtentTest test) throws Exception {
	              driver.switchTo().activeElement();
	              if(ele1.contentEquals(ele2))
	              {
	                test.pass("The String " +"'" + ele2 + "'"+ " is displayed correctly");
	                return true;
	              }
	              else
	              {
	                     test.fail("The String " + "'" + ele2 + "'" + " is not displayed correctly");
	                     return false;
	              }
	              
	       }
	       
	       
	   public void Download_Skeleton(ExtentTest test,String ReportName,String Format) throws Exception {
	     Boolean FileStatus;
	     if(Format.equals("All")) {
	     Basic.Delete_existFile("Path",ReportName);
	        Thread.sleep(5000);
		    Basic.Click("Download_Report");
		    Thread.sleep(5000);
		    
		    Basic.Click("Download_XML");
		    Thread.sleep(5000);
		    Runtime.getRuntime().exec("AutoIT\\Download.exe");
		    Thread.sleep(10000);
		     FileStatus=Basic.Verify_existFile("Path",ReportName);
		    if(FileStatus==true)
				 test.pass("Export XML successfully");
				else
				 test.fail("Export XML unsuccessfully");
		    
		    Thread.sleep(5000);
	     
		    Basic.Delete_existFile("Path",ReportName);
		    Basic.Click("Download_Report");
		    Thread.sleep(5000);
		    
		    Basic.Click("Download_CSV");
		    Thread.sleep(10000);
		    
		    Runtime.getRuntime().exec("AutoIT\\Download.exe");
		    
		     FileStatus=Basic.Verify_existFile("Path",ReportName);
		    if(FileStatus==true)
				 test.pass("Export CSV successfully");
				else
				 test.fail("Export CSV unsuccessfully");
	     
		    Thread.sleep(5000);
		    
		    Basic.Delete_existFile("Path",ReportName);
		    Basic.Click("Download_Report");
		    Thread.sleep(5000);
		    
		    Basic.Click("Download_PDF");
		    Thread.sleep(10000);
		    
		    Runtime.getRuntime().exec("AutoIT\\Download.exe");
		    
		     FileStatus=Basic.Verify_existFile("Path",ReportName);
		    if(FileStatus==true)
				 test.pass("Export PDF successfully");
				else
				 test.fail("Export PDF unsuccessfully");
		    
		    Thread.sleep(5000);
		    
		    Basic.Delete_existFile("Path",ReportName);
		    Basic.Click("Download_Report");
		    Thread.sleep(5000);
		    
		    Basic.Click("Download_MHTML");
		    Thread.sleep(10000);
		    
		    Runtime.getRuntime().exec("AutoIT\\Download.exe");
		    
		     FileStatus=Basic.Verify_existFile("Path",ReportName);
		    if(FileStatus==true)
				 test.pass("Export MHTML successfully");
				else
				 test.fail("Export MHTML unsuccessfully");
		    
		    Thread.sleep(5000);
		    
		    Basic.Delete_existFile("Path",ReportName);
		    Basic.Click("Download_Report");
		    Thread.sleep(5000);
		    
		    Basic.Click("Download_TIFF");
		    Thread.sleep(10000);
		    
		    Runtime.getRuntime().exec("AutoIT\\Download.exe");
		    
		     FileStatus=Basic.Verify_existFile("Path",ReportName);
		    if(FileStatus==true)
				 test.pass("Export TIFF successfully");
				else
				 test.fail("Export TIFF unsuccessfully");
		    
		    Thread.sleep(5000);
		    
		    Basic.Delete_existFile("Path",ReportName);
		    Basic.Click("Download_Report");
		    Thread.sleep(5000);
		    
		    Basic.Click("Download_Word");
		    Thread.sleep(10000);
		    
		    Runtime.getRuntime().exec("AutoIT\\Download.exe");
		    
		     FileStatus=Basic.Verify_existFile("Path",ReportName);
		    if(FileStatus==true)
				 test.pass("Export Word successfully");
				else
				 test.fail("Export word unsuccessfully");
		    
		    Thread.sleep(5000);
		    
	     }
		    else if(Format.equals("XML")) {
			    Basic.Delete_existFile("Path",ReportName);
			    Basic.Click("Download_Report");
			    Thread.sleep(5000);
			    
			    Basic.Click("Download_XML");
			    Thread.sleep(5000);
			    Runtime.getRuntime().exec("AutoIT\\Download.exe");
			    Thread.sleep(10000);
			     FileStatus=Basic.Verify_existFile("Path",ReportName);
			    if(FileStatus==true)
					 test.pass("Export XML successfully");
					else
					 test.fail("Export XML unsuccessfully");
			    
	    	   }
	     else if(Format.equals("CSV")) {
			    Basic.Delete_existFile("Path",ReportName);
			    Basic.Click("Download_Report");
			    Thread.sleep(5000);
			    
			    Basic.Click("Download_CSV");
			    Thread.sleep(10000);
			    
			    Runtime.getRuntime().exec("AutoIT\\Download.exe");
			    
			     FileStatus=Basic.Verify_existFile("Path",ReportName);
			    if(FileStatus==true)
					 test.pass("Export CSV successfully");
					else
					 test.fail("Export CSV unsuccessfully");
	    	   }
	    else if(Format.equals("PDF")) {
			    
			    Basic.Delete_existFile("Path",ReportName);
			    Basic.Click("Download_Report");
			    Thread.sleep(5000);
			    
			    Basic.Click("Download_PDF");
			    Thread.sleep(10000);
			    
			    Runtime.getRuntime().exec("AutoIT\\Download.exe");
			    
			     FileStatus=Basic.Verify_existFile("Path",ReportName);
			    if(FileStatus==true)
					 test.pass("Export PDF successfully");
					else
					 test.fail("Export PDF unsuccessfully");
	    	   }
	    else if(Format.equals("MHTML")) {
			    Basic.Delete_existFile("Path",ReportName);
			    Basic.Click("Download_Report");
			    Thread.sleep(5000);
			    
			    Basic.Click("Download_MHTML");
			    Thread.sleep(10000);
			    
			    Runtime.getRuntime().exec("AutoIT\\Download.exe");
			    
			     FileStatus=Basic.Verify_existFile("Path",ReportName);
			    if(FileStatus==true)
					 test.pass("Export MHTML successfully");
					else
					 test.fail("Export MHTML unsuccessfully");
	    	   }
	    else if(Format.equals("TIFF")) {
			    Basic.Delete_existFile("Path",ReportName);
			    Basic.Click("Download_Report");
			    Thread.sleep(5000);
			    
			    Basic.Click("Download_TIFF");
			    Thread.sleep(10000);
			    
			    Runtime.getRuntime().exec("AutoIT\\Download.exe");
			    
			     FileStatus=Basic.Verify_existFile("Path",ReportName);
			    if(FileStatus==true)
					 test.pass("Export TIFF successfully");
					else
					 test.fail("Export TIFF unsuccessfully");
	    	   }
	    else if(Format.equals("Word")) {
			    Basic.Delete_existFile("Path",ReportName);
			    Basic.Click("Download_Report");
			    Thread.sleep(5000);
			    
			    Basic.Click("Download_Word");
			    Thread.sleep(10000);
			    
			    Runtime.getRuntime().exec("AutoIT\\Download.exe");
			    
			     FileStatus=Basic.Verify_existFile("Path",ReportName);
			    if(FileStatus==true)
					 test.pass("Export Word successfully");
					else
					 test.fail("Export word unsuccessfully");
	    	   }
	       }
	
	   public void Explicit_Wait(String xpath) {
			WebDriverWait wait=new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}
	   
	   
}
