<#if products??>
    <table>
        <thead>
        <tr>
            <th>Название</th>
            <th>Цена</th>
            <th>Доступность</th>
        </tr>
        </thead>
        <tbody>
        <#list products as product>
            <tr>
                <td>${product.title}</td>
                <td>${product.price}</td>
                <td>${product.available?string('Да', 'Нет')}</td>
            </tr>
        </#list>
        </tbody>
    </table>
<#else>
    <p>Ничего не найдено</p>
</#if>