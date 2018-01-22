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
						<a href="">在线酒品商城</a>
					</h1>
				</div>
				<div id="header_right">
					<p>
					<c:if test="${sessionScope.userinfo == null}">
						<a href="login.jsp">个人中心</a> | 
						<a href="login.jsp">我的收藏</a> | 
						
						<a href="login.jsp">	
						我的购物车						
						</a> | 
						
						 <a href="login.jsp">
						 登录，注册					
						 </a>
						</c:if>
						
						
						<c:if test="${sessionScope.userinfo != null}">
						<a href="showuser.do">个人中心</a> | 
						<a href="showcollect.do?userid=${sessionScope.userinfo.userId }">我的收藏</a> | 
						
						<a href="showCart.do?id=${sessionScope.userinfo.userId }">	
						我的购物车						
						</a> | 								
						 <a href="showuser.do">
						 hello!${sessionScope.userinfo.userName}					
						 </a>
						 <a href="logout.do">退出</a>
						</c:if>
					</p>
					<p>
					<c:if test="${sessionScope.userinfo == null}">
						Shopping Cart: <strong>0 件</strong> (  
						
						 <a href="login.jsp?">
						 购物车					
						 </a>
						</c:if>
						<c:if test="${sessionScope.userinfo != null}">
						Shopping Cart: <strong>items</strong> (  
						  <a href="showCart.do?id=${sessionScope.userinfo.userId}">Show Cart</a>
							
						</c:if>)
					</p>
				</div>
				<div class="cleaner"></div>
			</div>
			<!-- END of templatemo_header -->

			<div id="templatemo_menubar">
				<div id="top_nav" class="ddsmoothmenu">
					<ul>
						<li><a href="homepage.jsp" class="selected">首页</a>
						</li>
						<li>
						<a href="showwines.do?winetype=wineall">酒品</a>
							</li>
						<li><a href="about.html">About</a>
							<ul>
								<li><a href="http://www.cssmoban.com/">Sub menu 1</a>
								</li>
								<li><a href="#">Sub menu 2</a>
								</li>
								<li><a href="#">Sub menu 3</a>
								</li>
							</ul></li>
						<li><a href="faqs.html">FAQs</a>
						</li>
						<li><a href="checkout.html">Checkout</a>
						</li>
						<li><a href="contact.html">Contact Us</a>
						</li>
					</ul>
					<br style="clear: left" />
				</div>
				<!-- end of ddsmoothmenu -->
				<div id="templatemo_search">
					<form action="search.do" method="post">
						<input type="text" value="" name="keyword" id="keyword"
							title="keyword" onfocus="clearText(this)"
							onblur="clearText(this)" class="txt_field" />
							 <input type="submit" name="Search" value=" " alt="Search"
							id="searchbutton" title="Search" class="sub_btn" />
					</form>
				</div>
			</div>
			<!-- END of templatemo_menubar -->
			<div class="copyrights">
				Collect from <a href="" title="网页模板"></a>
			</div>

			<div id="templatemo_main">
				<div id="sidebar" class="float_l">
					<div class="sidebar_box">
						<span class="bottom"></span>
						<h3>酒品分类</h3>
						<div class="content">
							<ul class="sidebar_list">
								<li class="first" id="baijiu" ><a href="showwines.do?winetype=白酒">白酒</a>
								</li>
								<li id="yangjiu" ><a href="showwines.do?winetype=洋酒">洋酒</a>
								</li>
								<li id="hongjiu" ><a href="showwines.do?winetype=红酒">红酒</a>
								</li>
								<li id="putaojiu" ><a href="showwines.do?winetype=葡萄酒">葡萄酒</a>
								</li>
								<li id="pijiu" ><a href="showwines.do?winetype=啤酒">啤酒</a>
								</li>
								<li id="yangshengjiu" ><a href="showwines.do?winetype=养生酒">养生酒</a>
								</li>
								<li id="qita" ><a href="showwines.do?winetype=null">其他</a>
								</li>

							</ul>
						</div>

						
					</div>
					<div class="sidebar_box">
						<span class="bottom"></span>
						<h3>Bestsellers</h3>
						<div class="content">
							<div class="bs_box">
								<a href="#"><img src="../images/templatemo_image_01.jpg"
									alt="image" />
								</a>
								<h4>
									<a href="#">Donec nunc nisl</a>
								</h4>
								<p class="price">$10</p>
								<div class="cleaner"></div>
							</div>
							<div class="bs_box">
								<a href="#"><img src="../images/templatemo_image_01.jpg"
									alt="image" />
								</a>
								<h4>
									<a href="#">Lorem ipsum dolor sit</a>
								</h4>
								<p class="price">$12</p>
								<div class="cleaner"></div>
							</div>
							<div class="bs_box">
								<a href="#"><img src="../images/templatemo_image_01.jpg"
									alt="image" />
								</a>
								<h4>
									<a href="#">Phasellus ut dui</a>
								</h4>
								<p class="price">$20</p>
								<div class="cleaner"></div>
							</div>
							<div class="bs_box">
								<a href="#"><img src="../images/templatemo_image_01.jpg"
									alt="image" />
								</a>
								<h4>
									<a href="#">Vestibulum ante</a>
								</h4>
								<p class="price">$8</p>
								<div class="cleaner"></div>
							</div>
						</div>
					</div>
				</div>
				<div id="content" class="float_r">
					<div id="slider-wrapper">
						<div id="slider" class="nivoSlider">
							<img src="../images/slider/02.jpg" alt="" style="width: 300px;height: 300px"/> <a href="#"><img
								src="../images/slider/01.jpg" alt="" style="width: 300px;height: 300px"
								title="This is an example of a caption" />
							</a> <img src="../images/slider/03.jpg" alt="" style="width: 300px;height: 300px; background-image:inherit;" /> <img
								src="../images/slider/04.jpg" alt="" title="#htmlcaption" style="width: 300px;height: 300px" />
						</div>
						<div id="htmlcaption" class="nivo-html-caption">
							<strong>This</strong> is an example of a <em>HTML</em> caption
							with <a href="#">a link</a>.
						</div>
					</div>
					<script type="text/javascript" src="../js/jquery-1.4.3.min.js"></script>
					<script type="text/javascript" src="../js/jquery.nivo.slider.pack.js"></script>
					<script type="text/javascript">
						$(window).load(function() {
							$('#slider').nivoSlider();
						});
					</script>
					<h1>热销酒品</h1>
					<table>
						<tr>
							<c:forEach items="${list}" var="list" varStatus="l">
							<td>
							
							<div class="product_box">
						
						<a href="productdetail.html"><img
							src="${list. }" alt="女儿红" />
						</a>
						<h3>${list.WineName}</h3>
						<p class="product_price">${list.price}</p>
						<a href="shoppingcart.html" class="addtocart">加入购物车</a>
						<a href="productdetail.html" class="detail">详细信息</a>
							</div>
							</td> 
							</c:forEach>
							<c:if test="${l.count%3==0 }"></tr><tr> </c:if>
						</tr>
					</table>
					<!--  -->
					<div class="product_box">
						
						<a href=""><img
							src="../images/image/maotai1.jpg" alt="女儿红" width="120px" height="120px"; />
						</a>
						<h3>女儿红</h3>
						<p class="product_price">$ 666</p>
						<a href="" class="addtocart">加入购物车</a>
						 <a	href="" class="detail">详细信息</a>
					</div>
					
					
				</div>
				<div class="cleaner"></div>
			</div>
			<!-- END of templatemo_main -->

			<div id="templatemo_footer">
				<p>
					<a href="#">Home</a> | <a href="#">Products</a> | <a href="#">About</a>
					| <a href="#">FAQs</a> | <a href="#">Checkout</a> | <a href="#">Contact
						Us</a>
				</p>

				Copyright © 2072 <a href="#">Your Company Name</a> | Collect from <a
					href="http://www.cssmoban.com" target="_parent">网站模板</a>
			</div>
			<!-- END of templatemo_footer -->

		</div>
		<!-- END of templatemo_wrapper -->
	</div>
	<!-- END of templatemo_body_wrapper -->

</body>
</html>