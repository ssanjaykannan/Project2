Feature: DataAnalysis

  Scenario: Login to the application
    Given Launch the Application
    Then Enter Username Password and Sign IN "DataAnalysis_Report1"

  Scenario: Switch to Client
    Given Switch to Client "WTW_Test"

  Scenario: DataAnalysis_Report
    Given Navigate to Reports List
    Then Validate Report "(MgmtRpt) Auditor Productivity Detailed Action Report" StartDate "1/01/2019" EndDate "3/30/2019" ReportFormat "XML"
    Then Validate Auditor Productivity Report "(MgmtRpt) Auditor Productivity Report" ProcessingEndDate "3/30/2019" ReportFormat "XML"
    Then Validate Exception Matrix By User Report "(MgmtRpt) Exception Matrix By User" ReportFormat "XML"
    Then Validate Payment Volume and Value by Payment Year Report "(MgmtRpt) Payment Volume and Value by Payment Year" ExpandAll "All" ReportFormat "XML"
    Then Validate Stratification of Invoice Value by Year Report "(MgmtRpt) Stratification of Invoice Value by Year" ExpandAll "All" ReportFormat "XML"
    Then Validate Top Ten Suppliers By Average Invoice Value Report "(MgmtRpt) Top Ten Suppliers By Average Invoice Value" ExpandAll "All" ReportFormat "XML"
    Then Validate Top Ten Suppliers By Invoice Value Report "(MgmtRpt) Top Ten Suppliers By Invoice Value" StartDate "1/01/2019" EndDate "3/30/2019" ExpandAll "All" ReportFormat "XML"
    Then Validate Top Ten Suppliers By Invoice Volume Report "(MgmtRpt) Top Ten Suppliers By Invoice Volume" StartDate "1/01/2019" EndDate "3/30/2019" ReportFormat "XML"
    Then Validate Top Ten Suppliers With Large Volumes of Low Value Invoices Report "(MgmtRpt) Top Ten Suppliers With Large Volumes of Low Value Invoices" StartDate "1/01/2019" EndDate "3/30/2019" ReportFormat "XML"
    Then Validate Transaction Volume and Invoice Value by month and year Report "(MgmtRpt) Transaction Volume and Invoice Value by month and year" StartDate "12/1/2017" EndDate "1/5/2019" ReportFormat "XML"

  
