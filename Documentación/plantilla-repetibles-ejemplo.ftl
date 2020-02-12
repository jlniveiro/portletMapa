<#--
Web content templates are used to lay out the fields defined in a web
content structure.

Please use the left panel to quickly add commonly used variables.
Autocomplete is also available and can be invoked by typing "${".
-->

<h1>${tituloPrincipal.getData()}</h1>
<div class="wrapper">
    <#list Separador4aqq.getSiblings() as item>
        <h5>${item.tituloSecundario.getData()}</h5>
        <div class="img-responsive">
        <#if item.Imagenkzqx.getData()?? && item.Imagenkzqx.getData() != "">
        	<img width="150" height="150" alt="${item.Imagenkzqx.getAttribute("alt")}" data-fileentryid="${item.Imagenkzqx.getAttribute("fileEntryId")}" src="${item.Imagenkzqx.getData()}" />
        </#if>
        </div>
        <br>
        <a href="${item.EnlaceAPginajrr9.getFriendlyUrl()}">
        	Enlace a página
        </a>
    </#list>
</div>