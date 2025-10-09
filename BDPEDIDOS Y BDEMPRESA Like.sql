use PEDIDOS_VENTAS5

select*from PEDIDO
--mostrar no razon social
select*from CLIENTE
where RAZONS is null

--clientes app perez, gonzales o castro
--intercalado no sea null

select*from CLIENTE
where APEPCLI in ('Perez', 'Gonzales', 'Castro')
and intercalado is not null

select*from PEDIDO
--todos los pedidos en el mes de octubre 2020, y total no este entre 100 y  200

select*from PEDIDO
where (FECPED between '2020/10/01' and '2020/10/31') and TOTAL not between 100 and 200

--like:
--% : varios caracteres
-- "_" : un solo caracter
--[] : rango de caracteres
select*from CLIENTE
--mostrar razones sociales que comience con "L"

select*from CLIENTE
where RAZONS like 'L%'


select*from CLIENTE
where DIRECLI like 'calle%' and CODCLI like '%[3,4]'


use EMPRESA5
select*from personal


select*from personal
where nom_personal like '%a' and dire_personal not like 'av.%' and estado_civil in ('c', 's')

--que sea el telefono 3 o 5
select*from personal
where telef_personal like '%3_' or telef_personal like '%5_'

--mostrar personal nombre = [a-f]
select*from personal
where nom_personal like '[a-f]%'
--cuato dijito dni 2,3,4
select*from personal
where dni_personal not like '___[2-4]____'

--order by (odenar por) asc/desc--->(ascendente/desendente)

select*from personal
order by nom_personal asc

select*from personal
where estado_civil = 'c'
order by fec_nacimiento asc

select*from contratos
where codpuesto in ('P001','P005')
order by sueldo_basico desc

--en el caso de que en el primer nivel haya repetidos, es mejor darle un segundo o hasta tercer nivel
select*from personal
order by ape_personal, nom_personal asc
