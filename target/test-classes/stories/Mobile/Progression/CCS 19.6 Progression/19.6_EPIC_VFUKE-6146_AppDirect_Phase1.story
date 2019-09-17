Story: Epic_4367
Meta:@Epic_4367
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account

Scenario: AppDirect01 - CCS VFUKE-4225-VFUS-1089 - AppDirect Integration- Phase 1_Drop1_TS01 Validate that agent should be able to place New acquisition journey by adding 'Vodafone Cloud Services Marketplace Plan'
Meta:@AppDirect01
@Zeba
@FolderName AppDirect01
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'VCSMAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'VCSMActive'

Scenario: AppDirect02 - CCS VFUKE-4225-VFUS-1089 - AppDirect Integration- Phase 1_Drop1_TS02 Validate that agent should be able to place New acquisition journey of adding 'Vodafone Cloud Services Marketplace' Package with other services
Meta:@AppDirect02
@Zeba
@FolderName AppDirect02
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'VCSMAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'VCSMActive'

Scenario: AppDirect06 - CCS VFUKE-4225-VFUS-1089 - AppDirect Integration- Phase 1_Drop1_TS06 Validate that App Direct products are not available to agent for divisions other that FUT
Meta:@AppDirect06
@Zeba
@FolderName AppDirect06
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'

Scenario: AppDirect08 - CCS VFUKE-4225-VFUS-1089 - AppDirect Integration- Phase 1_Drop1_TS08 Validate that agent should be able to place Disconnection journey where VCSM plan is active with App Direct Product
Meta:@AppDirect08
@Zeba
@FolderName AppDirect08
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'VCSMProduct111902'
Then Perform the action 'DisconnectWithPromotion'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'VCSMDelete'
When Perform the CustomerAccount
Then Verify the Product and Services for 'Null'

Scenario: AppDirect09 - CCS VFUKE-4225-VFUS-1089 - AppDirect Integration- Phase 1_Drop1_TS09 Validate that agent should be able to place Disconnection journey on VCSM plan where customer has additional services along with App Direct Product
Meta:@AppDirect09
@Zeba
@FolderName AppDirect09
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'VCSMProduct111902'
Then Perform the action 'DisconnectWithPromotion'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'VCSMDelete'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'

Scenario: AppDirect10 - CCS VFUKE-4225-VFUS-1089 - AppDirect Integration- Phase 1_Drop1_TS010 Validate that agent place new activation journey on account where VCSM plan was already disconnected
Meta:@AppDirect10
@Zeba
@FolderName AppDirect10
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'VCSMProduct111902'
Then Perform the action 'DisconnectWithPromotion'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'VCSMDelete'
When Perform the CustomerAccount
Then Verify the Product and Services for 'Null'
When Search The Account ''
When Create 'NewOrderNoPopUp'Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'VCSMAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'VCSMActive'