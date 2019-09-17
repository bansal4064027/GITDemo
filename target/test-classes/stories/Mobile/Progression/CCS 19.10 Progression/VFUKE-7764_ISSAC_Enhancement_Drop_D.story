
Story: New Connections
Meta:
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create a new provide



!-- ====================================================================================

Scenario:ISSAC_Post2Pre_01 - ISAAC_PostToPre_Add fraud bar
Meta:@ISSAC_Post2Pre_01
@Rakesh
@FolderName ISSAC_Post2Pre_01
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledIDFraudRiskPopUp' with Econfig Item 'DualFormatSIMBlankWhiteTripSIMOff&On'
When Retrieve ICCID
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimAdd'
And Reserve Order
And Submit the Order 'NormalSubmitOptionalSpendManagerThershold'
When Search The Account ''
When Validate Contacts tab for 'LastNameValidation'
And create new child account 'ClickNew'
And create new child account 'CaptureandSelectParentAccount'
And create new child account 'SelectAddressforChildAccount'
And search the child account ''
And Create New Billing Profile 'NewPrepaid'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'PostToPreWithPromotion'
When Retrieve Promotion 'PrepaidPackage'
And Perform the upgrade
And Customise 'RootProductMobilePhoneService' with Econfig Item 'FraudStolenBar'
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'



Scenario:ISSAC_Post2Pre_02 - ISAAC_PostToPre_Extra 250 Minutes for 7 days
Meta:@ISSAC_Post2Pre_02
@Rakesh
@FolderName ISSAC_Post2Pre_02
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledIDFraudRiskPopUp' with Econfig Item 'DualFormatSIMBlankWhiteTripSIMOff&On'
When Retrieve ICCID
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimAdd'
And Reserve Order
And Submit the Order 'NormalSubmitOptionalSpendManagerThershold'
When Search The Account ''
When Validate Contacts tab for 'LastNameValidation'
And create new child account 'ClickNew'
And create new child account 'CaptureandSelectParentAccount'
And create new child account 'SelectAddressforChildAccount'
And search the child account ''
And Create New Billing Profile 'NewPrepaid'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'PostToPreWithPromotion'
When Retrieve Promotion 'PrepaidPackage'
And Perform the upgrade
And Customise 'RootProductMobilePhoneService' with Econfig Item 'Extra250MinutesFor7daysPrepay'
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'


Scenario:ISSAC_Post2Pre_03 - ISAAC_19.10_PM2PG_03_PosttoPre_PAYM to VOXI: Add Bars
Meta:@ISSAC_Post2Pre_03
@Rakesh
@FolderName ISSAC_Post2Pre_03
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumerOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
When Validate Contacts tab for 'LastNameValidation'
And create new child account 'ClickNew'
And create new child account 'CaptureandSelectParentAccount'
And create new child account 'SelectAddressforChildAccount'
And search the child account ''
And Create New Billing Profile 'NewPrepaid'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'PostToPreWithPromotion'
When Retrieve Promotion 'PrepaidPromotionVOXI'
And Perform the upgrade
And Customise 'RootProductVOXI' with Econfig Item 'DataRoamingBarVOXIOn'
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPre2PostAndPost2Pre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'



Scenario:ISSAC_Post2Pre_04 - ISAAC_19.10_PM2PG_04_ISAAC_PostToPre_Add  Music pass, video pass
Meta:@ISSAC_Post2Pre_04
@Rakesh
@FolderName ISSAC_Post2Pre_04
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumerOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
When Validate Contacts tab for 'LastNameValidation'
And create new child account 'ClickNew'
And create new child account 'CaptureandSelectParentAccount'
And create new child account 'SelectAddressforChildAccount'
And search the child account ''
And Create New Billing Profile 'NewPrepaid'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'PostToPreWithPromotion'
When Retrieve Promotion 'PrepaidPromotionVOXI'
And Perform the upgrade
And Customise 'RootProductVOXI' with Econfig Item 'VOXIMusicPassAdd'
And Customise 'RootProductVOXI' with Econfig Item 'VOXIVideoPassAdd'
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Submit the Order 'Normal Submit'
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'



Scenario:ISSAC_Post2Pre_05 - ISAAC_19.10_PM2PG_05_PosttoPre_MBB PAYM to PAYG: Add Bars
Meta:@ISSAC_Post2Pre_05
@Rakesh
@FolderName ISSAC_Post2Pre_05
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidDataSIM15GB111565'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidDataSIM15GB111565'
And Modify 'ModifyWithInstalledIDFraudRiskPopUp' with Econfig Item 'DualFormatSIMBlankWhiteTripSIMOff&On'
When Retrieve ICCID
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimAdd'
And Reserve Order
And Submit the Order 'NormalSubmitOptionalSpendManagerThershold'
When Search The Account ''
When Validate Contacts tab for 'LastNameValidation'
And create new child account 'ClickNew'
And create new child account 'CaptureandSelectParentAccount'
And create new child account 'SelectAddressforChildAccount'
And search the child account ''
And Create New Billing Profile 'NewPrepaid'
When Search The Account ''
And Retrieve Promotion 'PostpaidDataSIM15GB111565'
Then Perform the action 'PostToPreWithPromotion'
When Retrieve Promotion 'PrepaidPackage'
And Perform the upgrade
And Customise 'RootProductMobilePhoneService' with Econfig Item 'DataBarOn'
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'


Scenario:ISSAC_Post2Pre_06 - PosttoPre_MBB PAYM to PAYG: Add Bundle,option
Meta:@ISSAC_Post2Pre_06
@Rakesh
@FolderName ISSAC_Post2Pre_06
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidDataSIM15GB111565'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidDataSIM15GB111565'
And Modify 'ModifyWithInstalledIDFraudRiskPopUp' with Econfig Item 'DualFormatSIMBlankWhiteTripSIMOff&On'
When Retrieve ICCID
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimAdd'
And Reserve Order
And Submit the Order 'NormalSubmitOptionalSpendManagerThershold'
When Search The Account ''
When Validate Contacts tab for 'LastNameValidation'
And create new child account 'ClickNew'
And create new child account 'CaptureandSelectParentAccount'
And create new child account 'SelectAddressforChildAccount'
And search the child account ''
And Create New Billing Profile 'NewPrepaid'
When Search The Account ''
And Retrieve Promotion 'PostpaidDataSIM15GB111565'
Then Perform the action 'PostToPreWithPromotion'
When Retrieve Promotion 'PrepaidPackage'
And Perform the upgrade
And Customise 'RootProductMobilePhoneService' with Econfig Item 'Extra250MinutesFor7daysPrepay'
And Customise 'RootProductMobilePhoneService' with Econfig Item 'IOUOn'
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'





Scenario:ISSAC_Post2Pre_07 - ISAAC_PostToPre_Post to Pre after sim swap
Meta:@ISSAC_Post2Pre_07
@Rakesh
@FolderName ISSAC_Post2Pre_07
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledIDFraudRiskPopUp' with Econfig Item 'DualFormatSIMBlankWhiteTripSIMOff&On'
When Retrieve ICCID
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimAdd'
And Reserve Order
And Submit the Order 'NormalSubmitOptionalSpendManagerThershold'
When Search The Account ''
When Validate Contacts tab for 'LastNameValidation'
And create new child account 'ClickNew'
And create new child account 'CaptureandSelectParentAccount'
And create new child account 'SelectAddressforChildAccount'
And search the child account ''
And Create New Billing Profile 'NewPrepaid'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'PostToPreWithPromotion'
When Retrieve Promotion 'PrepaidPackage'
And Perform the upgrade
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'



Scenario:ISSAC_Post2Pre_08 - ISAAC_PostToPre_Post to Pre after sim swap
Meta:@ISSAC_Post2Pre_08
@Rakesh
@FolderName ISSAC_Post2Pre_08
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledIDFraudRiskPopUp' with Econfig Item 'DualFormatSIMBlankWhiteTripSIMOff&On'
When Retrieve ICCID
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimAdd'
And Reserve Order
And Submit the Order 'NormalSubmitOptionalSpendManagerThershold'
When Search The Account ''
When Validate Contacts tab for 'LastNameValidation'
And create new child account 'ClickNew'
And create new child account 'CaptureandSelectParentAccount'
And create new child account 'SelectAddressforChildAccount'
And search the child account ''
And Create New Billing Profile 'NewPrepaid'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'PostToPreWithPromotion'
When Retrieve Promotion 'PrepaidPackage'
And Perform the upgrade
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'


Scenario:ISSAC_Post2Pre_09 - ISAAC_PostToPre_Add gold number
Meta:@ISSAC_Post2Pre_09
@Rakesh
@FolderName ISSAC_Post2Pre_09
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledIDFraudRiskPopUp' with Econfig Item 'DualFormatSIMBlankWhiteTripSIMOff&On'
When Retrieve ICCID
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimAdd'
And Reserve Order
And Submit the Order 'NormalSubmitOptionalSpendManagerThershold'
When Search The Account ''
When Validate Contacts tab for 'LastNameValidation'
And create new child account 'ClickNew'
And create new child account 'CaptureandSelectParentAccount'
And create new child account 'SelectAddressforChildAccount'
And search the child account ''
And Create New Billing Profile 'NewPrepaid'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'PostToPreWithPromotion'
When Retrieve Promotion 'PrepaidPackage'
And Perform the upgrade
And Customise 'RootProductMobilePhoneService' with Econfig Item 'GoldenNumbersPrepay'
And Make payment with 'CashNon-CardPopNO'
And Reserve Order
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'

Scenario:ISSAC_PreToPost_01 - ISAAC_19_10_PG2PM_01_ISAAC_PretoPost_Add fraud bar
Meta:@ISSAC_PreToPost_01
@Rakesh
@FolderName ISSAC_PreToPost_01
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PrepaidConsumerdd'
And Create New 'NewPrepaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PrepaidPackage'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
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
When Retrieve Promotion 'PostpaidPromotion4G'
And Perform the upgrade
And Customise 'RootProductPAYM' with Econfig Item 'FraudStolenBar'
And Update ICCID against 'EnterVodafoneSpendManagerOff'
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'



Scenario:ISSAC_PreToPost_02 - ISAAC_19_10_PG2PM_02_ISAAC_PretoPost_Add-Remove Bars,Bundles, Options
Meta:@ISSAC_PreToPost_02
@Rakesh
@FolderName ISSAC_PreToPost_02
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PrepaidConsumerdd'
And Create New 'NewPrepaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PrepaidPackage'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Submit the Order 'Normal Submit'
When ReLogin with 'AGENT02' in 'Env'
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
When Retrieve Promotion 'PostpaidPromotion4G'
And Perform the upgrade
And Customise 'RootProductPAYM' with Econfig Item 'ABarCreditAlert'
And Customise 'RootProductPAYM' with Econfig Item 'DataCappingOptOffExtra2GBdataMonthlyOn'
And Customise 'RootProductPAYM' with Econfig Item 'VoicemailOff'
And Update ICCID against 'EnterVodafoneSpendManagerOff'
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'


Scenario:ISSAC_PreToPost_03 - ISAAC_19_10_PG2PM_03_ISAAC_PretoPost_Add stolen bar, data roaming bar
Meta:@ISSAC_PreToPost_03
@Rakesh
@FolderName ISSAC_PreToPost_03
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PrepaidConsumerdd'
And Create New 'NewPrepaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PrepaidPackage'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Submit the Order 'Normal Submit'
When ReLogin with 'AGENT02' in 'Env'
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
When Retrieve Promotion 'PostpaidPromotion4G'
And Perform the upgrade
And Customise 'RootProductPAYM' with Econfig Item 'StolenOnNew'
And Customise 'RootProductPAYM' with Econfig Item 'PAYMRoamBarOnDataBarOn'
And Update ICCID against 'EnterVodafoneSpendManagerOff'
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'




Scenario:ISSAC_PreToPost_04 -ISAAC_19_10_PG2PM_04_ISAAC_PretoPost_Add inclusive Entertainment M1, Mobile Internet Traffic Bolt-ons i_e_ UK 2GB 4G 90 days 10GBP
Meta:@ISSAC_PreToPost_04
@Rakesh
@FolderName ISSAC_PreToPost_04
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PrepaidConsumerdd'
And Create New 'NewPrepaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PrepaidPackage'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Submit the Order 'Normal Submit'
When ReLogin with 'AGENT02' in 'Env'
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
When Retrieve Promotion 'PostpaidPromotion4G'
And Perform the upgrade
And Customise 'RootProductPAYM' with Econfig Item 'VodaSecureNetOn'
And Customise 'RootProductPAYM' with Econfig Item 'PAYMRoamBarOnDataBarOn'
And Update ICCID against 'EnterVodafoneSpendManagerOff'
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'



Scenario:ISSAC_PreToPost_05 - ISAAC_19_10_PG2PM_05_ISAAC_PretoPost_customer performs pre to post after change MSISDN has been performed on PAYM
Meta:@ISSAC_PreToPost_05
@Rakesh
@FolderName ISSAC_PreToPost_05
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PrepaidConsumerdd'
And Create New 'NewPrepaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PrepaidPackage'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Submit the Order 'Normal Submit'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledIDFraudRiskPopUp' with Econfig Item 'DualFormatSIMBlankWhiteTripSIMOff&On'
When Retrieve ICCID
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimAdd'
And Reserve Order
And Submit the Order 'NormalSubmitOptionalSpendManagerThershold'
When ReLogin with 'AGENT02' in 'Env'
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
When Retrieve Promotion 'PostpaidPromotion4G'
And Perform the upgrade
And Update ICCID against 'EnterVodafoneSpendManagerOff'
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'



Scenario:ISSAC_PreToPost_06 - ISAAC_19_10_PG2PM_06_ISAAC_PretoPost_customer performs pre to post after sim swap has been performed on PAYM
Meta:@ISSAC_PreToPost_06
@Rakesh
@FolderName ISSAC_PreToPost_06
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PrepaidConsumerdd'
And Create New 'NewPrepaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PrepaidPackage'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Update ICCID against 'SelectISSACasDropDown'
And Reserve Order
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
And Submit the Order 'Normal Submit'
When ReLogin with 'AGENT01' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PrepaidPackage'
And Modify 'ModifyWithInstalledIDFraudRiskPopUp' with Econfig Item 'BlankWhiteTripSimStandardSimOnOff'
When Retrieve ICCID
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimIMEI'
And Reserve Order
And Submit the Order 'Normal Submit'
When ReLogin with 'AGENT02' in 'Env'
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
When Retrieve Promotion 'PostpaidPromotion4G'
And Perform the upgrade
And Update ICCID against 'EnterVodafoneSpendManagerOff'
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Given Login to OSM with 'ADMIN' in ''
When Search Order Number '' in OSM
Then Validate it is a ISSAC order 'SingleMSISDNPostToPre'
When Capture IMSI for ICCID ''
When Execute BRM query 'CheckMZDBForSubscriber'
When Execute BRM query 'CheckAccountDetailsPostpaidInBRM'
When Execute BRM query 'OSMDBCheckPostToPreEDW'
When Execute BRM query 'OSMDBCheckNewConnectionADDOTA'
When Execute BRM query 'OSMDBCheckMigrationAddOTA'
When Execute BRM query 'OSMDBCheckMigrationDeleteOTA'




Scenario:ISSAC_PreToPost_06 - ISAAC_19_10_PG2PM_06_ISAAC_PretoPost_customer performs pre to post after sim swap has been performed on PAYM
Meta:@ISSACdsds63
@Rakesh
@FolderName ISSAC_PreToPost_06
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Execute Database query 'CheckMZDBForSubscriber' with query inputs '447823025254'

