<#--
Application display templates can be used to modify the look of a
specific application.

Please use the left panel to quickly add commonly used variables.
Autocomplete is also available and can be invoked by typing "${".
-->


<div class="Leer_Listar_Blog">
    <#if entries?has_content>
        <ul>
        	<#list entries as entry>
                <#assign entry = entry />
    	        <#assign assetRenderer = entry.getAssetRenderer() />
    	        <#assign entryTitle = htmlUtil.escape(assetRenderer.getTitle(locale)) />
    	        <#assign entryDescripcion = htmlUtil.escape(assetRenderer.getSummary(locale)) />


    	        <#assign viewURL = renderResponse.createRenderURL() />

    	        ${viewURL.setParameter("struts_action", "/asset_publisher/view_content")}
    	        ${viewURL.setParameter("assetEntryId", entry.getEntryId()?string)}
    	        ${viewURL.setParameter("type", entry.getAssetRendererFactory().getType())}
    	        ${viewURL.setParameter("redirect", portalUtil.getCurrentURL(request))}
    	        ${viewURL.setWindowState("maximized")}
    	        
    	        
                <#if (validator.isNotNull(assetRenderer.getUrlTitle()))>
    		        <#if (assetRenderer.getGroupId() != themeDisplay.getScopeGroupId())>
    			        ${viewURL.setParameter("groupId", assetRenderer.getGroupId()?string)}
    		        </#if>
    		        ${viewURL.setParameter("urlTitle", assetRenderer.getUrlTitle())}
    	        </#if>

    	        <#if assetLinkBehavior != "showFullContent">
    		        <#assign viewURL = assetRenderer.getURLViewInContext(renderRequest, renderResponse, viewURL) />
    	        </#if>    	        
    	        
    	       <#assign docXml = saxReaderUtil.read(entry.getAssetRenderer().getArticle().getContent()) />
        	   <#assign Img = docXml.valueOf("//dynamic-element[@name='ImagenPeq']/dynamic-content/text()") />
        	   <#assign Date = docXml.valueOf("//dynamic-element[@name='Fecha']/dynamic-content/text()") />
        	   <#assign DesCorta = docXml.valueOf("//dynamic-element[@name='DescripcionCorta']/dynamic-content/text()") />
        	   <#assign categorias = entry.getCategories() />
        	   <#assign etiquetas = entry.getTags() />
        	   
        	   <li>
        	        <p class="LEER_imgL"><img class="LEER-Imagen-Redondeada" src="${Img}" title="${entryTitle}" /></p> 	
        	        <h2>${entryTitle}</h2>

        	        <p><span class="Leer-Detalle-Blog">${Date} - 
        	            <span class="Leer-Categorias-Etiquetas">
        	            <#list categorias as NumCategorias> 
            	        <#if NumCategorias?has_content>
                            <#assign cat = NumCategorias.getName() />
                            
        					<#assign categoryURL = renderResponse.createRenderURL()>
        
        					${categoryURL.setParameter("resetCur", "true")}
        					${categoryURL.setParameter("categoryId", NumCategorias.getCategoryId()?string)}                            
                            
                            <a href="${categoryURL}" title="Buscar post con la categoria ${cat}">${cat},</a>
                        </#if>    
                        </#list>
                        </span>
            	        <span class="Leer-Detalle-Blog"> Etiquetas</span>
        	            <span class="Leer-Categorias-Etiquetas">
        	            <#list etiquetas as etiqueta> 
            	        <#if etiqueta?has_content>
                            <#assign tag = etiqueta.getName() />
                            <#assign tagURL = renderResponse.createRenderURL()>
        					${tagURL.setParameter("resetCur", "true")}
        					${tagURL.setParameter("tags", tag)}     
                            <a href="${tagURL}" title="Buscar post con la etiqueta ${tag}">, ${tag}</a>
                        </#if>    
                        </#list>            	        
                        </span>
            	        
            	        </p>
        	        <p>${DesCorta}</p>

        	         <p class="LEER_right"><a href="${viewURL}" title="Ver la entrada del completa del Blog - ${entryTitle}"> 
        	        Leer Entrada</a></p>
    	       </li> 
        	
	        </#list>		
        </ul>
    </#if>
</div>