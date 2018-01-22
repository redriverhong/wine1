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
						 Log In						
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
			</div><!-- END of templatemo_header -->
    
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
        
        
        	<h2>订单</h2>
            <h5><strong>-------收件信息填写-------</strong></h5>
            
            <form action="sureinfo.do?orderid=${orderq.orderId }" method="post">
            <c:if test="${sessionScope.userinfo != null}">
            <c:if test="${orderq.payorno==0 }">
				收件名： (必须真实有效):<br />  
                  <input type="text" name="uname" value="${orderq.uname}" style="width:300px;"  />
                <br />
         	           收件地址:(详细至街道门号)<br />
				<input type="text" name="address" value="${orderq.address}" style="width:300px;"  />
                <br />
                                                邮编:<br />
				<input type="text" name="youbian" value="${orderq.youbian}" style="width:300px;"  />
                <br />
            
            	联系电话：<br />
				<input type="text" name="phone" value="${orderq.phone}" style="width:300px;"  />
                <br />
            
            <br />
            
            <input type="submit" value="确认信息" style="width:100px" />
            </c:if>
            
            <c:if test="${orderq.payorno==1 }">
				收件名： (必须真实有效):<br />  
                  <input type="text" name="uname" readonly="readonly" value="${orderq.uname}" style="width:300px;"  />
                <br />
         	           收件地址:(详细至街道门号)<br />
				<input type="text" name="address" readonly="readonly" value="${orderq.address}" style="width:300px;"  />
                <br />
                                                邮编:<br />
				<input type="text" name="youbian" readonly="readonly" value="${orderq.youbian}" style="width:300px;"  />
                <br />
            
            	联系电话：<br />
				<input type="text" name="phone" readonly="readonly" value="${orderq.phone}" style="width:300px;"  />
                <br />
            
            <br />
            
            </c:if>
            
             </c:if>
            </form>
            
            <div class="cleaner h30"></div>
            <h3>商品清单</h3>
			<table width="680px" cellspacing="0" cellpadding="5">
                   	  <tr bgcolor="#ddd">
                        	<th width="100" align="left">名称 </th> 
                       	  	<th width="100" align="center">数量 </th> 
                        	<th width="60" align="right">价格 </th> 
                        	<th width="60" align="right">合计 </th> 
                        	<th width="90"> </th>
                            
                      </tr>
                      <c:forEach items="${orderinfo }" var="of">
                      <tr>
                    		<c:set var="count" value="${of.wine.winePrice*of.orderCount }"></c:set>
                    		<c:set var="allcount" value="${count+allcount}"></c:set>
                        	<td><a href="showDetail.do?id=${of.wine.wineId }">${of.wine.wineName}</a></td> 
                            <td align="center">
                            <span>${of.orderCount}</span>
                            </td>
                            <td align="right"><span id="wineprice">${of.wine.winePrice} </span></td> 
                            <td align="right"><span>${count }</span></td>
                            
                           
						</tr>
                  
                        </c:forEach>
					</table>
					<div style="float:right; width: 215px; margin-top: 20px;">
					<h4><strong>总价：${allcount}</strong></h4>
					<c:if test="${orderq.payorno==0 }">
					<p><span>我的余额：${orderq.user.balance}</span></p>
					<p><a href="checkout.do?orderid=${orderq.orderId }&&userid=${orderq.user.userId}" onclick="suretopay();">支付</a></p>
                    <p><a href="javascript:history.back()">取消</a></p>
                    </c:if>	
                    </div>
        </div> 
        
        
        <div class="cleaner"></div>
    </div> 
       <!-- END of templatemo_main -->
    
    <div id="templatemo_footer">
    	<p><a href="#">Home</a> | <a href="#">Products</a> | <a href="#">About</a> | <a href="#">FAQs</a> | <a href="#">Checkout</a> | <a href="#">Contact Us</a>
		</p>

		Copyright Â© 2072 <a href="#">Your Company Name</a> | Collect from <a href="http://www.cssmoban.com" target="_parent">ç½ç«æ¨¡æ¿</a>
    	
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->

</body>
</html>