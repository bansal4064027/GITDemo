Story: ENUMSWAP
Meta:@ENUMSWAP
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario: ENUMSWAP01_POST VFUKE-1762- ASAP Changes to provision IPWorks_Place a One net New connection Order and validate on Network
Meta:@ENUMSWAP01_POST
@FolderName ENUMSWAP01_POST
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'OnenetPromotionBusiness'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
Given Retrieve Account 'PostpaidConsumer'
When Customise 'FixedService' with Econfig Item 'AreaCodeSelectConfPhoneOFFIPphoneONClickCallForwardTextMSISDN'
And Update ICCID against 'EnterIMEIIPphone'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'SubmitandNoOrderCheck'


Scenario: ENUMSWAP02_POST VFUKE-1762- ASAP Changes to provision IPWorks_Place a One net Disconnection Order and validate on Network 
@Sayali
Meta:@ENUMSWAP02_POST
@FolderName ENUMSWAP02_POST
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'OnenetPromotionBusiness'
Then Perform the action 'DisconnectWithInstalledIDPrep'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'


Scenario: ENUMSWAP03_POST VFUKE-1762- ASAP Changes to provision IPWorks_Place a Modify order on one net subscriber and remove Volte
@Vishwa
Meta:@ENUMSWAP03_POST
@FolderName ENUMSWAP03_POST
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledID' with Econfig Item 'WiFiAnd4GCallingOff'
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'WiFiand4GcallingDelete'
When Search The Account ''
Then Verify the Product and Services for 'AllActiveRootPWi-FiCallingNotExist'


Scenario: ENUMSWAP04_Post VFUKE-1762- ASAP Changes to provision IPWorks_Place a Modify order on Subscriber and add Bar. Validate on Network
Meta:@ENUMSWAP04_Post
@FolderName ENUMSWAP04_Post
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledID' with Econfig Item 'DataBarOn'
And Submit the Order 'Normal Submit'


Scenario: ENUMSWAP05_POST VFUKE-1762- ASAP Changes to provision IPWorks_Place a Modify order on  One net Subscriber and add Volte service and validate it on Network
@Vishwa
Meta:@ENUMSWAP05_POST
@FolderName ENUMSWAP05_POST
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion111136'
And Modify 'ModifyWithInstalledID' with Econfig Item 'WiFiAnd4GCalling'
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'WiFiand4GcallingAdd'
When Search The Account ''
Then Verify the Product and Services for 'AllActiveRootPWi-FiCallingExist'


Scenario: ENUMSWAP06_POST VFUKE-1762- ASAP Changes to provision IPWorks_Place a Disconnection order on a postpay Account having volte service and validate it on network 
@Vishwa
Meta:@ENUMSWAP06_POST
@FolderName ENUMSWAP06_POST
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'DisconnectWithInstalledIDPrep'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'


Scenario: ENUMSWAP07_POST New connection having multi subscrption and wifi /4G calling in each 
@Vishwa
Meta:@ENUMSWAP07_POST
@FolderName ENUMSWAP07_POST
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecordIndex1'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimIndex'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'


Scenario: ENUMSWAP08_POST : VFUKE-1762- ASAP Changes to provision IPWorks_Place a change Msisdn order on oneNet Subscriber 
Meta:@ENUMSWAP08_POST
@FolderName ENUMSWAP08_POST
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TMTTAR' in 'Env'
When Search The Account ''
And Modify 'ModifyWithInstalledID' with Econfig Item 'ClickOnDoneButton'
And Update ICCID against 'ChangeMSISDN'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'RootProduct0Update'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'

Scenario: ENUMSWAP09_POST VFUKE-1762- ASAP Changes to provision IPWorks_Add a Bar in one net Subscription Order and validate on Network
Meta:@ENUMSWAP09_POST
@FolderName ENUMSWAP09_POST
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TMTTAR' in 'Env'
When Search The Account ''
And Retrieve Promotion 'OnenetPromotionBusiness'
And Modify 'ModifyWithInstalledID' with Econfig Item 'DataBarOn'
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'DataBarAdd'
When Search The Account ''
Then Verify the Product and Services for 'AllActiveRootPCreditDataBarExist'

Scenario: ENUMSWAP10_POST VFUKE-1762- ASAP Changes to provision IPWorks_Place a secondary Multidevice order and validate it on Network
Meta:@ENUMSWAP10_POST
@FolderName ENUMSWAP10_POST
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'SelectActiveStatusMSISDN' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryOnHold'
When Check order in Account Overview Page for 'CheckModifyComplete'
When Check order in Account Overview Page for 'CheckSecondaryOpen'
When Check if Order has reached Dispatch Shipping Task in OSM
And Dispatch 'ESIM' order via FMW XML
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryComplete'

Scenario: ENUMSWAP11_POST VFUKE-1762- ASAP Changes to provision IPWorks_Delete secondary Multidevice from the multidevice subscriber and validate it on Network
Meta:@ENUMSWAP11_POST
@FolderName ENUMSWAP11_POST
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Perform the 'AboutRecordOfMenuItem' with About Record
And Execute query 'Tokenization'
And Retrieve Promotion 'SecondaryPromotion111279'
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'


Scenario: ENUMSWAP12_POST VFUKE-1762- ASAP Changes to provision IPWorks_Place a Multidevice DVA (Digitl Voice Assistance) and validate it on Network
Meta:@ENUMSWAP12_POST
@FolderName ENUMSWAP12_POST
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Create new order 'NewOrderNoPopUp'
And Promotion is added with 'AmazonDVAPackage'
And Update ICCID against 'OpenPopUpPrimaryInstalledID'
And Update ICCID against 'OpenPopUpAddAddress'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'SubmitandNoOrderCheckMultiDevicePopup'
When Search The Account ''
And Create new order 'CheckONHoldOrder'
When ReLogin with 'AGENT04' in 'Env'
When Search The Account ''
And Create new order 'DrillDownModifyOrder'
Then Check Order Status till Complete
Then verify the Order line Items 'OneNumberPrimaryProductAdd'
When Search The Account ''
And Create new order 'CheckOpenOrder'
And Create new order 'DrillDownSecondaryDeviceOpenOrder'
Then Check Order Status till Complete
When Retrieve Promotion 'AmazonDVAPackage'
Then verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'RootProduct0Add'

Scenario: ENUMSWAP13_POST VFUKE-1762- ASAP Changes to provision IPWorks_Place a Disconnection order on a postpay Account having Volte service and validate it on network
Meta:@ENUMSWAP13_POST
@FolderName ENUMSWAP13_POST
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
Then Perform the action 'DisconnectWithInstalledIDPrep'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'



Scenario: ENUMSWAP14_POST VFUKE-1762- ASAP Changes to provision IPWorks_Delete Multidevice DVA (Digitl Voice Assistance) and validate it on Network
Meta:@ENUMSWAP14_POST
@FolderName ENUMSWAP14_POST
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Perform the 'AboutRecordOfMenuItem' with About Record
And Execute query 'Tokenization'
And Retrieve Promotion 'AmazonDVAPackage'
Then Perform the action 'DisconnectWithPromotion'
When Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
When Submit the Order 'SubmitForDisconnectionJourney'
Then verify the Order line Items 'RootProduct0Delete'