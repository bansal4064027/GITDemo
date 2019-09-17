Story: New Connections
Meta:@VFUKESurepayUpgradePreNVT
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create a new provide


Scenario: Surepay002_PreNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Test Disconnection orders with volte and validate on OCS 5
Meta:@Surepay002_PreNVT
@FolderName Surepay002_PreNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Customise 'RootProduct' with Econfig Item 'Extra1GBDataMonthlyOn'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'NoSubmit'


Scenario: Surepay003_PreNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Add Data Bar and Data Roaming Bar and validate on OCS 5
Meta:@Surepay003_PreNVT
@FolderName Surepay003_PreNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'NoSubmit'



Scenario: Surepay004_PreNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Delete Data Roaming Bar and validate on OCS 5
Meta:@Surepay004_PreNVT
@FolderName Surepay004_PreNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Customise 'RootProduct' with Econfig Item 'DataRoamingBarOn'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'NoSubmit'


Scenario: Surepay005_PreNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Perform Modify Promo and upgrade a customer and validate on OCS 5
Meta:@Surepay005_PreNVT
@FolderName Surepay005_PreNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'NoSubmit'



Scenario: Surepay006_PreNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Perform TOO and validate on OCS 5
Meta:@Surepay006_PreNVT
@FolderName Surepay006_PreNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'NoSubmit'



Scenario: Surepay007_PreNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Perform Tariff Migration Journey and validate on OCS 5
Meta:@Surepay007_PreNVT
@Bushra
@FolderName Surepay007_PreNVT
Given Place screenshots in Folder 'FolderName'
Given Login with 'TalkMobile' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'NoSubmit'


Scenario: Surepay008_PreNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Perform Change Msisdn and validate on OCS 5
Meta:@Surepay008_PreNVT
@FolderName Surepay008_PreNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'NoSubmit'



Scenario: MultiDeviceRetrofit001 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Validate that new connection Multi device secondary subscription with iWatch is placed on an active PAYM with wi-fi calling &4G
Meta:@MultiDeviceRetrofit001
@FolderName MultiDeviceRetrofit001
@Zeba	
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform One Number Validation for 'SelectActiveStatusMSISDN' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryOnHold'
When Check order in Account Overview Page for 'CheckModifyComplete'
When Check order in Account Overview Page for 'CheckSecondaryOpen'
When Check if Order has reached Dispatch Shipping Task in OSM
And Dispatch 'ESIM' order via FMW XML
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryComplete'
