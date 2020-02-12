<#if entries?has_content>
	<#list entries as curEntry>
	        <#assign countR = 0>
	    <#list curEntry.getSyndFeed().getEntries() as curEntryA>
				   <p> <a href="${curEntryA.link}" title="${curEntryA.title}">${curEntryA.title}</a></p>
				   <#assign countR = countR + 1>
				   <#if countR == 4 >
				        <#break>
				   </#if>
	    </#list>
	</#list>
</#if>