Story: ENUMSWAP
Meta:@ENUMSWAPVFUKE7924_POST
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario: ENUMSWAPNEWCONN_POST_01 VFUKE-7924 - UK IT Spring II - ENUM Swap_Place a One net New connection Order and validate on Network
Meta:@ENUMSWAPNEWCONN_POST_01
@FolderName ENUMSWAPNEWCONN_POST_01
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'WiFiAnd4GCallingOff'
And Select Menu 'PromotionEditPackage'
And Add Product 'FixedService'
When Customise 'FixedService' with Econfig Item 'AreacodeFixedService'
And Customise 'RootProduct' with Econfig Item 'VodaOneNetAnywhere'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'SubmitForStolenBarAddJourneyNoOrderCheck'


Scenario: ENUMSWAPDISCON_POST_02 VFUKE-7924 - UK IT Spring II - ENUM Swap_Place a One net Disconnection Order and validate on Network
Meta:@ENUMSWAPDISCON_POST_02
@FolderName ENUMSWAPDISCON_POST_02
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'OnenetPromotionBusiness'
Then Perform the action 'DisconnectWithInstalledIDPrep'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'


Scenario: ENUMSWAPMODIFY_POST_03 VFUKE-7924 - UK IT Spring II - ENUM Swap_Place a Modify order on postpay Subscriber and add Bar. Validate on Network
Meta:@ENUMSWAPMODIFY_POST_03
@FolderName ENUMSWAPMODIFY_POST_03
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledID' with Econfig Item 'DataBarOn'
And Submit the Order 'Normal Submit'



Scenario: ENUMSWAPADDVOLTE_POST_04 VFUKE-1762- ASAP Changes to provision IPWorks_Place a Modify order on Subscriber and add Bar. Validate on Network
Meta:@ENUMSWAPADDVOLTE_POST_04
@FolderName ENUMSWAPADDVOLTE_POST_04
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion110041'
And Modify 'ModifyWithInstalledID' with Econfig Item 'WiFiAnd4GCalling'
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'WiFiand4GcallingAdd'
When Search The Account ''
Then Verify the Product and Services for 'AllActiveRootPWi-FiCallingExist'


Scenario: ENUMSWAPREMOVEVOLTE_POST_05  VFUKE-7924 - UK IT Spring II - ENUM Swap_Place a Modify order on a postpay account and Remove Volte service. Validate on Network
Meta:@ENUMSWAPREMOVEVOLTE_POST_05 
@FolderName ENUMSWAPREMOVEVOLTE_POST_05 
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledID' with Econfig Item 'WiFiAnd4GCallingOff'
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'WiFiand4GcallingDelete'
When Search The Account ''
Then Verify the Product and Services for 'AllActiveRootPWi-FiCallingNotExist'


Scenario: ENUMSWAPDISCONVOLTE_POST_06 VFUKE-7924 - UK IT Spring II - ENUM Swap_Place a Disconnection order on a postpay Account having volte service and validate it on network
Meta:@ENUMSWAPDISCONVOLTE_POST_06
@FolderName ENUMSWAPDISCONVOLTE_POST_06
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'DisconnectWithInstalledIDPrep'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'


Scenario: ENUMSWAPCHANGEMSISDN_POST_07 VFUKE-7924 - UK IT Spring II - ENUM Swap_Place a change Msisdn order on postpay Subscriber
Meta:@ENUMSWAPCHANGEMSISDN_POST_07
@FolderName ENUMSWAPCHANGEMSISDN_POST_07
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Modify 'ModifyWithInstalledID' with Econfig Item 'ClickOnDoneButton'
And Update ICCID against 'ChangeMSISDN'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'

Scenario: ENUMSWAPDELETEBAR_POST_08 VFUKE-7924 - UK IT Spring II - ENUM Swap_Delete a Bar from Postpay subscription Order and validate on Network
Meta:@ENUMSWAPDELETEBAR_POST_08
@FolderName ENUMSWAPDELETEBAR_POST_08
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledID' with Econfig Item 'DataRoamingBarOff'
And Submit the Order 'Normal Submit'
