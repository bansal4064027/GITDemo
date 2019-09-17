Story: Account Creation
Meta:@AccountLevelStoy
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  
Scenario: BillHistory(Non Migrated)01 HALO R1.1_Bill History_TS01_Account overview screen with billing profile applet
Meta:@BillHistoryNonMigrated01
@FolderName BillHistoryNonMigrated01
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The Account ''
And Validate the BillingProfile status 'BillProfileActivestatus'
When Execute DBQurey 'BilligProfileStatus'
And Execute DBQurey 'BillingProfileUpdatestatus'
And Modify 'ModifyWithInstalledID' with Econfig Item 'ClickOnDoneButton'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPostpaid'
Then Perform Product Services line items validation for Owned product Services 'CheckForBillingColumnsinInactive'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPostpaid'
Then Perform Product Services line items validation for Owned product Services 'CheckForBillingColumnsinPostpaid'
Given Retrieve Account 'PrepaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPrepaid'
Then Perform Product Services line items validation for Owned product Services 'CheckForBillingColumnsinPrepaid'


Scenario: BillHistory(Non Migrated)02 HALO R1.1_Bill History_TS02_Billing profile applet in account overview screen with postpaid billing profile selected
Meta:@BillHistoryNonMigrated02
@FolderName BillHistoryNonMigrated02
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPostpaid'
Then Perform Product Services line items validation for Owned product Services 'CheckForBillingColumnsinPostpaid'


Scenario: BillHistory(Non Migrated)03 HALO R1.1_Bill History_TS03_Billing profile applet in account overview screen with prepaid billing profile selected
Meta:@BillHistoryNonMigrated03
@FolderName BillHistory(Non Migrated)03
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PrepaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPrepaid'


Scenario: BillHistory(Non Migrated)04 HALO R1.1_Bill History_TS04_Postpaid billing profile_View billing details_button
Meta:@BillHistoryNonMigrated04
@FolderName BillHistory(Non Migrated)04
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPostpaid'
Given Retrieve Account 'PrepaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPrepaid'


Scenario: BillHistory(Non Migrated)05 HALO R1.1_Bill History_TS05_Postpaid billing profile_View PDF button
Meta:@BillHistoryNonMigrated05
@FolderName BillHistory(Non Migrated)05
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
And Retrieve Account 'PostpaidConsumer'
Given Login To Putty 'BRMPutty1' in 'Env'
And Show All Purchase Products in the account ''
Given Generate First Bill
Given Generate Month End Invoice with Account 'AccountNo'
And Enter Docgen details 'DocgenReport'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPostpaid'


Scenario: BillHistory(Non Migrated)06 HALO R1.1_Bill History_TS06_Billing profile_Postpay Hyperlink
Meta:@BillHistoryNonMigrated06
@FolderName BillHistoryNonMigrated06
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPostpaid'
Then Perform Product Services line items validation for Owned product Services 'CheckForBillingColumnsinPostpaid'


Scenario: BillHistory(Non Migrated)07 HALO R1.1_Bill History_TS06_Billing profile_Postpay Hyperlink
Meta:@BillHistoryNonMigrated07
@FolderName BillHistoryNonMigrated07
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPostpaid'
Then Perform Product Services line items validation for Owned product Services 'DrillOnNameCheckForBiilingColumnsinPostpaid'


Scenario: BillHistoryNonMigrated08 HALO R1.1_Bill History_TS08_Billing profile_Postpay Hyperlink_Applet_Balance Summary
Meta:@BillHistoryNonMigrated08
@FolderName BillHistoryNonMigrated08
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
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPostpaid'
Then Perform Product Services line items validation for Owned product Services 'DrillOnNameCheckForBalanceSummaryinPostpaid'


Scenario: BillHistoryNonMigrated09 HALO R1.1_Bill History_TS09_Billing profile_Postpay Hyperlink_Applet_Previous Bills
Meta:@BillHistoryNonMigrated09
@FolderName BillHistoryNonMigrated09
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
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPostpaid'
Then Perform Product Services line items validation for Owned product Services 'DrillOnNameCheckForPreviousBillingColumnsinPostpaid'

Scenario: BillHistoryNonMigrated10 HALO R1.1_Bill History_TS10_Billing profile_Prepay Hyperlink
Meta:@BillHistoryNonMigrated10
@FolderName BillHistoryNonMigrated10
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPrepaid'

Scenario: BillHistory(Non Migrated)11 HALO R1.1_Bill History_TS10_Billing profile_Prepay Hyperlink
Meta:@BillHistoryNonMigrated11
@FolderName BillHistoryNonMigrated11
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PrepaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPrepaid'
Then Perform Product Services line items validation for Owned product Services 'CheckForBillingColumnsinPrepaid'

Scenario: BillHistory(Non Migrated)12 HALO R1.1_Bill History_TS10_Billing profile_Prepay Hyperlink
Meta:@BillHistoryNonMigrated12
@FolderName BillHistoryNonMigrated12
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PrepaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckViewBillingDetailsForPrepaid'
Then Perform Product Services line items validation for Owned product Services 'DrillOnNameCheckForBiilingColumnsinPrepaid'
Then Perform Product Services line items validation for Owned product Services 'CheckForProductServiceAppletinPrepaid'