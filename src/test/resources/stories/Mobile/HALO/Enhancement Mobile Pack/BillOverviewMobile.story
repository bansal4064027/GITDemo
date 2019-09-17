Story: Bill Overview
Meta:@BillOverViewStory
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  

Scenario: BillOverviewNonMigrated01 HALO R1.1_Bill Overview_TS01_Bill Overview
Meta:@BillOverviewNonMigrated01
@FolderName BillOverviewNonMigrated01
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Perform Product Services line items validation for Owned product Services 'ValidateBillOverviewTabsAndApplet'



Scenario: BillOverviewNonMigrated02 HALO R1.1_Bill Overview_TS02_Currency field in Bill Overview or Bill details views
Meta:@BillOverviewNonMigrated02
@FolderName BillOverviewNonMigrated02
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
Given Login To Putty 'BRMPutty1' in 'Env'
And Show All Purchase Products in the account ''
Given Generate First Bill
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Execute BRM query 'CaptureBillBalance'
Then Perform Product Services line items validation for Owned product Services 'DrillOnNameCheckForPreviousBillingColumnsinPostpaid'


Scenario: BillOverviewNonMigrated03 HALO R1.1_Bill Overview_TS03_Service charges
Meta:@BillOverviewNonMigrated03
@FolderName BillOverviewNonMigrated03
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Perform 'DrillDownBillingProfileID' in Billing View
And Execute BRM query 'BillNumberCapture'
And Perform 'DrillDownLatestBillNo' in Previous Billing View
And Perform 'BillingDetailsValidation' in Billing Details View
And Perform 'ServicesAppletValidation' in Billing Details View
And Perform 'SummaryChargesValidation' in Billing Details View


Scenario: BillOverviewNonMigrated04 HALO R1.1_Bill Overview_TS04_Service charges_Billing details
Meta:@BillOverviewNonMigrated04
@FolderName BillOverviewNonMigrated04
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionNonVolte'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Given Login To Putty 'BRMPutty1' in 'Env'
And Show All Purchase Products in the account ''
Given Generate First Bill
When Execute BRM query 'RetrievpendbalanceCapture'
When Make Payment for 'AMOUNT0Other'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Perform 'DrillDownBillingProfileID' in Billing View
And Execute BRM query 'BillNumberCapture'
And Execute BRM query 'BillCreationDate'
And Perform 'DrillDownLatestBillNo' in Previous Billing View
And Perform 'BillingDetailsAppletValidation' in Billing Details View


Scenario: BillOverviewNonMigrated05 HALO R1.1_Bill Overview_TS05_Service charges_Services
Meta:@BillOverviewNonMigrated05
@FolderName BillOverviewNonMigrated05
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionNonVolte'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Given Login To Putty 'BRMPutty1' in 'Env'
And Show All Purchase Products in the account ''
Given Generate First Bill
When Execute BRM query 'RetrievpendbalanceCapture'
When Make Payment for 'AMOUNT0Other'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Perform 'DrillDownBillingProfileID' in Billing View
And Execute BRM query 'BillNumberCapture'
And Perform 'DrillDownLatestBillNo' in Previous Billing View
And Perform 'ServicesAppletTotalValidation' in Billing Details View


Scenario: BillOverviewNonMigrated06 HALO R1.1_Bill Overview_TS06_Service charges _Summary charges
Meta:@BillOverviewNonMigrated06
@FolderName BillOverviewNonMigrated06
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionNonVolte'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Given Login To Putty 'BRMPutty1' in 'Env'
And Show All Purchase Products in the account ''
Given Generate First Bill
When Execute BRM query 'RetrievpendbalanceCapture'
When Make Payment for 'AMOUNT0Other'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Perform 'DrillDownBillingProfileID' in Billing View
And Execute BRM query 'BillNumberCapture'
And Perform 'DrillDownLatestBillNo' in Previous Billing View
And Perform 'SummaryChargesTotalValidation' in Billing Details View



Scenario: BillOverviewNonMigrated16 HALO R1.1_Bill Overview_TS16_Drilldown on Cycle Forward
Meta:@BillOverviewNonMigrated16
@FolderName BillOverviewNonMigrated16
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Bill Details validation for 'CycleForwardPopupValidation'

Scenario: BillOverviewNonMigrated10 HALO R1.1_Bill Overview_TS10_Payments against selected bill_Retail
Meta:@BillOverviewNonMigrated10
@FolderName BillOverviewNonMigrated10
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login To Putty 'BRMPutty1' in 'Env'
And Show All Purchase Products in the account ''
Given Generate First Bill
Given Generate Month End Bill with Account 'AccountNo'
When Execute BRM query 'RetrievpendbalanceCapture'
When Make Payment for 'AMOUNT0Other'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Perform 'DrillDownBillingProfileID' in Billing View
And Execute BRM query 'BillNumberCapture'
And Perform 'DrillDownLatestBillNo' in Previous Billing View
And Perform 'CheckNewPaymentButtonEnabled' in Billing Details View
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Perform 'DrillDownBillingProfileID' in Billing View
And Execute BRM query 'BillNumberCapture'
And Perform 'DrillDownLatestBillNo' in Previous Billing View
And Perform 'CheckNewPaymentButtonDisabled' in Billing Details View

Scenario: BillOverviewNonMigrated12 HALO R1.1_Bill Overview_TS12_Bill Overview_Payments Applet_Amount
Meta:@BillOverviewNonMigrated12
@FolderName BillOverviewNonMigrated12
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login To Putty 'BRMPutty1' in 'Env'
And Show All Purchase Products in the account ''
Given Generate First Bill
Given Generate Month End Bill with Account 'AccountNo'
When Execute BRM query 'RetrievpendbalanceCapture'
When Make Payment for 'AMOUNT0Other'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Perform 'DrillDownBillingProfileID' in Billing View
And Execute BRM query 'BillNumberCapture'
And Perform 'DrillDownLatestBillNo' in Previous Billing View
And Perform 'CheckAmountColumninHaloPayments' in Billing Details View

Scenario: BillOverviewNonMigrated13 HALO R1.1_Bill Overview_TS13_Bill Overview Payments Applet_Sort code & Bank account
Meta:@BillOverviewNonMigrated13
@FolderName BillOverviewNonMigrated13
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerDirectDebit'
Given Login To Putty 'BRMPutty1' in 'Env'
And Show All Purchase Products in the account ''
Given Generate First Bill
Given Generate Month End Bill with Account 'AccountNo'
Given Generate Month End Invoice with Account 'AccountNo'
When Execute BRM query 'RetrievpendbalanceCapture'
When Make Payment for 'DDAccount'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Perform 'DrillDownBillingProfileID' in Billing View
And Execute BRM query 'BillNumberCapture'
And Perform 'DrillDownLatestBillNo' in Previous Billing View
And Perform 'CheckSortCodeBankAccinHaloPayments' in Billing Details View

Scenario: BillOverviewNonMigrated14 HALO R1.1_Bill Overview_TS14_Bill Overview Payments Applet_Allocated Value
Meta:@BillOverviewNonMigrated14
@FolderName BillOverviewNonMigrated14
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login To Putty 'BRMPutty1' in 'Env'
And Show All Purchase Products in the account ''
Given Generate First Bill
Given Generate Month End Bill with Account 'AccountNo'
When Execute BRM query 'RetrievpendbalanceCapture'
When Make Payment for 'AMOUNT0Other'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Perform 'DrillDownBillingProfileID' in Billing View
And Execute BRM query 'BillNumberCapture'
And Perform 'DrillDownLatestBillNo' in Previous Billing View
And Perform 'CheckAllocatedColumninHaloPayments' in Billing Details View