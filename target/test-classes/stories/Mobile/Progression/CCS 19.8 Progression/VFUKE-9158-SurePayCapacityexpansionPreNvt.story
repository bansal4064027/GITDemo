Story: New Connections
Meta:@VFUKESurepayCapacityExpansionPreNVT
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create a new provide

Scenario: SurepayCapacityExpansion002_PreNVT NewCo_CCS 19.10_VFUKE-9158_Test Disconnection orders with volte , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion002_PreNVT
@FolderName SurepayCapacityExpansion002_PreNVT
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
And Submit the Order 'Normal Submit'


Scenario: SurepayCapacityExpansion003_PreNVT NewCo_CCS 19.10_VFUKE-9158_Add Data Bar and Data Roaming Bar  , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion003_PreNVT
@FolderName SurepayCapacityExpansion003_PreNVT
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
And Submit the Order 'Normal Submit'


Scenario: SurepayCapacityExpansion004_PreNVT NewCo_CCS 19.10_VFUKE-9158_Delete Data Roaming Bar  , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion004_PreNVT
@FolderName SurepayCapacityExpansion004_PreNVT
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
And Submit the Order 'Normal Submit'


Scenario: SurepayCapacityExpansion005_PreNVT NewCo_CCS 19.10_VFUKE-9158_Perform Modify Promo  , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion005_PreNVT
@FolderName SurepayCapacityExpansion005_PreNVT
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
And Submit the Order 'Normal Submit'


Scenario: SurepayCapacityExpansion006_PreNVT NewCo_CCS 19.10_VFUKE-9158_Perform TOO  , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion006_PreNVT
@FolderName SurepayCapacityExpansion006_PreNVT
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
And Submit the Order 'Normal Submit'


Scenario: SurepayCapacityExpansion007_PreNVT NewCo_CCS 19.10_VFUKE-9158_Perform Add Bundle Journey  , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion007_PreNVT
@FolderName SurepayCapacityExpansion007_PreNVT
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
And Submit the Order 'Normal Submit'


Scenario: SurepayCapacityExpansion008_PreNVT NewCo_CCS 19.10_VFUKE-9158_Perform Change Msisdn  , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion008_PreNVT
@FolderName SurepayCapacityExpansion008_PreNVT
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
And Submit the Order 'Normal Submit'


Scenario: SurepayCapacityExpansion009_PreNVT NewCo_CCS 19.10_VFUKE-9158_Perform Reconnection on a postpay Account  , validate on Primary OCS and check if the request goes via new LDAP-RDR3
Meta:@SurepayCapacityExpansion009_PreNVT
@FolderName SurepayCapacityExpansion009_PreNVT
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
And Submit the Order 'Normal Submit'

