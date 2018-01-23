<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Savory &mdash; Online Order</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="C4G.top Code for Good" />
		<meta name="keywords" content="code for good, c4g" />
		<meta name="author" content="c4g.top" />

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Themify Icons-->
	<link rel="stylesheet" href="css/themify-icons.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">

	<!-- Bootstrap DateTimePicker -->
	<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">



	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

		<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
						   url="jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=utf-8"
						   user="root"  password="root"/>

		<sql:query dataSource="${snapshot}" var="result">
			SELECT * from menu;
		</sql:query>

	</head>
	<body>
		
	<div class="gtco-loader"></div>
	
	<div id="page">

	
	<!-- <div class="page-inner"> -->
	<nav class="gtco-nav" role="navigation">
		<div class="gtco-container">
			
			<div class="row">
				<div class="col-sm-4 col-xs-12">
					<div id="gtco-logo"><a href="index.jsp">Savory <em>.</em></a></div>
				</div>
				<div class="col-xs-8 text-right menu-1">
					<ul>
						<li class="btn-cta"><a href="index.jsp"><span>主页</span></a></li>
					</ul>	
				</div>
			</div>
			
		</div>
	</nav>
	
	<header id="gtco-header" class="gtco-cover gtco-cover-sm" role="banner" style="background-image: url(images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-center">
					

					<div class="row row-mt-15em">
						<div class="col-md-12 mt-text animate-box" data-animate-effect="fadeInUp">
							<span class="intro-text-small">Hand-crafted by <a href="c4g.top" target="_blank">Zachary</a></span>
							<h1 class="cursive-font">Taste all our menu!</h1>	
						</div>
						
					</div>
							
					
				</div>
			</div>
		</div>
	</header>

	
	
	<div class="gtco-section">
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
					<h2 class="cursive-font primary-color">菜单</h2>
				</div>
			</div>
			<div class="row">

				<c:forEach var="row" items="${result.rows}">
				<div class="col-lg-4 col-md-4 col-sm-6">
					<a href="${row.FoodImage}" class="fh5co-card-item image-popup">
						<figure>
							<div class="overlay"><i class="ti-plus"></i></div>
							<img src="${row.FoodImage}" alt="Image" class="img-responsive">
						</figure>
						<div class="fh5co-text">
							<h2><c:out value="${row.FoodName}"/></h2>
							<p><c:out value="${row.FoodDiscript}"/></p>
							<p><span class="price cursive-font">${row.FoodPrice}元</span></p>

						</div>
					</a>
				</div>
				</c:forEach>













			</div>
			<h4>商品列表信息</h4>
			<table width="100%" border="2">
				<tr>
					<td><input type="checkbox" id="all" onclick="allCheck(this)"/>全选</td>
					<td>商品编号</td>
					<td>商品名</td>
					<td>商品价格</td>

				</tr>
				<c:forEach var="pro" items="${result.rows}">
					<tr>
						<td><input type="checkbox" name="prochk" value="${pro.FoodID }"/></td>
						<td>${pro.FoodID }</td>
						<td>${pro.FoodName }</td>
						<td>${pro.FoodPrice }</td>

					</tr>
				</c:forEach>

			</table>
			<br/>

			<div style="float:right;">
				<h5 class="btn btn-primary btn-block" onclick="addPro()">加入购物车</h5>
				<a href ="services.jsp" class="btn btn-primary btn-block" >跳转到购物车</a>
			</div>
		</div>
	</div>

	<div class="gtco-cover gtco-cover-sm" style="background-image: url(images/img_bg_1.jpg)"  data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container text-center">
			<div class="display-t">
				<div class="display-tc">
					<h1>&ldquo; Their high quality of service makes me back over and over again!&rdquo;</h1>
					<p>&mdash; Justice Young, Pres of WHUT </p>
				</div>	
			</div>
		</div>
	</div>



	<footer id="gtco-footer" role="contentinfo" style="background-image: url(images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row row-pb-md">




				<div class="col-md-12 text-center">
					<div class="gtco-widget">
						<h3>联系我们</h3>
						<ul class="gtco-quick-contact">
							<li><a href="#"><i class="icon-phone"></i> +1 234 567 890</a></li>
							<li><a href="#"><i class="icon-mail2"></i> info@GetMenu.co</a></li>
							<li><a href="#"><i class="icon-chat"></i> Live Chat</a></li>
						</ul>
					</div>
					<div class="gtco-widget">
						<h3>社交媒体</h3>
						<ul class="gtco-social-icons">
							<li><a href="#"><i class="icon-twitter"></i></a></li>
							<li><a href="#"><i class="icon-facebook"></i></a></li>
							<li><a href="#"><i class="icon-linkedin"></i></a></li>
							<li><a href="#"><i class="icon-dribbble"></i></a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-12 text-center copyright">
					<p><small class="block">&copy; 2017 C4G Code for Good. All Rights Reserved.</small>
						<small class="block">More Details <a href="http://www.c4g.top/" target="_blank" title="C4G">C4G</a> - Collect from <a href="http://www.c4g.top/" title="Code for Good" target="_blank">Code for Good</a></small></p>
				</div>

			</div>

			

		</div>
	</footer>
	<!-- </div> -->

	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	<script>
        var xhr = null;

        function createXhr(){
            if(window.XMLHttpRequest){
                xhr = new XMLHttpRequest();
            }else{
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }

        function addPro() {
            //获取需要加入购物车商品编号
            var ids = "";
            var prochk = document.getElementsByName("prochk");
            for (var i = 0; i < prochk.length; i++) {
                if (prochk[i].checked) {
                    ids += prochk[i].value + ",";
                }
            }
            //连接后台，将商品编号，发送到后台
            createXhr();
            //打开连接
            xhr.open("post", "ProServlet", true);
            //设置post请求的请求头
            xhr.setRequestHeader("content-type",
                "application/x-www-form-urlencoded");
            //传送参数
            var data = "type=add&ids="+ids;
            xhr.send(data);
            xhr.onreadystatechange=function(){
                //判断服务器是否响应成功！
                if(xhr.readyState==4&&xhr.status==200){
                    if(xhr.responseText=="ok"){
                        alert("添加成功！");
                    }else{
                        alert("添加失败！");
                    }
                }
            }
        }

        function allCheck(obj) {
            var checkBoxList = document.getElementsByName("prochk");
            if (obj.checked == true) {
                for (var i = 0; i < checkBoxList.length; i++) {
                    checkBoxList[i].checked = true;
                }
            } else {
                for (var i = 0; i < checkBoxList.length; i++) {
                    checkBoxList[i].checked = false;
                }
            }
        }
	</script>
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>

	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>

	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	
	<script src="js/moment.min.js"></script>
	<script src="js/bootstrap-datetimepicker.min.js"></script>


	<!-- Main -->
	<script src="js/main.js"></script>

	</body>
</html>

