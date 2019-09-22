<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 19.09.19
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<script src="http://code.jquery.com/jquery-1.10.2.min.js" type="text/javascript" ></script>
<script type="text/javascript">

    $(document).ready(function() {
        $("#test").click(function(){

            var table = document.getElementById("table");

            while(table.rows.length > 1) {
                table.deleteRow(1);
            }
            var i=1;

            $.ajax({
                url: '/ajaxtest',
                dataType : "json",
                success: function (data) {
                    $.each(data, function() {
                        var row = table.insertRow(i);
                        i++;
                        var cell1 = row.insertCell(0);
                        var cell2 = row.insertCell(1);
                        var cell3 = row.insertCell(2);

                        $.each(this, function(key, val){
                            if (key=="electroenergy") cell1.innerHTML = val;
                            if (key=="units") cell2.innerHTML = val;
                            if (key=="fact") cell3.innerHTML = val;
                        });


                    });

                }
            });
        });
    });
</script>

<body>
<table id="table">
     <tr>
         <th>Электроэнергия</th>
         <th>Единицы</th>
         <th>Факт</th>
     </tr>
</table>


<button id="test">Отчет</button>
</body>
</html>