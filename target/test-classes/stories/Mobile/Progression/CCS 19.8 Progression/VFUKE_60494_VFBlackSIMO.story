Story: Account Creation
Meta:@VFUKE_60494_VFBlackSIMO
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account

Scenario: BlackTariff_28_Enhancement  SIT_VF Black_WR60494 _TC_01_ Validate VF Black Tariff Customer flag  on New Connection journey on CTR15 VF Black SIMO tariff_HALO 
Meta:@BlackTariff_28_Enhancement
@FolderName BlackTariff_28_Enhancement
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionVFBlackSIMO' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The OUI Account 'GoToAccountLink' ''
And Validate Black tariff checkbox for 'ValidateBlackTariffCheckboxChecked'


Scenario: BlackTariff_28_Enable ST_VFUKE 5423_VF Black Drop 3_TC_05_ Validate New amber banner in account overview for black tariff accounts_ HALO
Meta:@BlackTariff_28_Enable
@FolderName BlackTariff_28_Enable
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'Consumer'
Then Capture the Account Row ID in accountsummary page
When Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionVFBlackSIMO'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
When Execute BRM query 'ValidateBlackCustomerFlagFalse'
And Submit the Order 'Normal Submit'
When Perform the CustomerAccount
Then Capture the Account Row ID in accountsummary page
When Execute BRM query 'ValidateBlackCustomerFlagTrue'
When Search The OUI Account 'GoToAccountLink' ''
Then Verify HALO Screen if VF Black Banner is visible
When Validate Black tariff checkbox for 'ValidateBlackTariffCheckboxChecked'

Scenario: BlackTariff_29 SIT_VF Black_WR60494 _TC_02_Validate VF Black Tariff Customer flag on Disconnection (out of garce period) journey for VF Black SIMO Tariff (112003)_HALO
!-- Only New Connection for disconnection
Meta:@BlackTariff_29
@FolderName BlackTariff_29
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'Consumer'
Then Capture the Account Row ID in accountsummary page
When Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionVFBlackSIMO'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
When Execute BRM query 'ValidateBlackCustomerFlagFalse'
And Submit the Order 'Normal Submit'
When Perform the CustomerAccount
Then Capture the Account Row ID in accountsummary page
When Execute BRM query 'ValidateBlackCustomerFlagTrue'
When Search The OUI Account 'GoToAccountLink' ''
Then Verify HALO Screen if VF Black Banner is visible
When Validate Black tariff checkbox for 'ValidateBlackTariffCheckboxChecked'


Scenario: BlackTariff_30 SIT_VF Black_WR60494 _TC_03_Validate VF Black Tariff Customer flag on Reconnection journey for VF Black SIMO Tariff (112003) _Enable.
Meta:@BlackTariff_30
@FolderName BlackTariff_30
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'Consumer'
Then Capture the Account Row ID in accountsummary page
When Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionVFBlackSIMO'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
When Execute BRM query 'ValidateBlackCustomerFlagFalse'
And Submit the Order 'Normal Submit'
When Perform the CustomerAccount
Then Capture the Account Row ID in accountsummary page
When Execute BRM query 'ValidateBlackCustomerFlagTrue'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotionVFBlackSIMO'
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'ONAccountNon-CardPopNO'
When Submit the Order 'SubmitForDisconnectionforCollectionsJourney'
When Search The Account ''
And Modify with owned product 'ReconnectWithRootProd'
When Submit the Order 'SubmitForReconnectionJourney'
When Search The OUI Account 'GoToAccountLink' ''
Then Verify HALO Screen if VF Black Banner is visible
When Validate Black tariff checkbox for 'ValidateBlackTariffCheckboxChecked'


Scenario: BlackTariff_31 SIT_VF Black_WR60494 _TC_04_ Validate VF Black Tariff Customer flag on Pre to post on CTR15 VF Black SIMO tariff 
Meta:@BlackTariff_31
@Zeba
@FolderName BlackTariff_31
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'AGENT04' in 'Env'
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
When Retrieve Promotion 'PostpaidPromotionVFBlackSIMO'
And Perform the upgrade
And Update ICCID against 'SelectValueForVodafoneSpendManager'
And Perform Credit Vet
When Execute BRM query 'ValidateBlackCustomerFlagFalse'
And Submit the Order 'Normal Submit'
When Perform the CustomerAccount
Then Capture the Account Row ID in accountsummary page
When Execute BRM query 'ValidateBlackCustomerFlagTrue'
When Search The OUI Account 'GoToAccountLink' ''
Then Verify HALO Screen if VF Black Banner is visible
When Validate Black tariff checkbox for 'ValidateBlackTariffCheckboxChecked'

Scenario: BlackTariff_32 : SIT_VF Black_WR60494 _TC_05_ Validate VF Black Tariff Customer flag for TOO order completion for CTR15 VF Black SIMO plan  
Meta:@BlackTariff_32
@FolderName BlackTariff_32
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'RETAIL' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'TOOWithPromotion'
Given Retrieve Account 'PostpaidConsumerSIMOBlack'
Then Perform Transfer Of OwnerShip
When Perform Credit Vet
And Reserve Order
And Submit the Order 'SubmitForTOOJourney'
When Execute BRM query 'ValidateBlackCustomerFlagFalse'
And Submit the Order 'SubmitForTOOJourney'
Then verify the Order line Items 'RootProduct0Add'
Then verify the Order line Items 'PromotionAdd'
When Search The Account ''
Then Capture the Account Row ID in accountsummary page
When Execute BRM query 'ValidateBlackCustomerFlagTrue'

Scenario: BlackTariff_33 - SIT_VF Black_WR60494 _TC_06_Validate VF Black Tariff Customer flag on Tariff Migration order from Non black SIMO tariff CTR15 to CTR15 VF Black SIMO tariff_HALO
Meta:@BlackTariff_33
@FolderName BlackTariff_33
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'RETAIL' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'PostpaidPromotionVFBlackSIMO'
Then Perform Migration
When Execute BRM query 'ValidateBlackCustomerFlagFalse'
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
And verify the Order line Items 'PromotionAdd'
When Perform the CustomerAccount
Then Capture the Account Row ID in accountsummary page
When Execute BRM query 'ValidateBlackCustomerFlagTrue'