<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shoes Store - Shopping Cart</title>
<meta name="keywords" content="shoes store, shopping cart, free template, ecommerce, online shop, website templates, CSS, HTML" />
<meta name="description" content="Shoes Store, Shopping Cart, online store template " />

<link href="../templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="../css/ddsmoothmenu.css" />

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="../js/my.js"></script>
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
			</div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menubar">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="homepage.jsp" class="selected">首页</a></li>
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
            <form action="#" method="get">
              <input type="text" value=" " name="keyword" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
              <input type="submit" name="Search" value=" " alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
            </form>
        </div>
    </div> <!-- END of templatemo_menubar -->
    
    <div id="templatemo_main">
    	<div id="sidebar" class="float_l">
        	<div class="sidebar_box"><span class="bottom"></span>
            	<h3>菜单</h3>
						<div class="content">
							<ul class="sidebar_list">
								<li class="first" id="baijiu" ><a href="showuser.do">个人信息</a>
								</li>
								<li id="yangjiu" ><a href="showCart.do?id=${sessionScope.userinfo.userId }">我的购物车</a>
								</li>
								<li id="hongjiu" ><a href="showallorders.do?userid=${sessionScope.userinfo.userId }">我的订单</a>
								</li>
								<li id="putaojiu" ><a href="showcollect.do?userid=${sessionScope.userinfo.userId }">我的收藏</a>
								</li>
								<li id="pijiu" ><a href="showevalute.do?userid=${sessionScope.userinfo.userId }">待评论</a>
								</li>
								<li id="yangshengjiu" ><a href="">其他</a>
								</li>
								<li id="qita" ><a href="">其他</a>
								</li>
							</ul>
						</div>
            </div>
            
        </div>
        
        
        <div id="content" class="float_r">
        	<h2>购物车</h2>
        	
        	<table width="700px" cellspacing="0" cellpadding="5">
                   	  <tr bgcolor="#ddd">
                        	<th width="120" align="left">图片 </th> 
                        	<th width="150" align="left">名称 </th> 
                        	<th width="100" align="left">库存 </th> 
                       	  	<th width="100" align="center">数量 </th> 
                        	<th width="60" align="right">价格 </th> 
                        	<th width="60" align="right">合计 </th> 
                        	<th width="80"> </th>
                            
                      </tr>
                      
                     <c:forEach items="${shoppinglist }" var="cart">
                         
                    	<tr>
                    	    
                    		<c:set var="count" value="${cart.wine.winePrice*cart.cartCount}"></c:set>
                    		<c:set var="allcount" value="${count+allcount}"></c:set>
                    		<c:set var="userId" value="${cart.user.userId }"></c:set>
                    		
                        	<td><a href="showDetail.do?id=${cart.wine.wineId }"><img src="../images/image/${cart.wine.winePhoto }" alt="image 1" style="width:80px;height: 80px"/></a></td> 
                        	<td><a href="showDetail.do?id=${cart.wine.wineId }">${cart.wine.wineName }</a></td> 
                        	<td><span id="winecount">${cart.wine.wineCount }</span></a></td>
                            <td align="center">
                           <form action="updatecart.do?cartid=${cart.cartId }&&id=${cart.user.userId}" method="post">
                            <input type="text" id="cartcount" name="cartcount" value="${cart.cartCount}" onkeypress="onlyNumber();" onchange="checkcount(this);" style="width: 20px; text-align: right" /> 
                          
                            </td>
                            
                            <td align="right"><span id="wineprice">${cart.wine.winePrice } </span></td> 
                            <td align="right"><span>${count }</span></td>
                            <td align="center"> <input type="submit" value="修改数量"/> </td>
                            </form>
                            <td align="center"> <a href="deletewine.do?cartid=${cart.cartId }&&id=${cart.user.userId}"><img src="../images/trash.png" alt="remove" /><br />Remove</a> </td>
                           
						</tr>
						
					</c:forEach>
                        
					</table>
					
                    <div style="float:right; width: 215px; margin-top: 20px;">
                    <p><h3>总价：${allcount}</h3></p>
					<p><a href="order.do?userid=${userId }">下订单</a></p>
                    <p><a href="javascript:history.back()">继续购物</a></p>
                    	
                    </div>
			</div>
			
			
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <div id="templatemo_footer">
    	<p><a href="#">Home</a> | <a href="#">Products</a> | <a href="#">About</a> | <a href="#">FAQs</a> | <a href="#">Checkout</a> | <a href="#">Contact Us</a>
		</p>

		Copyright Â© 2072 <a href="#">Your Company Name</a> | Collect from <a href="http://www.cssmoban.com" target="_parent">ç½ç«æ¨¡æ¿</a>
    	
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->

</body>
</html>