<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/ordersuccess.css">
  </head>
    <style>
      
    </style>
    <body>
      <div class="card">
      <div style="border-radius:200px; height:auto; width:200px; background: #F8FAF5; margin:0 auto;">
        <i class="checkmark">✓</i>
      </div>
        <h1>Success</h1> 
        <p>We received your request;<br/> visit us with the <b>ID</b></p>
        <p>ORDER_ID: ${obj.order_id}</p>
        <p>B-GROUP: ${obj.bg} </p>
        <p>AMOUNT: ${obj.amount}L</p>   
        <br>
        <button type="button" onClick="window.location='./check'" class="back">back to status</button>
      </div>
    </body>
</html>