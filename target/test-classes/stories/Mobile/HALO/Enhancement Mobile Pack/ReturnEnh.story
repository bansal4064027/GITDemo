Story:ReturnEnh Story
Meta:
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  
  
Scenario:EnhReturn01 HALO R2.1_Sprint 34_Mobile_Return_TS37_TC01_E2E return order on Device (MBB)
Meta:@EnhReturn01
@FolderName EnhReturn01
@ankita
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerMBB'
Given Login with 'FLYING' in 'Env''
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'ReturnOnDevice'
And Compare Line Items 'PromotionDelete'
And Compare Line Items 'ClickNext'
When Select Action from Return Exchange Info
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario:EnhReturn02 HALO R2.1_Sprint 34_Mobile_Return_TS38_TC01_E2E return order on Handset with PAYM(MBB) from Retail
Meta:@EnhReturn02
@FolderName EnhReturn02
@ankita
Given Place screenshots in Folder 'FolderName'
And Login with 'STORE' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create New 'NewPostpaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderPopUp' Order
And Promotion is added with 'PostpaidPromotionMBB4G'
And Select Menu 'PromotionEditPackage'
And Add Product 'SIMODongleVodafoneR216'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'EnterIMEIinVodafone'
And Reserve Order
And Perform Credit Vet
And Make payment with 'CashPopNO'
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Retrieve Promotion 'PostpaidPromotionMBB4G'
And Select Action from Owned Product and Services (Account Overview)'ReturnOnDevice'
And Compare Line Items 'PromotionDelete'
And Compare Line Items 'ClickNext'
When Select Action from Return Exchange Info
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario:EnhReturn03 HALO R2.1_Sprint 34_Mobile_Return_TS39_TC01_E2E return order on PAYG + Handset From Retail Agent
Meta:@EnhReturn03
@FolderName EnhReturn03
@ankita
Given Place screenshots in Folder 'FolderName'
And Login with 'STORE' in 'Env'
When Create the account type 'PrepaidConsumer'
And Create New 'NewPrepaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PrepaidPromotionMBB'
And Select Menu 'PromotionEditPackage'
And Add Product 'SIMODongleVodafoneR216PAYG'
And Update MSISDN by performing 'UpdateMSISDN' on 'MobilebroadbandServiceAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'EnterIMEIinVodafone'
And Reserve Order
And Make payment with 'CashPopNO'
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Retrieve Promotion 'PrepaidPromotionMBB'
And Select Action from Owned Product and Services (Account Overview)'ReturnOnDevice'
And Compare Line Items 'PromotionDelete'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: EnhReturn06 HALO R2.1_Sprint 32_Mobile_Return_TS06_TC01_Blocking Message for permissions Level to Perform Return 
Meta:@EnhReturn06
@FolderName EnhReturn06
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContactforLevel1'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel1' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'Return'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel1' ''
Then Perform changes in Contacts scenario for 'AddNewContactforLevel2'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel2' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'Return'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel2' ''
Then Perform changes in Contacts scenario for 'AddNewContactforStoreCollection'
When Search The OUI Account 'GoToAccountLinkforPermissionStoreCollection' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'Return'


Scenario:EnhReturn07 HALO R2.1_Sprint 32_Blocking Message if Open order present on same asset
Meta:@EnhReturn07
@FolderName EnhReturn07
@ankita
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'FLYING' in 'Env''
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'RetrieveReturnOnDevice'
And Compare Line Items 'PromotionDelete'
And Compare Line Items 'ClickNext'
When Select Action from Return Exchange Info
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
And Execute query 'AutoAssetforOpen1'
And Execute query 'AutoAssetforOpen2'
And Execute query 'AutoAssetforOpen3'
When Search The OUI Account 'GoToAccountLink' ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Select Action from Owned Product and Services (Account Overview)'RetrieveReturnOnDevicePopUp'

Scenario:EnhReturn09 HALO R2.1_Sprint 32_Mobile_Return_TS17_TC01_Basket applet for Return order-Upgrade Order
Meta:@EnhReturn09
@FolderName EnhReturn09
@ankita
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
And ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidPromotion4G'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotionVolte'
Then Perform Migration
When Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Select Action from Owned Product and Services (Account Overview)'ReturnOnDevice'
And Retrieve Promotion 'PostpaidPromotion4G'
And Compare Line Items 'PromotionAdd'
And Compare Line Items 'PromotionDelete'


Scenario:EnhReturn10 HALO R2.1_Sprint 32_Mobile_Return_TS21_TC01_Basket applet for Return order-Copy and Delete Option
Meta:@EnhReturn10
@FolderName EnhReturn10
@ankita
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'FLYING' in 'Env''
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'RetrieveReturnOnDevice'
And Compare Line Items 'PromotionDelete'
And Compare Line Items 'PromotionAddTotalHoverScreenshot'

Scenario:EnhReturn11 HALO R2.1_Sprint 32_Mobile_Return_TS22_TC01_Add on and Customise button in Return Order
Meta:@EnhReturn11
@FolderName EnhReturn11
@ankita
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'FLYING' in 'Env''
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'RetrieveReturnOnDevice'
And Compare Line Items 'ReturnAddButton'
And Compare Line Items 'ReturnCustomiseButton'

Scenario: EnhReturn17 HALO R2.2_Return n Keep Number_TS06_SOU-6113_PAYG with Handset-E2E
Meta:@EnhReturn17
@FolderName EnhReturn17
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'PrepaidConsumerdd'
And Create 'NewOrderNoPopUp' 'NewPrepaid' Order
And Promotion is added with 'PrepaidPackage'
And Select Menu 'PromotionEditPackage'
And Add Product 'MpMpApple'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterIMEIInApple'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'ReturnandKeepMSISDN'
And Compare Line Items 'PromotionDelete'
And Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete

Scenario: EnhReturn19 HALO R2.1_E2E return order on PAYG New connection Order with in 33Days -CC
Meta:@EnhReturn19
@FolderName EnhReturn19
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'PrepaidConsumerdd'
And Create 'NewOrderNoPopUp' 'NewPrepaid' Order
And Promotion is added with 'PrepaidPackage'
And Select Menu 'PromotionEditPackage'
And Add Product 'MpMpApple'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterIMEIInApple'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'ReturnOnDevice'
And Compare Line Items 'PromotionDelete'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


Scenario: HALO R2.1_Sprint 34_Mobile_Return_TS40_TC01_E2E return order on Voxi from CC
Meta:@EnhReturn12
@FolderName EnhReturn12
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidVOXIConsumer'
Given Login with 'FLYING' in 'Env''
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'ReturnOnDeviceVoxi2'
And Compare Line Items 'ClickNext'
When Select Action from Return Exchange Info with 'DPAVoxiSelfReturn'
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order


Scenario: HALO R2.1_Sprint 34_Mobile_Return_TS42_TC01_E2E return order on PAYM Upgrade Order -Retails
Meta:@EnhReturn13
@FolderName EnhReturn13
@Sumit
Given Place screenshots in Folder 'FolderName'
And Retrieve Account 'PostpaidConsumer'
Given Login with 'FLYING' in 'Env''
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'TarriffMigPostpaidPromotion4G'
Then Perform Migration
When Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'ReturnOnDeviceVoxi'
And Compare Line Items 'ClickNext'
When Select Action from Return Exchange Info with 'DPAVoxiSelfReturn'
And Order Details Capture in Order Summary page
And Confirm Order

Scenario: HALO R2.1_Sprint 34_Mobile_Return_TS42_TC01_E2E return order on PAYG Upgrade Order -Retails
Meta:@EnhReturn14
@FolderName EnhReturn14
@Sumit
Given Place screenshots in Folder 'FolderName'
And Retrieve Account 'PrepaidConsumer'
Given Login with 'FLYING' in 'Env''
When Search The Account ''
And Retrieve Promotion 'PrepaidPackage'
And Modify 'ModifyWithInstalledID' with Econfig Item 'FraudOnE2'
When Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'ReturnOnDeviceVoxi'
And Compare Line Items 'ClickNext'
When Select Action from Return Exchange Info with 'DPAVoxiSelfReturn'
And Order Details Capture in Order Summary page
And Confirm Order


Scenario: HALO R2.2_Return n Keep Number_TS04_SOU-6112_PAYM with Handset-E2E
Meta:@EnhReturn15
@FolderName EnhReturn15
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
Given Login with 'FLYING' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'ReturnOnDeviceVoxi1'
And Update Promotion 'SIMOPromotion111469' for 'AddPostpaidForReturn' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Compare Line Items 'ClickNext'
And Select Action from Owned Product and Services (Account Overview)'ReturnWithReason'
And Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomerWIthDeliveryMethod'
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order


Scenario: HALO R2.2_Return n Keep Number_TS05_SOU-6112_PAYM MBB with Tablet-E2E
Meta:@EnhReturn16
@FolderName EnhReturn16
@Sumit
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
When Search The Account ''
When Create new order 'CheckOpenOrder'
Then Check Order Status till Complete
When ReLogin with 'FLYING' in 'Env'
When Search The Account ''
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'ReturnOnDeviceVoxi1'
And Update Promotion 'SIMOPromotion111469' for 'AddPostpaidForReturn' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Compare Line Items 'ClickNext'
And Select Action from Owned Product and Services (Account Overview)'ReturnWithReason'
And Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomerWIthDeliveryMethod'
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario:EnhReturn20 [1][1]HALO R2.1_E2E return order on PAYG Upgrade Order Where upgrade order is Performed with in 33Days -Retail
Meta:@EnhReturn20
@FolderName EnhReturn20
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PrepaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Upgrade'
And Retrieve Promotion 'PrepaidPackage'
And Select Promotion
And Retrieve Promotion 'PrepaidPhoneAndSIM'
And Update Promotion and add handset
And Compare Line Items 'PromotionAdd'
And Compare Line Items 'HandsetAdd'
And Retrieve Promotion 'PrepaidPackage'
And Compare Line Items 'PromotionDelete'
And Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Retrieve Promotion 'PrepaidPhoneAndSIM'
And Update IMEI for 'EnterIMEIInApple' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Perform Product Services line items validation for Owned product Services 'AllActive'
When Retrieve Promotion 'PrepaidPhoneAndSIM'
Then Select Action from Product&Services Overview for 'PromotionActive'
Given Login with 'TEST_RETAIL_1' in 'Env''
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'RetrieveReturnOnDevice'
And Compare Line Items 'PromotionDelete'
And Compare Line Items 'ReturnNext'
When Select Action from Return Exchange Info
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
