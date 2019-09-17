Story: ENUMSWAP
Meta:@ENUMSWAP
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario: ENUMSWAP02_PRE VFUKE-1762- ASAP Changes to provision IPWorks_Place a One net Disconnection Order and validate on Network
Meta:@ENUMSWAP02_PRE
@FolderName ENUMSWAP02_PRE
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


Scenario: ENUMSWAP03_PRE VFUKE-1762- ASAP Changes to provision IPWorks_Place a Modify order on one net subscriber and remove Volte
Meta:@ENUMSWAP03_PRE
@FolderName ENUMSWAP03_PRE
@Vishwa
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


Scenario: ENUMSWAP04_PRE VFUKE-1762- ASAP Changes to provision IPWorks_Place a Modify order on Subscriber and add Bar. Validate on Network
Meta:@ENUMSWAP04_PRE
@FolderName ENUMSWAP04_PRE
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'


Scenario: ENUMSWAP05_PRE VFUKE-1762- ASAP Changes to provision IPWorks_Place a Modify order on  One net Subscriber and add Volte service and validate it on Network
@Vishwa
Meta:@ENUMSWAP05_PRE
@FolderName ENUMSWAP05_PRE
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion111136'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'


Scenario: ENUMSWAP06_PRE VFUKE-1762- ASAP Changes to provision IPWorks_Place a Disconnection order on a postpay Account having volte service and validate it on network
@Vishwa
Meta:@ENUMSWAP06_PRE
@FolderName ENUMSWAP06_PRE
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


Scenario: ENUMSWAP09_PRE VFUKE-1762- ASAP Changes to provision IPWorks_Add a Bar in one net Subscription Order and validate on Network
Meta:@ENUMSWAP09_PRE
@FolderName ENUMSWAP09_PRE
@Zeba
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


Scenario: ENUMSWAP08_PRE : VFUKE-1762- ASAP Changes to provision IPWorks_Place a change Msisdn order on oneNet Subscriber 
Meta:@ENUMSWAP08_PRE
@FolderName ENUMSWAP08_PRE
@Zeba
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


Scenario: ENUMSWAP10_PRE VFUKE-1762- ASAP Changes to provision IPWorks_Place a secondary Multidevice order and validate it on Network
Meta:@ENUMSWAP10_PRE
@FolderName ENUMSWAP10_PRE
@Sayali
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


Scenario: ENUMSWAP11_PRE VFUKE-1762- ASAP Changes to provision IPWorks_Delete secondary Multidevice from the multidevice subscriber and validate it on Network
Meta:@ENUMSWAP11_PRE
@FolderName ENUMSWAP11_PRE
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerExcOneNumberSecondaryProd'
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

Scenario: ENUMSWAP12_PRE VFUKE-1762- ASAP Changes to provision IPWorks_Place a Multidevice DVA (Digitl Voice Assistance) and validate it on Network
Meta:@ENUMSWAP12_PRE
@FolderName ENUMSWAP12_PRE
@Sayali
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

Scenario: ENUMSWAP13_PRE VFUKE-1762- ASAP Changes to provision IPWorks_Place a Disconnection order on a postpay Account having Volte service and validate it on network
Meta:@ENUMSWAP13_PRE
@FolderName ENUMSWAP13_PRE
@Sayali
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

Scenario: ENUMSWAP14_PRE VFUKE-1762- ASAP Changes to provision IPWorks_Delete Multidevice DVA (Digitl Voice Assistance) and validate it on Network
Meta:@ENUMSWAP14_PRE
@FolderName ENUMSWAP14_PRE
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerExcOneNumberSecondaryProd'
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