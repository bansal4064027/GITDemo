Story: New Aquisition
Meta:@NewAquisition
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account

Scenario: NewAquisition01
Meta:@NewAquisition01 New Customer having Insurance and Add-On Product
@FolderName NewAquisition01
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Customise 'PromotionAddOn' with AddOn Item 'VodInsuranceApplecare' in Enhancement
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
Then verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'VodafoneinsuranceAdd'
Then verify the Order line Items 'AppleAdd'


Scenario: NewAquisition02  New Customer having Add-On product using Customise
Meta:@NewAquisition02
@FolderName NewAquisition02
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidEnhancementPromotionDummy' for 'AddSpecificHandsetPAYM' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'Extra300MinsTo084And087On' in Enhancement
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'AppleAdd'
Then verify the Order line Items 'Extr300minsto084and087Add'



Scenario: NewAquisition03  New Customer having two promotions having different insurance and handsets
Meta:@NewAquisition03
@FolderName NewAquisition03
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidEnhancementPromotionDummy' for 'AddSpecificHandsetPAYMandDonotNavigate' in OUI
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'ConsumerManualAddress'
And Retrieve Promotion 'PostpaidEnhancementPromotionDummy'
And Customise 'PromotionAddOn' with AddOn Item 'VodafoneInsuranceTier1Damage' in Enhancement
And Retrieve Promotion 'PostpaidPromotion4G'
And Customise 'PromotionAddOn' with AddOn Item 'VodInsuranceApplecare' in Enhancement
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Retrieve Promotion 'PostpaidEnhancementPromotionDummy'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN'
And Retrieve Promotion 'PostpaidPromotion4G'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
Then verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'VodafoneinsuranceAdd'
Then verify the Order line Items 'AppleAdd'


Scenario: NewAquisition04  New Customer having two promotions having different insurance and handsets
Meta:@NewAquisition04
@FolderName NewAquisition04
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlanandDonotNavigate' in OUI
And Update Promotion 'PostpaidEnhancementPromotionDummy' for 'AddSpecificHandsetPAYM' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Retrieve Promotion 'PostpaidPromotion4G'
And Customise 'PromotionAddOn' with AddOn Item 'VodafoneInsuranceTier1Damage' in Enhancement
And Retrieve Promotion 'PostpaidEnhancementPromotionDummy'
And Customise 'PromotionAddOn' with AddOn Item 'VodInsuranceApplecare' in Enhancement
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Retrieve Promotion 'PostpaidPromotion4G'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN'
And Retrieve Promotion 'PostpaidEnhancementPromotionDummy'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'AccessoryHeadphonesAdd'
Then verify the Order line Items 'AppleAdd'



Scenario: NewAquisition05  New order for MPS prepay with handset & accessories
Meta:@NewAquisition05
@FolderName NewAquisition05
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Prepaid'
And Update Promotion 'PrepaidPhoneAndSIM' for 'AddHandsetPrepayandDonotNavigate' in OUI
And Add Promotion 'AddAccessory' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then verify the Order line Items 'PromotionAdd'


Scenario: NewAquisition06 CCS 8.0_CR108212_Youth Age Gating_Mobile_TS01_TC01_Agent creates a New Youth subscription Order and adds Music Pass using Customise 
Meta:@NewAquisition06
@FolderName NewAquisition06
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PrepaidPromotionVOXI' for 'AddVOXISIMOnlyPackage' in OUI
And Create Personal Detail and Adress for 'PrepaidConsumerVOXI'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Customise 'RootProduct' with Econfig Item 'VOXIMusicPassAdd' in Enhancement
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
Then verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'VOXI6GBADD'


Scenario: NewAquisition07  CCS 8.0_CR108212_Youth Age Gating_Mobile_TS01_TC01_Agent creates a New Youth subscription Order having VOXI Plan 10GB 
Meta:@NewAquisition07
@FolderName NewAquisition07
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PrepaidPromotionVOXI' for 'AddVOXISIMOnlyPackage' in OUI
And Create Personal Detail and Adress for 'PrepaidConsumerVOXI'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'VOXI4GBDataOn' in Enhancement
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
Then verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'VOXI6GBADD'



Scenario: NewAquisition09 Siebel_Upgrade_Enhancement_Existing Customer_TC05_Validate that agent places a new MBB postpay acquisition order on existing MPS postpay customer. 
Meta:@NewAquisition09
@FolderName NewAquisition09
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotionMBB4G' for 'AddHandsetPostpayMBBPayGSearchByDevice' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIinVodafone' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
And Retrieve Promotion 'PostpaidPromotionMBB4G'
Then Select Action from Product&Services Overview for 'PromotionActive'



Scenario: NewAquisition08 Siebel_Upgrade_Enhancement_Existing Customer_TC03_Validate that agent places a new MPS prepay acquisition order on existing MBB prepay customer. 
Meta:@NewAquisition08
@FolderName NewAquisition08
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumerMBB'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PrepaidPhoneAndSIM' for 'AddHandsetPrepay' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
And Retrieve Promotion 'PrepaidPhoneAndSIM'
Then Select Action from Product&Services Overview for 'PromotionActive'



Scenario: NewAquisition10 Siebel_Upgrade_Enhancement_FL_Existing Customer_TC30_EBU_Agent creates a new connection EBU FL+BB nonappointed order on an existing account
Meta:@NewAquisition10
@FolderName NewAquisition10
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'ConsFLADSL'
Given Login with 'QP' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Create New OUI Order
And Get Address 'SPAREPAIREBU'
And Click on Fixed Line Check Avilibility for 'SPAREPAIREBU'
And Filter Promotion for Enhancement 'Biz6*&&NOT-ExistingMobileCustomer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Perform Fulfilment Status With 'NoShipping'
And Click on Generate New Number
And Click on Book Appointment
And Click on Terms and Condition
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: NewAquisition11 Siebel_Upgrade_Enhancement_FL_Existing Customer_TC31_EBU_Agent creates a new connection BB Only nonappointed order on an existing account
Meta:@NewAquisition11
@FolderName NewAquisition11
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'BusFLBBOnly'
Given Login with 'QP' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Create New OUI Order
And Get Address 'SPAREPAIREBU'
And Click on Fixed Line Check Avilibility for 'SPAREPAIREBU'
And Filter Promotion for Enhancement 'Biz6*&&NOT-ExistingMobileCustomer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Perform Fulfilment Status With 'NoShipping'
And Click on Generate New Number
And Click on Book Appointment
And Click on Terms and Condition
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order



Scenario: NewAquisition12 Siebel_Upgrade_Enhancement_TC114_Validate that the agent is able to place a new connection order with Secure Net product. 
Meta:@NewAquisition12
@FolderName NewAquisition12
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
And Search The Account ''
And Create 'NoNewNoPopUp'Order
When Retrieve Promotion 'PostpaidPromotion4G'
Then verify the Order line Items 'VodaSecureNetOFFVodaSecureNetON'


Scenario: NewAquisition13 CCS 8.0_CR108212_Youth Age Gating_Mobile_TS01_TC01_Agent creates a New Youth subscription Order having VOXI Plan 30GB 
Meta:@NewAquisition13
@FolderName NewAquisition13
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PrepaidPromotionVOXI' for 'AddVOXISIMOnlyPackage' in OUI
And Create Personal Detail and Adress for 'PrepaidConsumerVOXI'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'VOXIExtra15GBON' in Enhancement
And Compare Line Items 'ClickNext'
And Perform Fulfilment Status With 'NoShipping'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order




Scenario: HaloRegressionTC10 HALO IDV Regression_TC10_New Connection Order on new account using credit vet override 
Meta:@HaloRegressionTC10
@FolderName HaloRegressionTC10
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
When Perform IDV Check and Credit Vet with Result 'CreditVettingOverride'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order