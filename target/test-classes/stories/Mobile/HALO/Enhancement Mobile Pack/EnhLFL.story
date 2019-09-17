Story:EnhLFL Story
Meta:
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  
Scenario:EnhLFL01 HALO_R2.1_NLFL_TS06_SOU-7408_Out of policy check - Agents that can trigger a return journey outside the Returns Policy period
Meta:@EnhLFL01
@FolderName EnhLFL01
@Ankita
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerMBB'
Given Login with 'FLYING' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform DPA validation for 'DPAPassedValidation'
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNonLikeforLike'


Scenario:EnhLFL09 HALO R2.1_LFL_TS27_TC01_MBB Data Device LFL E2E-CC
Meta:@EnhLFL09
@FolderName EnhLFL09
@Ankita
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
When Select Action from Owned Product and Services (Account Overview)'DrilldownNewMSISDN'
Then Select Action from OwnedLineItems Overview for 'ExchangeLikeforLike'
When Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIinVodafone' in OUI and Click Next
And Order Details Capture in Order Summary page
When Confirm Order

Scenario:EnhLFL04Ankita HALO R2.1_LFL_TS09_TC01_Out of Policy Exchange
Meta:@EnhLFL04Ankita
@FolderName EnhLFL04Ankita
@ankita
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithAnyHandset'
Given Login with 'FLYING' in 'Env'
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
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeLFLOpenPopUp'

Scenario: HALO_LFL_02 HALO R2.1_LFL_TS23_TC01_Standalone Accessories LFL E2E-CC
Meta:@HALO_LFL_02
@FolderName HALO_LFL_02
@Zeba
Given Place screenshots in Folder 'FolderName'
And Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create New 'NewPostpaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderPopUp' Order
And Promotion is added with 'PostpaidPromotion4G'
And Select Menu 'PromotionEditPackage'
And Add Product 'SpecificHandset076935'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'EnterIMEIInApple'
And Reserve Order
And Perform Credit Vet
And Make payment with 'CashPopNO'
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Retrieve Promotion 'PostpaidPromotion4G'
When Select Action from Owned Product and Services (Account Overview)'DrilldownNewMSISDN'
Then Select Action from OwnedLineItems Overview for 'ExchangeLikeforLike'
When Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterServiceID' in OUI and Click Next
And Order Details Capture in Order Summary page
When Confirm Order


Scenario: HALO_LFL_03 HALO R2.1_LFL_TS24_TC01_PAYM LFL E2E-Retail
Meta:@HALO_LFL_03
@FolderName HALO_LFL_03
@Zeba
Given Place screenshots in Folder 'FolderName'
And Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create New 'NewPostpaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderPopUp' Order
And Promotion is added with 'PostpaidPromotion4G'
And Select Menu 'PromotionEditPackage'
And Add Product 'SpecificHandset076935'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'EnterIMEIInApple'
And Reserve Order
And Perform Credit Vet
And Make payment with 'CashPopNO'
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Retrieve Promotion 'PostpaidPromotion4G'
When Select Action from Owned Product and Services (Account Overview)'DrilldownNewMSISDN'
Then Select Action from OwnedLineItems Overview for 'ExchangeLikeforLike'
When Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterServiceID' in OUI and Click Next
And Order Details Capture in Order Summary page
When Confirm Order



Scenario: HALO_LFL_04 HALO R2.1_LFL_TS25_TC01_PAYG LFL over Upgrade E2E-Callcenter
Meta:@HALO_LFL_04
@FolderName HALO_LFL_04
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PrepaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Upgrade'
And Retrieve Promotion 'PrepaidPackage'
And Select Promotion
And Retrieve Promotion 'PAYGPhoneandSIMPackage'
And Update Promotion and add handset
And Compare Line Items 'PromotionAdd'
And Compare Line Items 'HandsetAdd'
And Retrieve Promotion 'PrepaidPackage'
And Compare Line Items 'PromotionDelete'
And Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Retrieve Promotion 'PAYGPhoneandSIMPackage'
And Update IMEI for 'EnterIMEIInApple' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The OUI Account 'GoToAccountLink' ''
And Retrieve Promotion 'PAYGPhoneandSIMPackage'
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from OwnedLineItems Overview for 'ExchangeLikeforLike'
When Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterServiceID' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: HALO_LFL_05 HALO R2.1_LFL_TS26_TC01_PAYM LFL over NLFL E2E-Retail
Meta:@HALO_LFL_05
@FolderName HALO_LFL_05
@Zeba
Given Place screenshots in Folder 'FolderName'
And Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create New 'NewPostpaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderPopUp' Order
And Promotion is added with 'PostpaidPromotion4G'
And Select Menu 'PromotionEditPackage'
And Add Product 'SpecificHandset076935'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'EnterIMEIInApple'
And Reserve Order
And Perform Credit Vet
And Make payment with 'CashPopNO'
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Retrieve Promotion 'PostpaidPromotion4G'
When Select Action from Owned Product and Services (Account Overview)'DrilldownNewMSISDN'
Then Select Action from Product&Services Overview for 'ExchangeNLFL'
When Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSimoForNLFLDeviceandPlan' in OUI
When Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
And Retrieve Promotion 'PostpaidPromotion4G'
When Select Action from Owned Product and Services (Account Overview)'DrilldownNewMSISDN'
Then Select Action from OwnedLineItems Overview for 'ExchangeLikeforLike'
When Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterServiceID' in OUI and Click Next
And Order Details Capture in Order Summary page
When Confirm Order