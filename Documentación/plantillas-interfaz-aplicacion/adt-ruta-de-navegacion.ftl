<a class="" href="/inicio">Inicio</a>&nbsp;&gt;
<#if entries?has_content>
    <#list entries as curEntry>
        <#if curEntry?is_last>
            ${curEntry.getTitle()}
        <#else>
            <a href="${curEntry.getURL()}">${curEntry.getTitle()}</a>
            <#sep>&gt;</#sep>
        </#if>
    </#list>
</#if>