Story: Account Creation
Meta:@EnhancementNewProvides
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account

Scenario: NPCustomiseEnh04  Add Data Bar 
Meta:@NPCustomiseEnh04
@FolderName NPCustomiseEnh04
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'DataBarOn' in Enhancement
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
Then verify the Order line Items 'DataBarAdd'


Scenario: NPCustomiseEnh05  Add Admin Bar
Meta:@NPCustomiseEnh05
@FolderName NPCustomiseEnh05
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'ABarOnE2' in Enhancement
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
Then verify the Order line Items 'AbarAdd'


Scenario: NPCustomiseEnh06  Add O Bar
Meta:@NPCustomiseEnh06
@FolderName NPCustomiseEnh06
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'OBarOnE2' in Enhancement
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
Then verify the Order line Items 'ObarAdd'


Scenario: NPCustomiseEnh07  Add Stolen Bar
Meta:@NPCustomiseEnh07
@FolderName NPCustomiseEnh07
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'StolenOnE2' in Enhancement
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
Then verify the Order line Items 'StolenBarAdd'
Then verify the Order line Items 'AppleAdd'


Scenario: NPCustomiseEnh08  Add Fraud Bar
Meta:@NPCustomiseEnh08
@FolderName NPCustomiseEnh08
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'FraudOnE2' in Enhancement
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
Then verify the Order line Items 'FraudAdd'
Then verify the Order line Items 'AppleAdd'


Scenario: NPCustomiseEnh09  Add Credit Alert A Bar
Meta:@NPCustomiseEnh09
@FolderName NPCustomiseEnh09
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'CreditAlertABarE2' in Enhancement
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: NPCustomiseEnh10  Add All call outgoing Bar
Meta:@NPCustomiseEnh10
@FolderName NPCustomiseEnh10
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'AllCallsOutgngOnlyBarOn' in Enhancement
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
Then verify the Order line Items 'AllCallsOutgoingOnlyBarAdd'
Then verify the Order line Items 'AppleAdd'


Scenario: NPCustomiseEnh11  Add Internation call forward Bar
Meta:@NPCustomiseEnh11
@FolderName NPCustomiseEnh11
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'IntneterCallsOutgngOnlyBarOn' in Enhancement
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
Then verify the Order line Items 'InternationalCallsOutgoingOnlyBarAdd'
Then verify the Order line Items 'AppleAdd'


Scenario: NPCustomiseEnh13  Add Extra 1GB data
Meta:@NPCustomiseEnh13
@FolderName NPCustomiseEnh13
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'Extra1GBDataMonthlyOnE2' in Enhancement
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
Then verify the Order line Items 'RootProduct0AddnExtra1GB'
Then verify the Order line Items 'AppleAdd'


Scenario: NPCustomiseEnh15  Add Extra 1GB data (one-off)
Meta:@NPCustomiseEnh15
@FolderName NPCustomiseEnh15
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'Extra1GBDataWithOneOffCostON' in Enhancement
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
Then verify the Order line Items 'Extra1GBDataOneOffAdd'
Then verify the Order line Items 'AppleAdd'


Scenario: NPCustomiseEnh17  Add Vodafone International Saver 100
Meta:@NPCustomiseEnh17
@FolderName NPCustomiseEnh17
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'VodafoneIntSaver100' in Enhancement
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
Then verify the Order line Items 'VodafoneIntSaver100Add'
Then verify the Order line Items 'AppleAdd'


Scenario: NPCustomiseEnh19  Add Vodafone Household 15% discount
Meta:@NPCustomiseEnh19
@FolderName NPCustomiseEnh19
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
When Customise 'RootProduct' with Econfig Item 'VodaHouse15%DiscOn' in Enhancement
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
Then verify the Order line Items 'VodafoneHousehold15%discountAdd'
Then verify the Order line Items 'AppleAdd'


Scenario: NPCustomiseEnh21  Add 15% promotional discount 
Meta:@NPCustomiseEnh21
@FolderName NPCustomiseEnh21
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidEnhancementPromotionDummy' for 'AddSpecificHandsetPAYM' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Customise 'RootProduct' with Econfig Item 'Disc15%PlanOn' in Enhancement
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: NPCustomiseEnh22  Add bar on VoLTE 
Meta:@NPCustomiseEnh22
@FolderName NPCustomiseEnh22
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
When Customise 'RootProduct' with Econfig Item 'DataBarOn' in Enhancement
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
Then verify the Order line Items 'DataBarAdd'
Then verify the Order line Items 'AppleAdd'

Scenario: NPCustomiseEnh23  Add BVB
Meta:@NPCustomiseEnh23
@FolderName NPCustomiseEnh23
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Prepaid'
And Update Promotion 'PrepaidPhoneAndSIM' for 'AddHandsetPrepay' in OUI
And Create Personal Detail and Adress for 'Consumer'
When Customise 'RootProduct' with Econfig Item 'BigVal10GBPOffAndBigVal30GBPOn' in Enhancement
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
Then verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'BigValueBundle30GBPAdd'
Then verify the Order line Items 'AppleAdd'


Scenario: NPCustomiseEnh24  Add BIS
Meta:@NPCustomiseEnh24
@FolderName NPCustomiseEnh24
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Prepaid'
And Update Promotion 'PrepaidPhoneAndSIM' for 'AddHandsetPrepay' in OUI
And Create Personal Detail and Adress for 'Consumer'
When Customise 'RootProduct' with Econfig Item 'BlackberryIntnetServ' in Enhancement
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
Then verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'BlackberryInternetServiceDelete'
Then verify the Order line Items 'AppleAdd'


Scenario: NPCustomiseEnh25  Add recurring products BVB
Meta:@NPCustomiseEnh25
@FolderName NPCustomiseEnh25
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Prepaid'
And Update Promotion 'PrepaidPhoneAndSIM' for 'AddHandsetPrepay' in OUI
And Create Personal Detail and Adress for 'Consumer'
When Customise 'RootProduct' with Econfig Item 'BigVal10GBPOffAndBigVal30GBPOn' in Enhancement
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
Then verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'BigValueBundle30GBPAdd'
Then verify the Order line Items 'AppleAdd'