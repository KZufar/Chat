<#ftl encoding='UTF-8'>
<body>
Добро пожаловать ${model.user.id}!

<form class="form-horizontal" action="/logout" method="get">
    <input type="submit" value="Выйти">
</form>
</body>