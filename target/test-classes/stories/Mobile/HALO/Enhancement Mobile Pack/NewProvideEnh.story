Story: Account Creation
Meta:@EnhancementNewProvides
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account

Scenario: NP02Enh New Customer with Content Products 
Meta:@NP02Enh
@FolderName NP02Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order


Scenario: NP03Enh Postpay MPS activation for Consumer with handset 
Meta:@NP03Enh
@FolderName NP03Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'ConsumerManualAddress'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: NP04Enh Postpay MPS activation for Sole trader with handset 
Meta:@NP04Enh
@FolderName NP04Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'SoleTraderOUI'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'SoleTraderOUI'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: NP05EnhPostpay MPS activation for Small business with handset 
Meta:@NP05Enh
@FolderName NP05Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'LtdCompany'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'LtdCompany'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order




Scenario: NP06Enh Prepay MPS activation for Consumer with Handset 
Meta:@NP06Enh
@FolderName NP06Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Prepaid'
And Update Promotion 'PrepaidPhoneAndSIM' for 'AddHandsetPrepay' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: NP07Enh Prepay MBB + device activation for Consumer 
Meta:@NP07Enh
@FolderName NP07Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Prepaid'
And Update Promotion 'PrepaidPromotionMBB' for 'AddHandsetPrepayMBBPayG' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order





Scenario: NP08Enh Postpay MBB activation for Consumer with tablet. 
Meta:@NP08Enh
@FolderName NP08Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionMBBforTablet' for 'AddTabletMBBviaSearchByDevice' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: NP10Enh Postpay MPS activation Consumer with Handset and Insurance 
Meta:@NP10Enh
@FolderName NP10Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidEnhancementPromotionDummy' for 'AddSpecificHandsetPAYM' in OUI
And Customise 'PromotionAddOn' with AddOn Item 'VodafoneInsuranceTier1Damage' in Enhancement
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: NP11Enh Postpay MBB activation with Device and Insurance 
Meta:@NP11Enh
@FolderName NP11Enh
@Zeba
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
When Perform payment with 'Cash' and Confirm Order


Scenario: NP12Enh Postpay MBB activation for Small Business with tablet. 
Meta:@NP12Enh
@FolderName NP12Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'LtdCompany'
And Update Promotion 'PostpaidPromotionMBBforTablet' for 'AddTabletMBBviaSearchByDevice' in OUI
And Create Personal Detail and Adress for 'LtdCompany'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: NP13Enh Postpay MBB activation for Sole trader with tablet. 
Meta:@NP13Enh
@FolderName NP13Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'SoleTraderOUI'
And Update Promotion 'PostpaidPromotionMBBforTablet' for 'AddTabletMBBviaSearchByDevice' in OUI
And Create Personal Detail and Adress for 'LtdCompany'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: NP14Enh  SIMO Activation for Consumer with  data 
Meta:@NP14Enh
@FolderName NP14Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: NP15Enh  SIMO Activation for Sole trader with data 
Meta:@NP15Enh
@FolderName NP15Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'SoleTraderOUI'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'SoleTraderOUI'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario:LOVCheck002 LOV check for payment method.
Meta:@LOVCheck002
@FolderName LOVCheck002
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
And Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
And Perform payment with 'PaymentLOVCheck'


Scenario:LOVCheck001: LOV check for Cancel reason.
Meta:@LOVCheck001
@FolderName LOVCheck001
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
And Discard Order




Scenario:CancelOrder002: Cancel order before shipping 
Meta:@CancelOrder002
@FolderName CancelOrder002
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'ConsumerManualAddress'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Discard Order


Scenario:CancelOrder003: Cancel order before submission 
Meta:@CancelOrder003
@FolderName CancelOrder003
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'ConsumerManualAddress'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
And Perform payment with 'Cash'
And Discard Order

Scenario: Ship03Enh DTA Order - Retail 
Meta:@Ship03Enh
@FolderName Ship03Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: Ship01Enh  DTS Order
Meta:@Ship01Enh
@FolderName Ship01Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToStore'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order



Scenario: Ship04Enh DTA Order - Call Center 
Meta:@Ship04Enh
@FolderName Ship04Enh
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order