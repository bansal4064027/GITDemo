Story: New Connections
Meta:@MTASexpansionsPOSTNVT
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create a new provide
  
  
Scenario: MTASexpansions003_PostNvt NewCo CCS 19.8 Remove Volte service NewCo_CCS 19.8_VFUKE-8498_PVD_124787 Spring II CSCF/MTAS expansions xMS&xBE_Remove Volte service
Meta:@MTASexpansions003_PostNvt
@FolderName MTASexpansions003_PostNvt
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account '7000564562'
And Retrieve Promotion 'PostpaidPromotionVolte'
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'ONAccountNon-CardPopNO'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'