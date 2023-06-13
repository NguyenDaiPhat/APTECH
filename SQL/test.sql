show databases;
use classicmodels;
show tables;
select *from orders;
select *from customers;
-- 1 
select city, count(*)"totalUsers" from customers group by city;
-- 2
select count(orderDate) as totalOrders from orders where orderDate like "2003-03-%";
select count(orderDate) as totalOrders from orders where month(orderdate) =3 and year(orderDate) = 2005;
-- 3
select month(orderdate) as myMonth, count(*) from orders where year(orderdate) = 2005 group by myMonth;
-- 4
select * from orderDetails;
select orderNumber, sum(quantityOrdered*priceEach) as totalPrice from orderDetails group by orderNumber order by totalPrice desc limit 10;
-- 5
select productLine, count(*) as totalProducts from products group by productLine;