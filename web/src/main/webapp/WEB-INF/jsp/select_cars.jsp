<%--
  Created by IntelliJ IDEA.
  User: chep
  Date: 11.02.2018
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-chained/1.0.1/jquery.chained.min.js"></script>
    <script>
        $(function(){
            $("#model").chained("#manufacture");
        })
    </script>
</head>
<body>
<div height="400" width="800" align="center">
<form  name="test" method="post" action="${pageContext.request.contextPath}/selectcars" >
    <p><b>Марка</b><br>
        <select id="manufacture" name="manufacture" required>
            <option value="bmw">BMW</option>
            <option value="audi">Audi</option>
        </select>
    </p>
    <p><b>Модель</b><br>
        <select id="model" name="model" required>
            <option value="645" class="bmw">645</option>
            <option value="320i" class="bmw">320i</option>
            <option value="740" class="bmw">740</option>
            <option value="a3" class="audi">A3</option>
            <option value="a4" class="audi">A4</option>
            <option value="a5" class="audi">A5</option>
        </select>
    </p>
    <p style="text-align: center">Год:</p> <p style="text-align: center">
    <select name="minYear" required>
        <option value="1980">1980</option>
        <option value="1981">1981</option>
        <option value="1982">1982</option>
        <option value="1983">1983</option>
        <option value="1984">1984</option>
        <option value="1985">1985</option>
        <option value="1986">1986</option>
        <option value="1987">1987</option>
        <option value="1988">1988</option>
        <option value="1989">1989</option>
        <option value="1990">1990</option>
        <option value="1991">1991</option>
        <option value="1992">1992</option>
        <option value="1993">1993</option>
        <option value="1994">1994</option>
        <option value="1995">1995</option>
        <option value="1996">1996</option>
        <option value="1997">1997</option>
        <option value="1998">1998</option>
        <option value="1999">1999</option>
        <option value="2000">2000</option>
        <option value="2001">2001</option>
        <option value="2002">2002</option>
        <option value="2003">2003</option>
        <option value="2004">2004</option>
        <option value="2005">2005</option>
        <option value="2006">2006</option>
        <option value="2007">2007</option>
        <option value="2008">2008</option>
        <option value="2009">2009</option>
        <option value="2010">2010</option>
        <option value="2011">2011</option>
        <option value="2012">2012</option>
        <option value="2013">2013</option>
        <option value="2014">2014</option>
        <option value="2015">2015</option>
        <option value="2016">2016</option>
        <option value="2017">2017</option>
        <option value="2018">2018</option>
    </select>-
    <select name="maxYear" required>
        <option value="1980">1980</option>
        <option value="1981">1981</option>
        <option value="1982">1982</option>
        <option value="1983">1983</option>
        <option value="1984">1984</option>
        <option value="1985">1985</option>
        <option value="1986">1986</option>
        <option value="1987">1987</option>
        <option value="1988">1988</option>
        <option value="1989">1989</option>
        <option value="1990">1990</option>
        <option value="1991">1991</option>
        <option value="1992">1992</option>
        <option value="1993">1993</option>
        <option value="1994">1994</option>
        <option value="1995">1995</option>
        <option value="1996">1996</option>
        <option value="1997">1997</option>
        <option value="1998">1998</option>
        <option value="1999">1999</option>
        <option value="2000">2000</option>
        <option value="2001">2001</option>
        <option value="2002">2002</option>
        <option value="2003">2003</option>
        <option value="2004">2004</option>
        <option value="2005">2005</option>
        <option value="2006">2006</option>
        <option value="2007">2007</option>
        <option value="2008">2008</option>
        <option value="2009">2009</option>
        <option value="2010">2010</option>
        <option value="2011">2011</option>
        <option value="2012">2012</option>
        <option value="2013">2013</option>
        <option value="2014">2014</option>
        <option value="2015">2015</option>
        <option value="2016">2016</option>
        <option value="2017">2017</option>
        <option value="2018">2018</option>
    </select>
    </p>
    <p style="text-align: center">Отображать на странице:</p>
    <select name="limit" required>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="5">5</option>
    </select>
    </p>
    <p><input type="submit" value="Отправить">
        <input type="reset" value="Очистить"></p>
</form>
</div>
</body>
</html>
