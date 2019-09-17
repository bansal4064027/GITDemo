Story: ENUMSWAP
Meta:@ENUMSWAPVFUKE7924_POST
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario: ENUMSWAPDISCON02_PRE VFUKE-7924 - UK IT Spring II - ENUM Swap_Place a One net Disconnection Order and validate on Network
Meta:@ENUMSWAPDISCON02_PRE
@FolderName ENUMSWAPDISCON02_PRE
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


Scenario: ENUMSWAPMODIFY03_PRE VFUKE-7924 - UK IT Spring II - ENUM Swap_Place a Modify order on postpay Subscriber and add Bar. Validate on Network
Meta:@ENUMSWAPMODIFY03_PRE
@FolderName ENUMSWAPMODIFY03_PRE
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


Scenario: ENUMSWAPADDVOLTE_PRE_04 VFUKE-7924 - UK IT Spring II - ENUM Swap_Place a Modify order on a postpay subscriberand  add Volte service and validate it on Network
Meta:@ENUMSWAPADDVOLTE_PRE_04
@FolderName ENUMSWAPADDVOLTE_PRE_04
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion110041'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'


Scenario: ENUMSWAPREMOVEVOLTE_PRE_05 VFUKE-7924 - UK IT Spring II - ENUM Swap_Place a Modify order on a postpay account and Remove Volte service. Validate on Network
Meta:@ENUMSWAPREMOVEVOLTE_PRE_05
@FolderName ENUMSWAPREMOVEVOLTE_PRE_05
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


Scenario: ENUMSWAPDISCONVOLTE_PRE_06 VFUKE-7924 - UK IT Spring II - ENUM Swap_Place a Disconnection order on a postpay Account having volte service and validate it on network
Meta:@ENUMSWAPDISCONVOLTE_PRE_06
@FolderName ENUMSWAPDISCONVOLTE_PRE_06
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


Scenario: ENUMSWAPCHANGEMSISDN_PRE_07 VFUKE-7924 - UK IT Spring II - ENUM Swap_Place a change Msisdn order on postpay Subscriber
Meta:@ENUMSWAPCHANGEMSISDN_PRE_07
@FolderName ENUMSWAPCHANGEMSISDN_PRE_07
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


Scenario: ENUMSWAPDELETEBAR_PRE_08 VFUKE-7924 - UK IT Spring II - ENUM Swap_Delete a Bar from Postpay subscription Order and validate on Network
Meta:@ENUMSWAPDELETEBAR_PRE_08
@FolderName ENUMSWAPDELETEBAR_PRE_08
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