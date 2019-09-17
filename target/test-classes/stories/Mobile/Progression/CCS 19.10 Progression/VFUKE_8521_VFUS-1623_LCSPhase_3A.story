Story: HALO DVT
Meta:@LCSStories
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario:LCS3A_Enablement_01 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 10_Validate Agent Places Return over Upgrade order on PAYM EBU account 
Meta:@LCS3A_Enablement_01
@FolderName LCS3A_Enablement_01 
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
And ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidPromotion4G'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotionReInventCTR15b'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotionVolte'
Then Perform Migration
When Submit the Order 'Normal Submit'
When ReLogin with 'STORE' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidPromotionVolte'
Then Perform the action 'ReturnWithPromotion'
When Make payment with 'ONAccountRefund'
And Submit the Order 'SubmitForReturnJourney'
Then verify the Order line Items 'RootProduct0Delete'




Scenario:LCS3A_Enablement_02 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 11_Validate Agent Places Return over Upgrade order on PAYM CBU account
Meta:@LCS3A_Enablement_02
@FolderName LCS3A_Enablement_02 
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
And ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidPromotion4G'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotionReInventCTR15b'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotionVolte'
Then Perform Migration
When Submit the Order 'Normal Submit'
When ReLogin with 'STORE' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Retrieve Promotion 'PostpaidPromotionVolte'
And Select Action from Owned Product and Services (Account Overview)'ReturnOnDevice'
And Compare Line Items 'PromotionDelete'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order



Scenario:LCS3A_Enablement_03 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 12_Validate Agent Places Return over Upgrade order on MBB CBU account
Meta:@LCS3A_Enablement_03
@FolderName LCS3A_Enablement_03
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT02' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidPromotionMBB4G'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotionMBB'
Then Perform Migration
When Submit the Order 'Normal Submit'
When ReLogin with 'STORE' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidPromotionMBB'
Then Perform the action 'ReturnWithPromotion'
When Make payment with 'ONAccountRefund'
And Submit the Order 'SubmitForReturnJourney'
Then verify the Order line Items 'RootProduct0Delete'




Scenario:LCS3A_Enablement_04 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 13_Validate Agent Places Return over Upgrade order on MBB EBU account
Meta:@LCS3A_Enablement_04
@FolderName LCS3A_Enablement_04
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT02' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidPromotionMBB4G'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotionMBB'
Then Perform Migration
When Submit the Order 'Normal Submit'
When ReLogin with 'STORE' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidPromotionMBB'
Then Perform the action 'ReturnWithPromotion'
When Make payment with 'ONAccountRefund'
And Submit the Order 'SubmitForReturnJourney'
Then verify the Order line Items 'RootProduct0Delete'




Scenario:LCS3A_Enablement_05 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 14_Validate Agent Places Return order on PAYM CBU account
Meta:@LCS3A_Enablement_05
@FolderName LCS3A_Enablement_05
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpayConsumerHandset'
And Create New 'NewPostpaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Select Menu 'PromotionEditPackage'
And Add Product 'SpecificHandset076935'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterIMEIInApple'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'STORE' in 'Env'
When Search The Account ''
Then Perform the action 'ReturnApple'
When Reserve Order
And Make payment with 'ONAccountRefund'
And Submit the Order 'SubmitForReturnJourney'
Then verify the Order line Items 'Apple*Delete'



Scenario:LCS3A_Enablement_05 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 14_Validate Agent Places Return order on PAYM CBU account
Meta:@LCS3A_Enablement_05
@FolderName LCS3A_Enablement_05
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpayConsumerHandset'
And Create New 'NewPostpaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Select Menu 'PromotionEditPackage'
And Add Product 'SpecificHandset076935'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterIMEIInApple'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'STORE' in 'Env'
When Search The Account ''
Then Perform the action 'ReturnApple'
When Reserve Order
And Make payment with 'ONAccountRefund'
And Submit the Order 'SubmitForReturnJourney'
Then verify the Order line Items 'Apple*Delete'


Scenario:LCS3A_Enablement_06 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 13_Validate Agent Places Return over Upgrade order on MBB EBU account
Meta:@LCS3A_Enablement_06
@FolderName LCS3A_Enablement_06
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create New 'NewPostpaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Select Menu 'PromotionEditPackage'
And Add Product 'SimoDongleSimoDongleVodafoneK4203'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'EnterIMEIinVodafone'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'STORE' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
Then Perform the action 'ReturnWithPromotion'
When Make payment with 'ONAccountRefund'
And Submit the Order 'SubmitForReturnJourney'
Then verify the Order line Items 'RootProduct0Delete'



Scenario:LCS3A_Enablement_07 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC24 Validate Agent Places Upgrade order On PAYM CBU account
Meta:@LCS3A_Enablement_07
@FolderName LCS3A_Enablement_07
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
And ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidPromotion4G'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotionReInventCTR15b'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotionVolte'
Then Perform Migration
When Submit the Order 'Normal Submit'
When Retrieve Promotion 'PostpaidPromotionReInventCTR15b'
Then verify the Order line Items 'PromotionDelete'



Scenario:LCS3A_Enablement_08 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC25 Validate Agent Places Upgrade order On PAYM EBU account 
Meta:@LCS3A_Enablement_08
@FolderName LCS3A_Enablement_08
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
And ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidPromotion4G'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotionReInventCTR15b'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotionVolte'
Then Perform Migration
When Submit the Order 'Normal Submit'
When Retrieve Promotion 'PostpaidPromotionReInventCTR15b'
Then verify the Order line Items 'PromotionDelete'



Scenario:LCS3A_Enablement_09 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC26_Validate Agent Places Upgrade order on MBB CBU account
Meta:@LCS3A_Enablement_09
@FolderName LCS3A_Enablement_09
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT02' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotionMBB'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'PromotionAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'




Scenario:LCS3A_Enablement_10 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC27_Validate Agent Places Upgrade order on MBB EBU account
Meta:@LCS3A_Enablement_10
@FolderName LCS3A_Enablement_10
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT02' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotionMBB'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'PromotionAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'





Scenario:LCS3A_Enablement_10 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC27_Validate Agent Places Upgrade order on MBB EBU account
Meta:@LCS3A_Enablement_10
@FolderName LCS3A_Enablement_10
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT02' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotionMBB'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'PromotionAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'





Scenario:LCS3A_Enablement_10 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC27_Validate Agent Places Upgrade order on MBB EBU account
Meta:@LCS3A_Enablement_10
@FolderName LCS3A_Enablement_10
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT02' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotionMBB'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'PromotionAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'





Scenario: LCS3A_Enablement_11 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC30_Validate Agent Places Tariff Migration order On PAYM CBU account
Meta:@LCS3A_Enablement_11
@FolderName LCS3A_Enablement_11
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotionReInventCTR15b'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'PopstpaidPromotion110047'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
And verify the Order line Items 'PromotionAdd'
When Retrieve Promotion 'PostpaidPromotion4G'
Then verify the Order line Items 'PromotionDelete'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'



Scenario: LCS3A_Enablement_12 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC31_Validate Agent Places Tariff Migration order On MBB CBU account 
Meta:@LCS3A_Enablement_12
@FolderName LCS3A_Enablement_12
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'TarriffMigPostpaidPromotionMBB4G'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
And verify the Order line Items 'PromotionAdd'
When Retrieve Promotion 'PostpaidPromotionMBB4G'
Then verify the Order line Items 'PromotionDelete'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'





Scenario: LCS3A_Enablement_13 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC32_Validate Agent Places Tariff Migration order On PAYM EBU account
Meta:@LCS3A_Enablement_13
@FolderName LCS3A_Enablement_13
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotionReInventCTR15b'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'PopstpaidPromotion110047'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
And verify the Order line Items 'PromotionAdd'
When Retrieve Promotion 'PostpaidPromotion4G'
Then verify the Order line Items 'PromotionDelete'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'



Scenario: LCS3A_Enablement_14  CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC33_Validate Agent Places Tariff Migration order On MBB EBU account 
Meta:@LCS3A_Enablement_14
@FolderName LCS3A_Enablement_14
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'TarriffMigPostpaidPromotionMBB4G'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
And verify the Order line Items 'PromotionAdd'
When Retrieve Promotion 'PostpaidPromotionMBB4G'
Then verify the Order line Items 'PromotionDelete'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'



Scenario: LCS3A_Enablement_15 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC34_Return over Tariff Migration for PAYM LCS Promotions 
Meta:@LCS3A_Enablement_15
@FolderName LCS3A_Enablement_15
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'LCSPromotion111053'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'LCSPromotion111053'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'PopstpaidPromotion110047'
Then Perform Migration
When Submit the Order 'Normal Submit'
When ReLogin with 'STORE' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PopstpaidPromotion110047'
Then Perform the action 'ReturnWithPromotion'
When Make payment with 'ONAccountRefund'
And Submit the Order 'SubmitForReturnJourney'
Then verify the Order line Items 'RootProduct0Delete'




Scenario: LCS3A_Enablement_16 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 16_Validate Agent Places “Reconnection” order on PAYM CBU account
Meta:@LCS3A_Enablement_16
@FolderName LCS3A_Enablement_16
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'PostpayConsumerHandset'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Select Menu 'PromotionEditPackage'
And Add Product 'SpecificHandset080011'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterIMEIInApple'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
When Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotionReInventCTR15b'
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'CashNon-CardPopNO'
When Submit the Order 'SubmitForDisconnectionforCollectionsJourney'
When Search The Account ''
And Modify with owned product 'ReconnectWithRootProd'
When Submit the Order 'SubmitForReconnectionJourney'
Then verify the Order line Items 'RootProduct0Add'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'




Scenario: LCS3A_Enablement_17 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 19_Validate Agent Places “Reconnection” order on MBB CBU account
Meta:@LCS3A_Enablement_17
@FolderName LCS3A_Enablement_17
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'PostpayConsumerHandset'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'CashNon-CardPopNO'
When Submit the Order 'SubmitForDisconnectionforCollectionsJourney'
When Search The Account ''
And Modify with owned product 'ReconnectWithRootProd'
When Submit the Order 'SubmitForReconnectionJourney'
Then verify the Order line Items 'RootProduct0Add'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'




Scenario: LCS3A_Enablement_18 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 18_Validate Agent Places “Reconnection” order on MBB EBU account
Meta:@LCS3A_Enablement_18
@FolderName LCS3A_Enablement_18
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT02' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'CashNon-CardPopNO'
When Submit the Order 'SubmitForDisconnectionforCollectionsJourney'
When Search The Account ''
And Modify with owned product 'ReconnectWithRootProd'
When Submit the Order 'SubmitForReconnectionJourney'
Then verify the Order line Items 'RootProduct0Add'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'



Scenario:LCS3A_Enablement_19 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 20_Validate Agent Places “Disconnection” order on PAYM CBU account
Meta:@LCS3A_Enablement_19
@FolderName LCS3A_Enablement_19
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Customise 'RootProduct' with Econfig Item 'Extra1GBDataMonthlyOn'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'ONAccountNon-CardPopNO'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'



Scenario: LCS3A_Enablement_20 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC23 Validate Agent Places “Disconnection” order on MBB EBU account
Meta:@LCS3A_Enablement_20
@FolderName LCS3A_Enablement_20
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create New 'NewPostpaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Submit the Order 'Normal Submit'
When Search The Account ''
Then Perform the action 'DisconnectWithPromotion'
When Submit the Order 'SubmitForDisconnectionJourney'


 
Scenario: LCS3A_Enablement_21 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 06_Validate agent places TOO order on  CBU PAYM account
Meta:@LCS3A_Enablement_21
@FolderName LCS3A_Enablement_21
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotionReInventCTR15b'
Then Perform the action 'TOOWithPromotion'
Given Retrieve Account 'PostpaidConsumer'
Then Perform Transfer Of OwnerShip
When Perform Credit Vet
And Reserve Order
And Submit the Order 'SubmitForTOOJourney'
Then verify the Order line Items 'RootProduct0Add'
Then verify the Order line Items 'PromotionAdd'



Scenario: LCS3A_Enablement_22 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 07_Validate agent places TOO order on  EBU MBB account
Meta:@LCS3A_Enablement_22
@FolderName LCS3A_Enablement_22
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'VFREDUSR' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidMBBTabletPlan110703'
Then Perform the action 'TOOWithPromotion'
Given Retrieve Account 'PostpaidConsumerMBB'
Then Perform Transfer Of OwnerShip
When Perform Credit Vet
And Reserve Order
And Submit the Order 'SubmitForTOOJourney'
Then verify the Order line Items 'RootProduct0Add'
Then verify the Order line Items 'PromotionAdd'


Scenario: LCS3A_Enablement_23 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 02_Validate Agent Places new Connection Order With PAYM CBU Account8:17 PM 8/26/2019
Meta:@LCS3A_Enablement_23
@FolderName LCS3A_Enablement_23
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'


Scenario: LCS3A_Enablement_24 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 02_Validate Agent Places new Connection Order With PAYM EBU Account
Meta:@LCS3A_Enablement_24
@FolderName LCS3A_Enablement_24
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'


Scenario: LCS3A_Enablement_25 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 02_Validate Agent Places new Connection Order With MBB CBU Account
Meta:@LCS3A_Enablement_25
@FolderName LCS3A_Enablement_25
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'


Scenario: LCS3A_Enablement_26 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 02_Validate Agent Places new Connection Order With PAYM EBU Account
Meta:@LCS3A_Enablement_26
@FolderName LCS3A_Enablement_26
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'



Scenario:LCS3A_Enablement_27 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 20_Validate Agent Places “Disconnection” order on PAYM EBU account
Meta:@LCS3A_Enablement_27
@FolderName LCS3A_Enablement_27
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Customise 'RootProduct' with Econfig Item 'Extra1GBDataMonthlyOn'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'ONAccountNon-CardPopNO'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'



Scenario: LCS3A_Enablement_28 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC23 Validate Agent Places “Disconnection” order on MBB CBU account
Meta:@LCS3A_Enablement_28
@FolderName LCS3A_Enablement_28
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create New 'NewPostpaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PostpaidMBBTabletPlan110703'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Submit the Order 'Normal Submit'
When Search The Account ''
Then Perform the action 'DisconnectWithPromotion'
When Submit the Order 'SubmitForDisconnectionJourney'




Scenario: LCS3A_Enablement_29 CCS 19.10_VFUKE_8521_VFUS-1623_Mobile_TC 16_Validate Agent Places “Reconnection” order on PAYM EBU account
Meta:@LCS3A_Enablement_29
@FolderName LCS3A_Enablement_29
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionReInventCTR15b'
And Select Menu 'PromotionEditPackage'
And Add Product 'SpecificHandset080011'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterIMEIInApple'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
When Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotionReInventCTR15b'
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'CashNon-CardPopNO'
When Submit the Order 'SubmitForDisconnectionforCollectionsJourney'
When Search The Account ''
And Modify with owned product 'ReconnectWithRootProd'
When Submit the Order 'SubmitForReconnectionJourney'
Then verify the Order line Items 'RootProduct0Add'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'
