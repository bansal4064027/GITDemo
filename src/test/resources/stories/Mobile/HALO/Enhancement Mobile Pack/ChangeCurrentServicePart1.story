Story: Change Current Service Part1 Mobile
Meta:@ChangeCurrentServicePart1Mobile
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  
Scenario: ChangeCurrentServicePart1_01 HALO R1.1_Change Current Service_Part1_TS01_Call Centre Agent Trigger Modify e-configurator journey from product & services overview 
Meta:@ChangeCurrentServicePart1_01
@FolderName ChangeCurrentServicePart1_01
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumerExcludingAllCallsIncomingOnlyBar'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'CustomiseRootProduct'
When Econfig Item 'AllCallsIncmgOnlyBarON'
And Compare Line Items 'AllCallsIncomingOnlyBarAdd'
And Order Details Capture in Order Summary page
And Confirm Order


Scenario: ChangeCurrentServicePart1_03 HALO R1.1_Change Current Service_Part1_TS03_Call Centre Agent Trigger Modify e-configurator journey from Account overview. 
Meta:@ChangeCurrentServicePart1_03
@FolderName ChangeCurrentServicePart1_03
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumerExcludingAllCallsIncomingOnlyBar'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Customise'
When Econfig Item 'AllCallsIncmgOnlyBarON'
And Compare Line Items 'AllCallsIncomingOnlyBarAdd'
And Order Details Capture in Order Summary page
And Confirm Order

Scenario: ChangeCurrentServicePart1_05 HALO R1.1_Change Current Service_Part1_TS09_Call Centre Agent Trigger Modify edit package journey from product & services overview. 
Meta:@ChangeCurrentServicePart1_05
@FolderName ChangeCurrentServicePart1_05
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Editpackage'
And Retrieve Promotion 'PostpaidPromotion4G'
And Customise 'PromotionAddOn' with AddOn Item 'Band7' in Enhancement
And Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI and Click Next
When Reserve Order in Order Summary page
When Perform payment with 'Cash' and Confirm Order

Scenario: ChangeCurrentServicePart1_06 HALO R1.1_Change Current Service_Part1_TS10_Call Centre Agent Trigger Modify edit package journey from Account overview. 
Meta:@ChangeCurrentServicePart1_06
@FolderName ChangeCurrentServicePart1_06
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Editpackage'
And Retrieve Promotion 'PostpaidPromotion4G'
And Customise 'PromotionAddOn' with AddOn Item 'Band7' in Enhancement
And Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI and Click Next
When Reserve Order in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: ChangeCurrentServicePart1_07 HALO R1.1_Change Current Service_Part1_TS13_Stolen Bar Added Modal 
Meta:@ChangeCurrentServicePart1_07
@FolderName ChangeCurrentServicePart1_07
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerExcludingStolenBar'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Customise'
When Econfig Item 'StolenOnE2'
And Compare Line Items 'StolenBarAdd'
And Order Details Capture in Order Summary page
And Confirm Order


Scenario: ChangeCurrentServicePart1_08 HALO R1.1_Change Current Service_Part1_TS14_Stolen Bar Removed Modal
Meta:@ChangeCurrentServicePart1_08
@FolderName ChangeCurrentServicePart1_08
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumerdd'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'StolenOnE2'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'SubmitForStolenBarAddJourney'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CustomiseNewMSISDN'
When Econfig Item 'StolenBarOff'
And Compare Line Items 'StolenBarDelete'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
And Confirm Order

Scenario: ChangeCurrentServicePart1_09 HALO R1.1_Change Current Service_Part1_TS15_User click Edit package menu item for the selected service which already has one or more pending orders from
Account overview – Owned Product & services applet 
Meta:@ChangeCurrentServicePart1_09
@FolderName ChangeCurrentServicePart1_09
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerPending'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'EditPackagePromotionValidation'
When Retrieve Promotion 'PostpaidPromotion4G'
And Customise 'PromotionAddOn' with AddOn Item 'Band7' in Enhancement
And Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI and Click Next
When Reserve Order in Order Summary page
When Perform payment with 'Cash' and Confirm Order

Scenario: ChangeCurrentServicePart1_10 HALO R1.1_Change Current Service_Part1_TS16_User click e-configurator menu item ifor the selected service which already has one or more pending orders from 
Product & services overview – Owned Product & services applet 
Meta:@ChangeCurrentServicePart1_10
@FolderName ChangeCurrentServicePart1_10
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerPending'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'CustomiseRootProduct'
When Econfig Item 'OBarOnE2'
And Compare Line Items 'OBarAdd'
And Order Details Capture in Order Summary page
And Confirm Order


Scenario: ChangeCurrentServicePart1_11 HALO R1.1_Change Current Service_Part1_TS17_Add_delete line items error 
Meta:@ChangeCurrentServicePart1_11
@FolderName ChangeCurrentServicePart1_11
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Customise'
When Econfig Item 'ClickOnDoneButton'
And Compare Line Items 'ValidatePopupAndCompareItemsScreen'

Scenario: ChangeCurrentServicePart1_12 HALO R1.1_Change Current Service_Part1_TS18_Insufficient Permission Level_Perform Modify Journey 
Meta:@ChangeCurrentServicePart1_12
@FolderName ChangeCurrentServicePart1_12
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContactforStoreCollection'
When Search The OUI Account 'GoToAccountLinkforPermissionStoreCollection' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'CustomiseRootProduct'
When Econfig Item 'AllCallsIncmgOnlyBarON'
And Compare Line Items 'AllCallsIncomingOnlyBarAdd'
And Order Details Capture in Order Summary page
And Confirm Order

Scenario: ChangeCurrentServicePart1_13 HALO R1.1_Change Current Service_Part1_TS19_Insufficient Permission Level - Perform Modify Journey to Add Stolen Bar 
Meta:@ChangeCurrentServicePart1_13
@FolderName ChangeCurrentServicePart1_13
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContactforStoreCollection'
When Search The OUI Account 'GoToAccountLinkforPermissionStoreCollection' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'CustomiseRootProduct'
When Econfig Item 'StolenOnE2'
And Compare Line Items 'StolenBarAdd'
And Order Details Capture in Order Summary page
And Confirm Order


Scenario: ChangeCurrentServicePart1_15 HALO R1.1_Change Current Service_Part1_TS21_SIM activities insufficient permission level pop-up 
Meta:@ChangeCurrentServicePart1_15
@FolderName ChangeCurrentServicePart1_15
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContactforStoreCollection'
When Search The OUI Account 'GoToAccountLinkforPermissionStoreCollection' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'SIMActivitiesInsufficientFund'


Scenario: ChangeCurrentServicePart1_14 HALO R1.1_Change Current Service_Part1_TS20_SIM activities under menu item
Meta:@ChangeCurrentServicePart1_14
@FolderName ChangeCurrentServicePart1_14
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ValidateSIMActivitiesOptionPresentForViews'

Scenario: ChangeCurrentServicePart1_17 HALO R1.1_Change Current Service_Part1_TS31_Everything else
Meta:@ChangeCurrentServicePart1_17
@FolderName ChangeCurrentServicePart1_17
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddOtherUnderEverythingElse' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterServiceID' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order

Scenario: ChangeCurrentServicePart1_18 HALO R1.1_Change Current Service_Part1_TS32_Products in the ‘Everything else’ tab can be purchased as a standalone product order.
Meta:@ChangeCurrentServicePart1_18
@FolderName ChangeCurrentServicePart1_18
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddOtherUnderEverythingElse' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterServiceID' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddAccessory' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterServiceID' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: ChangeCurrentServicePart1_19 HALO R1.1_Change Current Service_Part1_TS33_Filter section for the Everything else
Meta:@ChangeCurrentServicePart1_19
@FolderName ChangeCurrentServicePart1_19
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddEverythingElseForApplyFilterDisabled' in OUI

Scenario: ChangeCurrentServicePart1_20  HALO R1.1_Change Current Service_Part1_TS34_Search results of Billing section in Everything else tab in Add product & services
Meta:@ChangeCurrentServicePart1_20
@FolderName ChangeCurrentServicePart1_20
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'Itemisedpaperbillcharge' for 'AddEverythingElseForApplyFilterDisabledforBilling' in OUI
And Update Promotion 'Itemisedpaperbillcharge' for 'AddEverythingElseForSortByDisabledforBilling' in OUI
And Update Promotion 'Itemisedpaperbillcharge' for 'AddAnyBillingItem' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: ChangeCurrentServicePart1_21  HALO R1.1_Change Current Service_Part1_TS35_Other Tab
Meta:@ChangeCurrentServicePart1_21
@FolderName ChangeCurrentServicePart1_21
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddEverythingElseForApplyFilterDisabled' in OUI
And Update Promotion 'PostpaidPromotion4G' for 'AddEverythingElseForSortByDisabled' in OUI
And Update Promotion 'PostpaidPromotion4G' for 'AddEverythingElseForHandsetNotFound' in OUI



Scenario: ChangeCurrentServicePart1_22 HALO R1.1_Change Current Service_Part1_TS38_View and add account level billing products to an account i.e. itemised bill charge etc. 
Meta:@ChangeCurrentServicePart1_22
@FolderName ChangeCurrentServicePart1_22
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'Itemisedpaperbillcharge' for 'AddAnyBillingItem' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order

Scenario: ChangeCurrentServicePart1_24 HALO R1.1_Change Current Service_Part1_TS37_Journey Navigation - Progress Bar
Meta:@ChangeCurrentServicePart1_24
@FolderName ChangeCurrentServicePart1_24
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Navigate to Product Services Page


Scenario: ChangeCurrentServicePart1_25 HALO R1.1_Change Current Service_Part1_TS06_Retail Agent Trigger Modify e-configurator journey from Account overview.
Meta:@ChangeCurrentServicePart1_25
@FolderName ChangeCurrentServicePart1_25
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumerExcludingAllCallsIncomingOnlyBar'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Customise'
When Econfig Item 'AllCallsIncmgOnlyBarON'
And Compare Line Items 'AllCallsIncomingOnlyBarAdd'
And Order Details Capture in Order Summary page
And Confirm Order

Scenario: ChangeCurrentServicePart1_26 HALO R1.1_Change Current Service_Part1_TS12_Retail Agent Trigger Modify edit package journey from Account overview.
Meta:@ChangeCurrentServicePart1_26
@FolderName ChangeCurrentServicePart1_26
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Editpackage'
And Retrieve Promotion 'PostpaidPromotion4G'
And Customise 'PromotionAddOn' with AddOn Item 'Band8' in Enhancement
And Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI and Click Next
When Reserve Order in Order Summary page
When Perform payment with 'Cash' and Confirm Order

Scenario: ChangeCurrentServicePart1_28 HALO R1.1_Change Current Service_Part1_TS29_Supply & Activate SIM journey via Call Centre
Meta:@ChangeCurrentServicePart1_28
@FolderName ChangeCurrentServicePart1_28
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'SIMActivate'
When Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
And Confirm Order

Scenario: ChangeCurrentServicePart1_29 HALO R1.1_Change Current Service_Part1_TS28_Supply & Activate SIM journey via Retail
Meta:@ChangeCurrentServicePart1_29
@FolderName ChangeCurrentServicePart1_29
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
And Retrieve ICCID
Then Select Action from Product&Services Overview for 'SIMSupplyAndActivate'
When Compare Line Items 'BlankWhiteTripleFormatSIMAdd'
When Perform Fulfilment Status With 'NoShipping'
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


Scenario: ChangeAccountDetails01 HALO R2.0_Sprint 31_Change Account Details_TS03_Navigate to Account Details SOU-5958 Customer Comm - Account Overview - Drill-down to Account Name - Account details
Meta:@ChangeAccountDetails01
@FolderName ChangeAccountDetails01
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLinkAndDrillDownAccountName' ''

Scenario: ChangeAccountDetails02 HALO R2.0_Sprint 31_Change Account Details_TS06_Account details - Account created by and Customer value
Meta:@ChangeAccountDetails02
@FolderName ChangeAccountDetails02
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLinkAndCheckCustomerValue' ''

Scenario: ChangeAccountDetails04 HALO R2.0_Sprint 31_Change Account Details_TS14_Account Details - Business Details Business or Sole Trader SOU-5940.
Meta:@ChangeAccountDetails04
@FolderName ChangeAccountDetails04
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidSmallBusiness'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'CheckAccountManager' ''

Scenario:  ChangeCurrentServicePartT1_25 HALO R1.1_Change Current Service_Part1_TS25_Activate SIM journey via Call Centre
Meta:@ChangeCurrentServicePartT1_25
@FolderName 
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
And Retrieve ICCID
Then Select Action from Product&Services Overview for 'SIMActivate'
When Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
And Confirm Order

Scenario: ChangeCurrentServicePartT1_23 HALO R1.1_Change Current Service_Part1_TS23_Dispatch SIM journey via Call Centre
Meta:@ChangeCurrentServicePartT1_23
@FolderName 
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
And Retrieve ICCID
Then Select Action from Product&Services Overview for 'SIMDispatch'
When Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'CollectFromStoreStock'
And Order Details Capture in Order Summary page
And Confirm Order

