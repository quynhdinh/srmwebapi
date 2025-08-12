insert into suppliers values(1, '(641) 451-0009', 'Iowa Farms') on duplicate key update supplier_id = supplier_id ;
insert into suppliers values(2, null, 'Hallmark Agro, Inc') on duplicate key update supplier_id = supplier_id ;
insert into products values(1, '2023-05-31', 'Santa sweet apple', 105, 1.08, 1) on duplicate key update product_id = product_id ;
insert into products values(2, '2023-05-31', 'Chicken drumsticks', 14, 20, 1) on duplicate key update product_id = product_id ;
insert into products values(3, '2023-05-31', 'Dole bananas', 16, 14, 2) on duplicate key update product_id = product_id ;
