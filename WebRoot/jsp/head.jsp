<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shoes Store, free template</title>
<meta name="keywords"
	content="shoes store, free template, ecommerce, online shop, website templates, CSS, HTML" />
<meta name="description"
	content="Shoes Store is a free ecommerce template provided " />
<link href="../templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="../nivo-slider.css" type="text/css"
	media="screen" />

<link rel="stylesheet" type="text/css" href="../css/ddsmoothmenu.css" />

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/my.js"></script>
<script type="text/javascript" src="../js/ddsmoothmenu.js">
	
</script>

<script type="text/javascript">
	ddsmoothmenu.init({
		mainmenuid : "top_nav", //menu DIV id
		orientation : 'h', //Horizontal or vertical menu: Set to "h" or "v"
		classname : 'ddsmoothmenu', //class added to menu's outer DIV
		//customtheme: ["#1c5a80", "#18374a"],
		contentsource : "markup" //"markup" or ["container_id", "path_to_menu_file"]
	})
</script>

</head>
  
  <body>
  <div id="templatemo_body_wrapper">
		<div id="templatemo_wrapper">
   			<div id="templatemo_header">
				<div id="site_title">
					<h1>
						<a href="http://www.cssmoban.com">Online Shoes Store</a>
					</h1>
				</div>
				<div id="header_right">
					<p>
						<a href="#">My Account</a> | <a href="#">My Wishlist</a> | 
						
						<a href="#">	
						My Cart						
						</a> | <a href="#">Checkout</a> |
						 <a href="login.jsp">
						 ${userinfo};
						 if() %>
						 Log In
						 </a>
					</p>
					<p>
						Shopping Cart: <strong>3 items</strong> ( <a
							href="shoppingcart.html">Show Cart</a> )
					</p>
				</div>
				<div class="cleaner"></div>
			</div>
			<!-- END of templatemo_header -->
			</div>
			</div>
  </body>
</html>
