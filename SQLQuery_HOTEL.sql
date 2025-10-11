CREATE DATABASE BDHOTEL
use BDHOTEL
CREATE TABLE RECEPCIONISTA
(
codrecepcio char(3) not null,
nomrecepcio varchar(20) not null,
apeprecepcio varchar(20) not null,
apemrecepcio varchar(20) null,
constraint pk_cliente primary key(codrecepcio),
)
CREATE TABLE TIPOSERVICIO
(
codtiposer char(3) not null,
nomtiposer varchar(20) not null,
constraint pk_tiposer primary key(codtiposer),
)
CREATE TABLE TIPOHABITA
(
codtipoha char(3) not null,
nomtipoha varchar(20) not null,
constraint pk_tipoha primary key(codtipoha),
)
CREATE TABLE PROCEDENCIA
(
codproce char(3) not null,
nomproce varchar(25) not null,
constraint pk_proce primary key(codproce),
)
CREATE TABLE CLIENTE
(
codcliente char(3) not null,
nomcliente varchar(25) not null,
apepcliente varchar(25) not null,
apemcliente varchar(25) null,
documident varchar(15) not null,
estadocivil varchar(12) not null,
telefono varchar(12) null,
codproce char(3) not null,
constraint pk_client primary key(codcliente),
constraint fk_proce2 foreign key(codproce) references PROCEDENCIA(codproce),
)
CREATE TABLE HABITACION
(
nrohabitacion integer not null,
estado varchar(20) not null,
precio decimal(5,2) not null,
codtipoha char(3) not null,
constraint pk_nrohabitacion primary key(nrohabitacion),
constraint fk_tipoha2 foreign key(codtipoha) references TIPOHABITA(codtipoha),
)
CREATE TABLE SERVICIOS
(
codservicio char(3) not null,
nomservicio varchar(20) not null,
precioserv decimal(7,2) not null,
codtiposer char(3) not null,
constraint pk_servicio primary key(codservicio),
constraint fk_tiposer2 foreign key(codtiposer) references TIPOSERVICIO(codtiposer),
)
CREATE TABLE RESERVA_PAGO
(
codreserva char(4) not null,
fechareserva datetime not null,
fechanulacion datetime not null,
estadreserva varchar(30) not null,
codpago char(3) not null,
monto_totalpago decimal(7,2) not null,
tipopago varchar(30) not null,
fechaemision datetime not null,
descuento decimal(7,2) not null,
modalidad varchar(30) not null,
codcliente char(3) not null,
codrecepcio char(3) not null,
constraint pk_reserva primary key(codreserva),
constraint fk_cliente2 foreign key(codcliente) references CLIENTE(codcliente),
constraint fk_recepcio2 foreign key(codrecepcio) references RECEPCIONISTA(codrecepcio),
)
CREATE TABLE RESER_SERVI
(
fechaconsumo datetime not null,
codreserva char(4) not null,
codservicio char(3) not null,
constraint fk_reserva2 foreign key(codreserva) references RESERVA_PAGO(codreserva),
constraint fk_servicio2 foreign key(codservicio) references SERVICIOS(codservicio),
)
CREATE TABLE RESER_HAB
(
codreserva char(4) not null,
nrohabitacion integer not null,
constraint fk_reserva3 foreign key(codreserva) references RESERVA_PAGO(codreserva),
constraint fk_nrohabitacion2 foreign key(nrohabitacion) references HABITACION(nrohabitacion),
)