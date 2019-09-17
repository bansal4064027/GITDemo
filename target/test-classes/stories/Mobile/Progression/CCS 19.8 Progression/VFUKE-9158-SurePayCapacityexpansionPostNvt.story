Story: New Connections
Meta:@VFUKESurepayCapacityExpansionPostNVT
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create a new provide


Scenario: SurepayCapacityExpansion001_PostNVT NewCo_CCS 19.10_VFUKE-9158_Test New connection orders with volte , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion001_PostNVT
@Bushra
@FolderName SurepayCapacityExpansion001_PostNVT
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


Scenario: SurepayCapacityExpansion002_PostNVT NewCo_CCS 19.10_VFUKE-9158_Test Disconnection orders with volte , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion002_PostNVT
@FolderName SurepayCapacityExpansion002_PostNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'ONAccountNon-CardPopNO'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'


Scenario: SurepayCapacityExpansion003_PostNVT NewCo_CCS 19.10_VFUKE-9158_Add Data Bar and Data Roaming Bar  , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion003_PostNVT
@FolderName SurepayCapacityExpansion003_PostNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledID' with Econfig Item 'DataBarOnAndDataRoamBarOn'
And Submit the Order 'Normal Submit'


Scenario: SurepayCapacityExpansion004_PostNVT NewCo_CCS 19.10_VFUKE-9158_Delete Data Roaming Bar  , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion004_PostNVT
@FolderName SurepayCapacityExpansion004_PostNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledID' with Econfig Item 'DataRoamingBarOff'
And Submit the Order 'Normal Submit'


Scenario: SurepayCapacityExpansion005_PostNVT NewCo_CCS 19.10_VFUKE-9158_Perform Modify Promo  , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion005_PostNVT
@FolderName SurepayCapacityExpansion005_PostNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AgentStoke' in 'Env'
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
When Retrieve Promotion 'PostpaidPromotion4G'
Then verify the Order line Items 'PromotionDelete'


Scenario: SurepayCapacityExpansion006_PostNVT NewCo_CCS 19.10_VFUKE-9158_Perform TOO  , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion006_PostNVT
@FolderName SurepayCapacityExpansion006_PostNVT
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

Scenario: SurepayCapacityExpansion008_PostNVT NewCo_CCS 19.10_VFUKE-9158_Perform Change Msisdn  , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion008_PostNVT
@FolderName SurepayCapacityExpansion008_PostNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Search The Account ''
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


Scenario: SurepayCapacityExpansion009_PostNVT NewCo_CCS 19.10_VFUKE-9158_Perform Reconnection on a postpay Account  , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion009_PostNVT
@FolderName SurepayCapacityExpansion009_PostNVT
@Bushra
Given Place screenshots in Folder 'FolderName'
And Retrieve Account 'PostpaidConsumer'
Given Login with 'RETAIL' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'ONAccountNon-CardPopNO'
When Submit the Order 'SubmitForDisconnectionforCollectionsJourney'
When Search The Account ''
And Modify with owned product 'ReconnectWithRootProd'
When Submit the Order 'SubmitForReconnectionJourney'
Then verify the Order line Items 'RootProduct0Add'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'