Story:EnhLFL Story
Meta:
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  
  
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

Scenario:EnhNLFL01 [1]HALO_R2.1_NLFL_PAYG_TS26_SOU-7222_NLFL Exchange - E2E Order (SOU-7222)-Retail From Account Overview Page
Meta:@EnhNLFL01
@FolderName EnhNLFL01
@Ranju
Given Login with 'RETAIL1' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The Account ''
When Validate Contacts tab for 'EnterEmail'
When Update Email Account
Given Login with 'FLYING' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddPlanForNLFL' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
And Order Details Capture in Order Summary page
And Confirm Order



Scenario:EnhNLFL02 [1]HALO_R2.1_NLFL_PAYG_TS26_SOU-7222_NLFL Exchange - E2E Order (SOU-7222)-Retail From Account Overview Page.
Meta:@EnhNLFL02
@FolderName EnhNLFL02
@Ranju
Given Login with 'RETAIL1' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The Account ''
When Validate Contacts tab for 'EnterEmail'
When Update Email Account
Given Login with 'STORE' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddPlanForNLFL' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Order Details Capture in Order Summary page
And Confirm Order

Scenario:EnhNLFL03 [1]HALO_R2.1_NLFL_TS52_SOU-7222_NLFL Exchange - E2E Order (SOU-7222)  Device & Promotion  to  Simo
Meta:@EnhNLFL03
@FolderName EnhNLFL03
@Ranju
Given Login with 'RETAIL1' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The Account ''
When Validate Contacts tab for 'EnterEmail'
When Update Email Account
Given Login with 'STORE' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSimoForNLFL' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Order Details Capture in Order Summary page
And Confirm Order

Scenario: EnhNLFL04 [1]HALO_R2.1_NLFL_PAYG_TS12_SOU-7303_Add product & services - PAYG MBB (SOU-7303)_Change plan and exchange device
Meta:@EnhNLFL04
@FolderName EnhNLFL04
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PrepaidConsumerdd'
And Create New 'NewPrepaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PrepaidPromotionMBB'
And Select Menu 'PromotionEditPackage'
And Add Product 'AppleIpadMiniMBBPayg'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterIMEIinVodafone'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Submit the Order 'Normal Submit'
Given Login with 'STORE' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownNewMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'MBBMobileWiFiPlanDongle' for 'DeviceAndPlanExchangeMBBPayg' in OUI
When Click on Next Button
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'DeliveryToStore'
And Order Details Capture in Order Summary page

Scenario: EnhNLFL05 [1]HALO_R2.1_NLFL_PAYG_TS13_SOU-7303_Add product & services - PAYG MBB (SOU-7303)_Exchange device and keep plan
Meta:@EnhNLFL05
@FolderName EnhNLFL05
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PrepaidConsumerdd'
And Create New 'NewPrepaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PrepaidPromotionMBB'
And Select Menu 'PromotionEditPackage'
And Add Product 'AppleIpadMiniMBBPayg'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterIMEIinVodafone'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Submit the Order 'Normal Submit'
Given Login with 'STORE' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownNewMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'MBBMobileWiFiPlanDongle' for 'DeviceExchangeMBBPayg' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'DeliveryToStore'
When Click on Next Button
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order


Scenario:EnhNLFL06 [1]HALO_R2.1_NLFL_PAYG_TS26_SOU-7222_NLFL Exchange - E2E Order (SOU-7222)-Retail From Account Overview Page
Meta:@EnhNLFL06
@FolderName EnhNLFL06
@Ranju
Given Login with 'RETAIL1' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The Account ''
When Validate Contacts tab for 'EnterEmail'
When Update Email Account
Given Login with 'STORE' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddPlanForNLFL' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'DeliveryToStore'
And Order Details Capture in Order Summary page
And Confirm Order


Scenario: EnhNLFL07 [1]HALO_R2.1_NLFL_TS51_SOU-7222_NLFL Exchange - E2E Order (SOU-7222) Promotion & Device to Promotion & device exchange (PAYM)
Meta:@EnhNLFL07
@FolderName EnhNLFL07
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'FLYING' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotion111740' for 'AddDevicePlanForNLFLDeviceandPlan' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomerForreturn'
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario:EnhNLFL08 [1]HALO_R2.1_NLFL_TS52_SOU-7222_NLFL Exchange - E2E Order (SOU-7222)  Device & Promotion  to  Simo
Meta:@EnhNLFL08
@FolderName EnhNLFL08
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL1' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The Account ''
When Validate Contacts tab for 'EnterEmail'
When Update Email Account
Given Login with 'STORE' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSimoForNLFL' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


Scenario: EnhNLFL09 [1]HALO_R2.1_NLFL_TS53_SOU-7222_NLFL Exchange - E2E Order (SOU-7222) Simo to Device & Promotion
Meta:@EnhNLFL09
@FolderName EnhNLFL09
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'STORE' in 'Env'
Given Retrieve Account 'PostpaidConsumerSIMO'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotion111740' for 'AddDevicePlanForNLFLDeviceandPlan' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomerForreturn'
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario:EnhNLFL10 [1]HALO_R2.1_NLFL_TS54_SOU-7222_NLFL Exchange - E2E Order (SOU-7222) Promotion only
Meta:@EnhNLFL10
@FolderName EnhNLFL10
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'FLYING' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddPlanForNLFL' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete

Scenario:EnhNLFL11 [1]HALO_R2.1_NLFL_TS55_SOU-7222_NLFL Exchange - E2E Order (SOU-7222) Device only
Meta:@EnhNLFL11
@FolderName EnhNLFL11
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'FLYING' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotion111740' for 'AddDevicePlanForNLFLDeviceOnly' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomerForreturn'
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order


Scenario:EnhNLFL11 [1]HALO_R2.1_NLFL_TS55_SOU-7222_NLFL Exchange - E2E Order (SOU-7222) Device only
Meta:@EnhNLFL11
@FolderName EnhNLFL11
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'FLYING' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotion111740' for 'AddDevicePlanForNLFLDeviceOnly' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomerForreturn'
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario:EnhNLFL12 [1]HALO_R2.1_NLFL_TS57_SOU-7222_NLFL Exchange - E2E Order (SOU-7222)-Retail
Meta:@EnhNLFL12
@FolderName EnhNLFL12
@Ranju
Given Login with 'RETAIL1' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The Account ''
When Validate Contacts tab for 'EnterEmail'
When Update Email Account
Given Login with 'STORE' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddPlanForNLFL' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'DeliveryToStore'
And Order Details Capture in Order Summary page
And Confirm Order

Scenario: EnhNLFL13 [1]HALO_R2.1_NLFL_TS58_SOU-7222_NLFL Exchange - E2E Order (SOU-7222)-Call Center
Meta:@EnhNLFL13
@FolderName EnhNLFL13
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'FLYING' in 'Env'
Given Retrieve Account 'PostpaidConsumerSIMO'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotion111740' for 'AddDevicePlanForNLFLDeviceandPlan' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario:EnhNLFL14 [1]HALO_R2.1_NLFL_TS59_SOU-7222_NLFL Exchange - E2E Order (SOU-7222)-Call Center(device retained)
Meta:@EnhNLFL14
@FolderName EnhNLFL14
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'FLYING' in 'Env'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFLPlan'
When Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddPlanForNLFL' in OUI
When Click on Next Button
When Compare Line Items 'EnterReturnReasonAndClickNext'
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


