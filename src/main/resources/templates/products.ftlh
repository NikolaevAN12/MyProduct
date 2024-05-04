<!DOCTYPE html>
<html>
<head>
    <title>MyProduct</title>
</head>
<body>
<h1>MyProduct</h1>
<hr>
<h4>Товары со всей России</h4>
<#list products as product>

    <div><p><b>${product.title}</b> — ${product.price} руб. | <b>Наличие: </b>
            <input type="checkbox" disabled ${product.isAvailable()?then('checked', '')}>
            <a href="/product/${product.id}">Подробнее...</a></p></div> </#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post">
    Название Объявления: <input type="text" name="title" maxlength="255" required/><br><br>
    Описание Объявления: <input type="text" name="description" maxlength="4096" required/><br><br>
    Цена: <input type="number" name="price" min="0" required/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>