Story: Enablement DVT
Meta:@IsaacSharer
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario: IsaacSharer_01 PAYM customer is upgrading to Parent Sharer with Data Bar, Vodafone CXX Bundle and Option	
Meta:@IsaacSharer_01
@FolderName IsaacSharer_01
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'DataBarOn'
And Customise 'RootProduct' with Econfig Item 'OptionalExtra1GBAdd'
And Customise 'RootProduct' with Econfig Item 'VoicemailOff'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidPromotion4G'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotionParentBusinessSharer'
Then Perform Migration
When Customise 'RootProduct' with Econfig Item 'BusinessPlusMemberOFFBusinessPlusLeaderON'
When Submit the Order 'Normal Submit'
When Retrieve Promotion 'PostpaidPromotionParentBusinessSharer'
Then verify the Order line Items 'PromotionAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'


Scenario: IsaacSharer_02 PAYM customer is migrating to Parent Sharer with MMS Bar, Vodafone CXX Bundle and Option	
Meta:@IsaacSharer_02
@FolderName IsaacSharer_02
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'VFREDUSR' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'MMSIncomingBarOn'
And Customise 'RootProduct' with Econfig Item 'OptionalExtra1GBAdd'
And Customise 'RootProduct' with Econfig Item 'VoicemailOff'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'UniversalPackagePromotion'
Then Perform Migration
When Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'UniversalPackagePromotion'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'PostpaidPromotionParentBusinessSharer'
Then Perform Migration
When Customise 'RootProduct' with Econfig Item 'BusinessPlusMemberOFFBusinessPlusLeaderON'
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
And verify the Order line Items 'PromotionAdd'
When Retrieve Promotion 'PostpaidPromotion4G'
Then verify the Order line Items 'PromotionDelete'
When Search The Account ''
Then Verify the Product and Services for 'AllActiveiveRootProductActive'


Scenario: IsaacSharer_03 PAYM customer is upgrading to Child Sharer with SMS Bar, Vodafone CXX Bundle and Option
Meta:@IsaacSharer_03
@FolderName IsaacSharer_03
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'SMSIncmgOnlyBarOn'
And Customise 'RootProduct' with Econfig Item 'OptionalExtra1GBAdd'
And Customise 'RootProduct' with Econfig Item 'VoicemailOff'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidPromotion4G'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotionChildBusinessSharer'
Then Perform Migration
When Promotion is added with 'PostpaidPromotionParentBusinessSharer'
And Customise 'RootProduct' with Econfig Item 'BusinessPlusMemberOFFBusinessPlusLeaderON'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecordIndex1'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimIndex'
When Submit the Order 'Normal Submit'
When Retrieve Promotion 'PostpaidPromotionChildBusinessSharer'
Then verify the Order line Items 'PromotionAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'


Scenario: IsaacSharer_04 PAYM customer is migrating to Parent Sharer with Stolen Bar, Vodafone CXX Bundle and Option
Meta:@IsaacSharer_04
@Bushra
@FolderName IsaacSharer_04
Given Place screenshots in Folder 'FolderName'
Given Login with 'VFREDUSR' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'StolenOn'
And Customise 'RootProduct' with Econfig Item 'OptionalExtra1GBAdd'
And Customise 'RootProduct' with Econfig Item 'VoicemailOff'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'EBUSharerUniversalPackage'
Then Perform Migration
When Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'EBUSharerUniversalPackage'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'PostpaidPromotionChildBusinessSharer'
Then Perform Migration
When Promotion is added with 'PostpaidPromotionParentBusinessSharer'
When Customise 'RootProduct' with Econfig Item 'BusinessPlusMemberOFFBusinessPlusLeaderON'
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
And verify the Order line Items 'PromotionAdd'
When Retrieve Promotion 'PostpaidPromotion4G'
Then verify the Order line Items 'PromotionDelete'
When Search The Account ''
Then Verify the Product and Services for 'AllActiveiveRootProductActive'


Scenario: IsaacSharer_05 Child Sharer customer is upgrading to PAYM with Bar, Vodafone CXX Bundle and Option
Meta:@IsaacSharer_05
@FolderName IsaacSharer_05
@Bushra
Given Place screenshots in Folder 'FolderName'
And Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionChildBusinessSharer'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Promotion is added with 'PostpaidPromotionParentBusinessSharer'
And Customise 'RootProduct' with Econfig Item 'BusinessPlusMemberOFFBusinessPlusLeaderON'
And Customise 'RootProduct' with Econfig Item 'DataBarOn'
And Customise 'RootProduct' with Econfig Item 'OptionalExtra1GBAdd'
And Customise 'RootProduct' with Econfig Item 'VoicemailOff'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecordIndex1'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimIndex'
And Perform Credit Vet
And Reserve Order
And Submit the Order 'Normal Submit'
When ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidPromotion4G'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidPromotionChildBusinessSharer'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotion4G'
Then Perform Migration
When Submit the Order 'Normal Submit'
When Retrieve Promotion 'PostpaidPromotion4G'
Then verify the Order line Items 'PromotionAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'


Scenario: IsaacSharer_06 PAYM customer is migrating to Parent Sharer with MMS Bar, Vodafone CXX Bundle and Option	
Meta:@IsaacSharer_06
@FolderName IsaacSharer_06
@Bushra
Given Place screenshots in Folder 'FolderName'
And Login with 'VFREDUSR' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionChildBusinessSharer'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Promotion is added with 'PostpaidPromotionParentBusinessSharer'
And Customise 'RootProduct' with Econfig Item 'BusinessPlusMemberOFFBusinessPlusLeaderON'
And Customise 'RootProduct' with Econfig Item 'DataBarOn'
And Customise 'RootProduct' with Econfig Item 'OptionalExtra1GBAdd'
And Customise 'RootProduct' with Econfig Item 'VoicemailOff'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecordIndex1'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimIndex'
And Perform Credit Vet
And Reserve Order
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotionChildBusinessSharer'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'EBUSharerUniversalPackage'
Then Perform Migration
When Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'EBUSharerUniversalPackage'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'PostpaidPromotion4G'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
And verify the Order line Items 'PromotionAdd'
When Retrieve Promotion 'PostpaidPromotionChildBusinessSharer'
Then verify the Order line Items 'PromotionDelete'
When Search The Account ''
Then Verify the Product and Services for 'AllActiveiveRootProductActive'


Scenario: IsaacSharer_07 Parent Sharer customer is upgrading to PAYM with Bar, Vodafone CXX Bundle and Option
Meta:@IsaacSharer_07
@FolderName IsaacSharer_07
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionParentBusinessSharer'
And Customise 'RootProduct' with Econfig Item 'BusinessPlusMemberOFFBusinessPlusLeaderON'
And Customise 'RootProduct' with Econfig Item 'DataBarOn'
And Customise 'RootProduct' with Econfig Item 'OptionalExtra1GBAdd'
And Customise 'RootProduct' with Econfig Item 'VoicemailOff'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When ReLogin with 'AgentStoke' in 'Env'
When Search The Account ''
And Select 'UsedProdCommitment&DrillDown' AgreementId
And Retrieve Promotion 'PostpaidPromotion4G'
And Change the Date
When ReLogin with 'AGENT04' in 'Env'
And Search The Account ''
And Retrieve Promotion 'PostpaidPromotionParentBusinessSharer'
Then Perform the action 'ModifyPromoWithPromotion'
When Retrieve Promotion 'PostpaidPromotion4G'
Then Perform Migration
When Submit the Order 'Normal Submit'
When Retrieve Promotion 'PostpaidPromotion4G'
Then verify the Order line Items 'PromotionAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'


Scenario: IsaacSharer_08 Parent Sharer customer is migrating to PAYM with Bar, Vodafone CXX Bundle and Option	
Meta:@IsaacSharer_08
@FolderName IsaacSharer_08
@Bushra
Given Place screenshots in Folder 'FolderName'
And Login with 'VFREDUSR' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionParentBusinessSharer'
And Customise 'RootProduct' with Econfig Item 'BusinessPlusMemberOFFBusinessPlusLeaderON'
And Customise 'RootProduct' with Econfig Item 'DataBarOn'
And Customise 'RootProduct' with Econfig Item 'OptionalExtra1GBAdd'
And Customise 'RootProduct' with Econfig Item 'VoicemailOff'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Perform Credit Vet
And Reserve Order
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotionParentBusinessSharer'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'EBUSharerUniversalPackage'
Then Perform Migration
When Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'EBUSharerUniversalPackage'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'PostpaidPromotion4G'
Then Perform Migration
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
And verify the Order line Items 'PromotionAdd'
When Retrieve Promotion 'PostpaidPromotionParentBusinessSharer'
Then verify the Order line Items 'PromotionDelete'
When Search The Account ''
Then Verify the Product and Services for 'AllActiveiveRootProductActive'


Scenario: IsaacSharer_09 Parent Sharer customer is moving to PAYG with Bar, Vodafone CXX Bundle and Option
Meta:@IsaacSharer_09
@Bushra
@FolderName IsaacSharer_09
Given Place screenshots in Folder 'FolderName'
And Login with 'VFREDUSR' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionParentBusinessSharer'
And Customise 'RootProduct' with Econfig Item 'BusinessPlusMemberOFFBusinessPlusLeaderON'
And Customise 'RootProduct' with Econfig Item 'DataBarOn'
And Customise 'RootProduct' with Econfig Item 'OptionalExtra1GBAdd'
And Customise 'RootProduct' with Econfig Item 'VoicemailOff'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Perform Credit Vet
And Reserve Order
And Submit the Order 'Normal Submit'
When Search The Account ''
When Validate Contacts tab for 'LastNameValidation'
And create new child account 'ClickNew'
And create new child account 'CaptureandSelectParentAccount'
And create new child account 'SelectAddressforChildAccount'
And search the child account ''
And Create New Billing Profile 'NewPrepaid'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotionParentBusinessSharer'
Then Perform the action 'PostToPreWithPromotion'
When Retrieve Promotion 'PrepaidPackage'
And Perform the upgrade
And Retrieve Promotion 'PostpaidPromotionParentBusinessSharer'
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Submit the Order 'Normal Submit'



Scenario: IsaacSharer_010 Pre to Post Migration Order
Meta:@IsaacSharer_010
@Bushra
@FolderName IsaacSharer_010
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PrepaidConsumerdd'
And Create 'NewOrderNoPopUp' 'NewPrepaid' Order
And Promotion is added with 'PrepaidPackage'
And Customise 'RootProduct' with Econfig Item 'DataBarOn'
And Customise 'RootProduct' with Econfig Item 'OptionalExtra1GBAdd'
And Customise 'RootProduct' with Econfig Item 'VoicemailOff'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Make payment with 'CashNon-CardPopNO'
And Submit the Order 'Normal Submit'
When ReLogin with 'AGENT04' in 'Env'
When Search The Account ''
And Validate Contacts tab for 'LastNameDrillDown'
And create new child account 'ClickNew'
And create new child account 'CaptureandSelectParentAccount'
And create new child account 'SelectAddressforChildAccount'
And search the child account ''
And Create New Billing Profile 'NewPostpaid'
When Search The Account ''
And Retrieve Promotion 'PrepaidPackage'
Then Perform the action 'PretoPostWithPromotion'
When Retrieve Promotion 'PostpaidPromotionParentBusinessSharer'
And Perform the upgrade
And Update ICCID against 'SelectValueForVodafoneSpendManager'
And Perform Credit Vet
When Retrieve Promotion 'PostpaidPromotionParentBusinessSharer'
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'PromotionAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'PromotionActive'
Then Verify the Product and Services for 'AllActiveiveRootProductActive'