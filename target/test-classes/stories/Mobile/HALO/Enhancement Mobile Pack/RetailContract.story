Story: Retail Contract
Meta:@RetailContract
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account

Scenario: Halo_RetailContract01 Mobile_Retail Contract_TS04_Siebel to Siebel _To manually generate Retail Contract for PAYM Handset  plan with Insurance from Siebel
Meta:@Halo_RetailContract01 
@FolderName Halo_RetailContract01
@Manvi
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
And Navigate to Order Summary Page
Then Generate Contract Report in Halo


Scenario: Halo_RetailContract03 NewCo_CR110024_Mobile_Retail Contract_TS01_TC02_Siebel to Siebel _To manually generate Retail Contract for MPS Handset plan from Siebel_Consumer 
Meta:@Halo_RetailContract03
@FolderName Halo_RetailContract03
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
And Navigate to Order Summary Page
Then Generate Contract Report in Halo

Scenario: Halo_RetailContract04 NewCo_CR110024_Mobile_Retail Contract_TS01_TC03_Siebel to Siebel _To manually generate Retail Contract for MBB plan from Siebel_Consumer 
Meta:@Halo_RetailContract04
@FolderName Halo_RetailContract04
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionMBB4G' for 'AddHandsetPostpayMBBPayGSearchByDevice' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
And Navigate to Order Summary Page
Then Generate Contract Report in Halo

Scenario: Halo_RetailContract05 NewCo_CR110024_Mobile_Retail Contract_TS01_TC04_Siebel to Siebel _To manually generate Retail Contract for MPS SIMO plan from Siebel_Small Business 
Meta:@Halo_RetailContract05
@FolderName Halo_RetailContract05
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Partnership'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Partnership'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
And Navigate to Order Summary Page
Then Generate Contract Report in Halo

Scenario: Halo_RetailContract06 NewCo_CR110024_Mobile_Retail Contract_TS01_TC06_Siebel to Siebel _To manually generate Retail Contract for MBB plan from Siebel_Sole Trader 
Meta:@Halo_RetailContract06
@FolderName Halo_RetailContract06
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'SoleTraderOUI'
And Update Promotion 'PostpaidPromotionMBB4G' for 'AddHandsetPostpayMBBPayGSearchByDevice' in OUI
And Create Personal Detail and Adress for 'SoleTraderOUI'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
And Navigate to Order Summary Page
Then Generate Contract Report in Halo


Scenario: Halo_RetailContract07  NewCo_CR110024_Mobile_Retail Contract_TS02_TC02_Siebel to Siebel _To manually generate Retail Contract for MBB plan with Insurance from Siebel_Consumer
Meta:@Halo_RetailContract07
@FolderName Halo_RetailContract07
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionMBB4G' for 'AddHandsetPostpayMBBPayGSearchByDevice' in OUI
And Customise 'PromotionAddOn' with AddOn Item 'InseExc60gbp' in Enhancement
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
And Navigate to Order Summary Page
Then Generate Contract Report in Halo


Scenario: Halo_RetailContract08 NewCo_CR110024_Mobile_Retail Contract_TS03_TC01_Siebel to Siebel _To manually generate Retail Contract for MPS Handset  plan with SecureNet Discount from Siebel_Consumer 
Meta:@Halo_RetailContract08
@FolderName Halo_RetailContract08
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidVodafoneSecureNetPromotion' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Validate Product in Basket for 'ValidateSecureNetDiscountInBasket'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
And Navigate to Order Summary Page
Then Generate Contract Report in Halo

Scenario: Halo_RetailContract14 NewCo_CR110024_Mobile_Retail Contract_TS07_TC01_Siebel to Siebel _To manually generate Retail Contract for MPS Handset plan from Siebel and check Equipment subsidy value have 2 Decimal places _Consumer 
Meta:@Halo_RetailContract14
@FolderName Halo_RetailContract14
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
And Navigate to Order Summary Page
Then Validate Decimal for Equipment Subsidy Price
Then Generate Contract Report in Halo


Scenario: Halo_RetailContract15 NewCo_CR110024_Mobile_Retail Contract_TS07_TC02_Siebel to Siebel _To manually generate Retail Contract for MBB plan from Siebel and check Equipment subsidy value have 2 Decimal places _Consumer 
Meta:@Halo_RetailContract15
@FolderName Halo_RetailContract15
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionMBB4G' for 'AddHandsetPostpayMBBPayGSearchByDevice' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
And Navigate to Order Summary Page
Then Validate Decimal for Equipment Subsidy Price
Then Generate Contract Report in Halo



Scenario: Halo_RetailContract16 [1]NewCo_CR110024_Mobile_Retail Contract_TS08_TC01_Siebel to Siebel _To manually generate Retail Contract for MPS Handset plan with Multi CTN from Siebel_Consumer 
Meta:@Halo_RetailContract16
@FolderName Halo_RetailContract16
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidEnhancementPromotionDummy' for 'AddSpecificHandsetPAYM' in OUI
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
When Navigate to Order Summary Page
Then Generate Contract Report in Halo