<#--
Widget templates can be used to modify the look of a
specific application.

Please use the left panel to quickly add commonly used variables.
Autocomplete is also available and can be invoked by typing "${".
-->
<#-- Estilos CSS-->
<style>
    /* Estilos para el carousel de bootstrap */
    .carousel {
        background: #CECECE;
    }
    .carousel .carousel-item img {
        height: 400px;
    }
    .carousel .carousel-item h3 {
        color: #000;
    }

    /* Estilos para el carousel de slick.js */
    .slick-slide{
        margin:10px;
    }
    .slick-slide img{
        width:100%;
        border: 2px solid #fff;
    }
    .slick-prev:before {
        color: #CECECE;
    }
    .slick-prev:before,.slick-next:before {
        color: #CECECE;
    }
</style>
<#-- Funcionalidad javascript (jquery) -->
<script>
    $(document).ready(function() {
        console.log("ready!");
        $(".carousel .carousel-inner a").each(function() {
            var $this = $(this);
            var $texto = $this.text();
            var $textoFormateado = $texto.split('/').slice('0').join(' ');
            //console.log($texto +'-'+ $textoFormateado);
            $this.text($textoFormateado);
        });

        /* Funcionalidad carousel de slick.js */
        $('.carousel-slick').slick({
            slidesToShow: 3,
            dots:true,
            centerMode: true,
        });
    });
</script>


<!-- configurarlo desde el panel de control -> configuracion ->  configuracion del sistema -> motores de plantilla (eliminar servicelocator de variables restringidas) -->
<#assign AssetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService")>
<#--${AssetEntryLocalService}-->
<#assign LayoutLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
<#--<#assign PortletFileRepositoryUtil = serviceLocator.findService("com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil")>-->
<!-- Función para recoger contenido a traves del nombre de campo de estructura -->

<#function getContentByName entryC nombre>
    <#assign assetRenderer = entryC.getAssetRenderer() />
    <#assign docXml = saxReaderUtil.read(assetRenderer.getArticle().getContentByLocale(locale)) /> 
    <#assign valorContent = docXml.valueOf("//dynamic-element[@name='" + nombre + "']/dynamic-content/text()") />
    <#return valorContent />
</#function>

<#if entries?has_content>
    <#list entries as curEntry>

    	<#assign assetRenderer = curEntry.getAssetRenderer() />
        <#assign journalArticle = assetRenderer.getArticle()>
        <#assign docXml = saxReaderUtil.read(assetRenderer.getArticle().getContentByLocale(locale)) />
        <#assign document = saxReaderUtil.read(assetRenderer.getArticle().getContent()) />




        <!-- titulosecundario,imagenkzqx,EnlaceAPginajrr son repetibles (solo saca el primer elemento) -->
        <#--<#assign titulo = curEntry.getTitle(locale)/>-->
        <#assign tituloPrincipal = getContentByName(curEntry, "tituloPrincipal") />
        <#assign tituloSecundario = getContentByName(curEntry, "tituloSecundario") />
        <#assign Imagenkzqx = getContentByName(curEntry, "Imagenkzqx") />
        <#assign EnlaceAPginajrr9 = getContentByName(curEntry, "EnlaceAPginajrr9") />
        
        <!--<#assign imgJson = jsonFactoryUtil.createJSONObject(Imagenkzqx) />
        ${imgJson}-->

        <#--URL DETALLE-->
	     <#if assetLinkBehavior == "viewInPortlet">
                <#assign viewURL = assetRenderer.getURLViewInContext(renderRequest, renderResponse, currentURL) />
         </#if>
         
         <#assign viewURL = "/-/" + assetRenderer.getUrlTitle() />
         
         <!--viewURL : ${viewURL}-->
    
        <!--<div class="contenedor">
            <ul>
                <li>titulo principal: ${tituloPrincipal}</li>
                <li>titulo secundario: ${tituloSecundario}</li>
                <li>imagen: ${Imagenkzqx}</li>
                <li>enlace: ${EnlaceAPginajrr9}</li>
            </ul>
        </div>-->

        <h1>ADT Carrusel Bootstrap 4</h1>
        
        <#assign separador = document.getRootElement().selectNodes("//dynamic-element[@name='Separador4aqq']") />

        <#if separador?has_content>
            <h1>${tituloPrincipal}</h1>
		    <#list separador as sp>
                <#assign titulo = sp.valueOf("dynamic-element[@name='tituloSecundario']")/>
                <#assign img = sp.valueOf("dynamic-element[@name='Imagenkzqx']")/>
                <#assign imgGroupId = img?eval.groupId/>
                <#assign imgName = img?eval.name/>
                <#assign imgUuid = img?eval.uuid/>
                <#assign enlace = sp.valueOf("dynamic-element[@name='EnlaceAPginajrr9']/dynamic-content") />
                <#assign layoutID = enlace?split("@")?first?number/>
                <#assign groupId = enlace?split("@")?last?number/>
                <#assign pageLayout = LayoutLocalService.getLayout(groupId, false, layoutID) />

                <#--${titulo} - ${enlace}<br>-->
                <#--<img height="400" class="text-center mx-auto" src="/documents/${imgGroupId}/0/${imgName}/${imgUuid}" alt="${imgName}">-->
                <#--<a href="${pageLayout.getFriendlyURL()}">ir a ${pageLayout.getFriendlyURL()}</a>-->
            </#list>
            <div id="ica-carousel" class="carousel slide w-100 mx-auto" data-ride="carousel">
                <#assign x = -1>
                <ul class="carousel-indicators">
                <#list separador as sp>
                    <#assign x++>                    
                    <#if x = 0>
                        <li data-target="#ica-carousel" data-slide-to="${x}" class="active"></li>
                    <#else>
                        <li data-target="#ica-carousel" data-slide-to="${x}"></li>
                    </#if>                    
                </#list>
                </ul>
                <div class="carousel-inner">
                    <#assign y = 0>
                    <#list separador as sp>
                        <#assign y++>
                        <#assign titulo = sp.valueOf("dynamic-element[@name='tituloSecundario']")/>
                        <#assign img = sp.valueOf("dynamic-element[@name='Imagenkzqx']")/>
                        <#assign imgGroupId = img?eval.groupId/>
                        <#assign imgName = img?eval.name/>
                        <#assign imgUuid = img?eval.uuid/>
                        <#assign enlace = sp.valueOf("dynamic-element[@name='EnlaceAPginajrr9']/dynamic-content") />
                        <#assign layoutID = enlace?split("@")?first?number/>
                        <#assign groupId = enlace?split("@")?last?number/>
                        <#assign pageLayout = LayoutLocalService.getLayout(groupId, false, layoutID) />                        
                        <#if y = 1>

                            <div class="carousel-item active text-center">
                                <img src="/documents/${imgGroupId}/0/${imgName}/${imgUuid}" alt="${imgName}">
                                <div class="carousel-caption">
                                    <h3>${imgName}</h3>
                                    <a href="${pageLayout.getFriendlyURL()}">${pageLayout.getFriendlyURL()}</a>
                                </div>
                            </div>
                        <#else>
                            <div class="carousel-item text-center">
                                <img src="/documents/${imgGroupId}/0/${imgName}/${imgUuid}" alt="${imgName}">
                                <div class="carousel-caption">
                                    <h3>${imgName}</h3>
                                    <a href="${pageLayout.getFriendlyURL()}">${pageLayout.getFriendlyURL()}</a>
                                </div>
                            </div>
                        </#if>
                    </#list>
                </div>
                <a class="carousel-control-prev" href="#ica-carousel" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#ica-carousel" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>

            <!------------------------------------------------------------------------------------------------>
		</#if>

        <#assign separadorSlick = document.getRootElement().selectNodes("//dynamic-element[@name='separador_img_slick']") />
        <#if separadorSlick?has_content>
            <h1>ejemplo imagen repetible dentro un separador (slick.js)</h1>
            <div class="wrapper">
                <h2>Slick carousel Example</h2>
                <div class="carousel-slick">
                    <#list separadorSlick as img_slick>
                        <#assign img = img_slick.valueOf("dynamic-element[@name='img_slick']") />
                        <#assign imgGroupId = img?eval.groupId/>
                        <#assign imgName = img?eval.name/>
                        <#assign imgUuid = img?eval.uuid/>
                            <div><img src="/documents/${imgGroupId}/0/${imgName}/${imgUuid}" alt="${imgName}"></div>
                    </#list>
                </div>
            </div>
        </#if>

        <h1>Ejemplo imagen repetible sin un separador (slick.js)</h1>
        <#assign imagenRepetible = document.getRootElement().selectNodes("//dynamic-element[@name='imagen_slick_repetible']") />
        <#if imagenRepetible?has_content>
            <div class="wrapper">        
                <div class="carousel-slick">
                    <#list imagenRepetible as imgR>
                        <#--objeto del repetible -->
                        <#assign img = imgR.element("dynamic-content").getData() />
                        <#--${img}<br>--><#-- pintamos el objeto de tipo imagen -->
                        <#assign imgName = img?eval.name />
                        <#assign imgGroupId = img?eval.groupId />
                        <#assign imgUuid = img?eval.uuid />
                        <div><img src="/documents/${imgGroupId}/0/${imgName}/${imgUuid}" alt="${imgName}"></div>
                    </#list>
                </div>
            </div>
        </#if>
	</#list>
</#if>