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
function actualizarResultado ()
{
	alert ("Función invocada");
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
<table>
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



