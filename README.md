# Billing Amount Assignment

## Problem Statement
### Epic Context
As a big telecom brand outlet, on the eve of Christmas, we want to offer attractive seasonal discounts to our
customers to boost our retail sales for our sim card outlets partners.
As a retail outlet’s salesman, I should be able to calculate the customer's total billing including all
sims after considering applicable discount rates that are based on the billing amount and customer type
so that our retail outlet can maximize sales volume & value.

Discount Slabs for various billing amounts for the regular and premium customers are as follows:

Customer Type: Regular 
| Purchase Amount Slab | Discount % |
|:--------------------:|:----------:|
| $ 0 - $ 5,000        | Nil        |
| $ 5,000 - $10,000    | 10%        |
| $ 10,000 & above     | 20%        |
                                             
Customer Type: Premium
| Purchase Amount Slab | Discount % |
|:--------------------:|:----------:|
| $ 0 - $ 4,000        | 10%        |
| $ 4,000 - $ 8,000    | 15%        | 
| $ 8,000 - $ 12,000   | 20%        | 
| $ 12,000 & above     | 30%        |
                                             

### Stories to develop
Here are some of the use cases and corresponding input / output expectations:
#### Story#1 : Regular Customer Billing
- Input (Customer type, Purchase Amount) : Regular 5,000 Output (Bill Amount): 5,000
- Input (Customer type, Purchase Amount) : Regular 10,000 Output (Bill Amount): 9,500
- Input (Customer type, Purchase Amount) : Regular 15,000 Output (Bill Amount): 13,500
#### Story#2 : Premium Customer Billing
- Input (Customer type, Purchase Amount) : Premium 4,000 Output (Bill Amount): 3,600
- Input (Customer type, Purchase Amount) : Premium 8,000 Output (Bill Amount): 7,000
- Input (Customer type, Purchase Amount) : Premium 12,000 Output (Bill Amount): 10,200
- Input (Customer type, Purchase Amount) : Premium 20,000 Output (Bill Amount): 15,800


## Solution

Designed an API which accepts CustomerType and PurchaseAmount in request Body. 

### API Contract

Url: http://localhost:8080/billing/v1/billing-amount

Request: 
```
{
	"customerType": "PREMIUM",
	"purchaseAmount": 1000
}
```

- **customerType** is ENUM which support two types REGULAR and PREMIUM
- **purchaseAmount** is the total purchase

Response:
```
{
	"billAmount": 900.0
}
```
- **billAmount** is the amount after applying the discount
