<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/ybootstrap.min.css" />
</head>
<body>
     <!-- Navigation-->    
     <nav class="navbar navbar-expand-lg navbar-light bg-light">
         <div class="container px-4 px-lg-5">
             <a class="navbar-brand" href="/">Movie Zoa</a>   
             <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
             <div class="collapse navbar-collapse" id="navbarSupportedContent">
                 <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                     <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                     <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                     <li class="nav-item dropdown">
                         <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                         <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                             <li><a class="dropdown-item" href="#!">All Products</a></li>
                             <li><hr class="dropdown-divider" /></li>
                             <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                             <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                         </ul>
                     </li>
                 </ul>      
                 <form class="d-flex">
                     <button class="btn btn-outline-dark boxButton" type="button">
                         <i class="bi-cart-fill me-1"></i>
                         Login
                     </button>
                     <button class="btn btn-outline-dark" type="button">
                         <i class="bi-cart-fill me-1"></i>
                         Join in
                     </button>
                     
                 </form>
             </div>
         </div>
     </nav>
       <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                   <c:forEach var="dto" items="${list}">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
	                                    <div class="fw-bolder">
	                                     <h5>${dto.rank} : 위</h5>
								          <h5>${dto.movieNm}</h5>
								          <h5>누적관객수 : ${dto.audiAcc}</h5>
								          <h5>개봉일 : ${dto.openDt}</h5>
	                                    </div>
	                                    <!-- Product price-->
	                                    <!-- $40.00 - $80.00 boxRank-->
                                </div> 
                            </div>  
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/movie/movieDetail?movieNm=${dto.movieNm}&openDt=${dto.openDt}">상세정보</a></div>
                            </div>
                            <div class="MoiveContent ">여기지롱</div>
                        </div>
                    </div>
	               </c:forEach>
                    <%-- ?movieNm=${dto.movieNm}&openDt=${dto.openDt} --%>

                </div>
            </div>
        </section>
     
<button type="button" class="btn btn-secondary">Secondary</button>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <!-- <script src="/js/box.js"></script> -->
</body>
</html> 