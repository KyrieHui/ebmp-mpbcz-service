### 1.1 Pre-order
#### 1.1.2 Pre-order Interface
|Interface Protocol|http/http+json|
|----|----|
|Interface Description|The payment center calls the transaction creation interface based on the information submitted by the open bank and returns the successfully created order number to the open bank.|

#### 1.1.2.1 Interface Method: excute
##### 1.1.2.1.1 Method Description
Pre-ordering is required before launching the cashier to obtain the payment order number.

##### 1.1.2.1.2 Input Description
|No.|Field Name|Chinese Meaning|Type|Length|Mandatory|Data Item Description|
|----|----|----|----|----|----|----|
|1|merchtOrdrId|Merchant Order Number|String|64|Yes| |
|2|bizTxTm|Business Transaction Time|String|14|Yes|yyyyMMddhhmmss|
|3|merchtId|Merchant ID|String|64|Yes| |
|4|merchtNm|Merchant Name|String|64|No| |
|5|secMerchtId|Secondary Merchant ID|String|64|No|Not currently used, reserved|
|6|contrMerchtId|Contract Merchant ID|String|32|No|For transactions with other bank cards, the contract merchant number must be submitted. Currently, it is set as the merchant number.|
|7|contrMerchtNm|Contract Merchant Name|String|64|No| |
|8|usrId|User ID|String|64|Yes| |
|9|usrIpAdr|User IP|String|32|No| |
|10|ordrValidPrdDt|Order Validity Period|String|20|Yes|yyyyMMddhhmmss|
|11|ccy|Currency|String|3|Yes|156|
|12|orgnlPrc|Original Price|Decimal|20,2|Yes| |
|13|prcAmt|Sale Price|Decimal|20,2|No|Cash portion of the sale price (if empty during development, use the original price)|
|14|pointPrcCnt|Points Sale Quantity|Integer||No|Points for sale|
|15|costPrc|Cost Price|Decimal|20,2|Yes| |
|16|payTotlAmt|Total Payment Amount|Decimal|20,2|Yes| |
|16-1|extRightsAmt|External Rights Amount|Decimal|20,2|No|External discount information, recorded by the middle platform but not processed|
|17|bizTpCd|Business Type Code|String|32|Yes|Decision Key|
|18|evtCd|Event Code|String|32|Yes|Decision Key|
|List<decisInf> Start: Decision Information Group (Payment Decision Rule Basic Extension Information)|List<decisInf> Start: Decision Information Group (Payment Decision Rule Basic Extension Information)|List<decisInf> Start: Decision Information Group (Payment Decision Rule Basic Extension Information)|List<decisInf> Start: Decision Information Group (Payment Decision Rule Basic Extension Information)|List<decisInf> Start: Decision Information Group (Payment Decision Rule Basic Extension Information)|List<decisInf> Start: Decision Information Group (Payment Decision Rule Basic Extension Information)|List<decisInf> Start: Decision Information Group (Payment Decision Rule Basic Extension Information)|
|17|decisExtInd|Decision Extension Identifier|String|64|No|MAP KEY|
|18|decisExtInf|Decision Extension Content|String|128|No|MAP VALUE|
|List<decisInf> End|List<decisInf> End|List<decisInf> End|List<decisInf> End|List<decisInf> End|List<decisInf> End|List<decisInf> End|
|List<merchdInf> Start: Product Information Array|List<merchdInf> Start: Product Information Array|List<merchdInf> Start: Product Information Array|List<merchdInf> Start: Product Information Array|List<merchdInf> Start: Product Information Array|List<merchdInf> Start: Product Information Array|List<merchdInf> Start: Product Information Array|
|19|merchdId|Product ID|String|64|No| |
|20|merchdNm|Product Name|String|128|No| |
|21|merchdCnt|Product Quantity|String|16|No| |
|22|merchdOrgnlPrc|Product Original Price|Decimal|20,2|No| |
|23|merchdCostPrc|Product Cost Price|Decimal|20,2|No| |
|24|merchdPrefrPrc|Product Discount Price|Decimal|20,2|No| |
|List<merchdInf> End|List<merchdInf> End|List<merchdInf> End|List<merchdInf> End|List<merchdInf> End|List<merchdInf> End|List<merchdInf> End|
|List<prefrCpnInf> Start: Coupon Information|List<prefrCpnInf> Start: Coupon Information|List<prefrCpnInf> Start: Coupon Information|List<prefrCpnInf> Start: Coupon Information|List<prefrCpnInf> Start: Coupon Information|List<prefrCpnInf> Start: Coupon Information|List<prefrCpnInf> Start: Coupon Information|
|25|rightsId|Rights ID|String|64|No|Rights ID is equivalent to coupons like "100 minus 20." Whether the rights detail ID (specific coupon number) needs to be passed is unclear.|
|26|rightsDtlId|Rights Detail ID|String|64|No|Primary Key|
|27|rightsNm|Rights Name|String|300|No| |
|28|rightsAmt|Rights Amount|Decimal|20,2|No| |
|List<prefrCpnInf> End|List<prefrCpnInf> End|List<prefrCpnInf> End|List<prefrCpnInf> End|List<prefrCpnInf> End|List<prefrCpnInf> End|List<prefrCpnInf> End|
|List<point> Start: Points Information Group|List<point> Start: Points Information Group|List<point> Start: Points Information Group|List<point> Start: Points Information Group|List<point> Start: Points Information Group|List<point> Start: Points Information Group|List<point> Start: Points Information Group|
|29|sumPointId|Aggregate Points ID|String|64|No| |
|30|pointCnt|Points Quantity|Integer||No| |
|List<point> End: Points Information Group|List<point> End: Points Information Group|List<point> End: Points Information Group|List<point> End: Points Information Group|List<point> End: Points Information Group|List<point> End: Points Information Group|List<point> End: Points Information Group|
|37|ordrRmrk|Order Remarks|String|32|No| |
|38|rtnAdr|Callback Address|String|256|Yes|Used to redirect back to the merchant page after the cashier is closed.|
|39|advsAdr|Notification Address|String|256|No|Payment result notification, fixed address, no need to submit.|
|40|payrCpln|Payer Name|String|32|No| |
|41|payrCertTpCd|Payer ID Type|String|2|No|01 ID Card  |
|42|payrCertNo|Payer ID Number|String|32|No| |
|43|payrMoblNo|Payer Mobile Number|String|11|No| |
|44|payrMailNo|Payer Email|String|32|No| |

##### 1.1.2.1.3 Output
|No.|Field Name|Chinese Meaning|Type|Length|Mandatory|Data Item Description|
|----|----|----|----|----|----|----|
|1|payOrdrId|Payment Order Number|String|64|Yes|Field returned by the bpaas transaction creation interface. If successful, this field is returned to the client. If failed, this value is empty.|

##### 1.1.2.1.4 Execution Logic
1. After receiving the request, validate mandatory data items. If any mandatory field is missing, report an error [Error Code: MPBCZ00000XXX, XXX cannot be empty (specify each field validation)].
2. Use the supplier platform number from the request to call the user center service [Supplier Basic Information Detail Query] and retrieve detailed supplier information. If the returned information is empty, the payment center reports an error [Error Code: MPBCZ0000137, Supplier platform [XXXX] information does not exist]. If the call fails, the exception is directly thrown to the client. Further check the status of the returned supplier platform information. If it is not enabled, the payment center reports an error [Error Code: MPBCZ0000088, [XXXX] supplier platform authentication failed, status closed].
3. Use the user ID from the request to call the user center service [Customer Information Query] and retrieve user information. If the returned information is empty, the payment center reports an error [Error Code: MPBCZ0000214, User information does not exist]. If the call fails, the exception is directly thrown to the client. Further check the user status. If it is not active, the payment center reports an error [Error Code: MPBCZ0000089, User [XXXX] authentication failed]. Further check the user level. If the level is not V3 or higher, the payment center reports an error [Error Code: MPBCZ0000090, User level [XX] does not support the current operation].
4. Use the user ID from the request to query the cashier payment whitelist (t_pay_white_user) for valid data: If none exists, proceed to the next step. If data exists, call the account center [Bound Card List Information Query] to retrieve all bound cards for the user. Check if there is a physical debit card from the bank in the returned list. If yes, proceed to the next step. If no, query the supplier platform payment control table (t_pay_provr_ctrl) to determine whether to block transactions for users with only other bank cards: Block or null: The payment center reports an error [Error Code: MPBCZ0000252, Please bind a physical debit card from this bank]. Do not block: Based on the payment amount, determine whether to block: Block or null: The payment center reports an error [Error Code: MPBCZ0000252, Please bind a physical debit card from this bank]. Do not block: Determine whether to control the number of transactions: No control or null: Proceed. Control: Retrieve the number of transactions within the configured interval from the user cashier payment transaction cumulative table (t_pay_user_tx_count). If exceeded, block the transaction and report an error [Error Code: MPBCZ0000252, Please bind a physical debit card from this bank]. If not exceeded, proceed. Determine whether to control the cost price: No control or null: Proceed. Control: Compare whether the transaction cost price exceeds the configured cost price. If exceeded, block the transaction and report an error [Error Code: MPBCZ0000252, Please bind a physical debit card from this bank]. If not exceeded, proceed.
5. Call the security center [Security Authentication Tool Query] to check if the user has a payment password. If the security center reports an error or returns NULL, the payment center reports an error [Error Code: MPBCZ0000091, Payment password not set up. Please set up a payment password first].
6. Query the payment center supplier and payment decision relationship table (t_pay_provr_decision_rule) based on the supplier platform number. If no record is found, the payment center reports an error [Error Code: MPBCZ0000032, Supplier platform [XXXX] has no payment decision rule configured]. If found, check the configuration status. If not enabled, the payment center reports an error [Error Code: MPBCZ0000033, Supplier platform [XXXX] associated payment decision rule configuration is closed].
7. Query the payment center payment decision rule base table (t_pay_decision_rule) based on the configured payment decision rule number. If no record is found, the payment center reports an error [Error Code: MPBCZ0000035, Supplier platform [XXXX] association]. If found, check the payment decision rule status. If not enabled, the payment center reports an error [Error Code: MPBCZ0000035, Payment decision rule status is not enabled].
8. Check if the request data contains a points information group. If yes, use the aggregate points ID to call the points center service [Aggregate Points Definition Detail Query] to retrieve detailed points definition information. If the points center reports an error, the exception is thrown. Based on the returned points definition rules, calculate the total points deduction amount from the points information group in the request. Check if the points are consumed without effect. If cost price < payment amount + rights amount, the payment center reports an error [Error Code: MPBCZ0000216, Premium sales are not allowed]. If cost price = payment amount + rights amount, points are consumed without effect. If cost price > payment amount + rights amount, points are not consumed without effect, but verify whether the points deduction amount exceeds the difference (cost price - payment amount - rights amount). If exceeded, the payment center reports an error [Error Code: MPBCZ0000215, Points cannot be partially consumed without effect]. If less than the difference, calculate the bank advance amount: cost price - payment amount - rights amount - points amount.
9. If no points information group exists, check for premium sales. If cost price < payment amount + rights amount, the payment center reports an error [Error Code: MPBCZ0000216, Premium sales are currently not supported]. If cost price > payment amount + rights amount, calculate the bank advance amount: cost price - payment amount - rights amount.
10. Assemble the data for database insertion based on the request data. Main transaction information is inserted into the payment center pre-order table (t_prepay_order), product information into the pre-order product information table (t_prepay_merchd_inf), points information group into the pre-order points information table (t_prepay_point_inf), and rights information into the pre-order rights information table (t_prepay_rights_inf).
11. Assemble the transaction creation request data. User points, user rights, and bank advances are transparently transmitted for verification through the rights information group extension. Call the payment service—[Create Transaction Order]—to create the payment order information and return the payment order number. If an error occurs, the exception is directly thrown to the caller. If successful, the payment order number is inserted into the pre-order table (t_prepay_order).
12. Return the payment order number to the open bank. The open bank assembles the cashier URL address based on the returned order number and returns it to the third-party mall.

##### 1.1.2.1.5 External Service Calls
|External System|Interface Type|Interface Name|
|----|----|----|
|User Center|http|Supplier Basic Information Detail Query<br/>Customer Information Query|
|Security Center|http|Security Authentication Tool Query|
|Points Center|http|Aggregate Points Definition Detail Query|

##### 1.1.2.1.6 Related Database Tables
|English Table Name|Chinese Table Name|Description|
|----|----|----|
|t_prepay_order|Pre-order Table|Main payment information data for pre-orders when other platforms access the cashier.|
|t_prepay_merchd_inf|Pre-order Product Information Table|Product information data for pre-orders when other platforms access the cashier.|
|t_prepay_point_inf|Pre-order Points Information Table|User points information data for pre-orders when other platforms access the cashier.|
|t_prepay_rights_inf|Pre-order Rights Information Table|User rights information data for pre-orders when other platforms access the cashier.|
|t_pay_provr_decision_rule|Supplier and Payment Decision Relationship Table|Payment decision rules associated with the supplier platform.|
|t_pay_decision_rule|Payment Decision Rule Base Table|Basic configuration information for payment decision rules, mainly business type and event codes, status.|