Story: New Connections
Meta:@VFUKE8626PaymentServicesPostNvt
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create a new provide


Scenario: PaymentServices001_PostNvt NewCo_CCS 19.8_VFUKE-8626-SIT & Technical Go-Live of Payment Services Directive 2_New Connection Postpaid
Meta:@PaymentServices001_PostNvt
@FolderName PaymentServices001_PostNvt
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
Then verify the Order line Items 'PostPayRTServiceProfile'
When Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'



Scenario: PaymentServices002_PostNvt NewCo_CCS 19.8_VFUKE-8626-SIT & Technical Go-Live of Payment Services Directive 2_New Connection Prepaid
Meta:@PaymentServices002_PostNvt
@FolderName PaymentServices002_PostNvt
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PrepaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPrepaid' Order
And Promotion is added with 'PrepaidPackage'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
Then verify the Order line Items 'PrepayStandardServiceProfile'
When Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'




Scenario: PaymentServices003_PostNvt NewCo_CCS 19.8_VFUKE-6898_SurePay SW Upgrade_Perform Reconnection on a postpay Account and validate on OCS 5
Meta:@PaymentServices003_PostNvt
@FolderName PaymentServices003_PostNvt
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify with owned product 'ReconnectWithRootProd'
When Submit the Order 'SubmitForReconnectionJourney'
Then verify the Order line Items 'PostPayRTServiceProfile'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'



Scenario: PaymentServices004_PostNvt NewCo_CCS 19.8_VFUKE-8626-SIT & Technical Go-Live of Payment Services Directive 2_Reconnection Prepaid
Meta:@PaymentServices004_PostNvt
@FolderName PaymentServices004_PostNvt
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PrepaidPackage'
And Modify with owned product 'ReconnectWithRootProd'
When Submit the Order 'SubmitForReconnectionJourney'
Then verify the Order line Items 'PrepayStandardServiceProfile'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'


Scenario: PaymentServices005_PostNvt NewCo_CCS 19.8_VFUKE-8626-SIT & Technical Go-Live of Payment Services Directive 2_Upgrade order Postpaid_Non VOLTE
Meta:@PaymentServices005_PostNvt
@FolderName PaymentServices005_PostNvt
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidPromotion110044'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidPromotion110044'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidVodafoneSecureNetPromotion'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'PostPayRTServiceProfile'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'


Scenario: PaymentServices006_PostNvt NewCo_CCS 19.8_VFUKE-8626-SIT & Technical Go-Live of Payment Services Directive 2_Upgrade order Postpaid_Non VOLTE
Meta:@PaymentServices006_PostNvt
@FolderName PaymentServices006_PostNvt
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidNonVolteCtr13'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidNonVolteCtr13'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidNonVolte105948Ctr15'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'PostPayRTServiceProfile'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'



Scenario: PaymentServices007_PostNvt NewCo_CCS 19.8_VFUKE-8626-SIT & Technical Go-Live of Payment Services Directive 2_Tariff Migration Postpaid
Meta:@PaymentServices007_PostNvt
@Bushra
@FolderName PaymentServices007_PostNvt
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account '7000566156'
And Retrieve Promotion 'PostpaidTariffMigCtr13110075'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'PostpaidTariffMigCtr15111428'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
And verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'PostPayRTServiceProfile'
When Retrieve Promotion 'PostpaidTariffMigCtr13110075'
Then verify the Order line Items 'PromotionDelete'
When Search The Account ''
Then Verify the Product and Services for 'AllActiveiveRootProductActive'

