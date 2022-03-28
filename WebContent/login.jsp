<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setHeader ("Expires", "0"); //prevents caching at the proxy server
%> 
<%@page import="com.online.constants.GlobalConstants"%>
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        
        <title>OES | Login</title>
        <style>
           #logreg-forms{
    width:412px;
    margin:10vh auto;
    background-color:#f3f3f3;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
    transition: all 0.3s cubic-bezier(.25,.8,.25,1);
}
#logreg-forms form {
    width: 100%;
    max-width: 410px;
    padding: 15px;
    margin: auto;
}
#logreg-forms .form-control {
    position: relative;
    box-sizing: border-box;
    height: auto;
    padding: 10px;
    font-size: 16px;
}
#logreg-forms .form-control:focus { z-index: 2; }
#logreg-forms .form-signin input[type="text"] {
    margin-bottom: -1px;
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
    
}
#logreg-forms .form-signin input[type="password"] {
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}

#logreg-forms a{
    display: block;
    padding-top:10px;
    color:grey;
}


#logreg-forms input[type="submit"]{ margin-top:10px;  background-color: #4a4747}

#logreg-forms .form-reset, #logreg-forms .form-signup{ display: none; }

#logreg-forms .form-signup input { margin-bottom: 2px;}

/* Mobile */

@media screen and (max-width:500px){
    #logreg-forms{
        width:300px;
    }
    
}

        </style>
    </head>
    <body>
        <div id="logreg-forms">
        
        <form action="control?action=login" method="post">
        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Login</h1>
            <hr/>
		    <%
			  if (!GlobalConstants.MESSAGE.equals("") && GlobalConstants.MESSAGE != null) {
				  out.write("<h3>" + GlobalConstants.MESSAGE + "</h3>");
				  GlobalConstants.MESSAGE = "";
			  }
		    %>
  		    <div class="form-group">
    		  <label for="username">User Name:</label>
    		  <input type="text" class="form-control"  name="username" id="username" placeholder="Username" required="" autofocus=""/>
    		  
            </div>
  		    <div class="form-group">
    		  <label for="pwd">Password:</label>
    		  <input type="password" class="form-control" name="password" id="password" placeholder="Password" required=""  />
   
  		    </div>
  		    <button type="submit" class="btn btn-primary">Login</button>
		  </form>
          
    </div>
    </body>
</html>
