<#ftl encoding='UTF-8'>
<head>
    <head>
        <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
</head>
<body>
<#if error??>
<div class="alert alert-danger" role="alert">${error}</div>
</#if>
<div class="content-block">
    <form class="form-horizontal" action="/signUp" method="post">
        <span>Регистрация на сайте</span><br><br>
        <label>Name </label>
        <input name="name" placeholder="Имя"/><br><br>
        <label>Login </label>
        <input name="login" placeholder="Логин"/><br><br>
        <label>Email </label>
        <input name="email" placeholder="Email"/><br><br>
        <label>Password </label>
        <input name="password" placeholder="Пароль"/><br><br>
        <label>Phone </label>
        <input name="phone" placeholder="Телефон"/><br><br>
        <input type="submit">
    </form>

    <form class="form-horizontal" action="/login" method="get">
        <br>
        <input type="submit" value="Войти">
    </form>
</div>
</body>