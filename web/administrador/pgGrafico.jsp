
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="cabAdmi2.jsp" %>

        <center>
            <br>
            <table>
            <tr><td> 
         <form action="prueba" target="ventana" name="fr">
         Escoja un tipo de producto:<select name="tan">
            <option value="T001">Promociones
            <option value="T002">PollosBrasa
            <option value="T003">Guarniciones
            <option value="T004">SanguchesPolleros
            <option value="T005">Bebidas
            </select>  
         <br>
            <input type="radio" name="op" value="1" onclick="ver()">Barras
            <input type="radio" name="op" value="2" onclick="ver()">Circular
        </form>
            <br>
        <iframe name="ventana" height="400" width="500"></iframe>
                 </td>
                
            <td> 
            <form action="prueba22" target="ventana2" name="fr2">
          Elija un día de la semana:<select name="tan2">
             <option value="Monday">Lunes
            <option value="Tuesday">Martes
            <option value="Wednesday">Miércoles
            <option value="Thursday">Jueves
            <option value="Friday">Viernes
            <option value="Saturday">Sábado
            <option value="Sunday">Domingo
            </select> 
         <br>
            <input type="radio" name="op2" value="1" onclick="ver2()">Barras
            <input type="radio" name="op2" value="2" onclick="ver2()">Circular
        </form>
            <br>
        <iframe name="ventana2" height="400" width="500"></iframe>
             </td>
            </tr>
            
            </table>
        </center>
    <br> <br>
        <script>
                function ver(){
                    fr.submit();
                }
                function ver2(){
                    fr2.submit();
                }
                </script>

    </body>
</html>
