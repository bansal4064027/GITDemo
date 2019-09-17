Story: PS Mobile
Meta:@PSMobile
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario: PAYGUpgrade01 HALO R1.0_Mobile_PAYG Upgrade_TS01_PAYG Upgrade_Upgrade from SIM Package to Phone and SIM Package via Call Center 
Meta:@PAYGUpgrade01
@FolderName PAYGUpgrade01
@Payel
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


Scenario: PAYGUpgrade02  HALO R1.0_Mobile_PAYG Upgrade_TS02_PAYG Upgrade_Upgrade from Phone SIM Package to SIM Package via Call Center 
Meta:@PAYGUpgrade02
@FolderName PAYGUpgrade02
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'PrepaidConsumerdd'
And Create 'NewOrderNoPopUp' 'NewPrepaid' Order
And Promotion is added with 'PrepaidPhoneAndSIM'
And Select Menu 'PromotionEditPackage'
And Add Product 'HandsetforPhoneandSIMPackage'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'EnterIMEIInApple'
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Submit the Order 'Normal Submit'
When ReLogin with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'UpgradeNewMSISDN'
And Retrieve Promotion 'PrepaidPhoneAndSIM'
And Select Promotion
And Retrieve Promotion 'PrepaidPackage'
And Update Promotion for 'UpgradePromo'
And Compare Line Items 'PromotionAdd'
And Retrieve Promotion 'PrepaidPhoneAndSIM'
And Compare Line Items 'PromotionDelete'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownNewMSISDN'
Then Perform Product Services line items validation for Owned product Services 'AllActive'
When Retrieve Promotion 'PrepaidPackage'
Then Select Action from Product&Services Overview for 'PromotionActive'


Scenario: PAYGUpgrade03 HALO R1.0_Mobile_PAYG Upgrade_TS03_PAYG Upgrade_Upgrade from Phone SIM Package to VOXI Package via Call Center 
Meta:@PAYGUpgrade03
@FolderName PAYGUpgrade03
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'PrepaidConsumerVOXI'
And Create 'NewOrderNoPopUp' 'NewPrepaid' Order
And Promotion is added with 'PrepaidPhoneAndSIM'
And Select Menu 'PromotionEditPackage'
And Add Product 'HandsetforPhoneandSIMPackage'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'EnterIMEIInApple'
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Submit the Order 'Normal Submit'
When ReLogin with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'UpgradeNewMSISDN'
And Retrieve Promotion 'PrepaidPhoneAndSIM'
And Select Promotion
And Retrieve Promotion 'PrepaidPromotionVOXI'
And Update Promotion for 'UpgradePromo'
And Compare Line Items 'PromotionAdd'
And Retrieve Promotion 'PrepaidPhoneAndSIM'
And Compare Line Items 'PromotionDelete'
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
When Retrieve Promotion 'PrepaidPromotionVOXI'
Then Select Action from Product&Services Overview for 'PromotionActive'


Scenario: PAYGUpgrade04 HALO R1.0_Mobile_PAYG Upgrade_TS04_PAYG Upgrade_Upgrade from SIM Package to VOXI Package via Call Center 
Meta:@PAYGUpgrade04
@FolderName PAYGUpgrade04
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'PrepaidConsumerVOXI'
And Create 'NewOrderNoPopUp' 'NewPrepaid' Order
And Promotion is added with 'PrepaidPackage'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Then Check Order Status till Complete
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'UpgradeNewMSISDN'
And Retrieve Promotion 'PrepaidPackage'
And Select Promotion
And Retrieve Promotion 'PrepaidPromotionVOXI'
And Update Promotion for 'UpgradePromo'
And Compare Line Items 'PromotionAdd'
And Retrieve Promotion 'PrepaidPackage'
And Compare Line Items 'PromotionDelete'
And Compare Line Items 'ClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID  in OUI and Click Next
And Order Details Capture in Order Summary page
When Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownNewMSISDN'
Then Perform Product Services line items validation for Owned product Services 'AllActive'
When Retrieve Promotion 'PrepaidPromotionVOXI'
Then Select Action from Product&Services Overview for 'PromotionActive'