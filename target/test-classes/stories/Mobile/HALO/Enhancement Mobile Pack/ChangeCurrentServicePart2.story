Story: Change Current Service Part2 Mobile
Meta:@ChangeCurrentServicePart2
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account



Scenario: ChangeCurrentServicePart2_01 HALO R1.1_Change Current Service_Part2_TS13_Tariff Migration Change Plan Journey within product & services overview screen_Shippable item in the basket
Meta:@ChangeCurrentServicePart2_01
@FolderName ChangeCurrentServicePart2_01
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ChangePlan'
When Retrieve Promotion 'TarriffMigPostpaidPromotion4G'
And Update Promotion for 'ChangePlan'
And Compare Line Items 'PromotionAdd'
And Retrieve Promotion 'PostpaidPromotion4G'
And Compare Line Items 'PromotionDelete'
When Retrieve Promotion 'TarriffMigPostpaidPromotion4G'
And Customise 'PromotionAddOn' with AddOn Item 'BlnkWhiteTripleFrmtSim' in Enhancement
And Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID  in OUI and Click Next
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownNewMSISDN'
Then Perform Product Services line items validation for Owned product Services 'AllActive'
When Retrieve Promotion 'TarriffMigPostpaidPromotion4G'
Then Select Action from Product&Services Overview for 'PromotionActive'


Scenario: ChangeCurrentServicePart2_05 HALO R1.1_Change Current Service_Part2_TS18_Change plan option_Blocking error will be displayed If the service in context has pending order present
Meta:@ChangeCurrentServicePart2_05
@FolderName ChangeCurrentServicePart2_05
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerExcludingDataRoamingBar'
Given Login with 'TEST_RETAIL_1' in 'Env''
When Search The Account ''
And Modify 'ModifyWithInstalledID' with Econfig Item 'DataRoamingBarOn'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ChangePlanCancelValidation'


Scenario: ChangeCurrentServicePart2_06 HALO R1.1_Change Current Service_Part2_TS19_New control Restart as part of Change plan journey 
Meta:@ChangeCurrentServicePart2_06
@FolderName ChangeCurrentServicePart2_06
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env''
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ChangePlan'
When Retrieve Promotion 'PostpaidPromotion4G109161'
And Update Promotion for 'ChangePlan'
And Compare Line Items 'PromotionAdd'
And Retrieve Promotion 'PostpaidPromotion4G'
And Compare Line Items 'PromotionDelete'
And Perform activity 'RestartOrder' in Compare Line Items


Scenario: ChangeCurrentServicePart2_07 HALO R1.1_Change Current Service_Part2_TS20_Blacklist_Lost & Stolen Bar not present
Meta:@ChangeCurrentServicePart2_07
@FolderName ChangeCurrentServicePart2_07
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'IMEIhistory(Un)Blacklist'
When Compare Line Items 'BlacklistingAdd'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete

Scenario: ChangeCurrentServicePart2_17 HALO R1.1_Change Current Service_Part2_TS02_Port in Change number option_Insufficient permission level 
Meta:@ChangeCurrentServicePart2_17
@FolderName ChangeCurrentServicePart2_17
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'PortInNumberChange'
When Order Details Capture in Order Summary page
When Confirm Order

Scenario: ChangeCurrentServicePart2_18 HALO R1.1_Change Current Service_Part2_TS02_Port in Change number option_Insufficient permission level 
Meta:@ChangeCurrentServicePart2_18
@FolderName ChangeCurrentServicePart2_18
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContactforLevel2'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel2' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'PortInValidationforInsufficientFund'


Scenario: ChangeCurrentServicePart2_20 HALO R1.1_Change Current Service_Part2_TS04_Port in Change number should be blocked for the service which already has pending orders_Discard the Journey
Meta:@ChangeCurrentServicePart2_20
@FolderName ChangeCurrentServicePart2_20
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerExcludingDataRoamingBar'
Given Login with 'TEST_RETAIL_1' in 'Env''
When Search The Account ''
And Modify 'ModifyWithInstalledID' with Econfig Item 'DataRoamingBarOn'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'PortInValidationforPendingOrder'

Scenario: ChangeCurrentServicePart2_22 HALO R1.1_Change Current Service_Part2_TS06_Number Change order journey_Add administration fee 
Meta:@ChangeCurrentServicePart2_22
@FolderName ChangeCurrentServicePart2_22
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'PortInNumberChangeAddAdminFee'
When Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order

Scenario: ChangeCurrentServicePart2_23 HALO R1.1_Change Current Service_Part2_TS07_Number Change order journey_WIthout administration fee 
Meta:@ChangeCurrentServicePart2_23
@FolderName ChangeCurrentServicePart2_23
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'PortInNumberChange'
When Order Details Capture in Order Summary page
When Confirm Order

Scenario: ChangeCurrentServicePart2_24 HALO R1.1_Change Current Service_Part2_TS08_Number Change order journey_Generate new number button Not clicked and proceed to click on Next button in the basket_Blocking error should be displayed 
Meta:@ChangeCurrentServicePart2_24
@FolderName ChangeCurrentServicePart2_24
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'PortInNumberChangeGenerateNumNotClicked'
When Order Details Capture in Order Summary page
When Confirm Order

Scenario: ChangeCurrentServicePart2_25 HALO R1.1_Change Current Service_Part2_TS21_Blacklist_Lost & Stolen Bar is present
Meta:@ChangeCurrentServicePart2_25
@FolderName ChangeCurrentServicePart2_25
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The Account ''
And Modify 'ModifyWithInstalledIDFraudRiskPopUp' with Econfig Item 'StolenOnE2'
And Submit the Order 'SubmitForStolenBarAddJourney'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'IMEIhistory(Un)Blacklist'
When Compare Line Items 'BlacklistingAdd'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


Scenario: ChangeCurrentServicePart2_26 HALO R1.1_Change Current Service_Part2_TS31_‘Standard’ blacklists are open and can be Unblacklisted with no check.
Meta:@ChangeCurrentServicePart2_26
@FolderName ChangeCurrentServicePart2_26
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'IMEIhistory(Un)Blacklist'
When Compare Line Items 'BlacklistingAdd'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'CheckBlickListHistory'
Then Select Action from Product&Services Overview for 'UnblackListStandard'


Scenario: ChangeCurrentServicePart2_27 HALO R1.1_Change Current Service_Part2_TS32_‘FRS‘  Unblacklist are only allowed by the FRS agents_Everyone else raises an SR.
Meta:@ChangeCurrentServicePart2_27
@FolderName ChangeCurrentServicePart2_27
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'CheckBlickListHistory'
Then Select Action from Product&Services Overview for 'UnblackListFRSValidateSRScreen'

Scenario: NLFL03 HALO HALO_R2.1_NLFL_TS13_SOU-6403_Add product & services - PAYM mobile (SOU-6403)_Change plan and return device
Meta:@NLFL03
@FolderName NLFL03
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'FLYING' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'TarriffMigBulkModifyRedEntPlan111389' for 'AddDevicePlanForNLFLDeviceandPlan' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: NLFL04 HALO HALO_R2.1_NLFL_TS15_SOU-6403_Add product & services - PAYM mobile (SOU-6403)_Change plan and keep device
Meta:@NLFL04
@FolderName NLFL04
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL1' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandsetandInsuranceWithin16DaysCTR14'
When Search The Account ''
When Validate Contacts tab for 'EnterEmail'
When Update Email Account
Given Login with 'FLYING' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddPlanForNLFL' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Order Details Capture in Order Summary page
And Confirm Order


