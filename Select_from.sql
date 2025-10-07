use PEDIDOS_VENTAS5
select*from PEDIDO
select*from PED_VEN_PRO
select*from PRODUCTO

update PED_VEN_PRO
set VTOTAL=80.00
where CODPED='PP002'and CODPRO='p0002'

update PEDIDO
set SUBTOTAL=130.00, IVA=23.40, TOTAL=153.4
where CODPED = 'PP002'
--USANDO <SELECT> EN EL COMANDO--

select*from CLIENTE
-- * = significa muchos
--mostramos los clientes del distrito 0001
select*from CLIENTE
where CODDISTRI='0001'

--USAMOS EL 'IS' CUANDO SE TRATA DE NULL

--mostrar todos los clientes que sean razones sociales
select*from CLIENTE
where RAZONS is not null
--mostrar todos los clientes que NO sean razones sociales
select*from CLIENTE
where RAZONS is null

--mostrar todos los clientes que sean razones sociales
--	y que vivan distrito 0001 o 0003
select*from CLIENTE
where RAZONS is not null and (CODDISTRI= '0001' or CODDISTRI= '0003')

--IN (DENTRO DE UNA LISTA) se usa cuando es una lista de muchos "or"
select*from CLIENTE
where RAZONS is not null and CODDISTRI IN ('0001','0003')

--mostrar todos los clientes que sean razones sociales
--	y que NO vivan distrito 0001 o 0003

select*from CLIENTE
where RAZONS is not null and CODDISTRI NOT IN ('0001','0003')

--mostrar todos los clientes 
-- que vivan distrito 0001 o 0003 O 0004
--cuyo estado sea A
-- cuyo apellido paterno no sea 'perez' o 'gonzales'

select *from CLIENTE
where CODDISTRI in ('0001','0003','0004') and 
ESTADO ='a' and APEPCLI not in ('Perez','Gonzales')

select*from PEDIDO
--mostrar los pedidos cuyo total este entre 100 y 250 soles
--y que se hayan realizado el 2020

select*from PEDIDO
where (TOTAL >=100 and TOTAL<251) and FECPED >='2020/01/01' 
and FECPED<='2020/12/31'

--between(entre)
select*from PEDIDO
where (TOTAL between 100 and 251) and (FECPED between '2020/01/01' 
and '2020/12/31')
--mostrar los pedidos cuyo total NO este entre 100 y 250 soles
--y que se hayan realizado el 2020
select*from PEDIDO
where (TOTAL not between 100 and 251) and (FECPED between '2020/01/01' 
and '2020/12/31')
