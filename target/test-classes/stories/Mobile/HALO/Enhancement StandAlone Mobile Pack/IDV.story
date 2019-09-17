Story: IDV
Meta:@IDV
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  
  
Scenario: IDV01 HALO IDV Regression_TC03_IDV using Manual Override - Call Validate for New Account
Meta:@IDV01
@FolderName IDV01
@Bushra 
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
When Perform IDV Check and Credit Vet with Result 'CreditVetIdCheck'



Scenario: IDV02 HALO IDV Regression_TC04_IDV using Manual Override - Call Validate for Existing account
Meta:@IDV02
@FolderName IDV02
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
When Perform IDV Check and Credit Vet with Result 'CreditVetIdCheck'


Scenario: IDV03 HALO IDV Regression_TC05_Credit Vet  - Accept
Meta:@IDV03
@FolderName IDV03
@Bushra 
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
When Perform IDV Check and Credit Vet with Result 'CreditVettingAccepted'


  
Scenario:IDV04 HALO IDV Regression_TC07_Credit Vet - Decline
Meta:@IDV04
@FolderName IDV04
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
When  Perform IDV Check and Credit Vet with Result 'CreditVettingDeclined'



Scenario: IDV05 HALO IDV Regression_TC09_New Connection Order on existing account. Account should have credit vet results updated
Meta:@IDV05
@FolderName IDV05
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order



Scenario: IDV06  HALO IDV Regression_TC10_New Connection Order on new account using credit vet override 
Meta:@IDV06
@FolderName IDV06
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT01' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order



Scenario:IDV07 HALO IDV Regression_TC18_Discard Order on About the Customer page
Meta:@IDV07
@FolderName IDV07
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
When Discard Order



