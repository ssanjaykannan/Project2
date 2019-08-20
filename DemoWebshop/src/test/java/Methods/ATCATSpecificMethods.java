package Methods;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Methods.Navigation;

public class ATCATSpecificMethods extends Basic {
	
	public static Navigation navigationObj=new Navigation();
	public static ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("Extent Report//TestExtent.html");
	public static ExtentReports extent = new ExtentReports();
	public static String Report;
	
	public void login(String ReportName) throws Exception {
		extent.attachReporter(htmlReport);
		Report=ReportName;
		ExtentTest test = extent.createTest("Login", "Execution Report of "+Report);
		 driver.manage().timeouts().implicitlyWait(Imp_Time,TimeUnit.SECONDS);
		 try {
			Basic.Type("ATCAT_Username","Username");
			Thread.sleep(1000);
			Basic.Type("ATCAT_Password","Password");
			Thread.sleep(1000);
			Basic.Type("ATCAT_Domain","Domain");
			Thread.sleep(1000);
			Basic.Click("ATCAT_Sign");
			Thread.sleep(2000);
			test.pass("Login Successful");
			Thread.sleep(5000);
			String Content=driver.findElement(By.xpath("//TD[@id='_ctl0_ctlHeaderTab_TabControlsCell']/TABLE/TBODY/TR/TD[11]")).getText();
			test.info("ATCAT Login Info"+Content);
			System.out.println("ATCAT Login Info"+Content);
		}
		catch (Exception e) {
			test.fail("Login Unsuccessful");
			test.error(e);
		}
		finally {
			extent.flush();
		}
	}
		 
		 
		 public void Switch_to_client(String client) throws Exception {
				extent.attachReporter(htmlReport);
				ExtentTest test = extent.createTest("Switch to client", "Execution Report of "+Report);
				driver.manage().timeouts().implicitlyWait(Imp_Time,TimeUnit.SECONDS);
			    try { 
			    	Thread.sleep(5000);
				    Basic.Click("Switch_login");
					Thread.sleep(5000);
			        Basic.Click("Switch_to_client");
			        Thread.sleep(5000);
					Basic.Access_dropdown("Client_dropdown", client);
					Thread.sleep(5000);
					Basic.Click("Switch_and_close");
				    Thread.sleep(10000);
				 

				    
				    String Content=driver.findElement(By.xpath("//TD[@id='_ctl0_ctlHeaderTab_TabControlsCell']/TABLE/TBODY/TR/TD[14]")).getText();
					   System.out.println(Content);
					   
					   test.pass("Switch to Client Successful");
			    }
			    catch (Exception e) {
					test.error(e);
				}
			finally {
				extent.flush();
			}
		 
	}
	
	
		 public void Auditor_Productivity_Detailed_ActionReport(String ReportName, String StartDate, String EndDate,String Format) throws Exception {
				extent.attachReporter(htmlReport);
				ExtentTest test = extent.createTest("Auditor_Productivity_Detailed_ActionReport", "Execution Report of "+Report);
				driver.manage().timeouts().implicitlyWait(Imp_Time,TimeUnit.SECONDS);
				try {
					
					Open_Report(ReportName);
				    Basic.Type_Content("Start_Date",StartDate);
				  
				    Basic.Type_Content("End_Date",EndDate);
				 
				    Basic.Click("View_Report");
			        Thread.sleep(10000);
			        Save_Report("Auditor Productivity Detailed Action Report",ReportName, test,Format);
				}
				
				catch (Exception e) {
					navigationObj.switchWindows_close();
					test.error(e);
				}
			finally {
				extent.flush();
			}
				
				
			}
		 
		 
		 public void Auditor_Productivity_Report (String ReportName, String ProcessingEndDate,String Format) throws Exception
		 {
		 	extent.attachReporter(htmlReport);
		 	ExtentTest test = extent.createTest("Auditor_Productivity_Report", "Execution Report of "+Report);
		 	driver.manage().timeouts().implicitlyWait(Imp_Time,TimeUnit.SECONDS);
		 	
		 	try {
		 		Open_Report(ReportName);
		 	    Basic.Type_Content("Processing_End_Date",ProcessingEndDate);
		 	 
		 	    Basic.Click("View_Report");
		         Thread.sleep(10000);

		         test.pass("Report displayed successfully");
		         
		         String image=TakeScreenshot();
		         test.addScreenCaptureFromPath(image);
		         Basic.Download_Skeleton(test, ReportName, Format);

		         navigationObj.switchWindows_close();
		 		}

		 	catch (Exception e) {
		 		navigationObj.switchWindows_close();
		 		test.error(e);
		 	}
		 finally {
		 	extent.flush();
		 }
		 }
		 
		 
		 public void Exception_Matrix_By_User_Report(String ReportName, String Format) throws Exception
		 {
		 	extent.attachReporter(htmlReport);
		 	ExtentTest test = extent.createTest("Exception_Matrix_By_User_Report", "Execution Report of "+Report);
		 	driver.manage().timeouts().implicitlyWait(Imp_Time,TimeUnit.SECONDS);
		 	
		 	try {
		 		Open_Report(ReportName);
		 	 
		         Thread.sleep(10000);
		            
		         test.pass("Report displayed successfully");
		        
		     	String image=TakeScreenshot();
		         test.addScreenCaptureFromPath(image);

		          Basic.Download_Skeleton(test, ReportName, Format);

		           navigationObj.switchWindows_close();

		       
		 		  		}

		 	catch (Exception e) {
		 		navigationObj.switchWindows_close();
		 		test.error(e);
		 	}
		 finally {
		 	extent.flush();
		 }
		 }

		 
		 public void Payment_volume_and_Value_by_payment_year_report(String ReportName, String Payment_Expand_All,String Format) throws Exception
		 {
		 	extent.attachReporter(htmlReport);
		 	ExtentTest test = extent.createTest("Payment_volume_and_Value_by_payment_year_report", "Execution Report of "+Report);
		 	driver.manage().timeouts().implicitlyWait(Imp_Time,TimeUnit.SECONDS);
		 	
		 	try {
		 		Open_Report(ReportName);
		 		Basic.Access_dropdown("Payment_Expand_All", Payment_Expand_All);
		 		Basic.Click("View_Report");
		         Thread.sleep(10000);
		         Save_Report("Payment Volume and Value by Payment Year",ReportName,test,Format);
		 		  		}

		 	catch (Exception e) {
		 		navigationObj.switchWindows_close();
		 		test.error(e);
		 	}
		 finally {
		 	extent.flush();
		 }
		 }

		 public void Stratification_of_invoice_value_by_year_Report(String ReportName, String Stratification_Expand_All,String Format) throws Exception
		 {
		 	extent.attachReporter(htmlReport);
		 	ExtentTest test = extent.createTest("Stratification_of_invoice_value_by_year_Report", "Execution Report of "+Report);
		 	driver.manage().timeouts().implicitlyWait(Imp_Time,TimeUnit.SECONDS);
		 	
		 	try {
		 		Open_Report(ReportName);
		 		Basic.Access_dropdown("Stratification_Expand_All", Stratification_Expand_All);
		 		Basic.Click("View_Report");
		         Thread.sleep(10000);
		         Save_Report("Stratification of Invoice Value by Year",ReportName,test,Format);
		 		  		}

		 	catch (Exception e) {
		 		navigationObj.switchWindows_close();
		 		test.error(e);
		 	}
		 finally {
		 	extent.flush();
		 }
		 }

		 public void Top_Ten_Suppliers_By_Average_Invoice_Value_Report(String ReportName, String Avg_Inv_expand_All,String Format) throws Exception
		 {
		 	extent.attachReporter(htmlReport);
		 	ExtentTest test = extent.createTest("Top_Ten_Suppliers_By_Average_Invoice_Value_Report", "Execution Report of "+Report);
		 	driver.manage().timeouts().implicitlyWait(Imp_Time,TimeUnit.SECONDS);
		 	
		 	try {
		 		Open_Report(ReportName);
		 		Basic.Access_dropdown("Avg_Inv_expand_All",Avg_Inv_expand_All);
		 		Thread.sleep(1000);
		 		Basic.Click("View_Report");
		         Thread.sleep(10000);
		         Save_Report("Top 10 Suppliers By Average Invoice Value",ReportName,test,Format); 
		 		  		}

		 	catch (Exception e) {
		 		navigationObj.switchWindows_close();
		 		test.error(e);
		 	}
		 finally {
		 	extent.flush();
		 }
		 }

		 public void Top_Ten_Suppliers_By_Invoice_Value_Report(String ReportName,String StartDate, String EndDate,String By_Inv_Expand_All,String Format) throws Exception
		 {
		 	extent.attachReporter(htmlReport);
		 	ExtentTest test = extent.createTest("Top_Ten_Suppliers_By_Invoice_Value_Report", "Execution Report of "+Report);
		 	driver.manage().timeouts().implicitlyWait(Imp_Time,TimeUnit.SECONDS);
		 	
		 	try {
		 		Open_Report(ReportName);
		 		Basic.Type_Content("Start_Date",StartDate);
		 	    Thread.sleep(2000);
		 	    Basic.Type_Content("End_Date",EndDate);
		 	    Thread.sleep(2000);
		 	    Basic.Access_dropdown("By_Inv_Expand_All", By_Inv_Expand_All);
		 		Basic.Click("View_Report");
		         Thread.sleep(10000);
		         Save_Report("Top 10 Suppliers By Invoice Value",ReportName,test,Format);
		 		  		}

		 	catch (Exception e) {
		 		navigationObj.switchWindows_close();
		 		test.error(e);
		 	}
		 finally {
		 	extent.flush();
		 }
		 }

		 public void Top_Ten_Suppliers_By_Invoice_Volume_Report(String ReportName, String StartDate, String EndDate,String Format) throws Exception
		 {
		 	extent.attachReporter(htmlReport);
		 	ExtentTest test = extent.createTest("Top_Ten_Suppliers_By_Invoice_Volume_Report", "Execution Report of "+Report);
		 	driver.manage().timeouts().implicitlyWait(Imp_Time,TimeUnit.SECONDS);
		 	
		 	try {
		 		Open_Report(ReportName);
		 		Basic.Type_Content("Start_Date",StartDate);
		 	    Thread.sleep(5000);
		 	    Basic.Type_Content("End_Date",EndDate);
		 		Basic.Click("View_Report");
		         Thread.sleep(10000);
		         Save_Report("Top 10 Suppliers by Invoice Volume",ReportName,test,Format);
		 		 }

		 	catch (Exception e) {
		 		navigationObj.switchWindows_close();
		 		test.error(e);
		 	}
		 finally {
		 	extent.flush();
		 }
		 }


		 public void Top_Ten_Suppliers_With_Large_Volumes_of_Low_Value_Invoices_Report(String ReportName, String StartDate, String EndDate, String Format) throws Exception
		 {
		 	extent.attachReporter(htmlReport);
		 	ExtentTest test = extent.createTest("Top_Ten_Suppliers_With_Large_Volumes_of_Low_Value_Invoices_Report", "Execution Report of "+Report);
		 	driver.manage().timeouts().implicitlyWait(Imp_Time,TimeUnit.SECONDS);
		 	
		 	try {
		 		Open_Report(ReportName);
		 		Basic.Type_Content("Start_Date",StartDate);
		 	    Thread.sleep(5000);
		 	    Basic.Type_Content("End_Date",EndDate);
		 		Basic.Click("View_Report");
		         Thread.sleep(10000);
		         Save_Report("Top 10 Suppliers with large volumes of low value invoices",ReportName, test,Format);
		 		  		}

		 	catch (Exception e) {
		 		navigationObj.switchWindows_close();
		 		test.error(e);
		 	}
		 finally {
		 	extent.flush();
		 }
		 }

		 public void Transaction_Volume_and_Invoice_Value_by_month_and_year_Report(String ReportName, String StartDate, String EndDate, String Format) throws Exception
		 {
		 	extent.attachReporter(htmlReport);
		 	ExtentTest test = extent.createTest("Transaction_Volume_and_Invoice_Value_by_month_and_year_Report", "Execution Report of "+Report);
		 	driver.manage().timeouts().implicitlyWait(Imp_Time,TimeUnit.SECONDS);
		 	
		 	try {
		 		Open_Report(ReportName);
		 	
		 		Basic.Type_Content("Start_Date",StartDate);
		 	    Thread.sleep(5000);
		 	    Basic.Type_Content("End_Date",EndDate);
		 		Basic.Click("View_Report");
		         Thread.sleep(10000);
		         Save_Report("Transaction Volume and Invoice Value by Month and Year",ReportName, test,Format);
		         
		 		  		}

		 	catch (Exception e) {
		 		navigationObj.switchWindows_close();
		 		test.error(e);
		 	}
		 finally {
		 	extent.flush();
		 }
		 }

		 public void Open_Report(String ReportName) throws Exception
		 {
		 		String Pages=driver.findElement(By.xpath("//TABLE[@id='_ctl0_ContentPlaceHolderMain__ctl0_dgReportListing_pageBarGrid']/TBODY/TR/TD[2]/SPAN[3]")).getText();
		 		int value = Integer.parseInt(Pages.replaceAll("[^0-9]", ""));
		 		System.out.println("Number of pages"+value);
		 		
		 		int TableCount=0;
		 		int i=0;
		 		int Count=0;
		 		
		 		 List<WebElement> Table=driver.findElements(By.xpath("//*[@id='G_xctl0xContentPlaceHolderMainxxctl0xdgReportListingxdgInnerGrid']/tbody/tr"));
		 		 
		 		   for (WebElement e : Table) {
		 				TableCount = Table.size();
		 			}
		 		   System.out.println("Table Row"+TableCount);
		 		
		 		   for(i=1;i<=TableCount;i++) 
		 		   {
		 				String Content=driver.findElement(By.xpath("//*[@id='G_xctl0xContentPlaceHolderMainxxctl0xdgReportListingxdgInnerGrid']/tbody/tr["+i+"]/td[1]/nobr/a")).getText();
		 				if((Content.equals(ReportName)))
		 				{
		 				Count=Count+1;
		 				System.out.println("Match Found");
		 				break;	
		 				}
		 			}
		 		   
		 			 if(Count==0) {
		 				 for(int n=1;n<=value;n++) {
		 						String Pagecount=String.valueOf(n);
		 						Thread.sleep(1000);
		 						Basic.Clear("Report_pagination_Input");
		 						Thread.sleep(1000);
		 						Basic.Type_Content("Report_pagination_Input",Pagecount);
		 						Thread.sleep(1000);
		 						Basic.Click("Report_Pagination_Go");
		 						Thread.sleep(2000);

		 				 Table=driver.findElements(By.xpath("//*[@id='G_xctl0xContentPlaceHolderMainxxctl0xdgReportListingxdgInnerGrid']/tbody/tr"));
		 					  
		 					   for (WebElement e : Table) {
		 							TableCount = Table.size();
		 						}
		 					   System.out.println("Table Row"+TableCount);
		 					   
		 			   for(i=1;i<=TableCount;i++) 
		 			   {
		 					String Content=driver.findElement(By.xpath("//*[@id='G_xctl0xContentPlaceHolderMainxxctl0xdgReportListingxdgInnerGrid']/tbody/tr["+i+"]/td[1]/nobr/a")).getText();
		 					if((Content.equals(ReportName)))
		 					{
		 					Count=Count+1;
		 					System.out.println("Match Found");
		 					break;	
		 					}
		 				}
		 			   if(Count==1) {
		 					break;
		 				}
		 			  } 
		 			}
		 		
		 		if(Count==1) {
		 	    driver.findElement(By.xpath("//*[@id='G_xctl0xContentPlaceHolderMainxxctl0xdgReportListingxdgInnerGrid']/tbody/tr["+i+"]/td[1]/nobr/a")).click();
		 	
		 	    Thread.sleep(10000);
		 	    navigationObj.switchWindows_Reports();
		 	    Thread.sleep(5000);
		 		}
		 }
		
		 
		 public void Save_Report(String ReportName,String Report,ExtentTest test,String Format) throws Exception
		 {
		 	
		 	String image=TakeScreenshot();
		     test.addScreenCaptureFromPath(image);
		    
		     Boolean Status=driver.findElement(By.xpath("//td[contains(text(),'"+ReportName+"')] ")).isDisplayed();
		     
		     if(Status==true){
		     	test.pass("Report displayed successfully");
		     }
		     else {
		     	test.fail("Report displayed Unsuccessfully");
		     }
		     
		       Basic.Download_Skeleton(test, Report, Format);
		       navigationObj.switchWindows_close();
		 	   
		 }
		 
		 public String TakeScreenshot() throws Exception {
				String destination="Fail";
				try {
				String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
			    destination = System.getProperty("user.dir") + "\\ExtentReportScreenshots\\"+"Proof"+dateName+".png";
			    File finalDestination = new File(destination);
			    FileUtils.copyFile(source, finalDestination);
			    return destination;
				}
				catch (Exception e) {
					System.out.println(e);
					return destination;
				}
				
			     }
		
}
