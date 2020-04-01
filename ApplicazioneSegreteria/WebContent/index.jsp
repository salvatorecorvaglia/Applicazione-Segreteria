<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.unisalento.business.core.model.Persona"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

<meta name="Description" content="Information architecture, Web Design, Web Standards." />
<meta name="Keywords" content="your, keywords" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="Distribution" content="Global" />
<meta name="Author" content="Erwin Aligam - ealigam@gmail.com" />
<meta name="Robots" content="index,follow" />

<link rel="stylesheet" href="images/Outdoor.css" type="text/css" />

<title>Outdoor</title>

</head>
<body>

<!-- wrap starts here -->
<div id="wrap">

	<!--header -->
	<div id="header">			
				
		<h1 id="logo-text"><a href="index.html" title="">outdoor</a></h1>		
		<p id="slogan">put your site slogan here...</p>		
			
		<div id="header-links">
			<p>
			<a href="index.html">Home</a> | 
			<a href="index.html">Contact</a> | 
			<a href="index.html">Site Map</a>			
			</p>		
		</div>				
		
	<!--header ends-->					
	</div>
	
	<div id="header-photo"><img src="images/header-photo.jpg" width="870" height="206" alt="header-photo" /></div>	
	
	<!-- navigation starts-->	
	<div  id="nav">
		<ul>
			<li id="current"><a href="index.html">Home</a></li>
			<li><a href="index.html">Archives</a></li>
			<li><a href="index.html">Downloads</a></li>
			<li><a href="index.html">Services</a></li>
			<li><a href="index.html">Support</a></li>
			<li><a href="index.html">About</a></li>		
		</ul>
	<!-- navigation ends-->	
	</div>					
			
	<!-- content-wrap starts -->
	<div id="content-wrap">
				
		<div id="main">
				
			
								
			<h3>Ciao, effettua il login</h3>
			
			<%
			
			String error=request.getParameter("error");
			
			if(error!=null) {

				if(error.equals("0"))
					out.println("<font color='red'>Username e password non validi!!</font>");
				else if(error.equals("1"))
					out.println("<font color='red'>Non hai accesso alla risorsa!!</font>");
			}
			
			else {
				Persona p;
				if(session.getAttribute("impiegato") != null) {
					p=(Persona)session.getAttribute("impiegato");

					out.println("<font color='blue'>Caro " +p.getNome()+" "+p.getCognome()+" ti sei già loggato!!</font>");
				}
					
			}
			%>
			
			
			<form action="impiegato_loggato.jsp" method="post">			
			<p>			
			<label>Name</label>
			<input name="usernameTxt" value="Your username" type="text" size="30" />
			<label>Password</label>
			<input name="passwordTxt" value="Your password" type="password" size="30" />
			
			<br />	
			<br />	
			<input class="button" type="submit" />		
			</p>		
			</form>				
			<br />	

		<!-- main ends -->	
		</div>
		
		<div id="sidebar">
			
			<h3>Search Box</h3>	
			<form action="#" class="searchform">
				<p>
				<input name="search_query" class="textbox" type="text" />
  				<input name="search" class="button" value="Search" type="submit" />
				</p>			
			</form>	
					
			
						
		<!-- sidebar ends -->		
		</div>
		
	<!-- content-wrap ends-->	
	</div>
		
	<!-- footer starts -->		
	<div id="footer-wrap">
	
		<div id="footer-columns">
	
			<div class="col3">
				<h3>Tincidunt</h3>
				<ul>
					<li><a href="index.html">consequat molestie</a></li>
					<li><a href="index.html">sem justo</a></li>
					<li><a href="index.html">semper</a></li>
					<li><a href="index.html">magna sed purus</a></li>
					<li><a href="index.html">tincidunt</a></li>
				</ul>
			</div>

			<div class="col3-center">
				<h3>Sed purus</h3>
				<ul>
					<li><a href="index.html">consequat molestie</a></li>
					<li><a href="index.html">sem justo</a></li>
					<li><a href="index.html">semper</a></li>
					<li><a href="index.html">magna sed purus</a></li>
					<li><a href="index.html">tincidunt</a></li>
				</ul>
			</div>

			<div class="col3">
				<h3>Praesent</h3>
				<ul>
					<li><a href="index.html">consequat molestie</a></li>
					<li><a href="index.html">sem justo</a></li>
					<li><a href="index.html">semper</a></li>
					<li><a href="index.html">magna sed purus</a></li>
					<li><a href="index.html">tincidunt</a></li>					
				</ul>
			</div>
		<!-- footer-columns ends -->
		</div>	
		
		<div id="footer-bottom">		
			
			<p>
			&copy; 2006 <strong>Your Company</strong> | 
			Design by: <a href="http://www.styleshout.com/">styleshout</a> | 
			Valid <a href="http://validator.w3.org/check?uri=referer">XHTML</a> | 
			<a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a>
			
   		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<a href="index.html">Home</a>&nbsp;|&nbsp;
   		<a href="index.html">Sitemap</a>&nbsp;|&nbsp;
	   	<a href="index.html">RSS Feed</a>
   		</p>		
			
		</div>
		
<!-- footer ends-->
</div>

<!-- wrap ends here -->
</div>

</body>
</html>
