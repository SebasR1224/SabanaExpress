<%@page import="ModeloVO.RecomendacionVO"%>
<%@page import="ModeloVO.ParteCuerpoVO"%>
<%@page import="ModeloVO.SintomaVO"%>
<%@page import="ModeloVO.RelacionPesoTallaVO"%>
<%@page import="ModeloDAO.RelacionPesoTallaDAO"%>
<%@page import="ModeloDAO.SintomaDAO"%>
<%@page import="ModeloDAO.ParteCuerpoDAO"%>
<%@include file="DB_Farmaceutico.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizar Recomendación</title>
</head>
<body>
    <%
        RecomendacionVO recVO = (RecomendacionVO)request.getAttribute("recomendacion");
        if(recVO !=null){
    %>
    <div class="home_content">
        <div class="text">Actualizar Recomendación</div>
        <form action="Recomendacion" method="POST">
            
            <input type="hidden" name="textRecId" value="<%=recVO.getRecId()%>">
            
            <label for="RecNombre">Nombre Recomendación</label>
            <input type="text" name="textRecNombre" id="RecNombre" class="" value="<%=recVO.getRecNombre()%>">
            
            <label for="ParId">Parte del cuerpo</label>
            <select name="textParId" id="ParId">
                <option value="0">Selecioné...</option>
                <%
                    ParteCuerpoDAO parDAO = new ParteCuerpoDAO();
                    for(ParteCuerpoVO parVO : parDAO.listar()){
                %>
                <option value="<%=parVO.getParId()%>"><%=parVO.getParNombre()%></option>
                <%}%>
            </select>
            <label for="SinId">Sintoma</label>
            <select name="textSinId" id="SinId">
                <option value="0">Selecioné...</option>
                <%
                    SintomaDAO sinDAO = new SintomaDAO();
                    for(SintomaVO sinVO : sinDAO.listar()){
                %>
                <option value="<%=sinVO.getSinId()%>"><%=sinVO.getSinDescripcion()%></option>
                <%}%>
            </select>

            <label for="MedId">Medicamento</label>
            <input type="text" name="textMedId" id="MedId" class="" placeholder="Medicamento">
            
            <label for="RecDosis">Dosis</label>
            <input type="text" name="textRecDosis" id="RecDosis" class="" value="<%=recVO.getRecDosis()%>">

            <label for="RecFrecuencia">Frecuencia</label>
            <input type="text" name="textRecFrecuencia" id="RecFrecuencia" class="" value="<%=recVO.getRecFrecuencia()%>">
            
            
            
            <label for="RecTiempo">Tiempo</label>
            <input type="text" name="textRecTiempo" id="RecTiempo" class=""  value="<%=recVO.getRecTiempo()%>">

            <label for="IntensidadMin">Intensidad minima</label>
            <input type="number" name="textRecIntensidadMin" id="IntensidadMin" class="" value="<%=recVO.getRecIntensidadMin()%>">

            <label for="IntensidadMax">Intensidad maxima</label>
            <input type="number" name="textRecIntensidadMax" id="IntensidadMax" class="" value="<%=recVO.getRecIntensidadMax()%>">
            
            <label for="RecEdadMin">Edad minima</label>
            <input type="number" name="textRecEdadMin" id="RecEdadMin" class="" value="<%=recVO.getRecEdadMin()%>">

            <label for="RecEdadMax">Edad maxima</label>
            <input type="number" name="textRecEdadMax" id="RecEdadMax" class="" value="<%=recVO.getRecEdadMax()%>">

            <label for="ImcId">Indice de masa corporal</label>
            <select name="textImcId" id="ImcId">
                <option value="0">Selecioné...</option>
                <%
                    RelacionPesoTallaDAO imcDAO = new RelacionPesoTallaDAO();
                    for(RelacionPesoTallaVO imcVO : imcDAO.listar()){
                %>
                <option value="<%=imcVO.getImcId()%>"><%=imcVO.getImcNombre()%></option>
                <%}%>
            </select>
            <label for="RecInformacion">Informacion adicional</label>
            <input type="textarea" name="textRecInformacion" id="RecInformacion" value="<%=recVO.getRecInformacion()%>">
            
            <input type="hidden" value="Activo" name="textRecEstado"> 
            
            <button name="opcion" value="2">Actualizar</button>
        </form>
         <%}%>   
    </div>
</body>
</html>