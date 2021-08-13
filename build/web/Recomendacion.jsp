<%-- 
    Document   : registrarRecomendacion
    Created on : 08-ago-2021, 9:52:20
    Author     : User
--%>

<%@page import="ModeloDAO.SintomaDAO"%>
<%@page import="ModeloVO.SintomaVO"%>
<%@page import="ModeloDAO.ParteCuerpoDAO"%>
<%@page import="ModeloVO.ParteCuerpoVO"%>
<%@page import="ModeloDAO.RecomendacionDAO"%>
<%@page import="ModeloVO.RecomendacionVO"%>
<%@include file="DB_Farmaceutico.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <!-- DATATABLES -->
    <!--  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"> -->
    <!-- BOOTSTRAP -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">

    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="farmaceutico/css/style.css">
    <!-- CSS Modal-->
    <link href="Recomendacion/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="home_content">
            <div class="text">Mis recomendaciones</div>
            <button type="submit" class="ctaSintoma"><i class="far fa-edit"></i>Sintoma</button>
            
            <button type="submit" class="ctaParte"><i class="far fa-edit"></i>Parte</button>
            <div class="container" style="margin-top: 10px;padding: 5px">
                <a href="Registrar_Recomendacion.jsp">Nuevo</a>
                <table id="tablax" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <th>Codigo</th>
                        <th>Recomendación</th>
                        <th>Parte del cuerpo</th>
                        <th>Sintoma </th>
                        <th>Medicamento</th>
                        <th>Dosis</th>
                        <th>Frecuencia</th>
                        <th>Tiempo</th>
                        <th>Intensidad</th>
                        <th>Edad</th>
                        <th>Imc</th>
                        <th>Descripcion</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </thead>
                    <tbody>
                        <%
                            
                        RecomendacionVO recVO = new RecomendacionVO();
                        RecomendacionDAO recDAO = new RecomendacionDAO(); 
                        
                        ArrayList<RecomendacionVO>listaRecomendacion= recDAO.listar();
                        for (int i = 0; i <listaRecomendacion.size() ; i++) {
                                recVO = listaRecomendacion.get(i);
                        
                        %>
                        <%
                        ParteCuerpoDAO parDAO = new ParteCuerpoDAO();
                        ParteCuerpoVO parVO = new ParteCuerpoVO();
                        
                        SintomaVO sinVO = new SintomaVO();
                        SintomaDAO sinDAO = new SintomaDAO();
                                           
                        parVO = parDAO.consultarPartes(recVO.getParId());
                        sinVO = sinDAO.consultarSintomas(recVO.getSinId());
                        %>
                        
                        <tr>
                            <td><%=recVO.getRecId()%></td>
                            <td><%=recVO.getRecNombre()%></td>
                            <td><%=parVO.getParNombre()%></td>
                            <td><%=sinVO.getSinDescripcion()%></td>
                            <td><%=recVO.getMedId()%></td>
                            <td><%=recVO.getRecDosis()%></td>
                            <td><%=recVO.getRecFrecuencia()%></td>
                            <td><%=recVO.getRecTiempo()%></td>
                            <td><%=recVO.getRecIntensidadMin()%> - <%=recVO.getRecIntensidadMax()%></td>
                            <td><%=recVO.getRecEdadMin()%> - <%=recVO.getRecEdadMax()%></td>
                            <td><%=recVO.getImcId()%></td>
                            <th><%=recVO.getRecInformacion()%></th>
                            <td><%=recVO.getRecEstado()%></td>
                            <td>
                                <form action="Recomendacion" method="POST">
                                    <input type="hidden" value="<%=recVO.getRecId()%>" name="textRecId" id="">
                                    <button name="opcion" value="3">Editar</button>
                                </form> 
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
                    
        <!-- Modal -->
        <div class="modal-containerSintoma">
            <div class="modalSintoma modal-close">
                <p class="closeSintoma">X</p>
                <div class="modal-form">
                    <form method="POST" action="Sintoma">
                        <h2 class="title">Registrar Sintomas</h2>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="text" placeholder="Nombre Sintoma" name="textDescriSintoma" required>
                        </div>
                        <button class="btn solid" value="1" name="opcion">Crear Sintoma</button>
                    </form>
                </div>
            </div>
        </div>
        
        <!-- Modal Parte -->
        <div class="modal-containerParte">
            <div class="modalParte modal-close">
                <p class="closeParte">X</p>
                <div class="modal-form">
                    <form method="POST" action="Recomendacion">
                        <h2 class="title">Registrar Parte Cuerpo</h2>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="text" placeholder="Nombre Parte" name="textParNombre" required>
                        </div>
                        <button class="btn solid" value="4" name="opcion">Crear Parte</button>
                    </form>
                </div>
            </div>
        </div>  
         <!-- JQUERY -->
         <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <!-- DATATABLES -->
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
        <!-- BOOTSTRAP -->
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
        <!-- -JAVASCRIPT -->
        <script src="farmaceutico/js/main.js"></script>
         <!-- -JS Modal -->
        <script src="Recomendacion/js/modals.js" type="text/javascript"></script>
    </body>
</html>
