Narrative:
  As a user
  I should be able to create the account

Scenario: BlackTariff_12 SIT_VFUKE 5423_VF Black Drop 1_TC_17_ Validate VF Black Tariff Customer flag for Tariff Migration order from Non black tariff CTR12/CTR13/CTR14 to Black tariff CTR15 VF Black 
Meta:@BlackTariff_12
@FolderName BlackTariff_12
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionVolte'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
Then Capture the Account Row ID in accountsummary page
When Execute BRM query 'ValidateBlackCustomerFlagFalse'
And Retrieve Promotion 'PostpaidPromotionVolte'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'PostpaidVFBLACK110860'
Then Perform Migration
When Submit the Order 'Normal Submit'
When Execute BRM query 'ValidateBlackCustomerFlagTrue'

Scenario: BlackTariff_13 SIT_VFUKE 5423_VF Black Drop 1_TC_18_ Validate VF Black Tariff Customer flag for Tariff Migration order from Non black tariff STR0/STR2 to Black tariff CTR15 VF Black 
Meta:@BlackTariff_13
@FolderName BlackTariff_13
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionSTR2'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
Then Capture the Account Row ID in accountsummary page
When Execute BRM query 'ValidateBlackCustomerFlagFalse'
And Retrieve Promotion 'PostpaidPromotionSTR2'
Then Perform the action 'TMWithPromotion'
When Retrieve Promotion 'PostpaidVFBLACK110860'
Then Perform Migration
When Submit the Order 'Normal Submit'
When Execute BRM query 'ValidateBlackCustomerFlagTrue'

Scenario:BlackTariff_24 SIT_VFUKE 5423_VF Black Drop 3_TC_04_ Validate  flag ‘Black tariff’ needs to be uneditable for Retail division_ HALO
Meta:@BlackTariff_24
@FolderName BlackTariff_24
@Rakesh
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
Given Retrieve Account 'PostpaidConsumerVFBlackTarif110860'
When Search The OUI Account 'GoToAccountLink' ''
Then Verify HALO Screen if VF Black Banner is visible


Scenario: BlackTariff_28 SIT_VFUKE 5423_VF Black Drop 3_TC_09_ Validate Warning message on removing insurance discount via Edit package _ Enabled
Meta: @BlackTariff_28
@FolderName BlackTariff_28
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
Then Capture the Account Row ID in accountsummary page
When Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidVFBLACK110860'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Execute BRM query 'ValidateBlackCustomerFlagTrue'
When Search The Account ''
And Retrieve Promotion 'PostpaidVFBLACK110860'
And Modify With 'ModifyWithPromotion'
And Select Menu 'PromotionEditPackage'
And Add Product 'InclusiveDamageInsuranceProduct'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'VerifyWarningMessageIncInsurance'



Scenario:BlackTariff_24 SIT_VFUKE 5423_VF Black Drop 3_TC_04_ Validate  flag ‘Black tariff’ needs to be uneditable for Retail division_ HALO
Meta:@BlackTariff_24
@FolderName BlackTariff_24
@Rakesh
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
Given Retrieve Account 'PostpaidConsumerVFBlackTarif110860'
When Search The OUI Account 'GoToAccountLink' ''
Then Verify HALO Screen if VF Black Banner is visible


Scenario:BlackTariff_26 SIT_VFUKE 5423_VF Black Drop 3_TC_07_ Validate Warning message should be displayed on removing insurance discount via Edit Package_ HALO
Meta:@BlackTariff_26
@FolderName BlackTariff_26
@Rakesh
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumerExcludingAllCallsIncomingOnlyBar'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CustomiseNewMSISDN'
When Econfig Item 'StolenBarOff'
And Compare Line Items 'StolenBarDelete'
And Compare Line Items 'ClickNext'
And Order Details Capture in Order Summary page
And Confirm Order
