Story: Siebel Upgrade
Meta:@SiebelUpgrade
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  

Scenario: SiebelUpgrade01 Siebel_Upgrade_Enhancement_TC123_Validate that agent places a new acquisition order for MPS prepay subscriber handset. 
Meta:@SiebelUpgrade01
@FolderName SiebelUpgrade01
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PrepaidPhoneAndSIM' for 'AddHandsetPrepay' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order

Scenario: SiebelUpgrade02 Siebel_Upgrade_Enhancement_TC123_Validate that agent places a new order for MPS postpay with handset & accessories 
Meta:@SiebelUpgrade02
@FolderName SiebelUpgrade02
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlanandDonotNavigate' in OUI
And Add Promotion 'AddAccessory' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order

Scenario: SiebelUpgrade03 Siebel_Upgrade_Enhancement__TC118_Validate that the agent is able to remove email
Meta:@SiebelUpgrade03
@FolderName SiebelUpgrade03
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Perform changes in Contacts scenario for 'UpdateEmail'
When Search The OUI Account 'GoToAccountLink' ''
Then Perform changes in Contacts scenario for 'RemoveEmail'


Scenario: SiebelUpgrade07 HALO_Modify Order  New Connection_ EBU Sole Trader_MBB
Meta:@SiebelUpgrade07
@FolderName SiebelUpgrade07
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'SoleTrader'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionMBB4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CustomiseNewMSISDN'
When Econfig Item 'DataBarOn'
And Compare Line Items 'DataBarAdd'
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete

Scenario: SiebelUpgrade08 HALO_New Order on  Existing Account EBU Partnership Account_PAYM SIMO
Meta:@SiebelUpgrade08
@FolderName SiebelUpgrade08
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'SmallBusinessPartnership'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel0' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Click on Next Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: SiebelUpgrade09 HALO_New Order on Existing Account_ EBU Charity Account_PAYM With Handset
Meta:@SiebelUpgrade09
@FolderName SiebelUpgrade09
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel0' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Click on Next Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: SiebelUpgrade10 HALO_New Order on New Connection_ EBU LTD Company With Dongle 
Meta:@SiebelUpgrade10
@FolderName SiebelUpgrade10
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'LtdCompany'
And Update Promotion 'PrepaidPromotionMBB' for 'AddHandsetPrepayMBBPayG' in OUI
And Create Personal Detail and Adress for 'LtdCompany'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: SiebelUpgrade04 [1]Siebel_Upgrade_Enhancement__TC122_Validate that the agent checks Account Permissions
Meta:@SiebelUpgrade04
@FolderName SiebelUpgrade04
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContact'
Then Perform changes in Contacts scenario for 'AddNewContactforLevel2'
Then Perform changes in Contacts scenario for 'AddNewContactforLevel0'

