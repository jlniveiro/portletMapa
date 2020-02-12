<#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />

<#function getContentByName entryC nombre>
    <#assign assetRenderer = entryC.getAssetRenderer() />
    <#assign docXml = saxReaderUtil.read(assetRenderer.getArticle().getContentByLocale(locale)) />
    <#assign valorContent = docXml.valueOf("//dynamic-element[@name='" + nombre + "']/dynamic-content/text()") />
    <#return valorContent />
</#function>



<div class="Leer_Listar_Video">

<ul class="listadogaleria">

<#if entries?has_content>
    <#list entries as curEntry>
        <#assign titulo = curEntry.getTitle(locale)/>
        <#assign urlImagenPoster = getContentByName(curEntry, "Clip_poster") />
        
        <#--URL DETALLE-->
	     <#if assetLinkBehavior == "viewInPortlet">
                <#assign viewURL = assetRenderer.getURLViewInContext(renderRequest, renderResponse, currentURL) />
         </#if>
         
         <#assign viewURL = "/-/" + assetRenderer.getUrlTitle() />
         
        <#-- -- -->
    
        <li>
            <div class="capa">
                <a href="${viewURL}" title="Ir al detalle del vídeo - ${titulo}">
                    <img src="${urlImagenPoster}" alt="Imagen del vídeo - ${titulo}" />
                    <div class="textofoto">
                        <div class="TextoFotoText">
                            <p>${titulo}</p>
                        </div>
                    </div>
                </a>
        	</div>
    	</li>
	</#list>
	
</#if>

</ul>


</div>