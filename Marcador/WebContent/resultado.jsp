<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESULTADO</title>
<style type="text/css">
.goles {
	background-color: blue;
	width: 400px;
	font-size: 40px;
	color: white;
	text-align: center;
}
</style>
<script type="text/javascript">
function programarllamada()
{
	setInterval (actualizarResultado, 10000);
}
var xmlHttp = new XMLHttpRequest();
function actualizarResultado ()
{
	//alert ("Función invocada"); INICIAR EL AJAX
	xmlHttp.onreadystatechange = mensajerecibido;
	xmlHttp.open('GET', 'ActualizarInfoPartido', true);
	xmlHttp.send (null);
}
function mensajerecibido() {
	if (xmlHttp.readyState==4)
		{
			if (xmlHttp.status==200)
				{
				//habremos recibido un json
				console.log (xmlHttp.responseText);
				var infojson = JSON.parse (xmlHttp.responseText);
				
				//alert ("GV " +infojson.marcador.goles_visitante);
				//alert ("GL " +infojson.marcador.goles_local);
				var caja_local = document.getElementById ("goleslocal");
				var caja_visitante = document.getElementById ("golesvisitante");
				caja_local.innerHTML = infojson.marcador.goles_local;
				caja_visitante.innerHTML = infojson.marcador.goles_visitante;
				var tabla= document.getElementById ("tablacomentarios");
				//todo actualizar tabla comentarios
				infojson.listacomentarios[0].minuto
				infojson.listacomentarios[0].comentario
				}
		}
}
</script>
</head>
<body onload="programarllamada()">
<div id="divfoto">
<img src="${imagen.ruta}" width="400" height="350">
</div>
<div class="goles" id="goleslocal">${marcador.goles_local}</div>
<div class="goles" id="golesvisitante">${marcador.goles_visitante}</div>
<div id="comentarios">
<table id="tablacomentarios">
<th>MINUTO</th>
<th>COMENTARIO</th>
<tr>
	<td>${comentario.minuto}</td>
	<td>${comentario.comentario}</td>
</tr>
</table>
</div>
</body>
</html>



