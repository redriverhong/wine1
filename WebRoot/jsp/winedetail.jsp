<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% session.setAttribute("path","jsp/winedetail"); %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
    <title>My JSP 'winedetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="../templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="../css/ddsmoothmenu.css" />

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/ddsmoothmenu.js">



</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>

<script type="text/javascript" src="../js/jquery-1-4-2.min.js"></script> 
<link rel="stylesheet" href="../css/slimbox2.css" type="text/css" media="screen" /> 
<script type="text/JavaScript" src="../js/slimbox2.js"></script> 
<script type="text/JavaScript" src="../js/my.js"></script> 


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
						<a href="showuser.do">个人中心</a> | 
						<a href="login.jsp">我的收藏</a> | 
						
						<a href="login.jsp">	
						我的购物车						
						</a> | 
						
						 <a href="login.jsp">
						  登录，注册						
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
            <form action="#" method="get">
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
        	<h1>${winedetail.wineName }</h1>
            <div class="content_half float_l">
        	<a  rel="lightbox[portfolio]" href="../images/image/${winedetail.winePhoto }">
        	<img src="../images/image/${winedetail.winePhoto }" style="width:300px;heigth:300px" alt="image" /></a>
            </div>
            
            <form id="form" action="addtocart.do?id=${winedetail.wineId }" method="post">
            <div class="content_half float_r">
                <table>
                    <tr>
                        <td width="160">价格:</td>
                        <td>${winedetail.winePrice }</td>
                    </tr>
                    <tr>
                        <td>产地:</td>
                        <td>${winedetail.origin }</td>
                    </tr>
                    <tr>
                        <td>净容量:</td>
                        <td>${winedetail.wineCapacity}</td>
                    </tr>
                    <tr>
                        <td>类别:</td>
                        <td>${winedetail.wineType }</td>
                    </tr>
                    <tr>
                    	<td>库存：</td>
                        <td><span id="kucun">
                        ${winedetail.wineCount }</span>件</td>
                    </tr>
                     <tr>
                    	<td>数量：</td>
                    	
                          <td>
                         	<a href="javascript:void(0)" id="num_del" onClick="num_del()" style="text-decoration: none"><input type="button" value="-" style="border:solid 0.5px;"/></a>
                         	<input type="text" value="1" name="cartCount" id="addnum" onchange="checknum(this)" style="ime-mode:disabled;width:30px"/>
                         	<a href="javascript:void(0)" id="num_add" onClick="num_add()" style="text-decoration: none"><input type="button" value="+" style="border:solid 0.5px;"/></a>                      	
                         	件</td>
                       
                    </tr>
                   
                   </table>
                   <div style="font-size: 15px">
                   	<span style="float: left; ">酒品介绍：</span>
                   	<p>${winedetail.wineIntroduce }</p>
                   </div>
                <div class="cleaner h20"></div>
				<c:if test="${sessionScope.userinfo==null }">
				<a href="login.jsp" class="addtocart"></a>
				<a href="login.jsp" class="addtocart"></a>
				</c:if>
               <c:if test="${sessionScope.userinfo!=null }">
				<a href="javascript:;" onclick="buttonSubmit('addtocart.do?id=${winedetail.wineId }')" class="addtocart">加入购物车</a>
				<a href="collect.do?wineid=${winedetail.wineId }" class="addtocart">收藏</a>
				</c:if>
                

			</div>
			</form>
            <div class="cleaner h30"></div>
            <div style="width:720px; height:inherit; background:">
             <h5>酒品评价（<span style="color:red;">${evalutetimes }</span> 次评价）：</h5>
           
       			
           	 	<table style="float:left;width:730px;height:50px;">
           	 	<c:forEach items="${evaluteinfo }" var="ef" varStatus="count">
           	 	<tr style="border-bottom: 1px solid red;"><td>
            		<textarea rows="1" cols="60" readonly="readonly" style="float:left;font-size: 15px;text-align:left;background-color:;">${ef.evalute }
            		</textarea>
            		<p style="float:right;width:200px;height:25px;margin-top:25px;margin-left:10px;font-style: oblique;">
            		<a>${ef.user.userName }</a>
            		<span style="margin-left:20px">${ef.date }</span>
            		</p>
            		</td>
            		</tr>
            		
            		</c:forEach>
            	
           	 	</table>
        		
            
            </div>
             
          <div class="cleaner h50"></div>
            
            <h3>相关推荐</h3>
        	<div class="product_box">
        		<table>
        			<tr>
							<c:forEach items="${recommendwine }" var="rwine" begin="0" end="2"  varStatus="rw">
							<td>
							
							<div class="product_box">
						
						<a href="showDetail.do?id=${rwine.wineId }"><img
							src="../images/image/${rwine.winePhoto }" style="width:150px;height:150px" alt="好久才能消愁" />
						</a>
						<h3>${rwine.wineName}</h3>
						<p class="product_price">￥：${rwine.winePrice}</p>
						<a href="addtocart.do?id=${rwine.wineId }&&cartCount=1" class="addtocart">加入购物车</a>
						<a href="showDetail.do?id=${rwine.wineId }" class="detail">详细信息</a>
							</div>
							</td> 
						
							</c:forEach>
						</tr>
        		</table>
            </div>        	
            
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
