Story: New Connections
Meta:@VFUKE8626PaymentServicesPreNvt
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create a new provide


Scenario: PaymentServices003_PreNvt[1] NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Perform Reconnection on a postpay Account and validate on OCS 5
Meta:@PaymentServices003_PreNvt[1]
@FolderName PaymentServices003_PreNvt[1]
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
Then verify the Order line Items 'PostPayRTServiceProfile'
When Reserve Order
And Perform Credit Vet


Scenario: PaymentServices003_PreNvt[2] NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Perform Reconnection on a postpay Account and validate on OCS 5
Meta:@PaymentServices003_PreNvt[2]
@FolderName PaymentServices003_PreNvt[2]
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account '7000562351'
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'ONAccountNon-CardPopNO'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'



Scenario: PaymentServices004_PreNvt[1] NewCo_CCS 19.8_VFUKE-8626-SIT & Technical Go-Live of Payment Services Directive 2_Reconnection Prepaid
Meta:@PaymentServices004_PreNvt[1]
@FolderName PaymentServices004_PreNvt[1]
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'PrepaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPrepaid' Order
And Promotion is added with 'PrepaidPackage'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
Then verify the Order line Items 'PrepayStandardServiceProfile'
When Reserve Order
And Perform Credit Vet


Scenario: PaymentServices004_PreNvt[2] NewCo_CCS 19.8_VFUKE-8626-SIT & Technical Go-Live of Payment Services Directive 2_Reconnection Prepaid
Meta:@PaymentServices004_PreNvt[2]
@FolderName PaymentServices004_PreNvt[2]
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PrepaidPackage'
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'ONAccountNon-CardPopNO'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'


Scenario: PaymentServices005_PreNvt NewCo_CCS 19.8_VFUKE-8626-SIT & Technical Go-Live of Payment Services Directive 2_Upgrade order Postpaid_VOLTE
Meta:@PaymentServices005_PreNvt
@FolderName PaymentServices005_PreNvt
Given Place screenshots in Folder 'FolderName'
Given Login with 'VFREDUSR' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion110044'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'


Scenario: PaymentServices006_PreNvt NewCo_CCS 19.8_VFUKE-8626-SIT & Technical Go-Live of Payment Services Directive 2_Upgrade order Postpaid_Non VOLTE
Meta:@PaymentServices006_PreNvt
@FolderName PaymentServices006_PreNvt
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'VFREDUSR' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidNonVolteCtr13'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'


Scenario: PaymentServices007_PreNvt NewCo_CCS 19.8_VFUKE-8626-SIT & Technical Go-Live of Payment Services Directive 2_Tariff Migration Postpaid
Meta:@PaymentServices007_PreNvt
@FolderName PaymentServices007_PreNvt
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'VFREDUSR' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidTariffMigCtr13110075'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'