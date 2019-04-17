<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    
    <style>
    body{
    font-family: sans-serif;
    }
    #sdiv{
position: fixed;
top: 0;
left: 0;
width: 100vw;
height: 40px;
background-color: white;
overflow: hidden;
padding: 10px;
        z-index: 1;
}
        #cdiv{
            position: relative;
            border: 1px solid dodgerblue;
            height: 100%;
            width: 40%;
            margin: 0 auto;
            overflow: hidden;
            border-radius: 50px;
             box-shadow: 0px 0px 8px 0px rgba(0,0,0,0.5);
            
        }
        #value{
            position: absolute;
            top: 0;
            left: 20px;;
            height: 100%;
            width: 90%;
            z-index: 0;
            background: none;
            border: none;
            font-size: 15px;
            letter-spacing: 0.1em;
            color:dodgerblue;
           
        }
        #sicon{
            border-radius: 50px;
            z-index: 1;
            color: black;
            font-size: 20px;
            position: absolute;
            right: 0;
            top: 0;
            height: 36px;
            width: 36px;
            text-align: center;
            line-height: 36px;
            background-color:dodgerblue;
            color: white;
            margin: 2px;
            cursor: pointer;
            
        }
        #sicon:active{
            background-color: deepskyblue;
        }
        #value::placeholder{
            color: #bbb;
            font-size: 15px;
        }
        #value:focus{
            border: none;
            outline: none;
        }
        
      #res{
      		
      		position:fixed;
            z-index: 0;
            overflow: auto;
            top: 0;
            left: 0;
            padding: 80px 0 0 0;
            height: 88vh;
            width: 100vw;
            margin: 0;
        }
        #tab{
        	overflow:auto;
        	margin: 0 auto;
            width: 90%;
            height: auto;
            padding: 5px;
        }
        
        #tab tr{
        text-align: center;
        border: 1px solid dodgerblue;
        }
        #tab td{
        
        width: 50%;
        }
        #tab th{
        background-color:dodgerblue;
        color:white;
        padding:10px 0;
        text-align: center;
        }
        #tab{
        border-collapse: collapse;
        }
        #headi{
        position :absolute;
        padding:10px;
        font-size:30px;
        letter-spacing:0.3em;
        font-weight:bolder;
        
        background-color:#ff5733;
        color:white;
        width:auto;
        }
        
        #imgg{
        position:relative;
      	overflow: hidden;
      	height: 140px;
      	width: auto;
        }
        #imgg img{
        top:0;
        left:0;
        position:relative;
        }
    </style>
    </head>
<body>
<div id="sdiv">
        
        <div id="headi">BAR BOOK</div> 
         
            
        <div id="cdiv">
        <input type="text" name="value" id="value" placeholder="Enter value to generate Bar code">
        <p id="sicon" onclick="generate();">GO</p>
        </div>
        
</div>
    
 
    <div id="res">
    
    </div>
   
   
   
<script>
    function generate(){
        var x=document.getElementById('value').value;
        if(x!=""){
        	var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function() {
              if (this.readyState == 4 && this.status == 200) {
                document.getElementById("res").innerHTML = this.responseText;
              }
            };
            xmlhttp.open("GET", "perform.jsp?q="+x, true);
            xmlhttp.send();
        }
    }
    
    </script>

</body>
</html>