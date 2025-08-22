### 1.1 Pre-order
### 1.1.2 Pre-order Table (t_prepay_order)
#### 1.1.2.1 Table Description
Other platforms accessing the cashier, transaction layer data.
##### 1.1.2.1.1 Table Structure
| No. | Field Name | Field Description | Field Type | Length | Nullable | Default Value |  
|-----|------------|-------------------|------------|--------|----------|---------------|  
| 1 | id | PK | bigint |  | Not allowed | None |  
| 2 | lpr_cd | Legal entity code | varchar | 12 | Not allowed | None |  
| 3 | global_seq_num | Global serial number<br/>Message header EventNo | varchar | 64 | Not allowed | None |  
| 4 | mercht_ordr_id | Merchant order number<br/>Third-party order serial number | varchar | 64 | Not allowed | None |  
| 5 | bpaas_ordr_id | bpaas order number | varchar | 64 | Allowed | None |  
| 6 | usr_id | User ID | varchar | 32 | Allowed | None |  
| 7 | usr_open_org_id | Account opening institution ID | varchar | 12 | Allowed | None |  
| 8 | usr_belg_org_id | Affiliated institution ID | varchar | 12 | Allowed | None |  
| 9 | mgr_org_id | Account management institution ID | varchar | 12 | Allowed | None |  
| 10 | biz_tx_tm | Business transaction time | datetime |  | Not allowed | None |  
| 11 | contr_mercht_id | Contracted merchant ID | varchar | 32 | Allowed | None |  
| 12 | contr_mercht_nm | Contracted merchant name | varchar | 64 | Allowed | None |  
| 13 | mercht_id | Merchant ID<br/>Supplier platform ID | varchar | 64 | Allowed | None |  
| 14 | mercht_nm | Merchant name<br/>Supplier platform name | varchar | 64 | Allowed | None |  
| 15 | sec_mercht_id | Secondary merchant ID | varchar | 64 | Allowed | None |  
| 16 | orgnl_prc | Original price<br/>Recorded, no operation currently | decimal | 20,2 | Not allowed | None |  
| 17 | prc_amt | Selling price<br/>If empty, take the original price | decimal | 20,2 | Allowed | None |  
| 18 | point_prc_cnt | Points selling price total | bigint |  | Allowed | None |  
| 19 | cost_prc | Cost price<br/>Settlement price defined with supplier | decimal | 20,2 | Allowed | None |  
| 20 | pay_totl_amt | Total payment amount<br/>Customer actual payment + tool rights amount | decimal | 20,2 | Not allowed | None |  
| 21 | rights_totl_amt | Total rights amount<br/>Sum of all rights amounts | decimal | 20,2 | Not allowed | None |  
| 22 | point_totl_cnt | Total points<br/>Sum of all points | bigint |  | Allowed | None |  
| 23 | point_totl_amt | Total points amount<br/>After taking the exchange rate for each points summary number, convert to amount and summarize | decimal | 20,2 | Allowed | None |  
| 24 | point_kh_flg | Points waste flag<br/>0-Waste<br/>1-No waste | bigint |  | Allowed | None |  
| 25 | adv_money_amt | Advance amount<br/>Advance amount = Cost price - Payment amount - Total rights amount - Total points amount | decimal | 20,2 | Allowed | None |  
| 26 | cust_pay_amt | Customer actual payment amount | decimal | 20,2 | Allowed | None |  
| 27 | biz_tp_cd | Business type code | varchar | 32 | Not allowed | None |  
| 28 | evt_cd | Event code | varchar | 32 | Not allowed | None |  
| 29 | ordr_valid_prd | Order validity period | datetime |  | Allowed | None |  
| 30 | ccy | Currency | varchar | 3 | Allowed | None |  
| 31 | usr_ip | User IP | varchar | 20 | Allowed | None |  
| 32 | tellr_no | Teller number | varchar | 10 | Allowed | None |  
| 33 | org_cd | Institution code | varchar | 12 | Not allowed | None |  
| 34 | rtn_adr | Callback address<br/>Cashier callback URL | varchar | 256 | Not allowed | None |  
| 35 | advs_adr | Notification address | varchar | 256 | Allowed | None |  
| 36 | payr_cpln | Payer full name | varchar | 32 | Allowed | None |  
| 37 | payr_cert_tp | Payer certificate type | varchar | 2 | Allowed | None |  
| 38 | payr_cert_no | Payer certificate number | varchar | 32 | Allowed | None |  
| 39 | payr_mobl_no | Payer mobile number | varchar | 11 | Allowed | None |  
| 40 | payr_mail | Payer email | varchar | 32 | Allowed | None |  
| 41 | ordr_rmrk | Order remarks | varchar | 32 | Allowed | None |  

#### Table Indexes
| Table Constraint | Name | Field |  
|------------------|------|-------|  
| Unique index | uk_t_prepay_order_1 | mercht_ordr_id |  
|  | uk_t_prepay_order_2 | bpaas_ordr_id |  

### 1.1.3 Pre-order Product Information Table (t_prepay_merchd_inf)
#### 1.1.3.1 Table Description
Transaction layer product information.
##### 1.1.3.1.1 Table Structure
| No. | Field Name | Field Description | Field Type | Length | Nullable | Default Value |  
|-----|------------|-------------------|------------|--------|----------|---------------|  
| 1 | id | PK | bigint |  | Not allowed | None |  
| 2 | lpr_cd | Legal entity code | varchar | 12 | Not allowed | None |  
| 3 | mercht_ordr_id | Merchant order number | varchar | 64 | Not allowed | None |  
| 4 | merchd_id | Product ID | varchar | 64 | Not allowed | None |  
| 5 | merchd_nm | Product name | varchar | 128 | Allowed | None |  
| 6 | merchd_cnt | Product quantity | varchar | 16 | Allowed | None |  
| 7 | merchd_orgnl_prc | Product original price | decimal | 20,2 | Not allowed | None |  
| 8 | merchd_cost_prc | Product cost price | decimal | 20,2 | Not allowed | None |  
| 9 | merchd_prefr_prc | Product preferential price | decimal | 20,2 | Allowed | None |  

### 1.1.4 Pre-order Rights Information Table (t_prepay_rights_inf)
#### 1.1.4.1 Table Description
Transaction layer user rights information.
##### 1.1.4.1.1 Table Structure
| No. | Field Name | Field Description | Field Type | Length | Nullable | Default Value |  
|-----|------------|-------------------|------------|--------|----------|---------------|  
| 1 | id | PK | bigint |  | Not allowed | None |  
| 2 | lpr_cd | Legal entity code | varchar | 12 | Not allowed | None |  
| 3 | mercht_ordr_id | Merchant order number | varchar | 64 | Not allowed | None |  
| 4 | rights_id | Rights ID | varchar | 64 | Not allowed | None |  
| 5 | rights_dtl_id | Rights detail ID | varchar | 64 | Not allowed | None |  
| 6 | rights_nm | Rights name | varchar | 300 | Allowed | None |  
| 7 | rights_amt | Rights amount | decimal | 20,2 | Allowed | None |  

### 1.1.5 Pre-order Points Information Table (t_prepay_point_inf)
#### 1.1.5.1 Table Description
Transaction layer points information.
##### 1.1.5.1.1 Table Structure
| No. | Field Name | Field Description | Field Type | Length | Nullable | Default Value |  
|-----|------------|-------------------|------------|--------|----------|---------------|  
| 1 | id | PK | bigint |  | Not allowed | None |  
| 2 | lpr_cd | Legal entity code | varchar | 12 | Not allowed | None |  
| 3 | mercht_ordr_id | Merchant order number | varchar | 64 | Not allowed | None |  
| 4 | sum_point_id | Summary points ID | varchar | 64 | Not allowed | None |  
| 5 | point_cnt | Points quantity | bigint |  | Not allowed | None |  
| 6 | point_exchg_rto | Points exchange rate | decimal | 20,2 | Allowed | None |  
| 7 | point_comut_amt | Points deduction amount | decimal | 20,2 | Allowed | None |  

### 1.1.6 Supplier and Payment Decision Relation Table (t_pay_provr_decision_rule)
#### 1.1.6.1 Table Description
Stores supplier platform-related payment decision relations.
##### 1.1.6.1.1 Table Structure
| No. | Field Name | Field Description | Field Type | Length | Nullable | Default Value |  
|-----|------------|-------------------|------------|--------|----------|---------------|  
| 1 | id | PK | bigint |  | Not allowed | None |  
| 2 | lpr_cd | Legal entity code | varchar | 12 | Not allowed | None |  
| 3 | provr_id | Supplier ID | varchar | 60 | Not allowed | None |  
| 4 | pay_decis_rule_id | Payment decision rule ID | varchar | 60 | Not allowed | None |  
| 5 | st_cd | Status code<br/>01-Normal<br/>02-Closed | varchar | 2 | Not allowed | None |  
| 6 | mark_flag | Mark flag<br/>0-Not marked<br/>1-Marked | bigint |  | Allowed | None |  

| Table Constraint | Name | Field |  
|------------------|------|-------|  
| Unique index | uk_t_pay_provr_decision_rule_1 | pay_decis_rule_id |  
|  |  | provr_id |  

### 1.1.7 Payment Decision Rule Basic Table (t_pay_decision_rule)
#### 1.1.7.1 Table Description
Payment decision rule main basic information.
##### 1.1.7.1.1 Table Structure
| No. | Field Name | Field Description | Field Type | Length | Nullable | Default Value |  
|-----|------------|-------------------|------------|--------|----------|---------------|  
| 1 | id | PK | bigint |  | Not allowed | None |  
| 2 | lpr_cd | Legal entity code | varchar | 12 | Not allowed | None |  
| 3 | pay_decis_rule_id | Payment decision rule ID | varchar | 60 | Not allowed | None |  
| 4 | pay_decis_rule_nm | Payment decision rule name | varchar | 300 | Not allowed | None |  
| 5 | biz_tp_cd | Business type code | varchar | 40 | Not allowed | None |  
| 6 | evt_cd | Event code | varchar | 40 | Not allowed | None |  
| 7 | pay_decis_rule_st_cd | Payment decision rule status code<br/>01-Normal<br/>02-Closed | varchar | 2 | Not allowed | None |  
| 8 | pay_decis_rule_rmrk | Payment decision rule remarks | varchar | 300 | Allowed | None |  
| 9 | rltnp_decis_id | Associated decision ID<br/>Corresponding bPaas payment decision ID | varchar | 60 | Allowed | None |  
| 10 | sync_st_cd | Synchronization status code<br/>Whether payment decision rule has been synchronized to bPaas<br/>01-Synchronized<br/>02-Not synchronized | varchar | 2 | Not allowed | None |  
| 11 | sync_ctrl_cd | Synchronization control code<br/>Whether payment decision rule can be published to bPaas<br/>01-Can publish<br/>02-Cannot publish | varchar | 2 | Not allowed | None |  
| 12 | mark_flag | Mark flag<br/>0-Not marked<br/>1-Marked | bigint |  | Allowed | None |  

| Table Constraint | Name | Field |  
|------------------|------|-------|  
| Unique index | uuk_t_pay_decision_rule | pay_decis_rule_id |  
| Index | idx_t_pay_decision_rule_1 | pay_decis_rule_nm |  
|  | idx_t_pay_decision_rule_2 | biz_tp_cd |  
|  | idx_t_pay_decision_rule_3 | evt_cd |  
|  | idx_t_pay_decision_rule_4 | biz_tp_cd |  
|  |  | evt_cd |