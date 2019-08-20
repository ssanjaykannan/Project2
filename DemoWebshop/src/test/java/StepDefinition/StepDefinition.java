package StepDefinition;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Methods.ATCATSpecificMethods;
import Methods.Basic;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition extends Basic {
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");   
	public static  LocalDateTime now = LocalDateTime.now();
	public static ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("Extent Report//TestExtent"+dtf.format(now)+".html");
	public static ExtentReports extent = new ExtentReports();
	public static String ReportExtent;
	public static ATCATSpecificMethods Specific=new ATCATSpecificMethods();
	
	@Given("^Launch the Application$")
	public void launch_the_Application() throws Throwable {
		 Basic.LaunchURL();
	}
	
	@Then("^Enter Username Password and Sign IN \"([^\"]*)\"$")
	public void enter_Username_Password_and_Sign_IN(String ReportName) throws Throwable {
		Specific.login(ReportName);
		ReportExtent=ReportName;
	}
	
	@Given("^Switch to Client \"([^\"]*)\"$")
	public void switch_to_Client(String client) throws Throwable {
		Specific.Switch_to_client(client);
	}
	
	@Given("^Navigate to Reports List$")
	public void navigate_to_Reports_List() throws Throwable {
		Basic.Click("DataAnalysis_Home");
	    Thread.sleep(2000);
	    Basic.Click("Reports_Home");
	    Thread.sleep(2000);
	    Basic.Click("Reports_List");
	    Thread.sleep(5000);
	    Alert alert=driver.switchTo().alert();
	    alert.wait(Imp_Time);
		alert.accept();
		Thread.sleep(2000);
	}
	
	
	/***************************DataAnalysis_Report1*****************************/
	@Then("^Validate Report \"([^\"]*)\" StartDate \"([^\"]*)\" EndDate \"([^\"]*)\" ReportFormat \"([^\"]*)\"$")
	public void validate_Report_StartDate_EndDate_ReportFormat(String ReportName, String StartDate, String EndDate, String ReportFormat) throws Throwable {
		Specific.Auditor_Productivity_Detailed_ActionReport(ReportName, StartDate, EndDate,ReportFormat);
	}

	@Then("^Validate Auditor Productivity Report \"([^\"]*)\" ProcessingEndDate \"([^\"]*)\" ReportFormat \"([^\"]*)\"$")
	public void validate_Auditor_Productivity_Report(String ReportName, String ProcessingEndDate, String ReportFormat) throws Throwable {
		Specific.Auditor_Productivity_Report(ReportName, ProcessingEndDate, ReportFormat);
	}

	@Then("^Validate Exception Matrix By User Report \"([^\"]*)\" ReportFormat \"([^\"]*)\"$")
	public void validate_Exception_Matrix_By_User_Report(String ReportName, String ReportFormat) throws Throwable {
		Specific.Exception_Matrix_By_User_Report(ReportName, ReportFormat);
	}

	@Then("^Validate Payment Volume and Value by Payment Year Report \"([^\"]*)\" ExpandAll \"([^\"]*)\" ReportFormat \"([^\"]*)\"$")
	public void validate_Payment_volume_and_Value_by_payment_year_report(String ReportName, String ExpandAll, String ReportFormat) throws Throwable {
		Specific.Payment_volume_and_Value_by_payment_year_report(ReportName, ExpandAll, ReportFormat);
	}

	@Then("^Validate Stratification of Invoice Value by Year Report \"([^\"]*)\" ExpandAll \"([^\"]*)\" ReportFormat \"([^\"]*)\"$")
	public void Stratification_of_invoice_value_by_year_Report(String ReportName, String ProcessingEndDate, String ReportFormat) throws Throwable {
		Specific.Stratification_of_invoice_value_by_year_Report(ReportName, ProcessingEndDate, ReportFormat);
	}

	@Then("^Validate Top Ten Suppliers By Average Invoice Value Report \"([^\"]*)\" ExpandAll \"([^\"]*)\" ReportFormat \"([^\"]*)\"$")
	public void Top_Ten_Suppliers_By_Average_Invoice_Value_Report(String ReportName, String ProcessingEndDate, String ReportFormat) throws Throwable {
		Specific.Top_Ten_Suppliers_By_Average_Invoice_Value_Report(ReportName, ProcessingEndDate, ReportFormat);
	}

	@Then("^Validate Top Ten Suppliers By Invoice Value Report \"([^\"]*)\" StartDate \"([^\"]*)\" EndDate \"([^\"]*)\" ExpandAll \"([^\"]*)\" ReportFormat \"([^\"]*)\"$")
	public void Top_Ten_Suppliers_By_Invoice_Value_Report(String ReportName,String StartDate, String EndDate, String ExpandAll, String ReportFormat) throws Throwable {
		Specific.Top_Ten_Suppliers_By_Invoice_Value_Report(ReportName, StartDate, EndDate, ExpandAll, ReportFormat);
	}

	@Then("^Validate Top Ten Suppliers By Invoice Volume Report \"([^\"]*)\" StartDate \"([^\"]*)\" EndDate \"([^\"]*)\" ReportFormat \"([^\"]*)\"$")
	public void Top_Ten_Suppliers_By_Invoice_Volume_Report(String ReportName, String StartDate, String EndDate, String ReportFormat) throws Throwable {
		Specific.Top_Ten_Suppliers_By_Invoice_Volume_Report(ReportName,  StartDate, EndDate, ReportFormat);
	}

	@Then("^Validate Top Ten Suppliers With Large Volumes of Low Value Invoices Report \"([^\"]*)\" StartDate \"([^\"]*)\" EndDate \"([^\"]*)\" ReportFormat \"([^\"]*)\"$")
	public void Top_Ten_Suppliers_With_Large_Volumes_of_Low_Value_Invoices_Report(String ReportName, String StartDate, String EndDate, String ReportFormat) throws Throwable {
		Specific.Top_Ten_Suppliers_With_Large_Volumes_of_Low_Value_Invoices_Report(ReportName, StartDate, EndDate, ReportFormat);
	}

	@Then("^Validate Transaction Volume and Invoice Value by month and year Report \"([^\"]*)\" StartDate \"([^\"]*)\" EndDate \"([^\"]*)\" ReportFormat \"([^\"]*)\"$")
	public void Transaction_Volume_and_Invoice_Value_by_month_and_year_Report(String ReportName, String StartDate, String EndDate, String ReportFormat) throws Throwable {
		Specific.Transaction_Volume_and_Invoice_Value_by_month_and_year_Report(ReportName, StartDate, EndDate, ReportFormat);
	}

/***************************Report 1 End******************************************************************************************/	
}
