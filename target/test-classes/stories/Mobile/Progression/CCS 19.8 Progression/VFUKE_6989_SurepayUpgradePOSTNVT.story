Story: New Connections
Meta:
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create a new provide


Scenario: Surepay001_PostNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Test New connection orders with volte and validate on OCS 5
Meta:@Surepay001_PostNVT
@Bushra
@FolderName Surepay001_PostNVT
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


Scenario: Surepay002_PostNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Test Disconnection orders with volte and validate on OCS 5
Meta:@Surepay002_PostNVT
@FolderName Surepay002_PostNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account '7000558626'
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'ONAccountNon-CardPopNO'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'


Scenario: Surepay003_PostNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Add Data Bar and Data Roaming Bar and validate on OCS 5
Meta:@Surepay003_PostNVT
@FolderName Surepay003_PostNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledID' with Econfig Item 'DataBarOnAndDataRoamBarOn'
And Submit the Order 'Normal Submit'


Scenario: Surepay004_PostNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Delete Data Roaming Bar and validate on OCS 5
Meta:@Surepay004_PostNVT
@FolderName Surepay004_PostNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account '7000558629'
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledID' with Econfig Item 'DataRoamingBarOff'
And Submit the Order 'Normal Submit'


Scenario: Surepay005_PostNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Perform Modify Promo and upgrade a customer and validate on OCS 5
Meta:@Surepay005_PostNVT
@FolderName Surepay005_PostNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AgentStoke' in 'Env'
When Search The Account '7000559233'
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
When Retrieve Promotion 'PostpaidPromotion4G'
Then verify the Order line Items 'PromotionDelete'



Scenario: Surepay006_PostNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Perform TOO and validate on OCS 5
Meta:@Surepay006_PostNVT
@FolderName Surepay006_PostNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Search The Account '7000558631'
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'TOOWithPromotion'
Given Retrieve Account 'PostpaidConsumer'
Then Perform Transfer Of OwnerShip
When Perform Credit Vet
And Reserve Order
And Submit the Order 'SubmitForTOOJourney'
Then verify the Order line Items 'RootProduct0Add'
Then verify the Order line Items 'PromotionAdd'



Scenario: Surepay007_PostNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Perform Tariff Migration Journey and validate on OCS 5
Meta:@Surepay007_PostNVT
@Bushra
@FolderName Surepay007_PostNVT
Given Place screenshots in Folder 'FolderName'
Given Login with 'TalkMobile' in 'Env'
When Search The Account '7000558633'
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'TarriffMigPostpaidPromotion4G'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
And verify the Order line Items 'PromotionAdd'
When Retrieve Promotion 'PostpaidPromotion4G'
Then verify the Order line Items 'PromotionDelete'
When Search The Account ''
Then Verify the Product and Services for 'AllActiveiveRootProductActive'


Scenario: Surepay008_PostNVT NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Perform Change Msisdn and validate on OCS 5
Meta:@Surepay008_PostNVT
@FolderName Surepay008_PostNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Search The Account '7000558634'
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledID' with Econfig Item 'ClickOnDoneButton'
And Update ICCID against 'ChangeMSISDN'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'