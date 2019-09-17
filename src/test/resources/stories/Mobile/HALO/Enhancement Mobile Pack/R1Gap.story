Story: R1 Gap
Meta:@R1Gap
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  
Scenario: R1GapMoblie01a Siebel_Upgrade_Enhancement_R1_Gap_02_PAYM SIMO Voice+Data and Data
Meta:@R1GapMoblie01a
@FolderName R1GapMoblie01a
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: R1GapMoblie01b Siebel_Upgrade_Enhancement_R1_Gap_02_PAYM SIMO Voice+Data and Data
Meta:@R1GapMoblie01b
@FolderName R1GapMoblie01b
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionMBB2' for 'AddSIMOwithDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: R1GapMoblie02 Siebel_Upgrade_Enhancement_R1_Gap_04_PAYM MBB search by plan 
Meta:@R1GapMoblie02
@FolderName R1GapMoblie02
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionMBB4G' for 'AddPAYMMBBviaSearchByPlan' in OUI


Scenario: R1GapMoblie04 Siebel_Upgrade_Enhancement_R1_Gap_10_NBA offers to be shown based on agent profile 
Meta:@R1GapMoblie04
@FolderName R1GapMoblie04
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Validate NBA Offers Applet

Scenario: R1GapMoblie06 Siebel_Upgrade_Enhancement_R1_Gap_18_CTI icons should be enabled
Meta:@R1GapMoblie06
@FolderName R1GapMoblie06
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'CTI' in 'Env'
When Search for CTI Toolbar for 'SearchForCTIToolbar' ''