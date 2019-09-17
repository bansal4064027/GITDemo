
Scenario: VFUKE-9631_Viper _TC_15  SMS Add Barring -Adult content calls and SMS Outgoing Only Bar
Meta:@Viper _TC_15
@FolderName Viper _TC_15
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Modify 'ModifyWithInstalledID' with Econfig Item 'SMSOutgoingOnlyBarON'
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'SMSOutgoingOnlyBarAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveRootPSMSOutgoingOnlyBarExist'



Scenario: VFUKE-9631_Viper _TC_16  SMS Add Barring -Age-restricted on-line content bar
Meta:@Viper _TC_16
@FolderName Viper _TC_16 
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'


Scenario: VFUKE-9631_Viper _TC_17  SMS Add Barring -Collection OutGoin Bar	
Meta:@Viper _TC_17 
@FolderName Viper _TC_17 
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Modify 'ModifyWithInstalledID' with Econfig Item 'CollectionOutgngBarOn'
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'CollectionsOutgoingBarAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveRootPCollectionsOutgoingBarExist'




Scenario: VFUKE-9631_Viper _TC_18  SMS Add Barring -SMS Incoming and Outgoing Bar
Meta:@Viper _TC_18
@FolderName Viper _TC_18
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Modify 'ModifyWithInstalledID' with Econfig Item 'SMSIncomingandOutgoingBar'
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'SMSIncomingandOutgoingBarAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveRootPSMSIncomingOutgoingBarExist'



Scenario:VFUKE-9631_Viper _TC_19 SMS Remove Barring -SMS Incoming and Outgoing Bar 
Meta:@Viper _TC_19
@FolderName Viper _TC_19
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create New 'NewPostpaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'SMSIncomingandOutgoingBar'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Submit the Order 'Normal Submit'
When Search The Account ''
And Modify 'ModifyWithInstalledID' with Econfig Item 'SMSIncomingandOutgoingBarOff'
When Submit the Order 'Normal Submit'
Then verify the Order line Items 'SMSIncomingandOutgoingOnlyBarDelete'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveRootPSMSIncomingOutgoingOnlyBarNotExist'


Scenario:VFUKE-9631_Viper _TC_20 SMS Delete Barring -Adult content calls and SMS Outgoing Only Bar  
Meta:@Viper _TC_20
@FolderName Viper _TC_20
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create New 'NewPostpaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'SMSOutgoingOnlyBarON'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Submit the Order 'Normal Submit'
When Search The Account ''
And Modify 'ModifyWithInstalledID' with Econfig Item 'AdultcontentcallsandSMSoutgoingOnlyBarOff'
When Submit the Order 'Normal Submit'



