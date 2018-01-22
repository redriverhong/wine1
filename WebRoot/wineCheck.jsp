<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.cyh.domain.*" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>酒品审核</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="shoes store, check out, free template, ecommerce, online shop, website templates, CSS, HTML" />
<meta name="description" content="Shoes Store, Check Out, free ecommerce template provided " />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/style.default.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />


<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/ddsmoothmenu.js"></script>

<script type="text/javascript" src="../js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="../js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="../js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="../js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="../js/custom/general.js"></script>
<script type="text/javascript" src="../js/custom/tables.js"></script>




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
    	<div id="site_title"><h1><a href="http://www.cssmoban.com">Online Shoes Store</a></h1></div>
        <div id="header_right">
        	<p>
	        <a href="#">My Account</a> | <a href="#">My Wishlist</a> | <a href="#">My Cart</a> | <a href="#">Checkout</a> | <a href="#">Log In</a></p>
            <p>
            	Shopping Cart: <strong>3 items</strong> ( <a href="shoppingcart.html">Show Cart</a> )
			</p>
		</div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menubar">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="products.html">Products</a>
                    <ul>
                        <li><a href="http://www.cssmoban.com/">Sub menu 1</a></li>
                        <li><a href="#">Sub menu 2</a></li>
                        <li><a href="#">Sub menu 3</a></li>
                        <li><a href="#">Sub menu 4</a></li>
                        <li><a href="#">Sub menu 5</a></li>
                  </ul>
                </li>
                <li><a href="about.html">About</a>
                    <ul>
                        <li><a href="http://www.cssmoban.com/">Sub menu 1</a></li>
                        <li><a href="#">Sub menu 2</a></li>
                        <li><a href="#">Sub menu 3</a></li>
                  </ul>
                </li>
                <li><a href="faqs.html">FAQs</a></li>
                <li><a href="checkout.html" class="selected">管理员界面</a></li>
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
  
            <div class="header">
    	<ul class="headermenu">
        	
           
            <li><a href="管理员界面.html"><span class="icon icon-message"></span>待办事项</a></li>
			
			 <li><a href="权限管理.html"><span class="icon icon-pencil"></span>权限管理</a></li>
			 
			 <li><a href="用户中心.html"><span class="icon icon-flatscreen"></span>用户中心</a></li>
        </ul>
        
    </div><!--header-->
    
    <div class="vernav2 iconmenu">
    	<ul>
        	<li><a href="#formsub" class="editor">信息处理</a>
            	<span class="arrow"></span>
            	<ul id="formsub">
               		<li><a href="管理员界面.html">发帖审核</a></li>
                    <li><a href="酒品审核.html">酒品审核</a></li>
                </ul>
            </li>
			 <li><a href="信息查询.html" class="tables">信息查询</a></li>
            <!--<li><a href="filemanager.html" class="gallery">File Manager</a></li>-->
        </ul>
        <br /><br />
    </div><!--leftmenu-->
        
    <div class="centercontent tables"><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">                
                <div class="contenttitle2">
                	<h3>发帖审核</h3>
                </div><!--contenttitle-->
                <div class="tableoptions">
                	<button class="deletebutton radius3" title="table2">批量删除</button> &nbsp;
                    <select class="radius3">
                    	<option value="">显示全部</option>
                        <option value="">店家发帖</option>
                        <option value="">用户发帖</option>
                    </select> &nbsp;
                    <button class="radius3">批量通过</button>
                </div><!--tableoptions-->	
                <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
                    <colgroup>
                        <col class="con0" style="width: 4%" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                    </colgroup>
                    <thead>
                        <tr>
                        	<th class="head0"><input type="checkbox" class="checkall" /></th>
                            <th class="head1">发帖名称</th>
                            <th class="head0">发帖人昵称</th>
                            <th class="head1">发帖类别</th>
                            <th class="head0">&nbsp;</th>
                        </tr>
                      <c:forEach items="${uList}" var="cao2"> 
        <tr>
        	<td>${cao2.userId}</td>
  			<td>${cao2.userName}</td>
  			<td>${cao2.password}</td>
  			<td class="center"><a href="" class="edit">查看</a> &nbsp; <a href="" class="edit">通过</a>&nbsp; <a href="" class="delete">删除</a></td>
  		</tr>
        </c:forEach> 
                    </thead>
                    <tbody>
        
     </tbody>
</table>
        </div>
	<div class="dataTables_info" id="dyntable2_info">显示 1 到 10 总共 35 条</div>
	<div class="dataTables_paginate paging_full_numbers" id="dyntable2_paginate"><span class="first paginate_button paginate_button_disabled" id="dyntable2_first">首页</span><span class="previous paginate_button paginate_button_disabled" id="dyntable2_previous">上一页</span><span><span class="paginate_active">1</span><span class="paginate_button">2</span><span class="paginate_button">3</span><span class="paginate_button">4</span></span><span class="next paginate_button" id="dyntable2_next">下一页</span><span class="last paginate_button" id="dyntable2_last">末页</span></div></div>
    <!--/main-->
</div>
 <!-- END of templatemo_main -->
    
    <div id="templatemo_footer">
    	<p><a href="#">Home</a> | <a href="#">Products</a> | <a href="#">About</a> | <a href="#">FAQs</a> | <a href="#">Checkout</a> | <a href="#">Contact Us</a>
		</p>
    	
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->

</body>
</html>