<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'wines.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="../css/ddsmoothmenu.css" type="text/css"></link>
  <link rel="stylesheet" href="../templatemo_style.css" type="text/css"></link>
  <script type="text/javascript" src="../js/jquery.min.js"></script>
  <script type="text/javascript" src="../js/ddsmoothmenu.js"></script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
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
						 Log In						
						 </a>
						</c:if>
						
						
						<c:if test="${sessionScope.userinfo != null}">
						<a href="user.jsp">个人中心</a> | 
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
						Shopping Cart: <strong>0 items</strong> (  
						
						 <a href="login.jsp?">
						 Show Cart					
						 </a>
						</c:if>
						<c:if test="${sessionScope.userinfo != null}">
						Shopping Cart: <strong>items</strong> (  
						  <a href="showCart.do?id=${sessionScope.userinfo.userId}">Show Cart</a>
							
						</c:if>)
					</p>
				</div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menubar">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="homepage.jsp">首页</a></li>
                <li><a href="showwines.do?winetype=wineall">酒品</a>
                   
                </li>
                <li><a href="about.html">About</a>
                    <ul>
                        <li><a href="http://www.cssmoban.com/">Sub menu 1</a></li>
                        <li><a href="#">Sub menu 2</a></li>
                        <li><a href="#">Sub menu 3</a></li>
                  </ul>
                </li>
                <li><a href="faqs.html">FAQs</a></li>
                <li><a href="checkout.html">Checkout</a></li>
                <li><a href="contact.html">Contact Us</a></li>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of ddsmoothmenu -->
        <div id="templatemo_search">
            <form action="search.do" method="get">
              <input type="text" value=" " name="keyword" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
              <input type="submit" name="Search" value=" " alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
            </form>
        </div>
    </div> <!-- END of templatemo_menubar -->
    
    <div id="templatemo_main">
    	<div id="sidebar" class="float_l">
        	<div class="sidebar_box"><span class="bottom"></span>
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
            <div class="sidebar_box"><span class="bottom"></span>
            	<h3>Bestsellers </h3>   
                <div class="content"> 
                	<div class="bs_box">
                    	<a href="#"><img src="../images/templatemo_image_01.jpg" alt="image" /></a>
                        <h4><a href="#">Donec nunc nisl</a></h4>
                        <p class="price">$10</p>
                        <div class="cleaner"></div>
                    </div>
                    <div class="bs_box">
                    	<a href="#"><img src="../images/templatemo_image_01.jpg" alt="image" /></a>
                        <h4><a href="#">Lorem ipsum dolor sit</a></h4>
                        <p class="price">$12</p>
                        <div class="cleaner"></div>
                    </div>
                    <div class="bs_box">
                    	<a href="#"><img src="../images/templatemo_image_01.jpg" alt="image" /></a>
                        <h4><a href="#">Phasellus ut dui</a></h4>
                        <p class="price">$20</p>
                        <div class="cleaner"></div>
                    </div>
                    <div class="bs_box">
                    	<a href="#"><img src="../images/templatemo_image_01.jpg" alt="image" /></a>
                        <h4><a href="#">Vestibulum ante</a></h4>
                        <p class="price">$8</p>
                        <div class="cleaner"></div>
                    </div>
                </div>
            </div>
        </div>
        
        
        <div id="content" class="float_r">
        	<h2>${wineinfo1.wineType }</h2>
        	
        	
        	<table>
						<tr>
							<c:forEach items="${wineinfo}" var="wine" varStatus="w">
							<c:set var="count" value="${w.count }"></c:set>
							<td>
						
							<div class="product_box">
						<a href="showDetail.do?id=${wine.wineId }"><img
							src="../images/image/${wine.winePhoto }" style="width:150px;height:150px" alt="一杯浓酒
							              消一身愁" />
						</a>
						<h3>${wine.wineName}</h3>
						<p class="product_price">￥：${wine.winePrice}</p>
						<a href="addtocart.do?id=${wine.wineId }&&cartCount=1" class="addtocart">加入购物车</a>
						<a href="showDetail.do?id=${wine.wineId }" class="detail">详细信息</a>
							</div>
							</td> 
							
							<c:if test="${w.count%3==0 }"></tr><tr> </c:if>
							</c:forEach>
						</tr>
						<c:if test="${count==null }"><h2>抱歉，该酒品已售完，请浏览其他酒品！</h2></c:if>
					</table>
                  	
            
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <div id="templatemo_footer">
    	<p><a href="#">Home</a> | <a href="#">Products</a> | <a href="#">About</a> | <a href="#">FAQs</a> | <a href="#">Checkout</a> | <a href="#">Contact Us</a>
		</p>


    	Copyright © 2072 <a href="#">Your Company Name</a> | Collect from <a href="http://www.cssmoban.com" target="_parent">网站模板</a>
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->

</body>
</html>
