<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
<!-- /Added by HTTrack -->
<head>
    <title>Sobrus Pharma</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta name="robots" content="noindex, nofollow">
    <meta name="description" content="Sobrus Pharma">
    <meta name="keywords" content="Sobrus, Pharma">

    <link href="<c:url value="/assets/img/favicon.ico" />" rel="shortcut icon" type="image/x-icon">
    <link href="<c:url value="/assets/css/login.css" />" media="screen" rel="stylesheet" type="text/css">
    <script src="<c:url value="/assets/vendor/jquery/jquery.min.js" />"></script>
    <script>
        $(document).ready(function () {
            if ($("header").length) { // make sure there is no menu
                window.location = window.location;
            }

            // login container placement
            var login_height = $('.login_container').height() / 2;
            $('.login_container').css({top: -login_height});
        });

        function badBrowser() {
            if ($.browser.msie) {
                return true;
            }

            if ($.browser.opera && ($.browser.version * 10) <= 100) {
                return true;
            }

            if (/Firefox[\/\s](\d+\.\d+)/.test(navigator.userAgent)) {
                var ffversion = new Number(RegExp.$1)
                if (ffversion <= 4) {
                    return true;
                }
            }

            return false;
        }

        var bad_browser = badBrowser();
        if (bad_browser && window.location.pathname != '/upgrade') {
            window.location = 'https://ma.pharma.sobrus.com/upgrade';
        }


    </script>
</head>
<body>
<div class="login_wrraper">
    <div class="logo-wrapper">
        <a href="#" class="logo"><img src="assets/img/sobrus-logo.jpg" alt=""></a>
        <p class="logo-slogan">Le logiciel de pharmacie <br>qu'il vous faut !</p>
    </div>

    <div class="login-top-info">
        <div class="lti-tel">
            <i class="login-tel"></i>
            05 30 500 500
        </div>

        <div class="lti-assistance">
            <span><i class="dash-head"></i> Support </span>
        </div>
    </div>
    <div class="login-bottom-info">
        <a href="http://pharma.sobrus.com/" class="lbi-bloc" target="_blank">
            <i class="world"></i>
            pharma.sobrus.com
        </a>
        <div class="lbi-bloc">
            <i class="small-envelope"></i>
            support@sobrus.com
        </div>
    </div>
    <c:url var="loginUrl" value="/login.htm"/>

    <div class="login_bg">
        <div class="login_container">
            <div class="login_ct">
                <div class="login">
                    <p class="login_head"><strong>Sobrus</strong> Pharma</p>
                    <c:if test="${not empty error}">
                        <h5 class="text-center"
                            style="border-bottom-color: red; color: red">Wrong Username
                            OR Password</h5>
                    </c:if>
                    <form:form cssClass="m-t-md ajax-form-login login_form" action="${loginUrl}"
                               id="connex_form" method="POST" modelAttribute="login">

                        <input type="hidden" name="hash" value="c278958a83f3924254c2c04408ea4b0b" id="hash">
                        <input type="hidden" name="redirect_url" value="/products" id="redirect_url">
                        <div class="form_row">
                            <form:input path="username"  placeholder="Email" cssClass="input"  />
                        </div>
                        <div class="form_row">
                            <form:password id="password" path="password" cssClass="input"
                                           placeholder="Password" />
                        </div>
                        <div class="form_row">
                            <label for="remember_me" class="checkbox">

                                <input type="hidden" name="remember_me" value="0"><input type="checkbox"
                                                                                         name="remember_me"
                                                                                         id="remember_me" value="1"
                                                                                         checked="checked"> <span
                                    class="checked"></span>
                                Se souvenir de moi </label>
                        </div>
                        <div class="form_row">
                            <button id="submit" type="submit" class="submit">Se connecter</button>
                    </form:form>
                </div>
                <div class="login_footer">
                    <p><a href="#">Mot de passe oublié ?</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
