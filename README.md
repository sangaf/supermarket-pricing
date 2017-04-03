# supermarket-pricing

## Assumtions

At the end of the shopping user will checkout and calculate total price for different shopping items.

1. Item is the unit of the supermarket shopping cart

2. Shopping promotions are associate with items hence ItemCode

3. Actual price of an Item can be get after applying promotions

* Promotions 
    - Buy two can of beans for £1
    - Buy two get one free
    
![Classes interaction](/images/checkout.jpg)

### REST resources and uri

URI: http://supermarket.com/cart/addItem

HttpMethod: POST

```$xslt
    { cart-item: {
        item-code: <some item code>,
        quantity: <item count>
        }
     }
```

URI: http://supermarket.com/checkout

HttpMethod: POST

```$xslt
    { cart-items: {
         {
            item-code: <some item code>,
            quantity: <item count>
            }
         },
         {
            item-code: <some item code>,
            quantity: <item count>
         },
        {
          item-code: <some item code>,
          quantity: <item count>
        }
      }
    }
```

