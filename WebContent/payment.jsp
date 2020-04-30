<!DOCTYPE html>
<html>
<head>
  <title>Payment</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <link rel="stylesheet" href="css/shalini/payment.css">
</head>
<body>

   

    <div class="row">
        <div class="col-lg-6">
            <main class="page payment-page">
                <section class="payment-form dark">
                    <div class="container">
                       
                        <form>
                            <div class="products" style="overflow: scroll;">
                                <h3 class="title">Checkout</h3>
                                
                                <div class="item">
                                    <span class="price">$200</span>
                                    <p class="item-name">Product 1</p>
                                    <p class="item-description">Lorem ipsum dolor sit amet</p>
                                </div>
                                <div class="item">
                                    <span class="price">$120</span>
                                    <p class="item-name">Product 2</p>
                                    <p class="item-description">Lorem ipsum dolor sit amet</p>
                                </div>
                                <div class="total">Total<span class="price">$320</span></div>
                            </div>
                            <div class="card-details">
                                <h3 class="title">Credit Card Details</h3>
                                <div class="row">
                                    <div class="form-group col-sm-7">
                                        <label for="card-holder">Card Holder</label>
                                        <input id="card-holder" type="text" class="form-control" placeholder="Card Holder"
                                            aria-label="Card Holder" aria-describedby="basic-addon1">
                                    </div>
                                    <div class="form-group col-sm-5">
                                        <label for="">Expiration Date</label>
                                        <div class="input-group expiration-date">
                                            <input type="text" class="form-control" placeholder="MM" aria-label="MM"
                                                aria-describedby="basic-addon1">
                                            <span class="date-separator">/</span>
                                            <input type="text" class="form-control" placeholder="YY" aria-label="YY"
                                                aria-describedby="basic-addon1">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-8">
                                        <label for="card-number">Card Number</label>
                                        <input id="card-number" type="text" class="form-control" placeholder="Card Number"
                                            aria-label="Card Holder" aria-describedby="basic-addon1">
                                    </div>
                                    <div class="form-group col-sm-4">
                                        <label for="cvc">CVC</label>
                                        <input id="cvc" type="text" class="form-control" placeholder="CVC" aria-label="Card Holder"
                                            aria-describedby="basic-addon1">
                                    </div>
                                    <div class="form-group col-sm-12">
                                        <button type="button" class="btn btn-primary btn-block">Proceed</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </section>
            </main>
        </div>

        <div class="col-lg-6 right">
            <img class="img" src="img/shalini/pay.gif" alt="">
        </div>
    </div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>