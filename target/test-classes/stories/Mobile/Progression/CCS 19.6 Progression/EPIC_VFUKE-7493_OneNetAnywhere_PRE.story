Story: OnenetAnywhere Pre NVT
Meta:@OnenetAnywhere_Pre
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario: OneNetAnywhere_01_PRE NewCo_CCS 19.6_VFUS- 1352_One Net Anywhere-CCS Terminal Barring_Validate that the agents places a modify order to add All Calls Outgoing Only Bar to standalone one net promotions 
Meta:@OneNetAnywhere_01_PRE
@FolderName OneNetAnywhere_01_PRE
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'OneNetStandAlonePromotion108851'
And Get the BBIP Number
And Update BBIP by performing 'UpdateBBIP' on 'OneNetFixedDataServiceAboutRecord'
When Get the Random IMEI Number
And Update ICCID against 'EnterRandomIMEIinADSLOneNetRout'
And Reserve Order
And Perform Credit Vet
When Submit the Order 'Normal Submit'


Scenario: OneNetAnywhere_02_PRE_NVT NewCo_CCS 19.6_VFUS- 1352_One Net Anywhere-CCS Terminal Barring_Validate that the agents places a modify order to add All Calls Outgoing Only Bar to one net mobile promotions.
Meta:@OneNetAnywhere_02_PRE_NVT
@FolderName OneNetAnywhere_02_PRE_NVT
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'OnenetMobilePromotion'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'


Scenario: OneNetAnywhere_05_PRE NewCo_CCS 19.6_VFUS- 1352_One Net Anywhere-CCS Terminal Barring_Validate that the agents places a modify order to add All Calls Outgoing Only Bar to one net complete promotions 
Meta:@OneNetAnywhere_05_PRE
@FolderName OneNetAnywhere_05_PRE
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'OnenetPromotionBusiness'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
Given Retrieve Account 'PostpaidConsumer'
When Customise 'FixedService' with Econfig Item 'AreaCodeSelectConfPhoneOFFIPphoneONClickCallForwardTextMSISDN'
And Update ICCID against 'EnterIMEIIPphone'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'SubmitandNoOrderCheck'


Scenario: OneNetAnywhere_08_PRE_NVT NewCo_CCS 19.6_VFUS- 1352_One Net Anywhere-CCS Terminal Barring_Validate that the agents places a Tariff migration order to add All Calls Outgoing Only Bar to standalone one net promotions.
Meta:@OneNetAnywhere_08_PRE_NVT
@FolderName OneNetAnywhere_08_PRE_NVT
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'OnenetMobilePromotion'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'