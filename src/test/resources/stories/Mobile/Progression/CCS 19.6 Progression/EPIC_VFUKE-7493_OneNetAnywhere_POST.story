Story: OnenetAnywhere Post NVT
Meta:@OnenetAnywhere_Post
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario: OneNetAnywhere_01_POST NewCo_CCS 19.6_VFUS- 1352_One Net Anywhere-CCS Terminal Barring_Validate 
that the agents places a modify order to add All Calls Outgoing Only Bar to standalone one net promotions 
Meta:@OneNetAnywhere_01_POST
@FolderName OneNetAnywhere_01_POST
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'OneNetStandAlonePromotion108851'
And Modify 'ModifyWithInstalledID' with Econfig Item 'AllCallsOutgngOnlyBarOn'
And Submit the Order 'Normal Submit'


Scenario: OneNetAnywhere_02_POST_NVT NewCo_CCS 19.6_VFUS- 1352_One Net Anywhere-CCS Terminal Barring_Validate 
that the agents places a modify order to add All Calls Outgoing Only Bar to one net mobile promotions.
Meta:@OneNetAnywhere_02_POST_NVT
@FolderName OneNetAnywhere_02_POST_NVT
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'OnenetMobilePromotion'
And Modify 'ModifyWithInstalledID' with Econfig Item 'AllCallsOutgngOnlyBarOn'
And Submit the Order 'Normal Submit'


Scenario: OneNetAnywhere_04_POST_NVT NewCo_CCS 19.6_VFUS- 1352_One Net Anywhere-CCS Terminal Barring_Validate 
that the agents places a modify order to remove All Calls Outgoing Only Bar to one net mobile promotions.
Meta:@OneNetAnywhere_04_POST_NVT
@FolderName OneNetAnywhere_04_POST_NVT
@Zeba(Take data from OneNetAnywhere_02_POST_NVT)
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'OnenetMobilePromotion'
And Modify 'ModifyWithInstalledID' with Econfig Item 'AllCallsOutgngOnlyBarOff'
And Submit the Order 'Normal Submit'



Scenario: OneNetAnywhere_05_POST NewCo_CCS 19.6_VFUS- 1352_One Net Anywhere-CCS Terminal Barring_Validate 
that the agents places a modify order to add All Calls Outgoing Only Bar to one net complete promotions 
Meta:@OneNetAnywhere_05_POST
@FolderName OneNetAnywhere_05_POST
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'OnenetPromotionBusiness'
And Modify 'ModifyWithInstalledID' with Econfig Item 'AllCallsOutgngOnlyBarOn'
And Submit the Order 'Normal Submit'



Scenario: OneNetAnywhere_06_POST NewCo_CCS 19.6_VFUS- 1352_One Net Anywhere-CCS Terminal Barring_Validate 
that the agents places a modify order to add All Calls Outgoing Only Bar to one net complete promotions 
Meta:@OneNetAnywhere_06_POST
@FolderName OneNetAnywhere_06_POST 
@Payel (Take data from OneNetAnywhere_05_POST)
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'OnenetPromotionBusiness'
And Modify 'ModifyWithInstalledID' with Econfig Item 'AllCallsOutgngOnlyBarOff'
And Submit the Order 'Normal Submit'



Scenario: OneNetAnywhere_08_POST_NVT NewCo_CCS 19.6_VFUS- 1352_One Net Anywhere-CCS Terminal Barring_Validate 
that the agents places a Tariff migration order to add All Calls Outgoing Only Bar to standalone one net promotions.
Meta:@OneNetAnywhere_08_POST_NVT
@FolderName OneNetAnywhere_08_POST_NVT
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'OnenetMobilePromotion'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'OneNetPromotion108844'
Then Perform Migration
When Customise 'RootProduct' with Econfig Item 'AllCallsOutgngOnlyBarOn'
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'AllCallsOutgoingOnlyBarAdd'
And verify the Order line Items 'PromotionAdd'
When Retrieve Promotion 'OnenetMobilePromotion'
Then verify the Order line Items 'PromotionDelete'
When Search The Account ''
Then Verify the Product and Services for 'AllActiveiveRootProductActive'