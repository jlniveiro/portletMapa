<#-- Web content templates are used to lay out the fields defined in a web content structure. Please use the left panel
    to quickly add commonly used variables. Autocomplete is also available and can be invoked by typing "${" . -->


    <h1>${tituloPrincipal.getData()}</h1>
    <div class="wrapper">
        <#list Separador4aqq.getSiblings() as item>
            <h5>${item.tituloSecundario.getData()}</h5>
            <div class="img-responsive">
                <#if item.Imagenkzqx.getData()?? && item.Imagenkzqx.getData() !="">
                    <img width="150" height="150" alt="${item.Imagenkzqx.getAttribute("alt")}"
                        data-fileentryid="${item.Imagenkzqx.getAttribute("fileEntryId")}"
                        src="${item.Imagenkzqx.getData()}" />
                </#if>
            </div>
            <br>
            <a href="${item.EnlaceAPginajrr9.getFriendlyUrl()}">
                Enlace a página
            </a>
        </#list>
    </div>

    <!-- carrusel con imagenes (estructura y plantilla) -->
    <h1>prueba de carrusel (estructura y plantilla)</h1>
    <div class="row justify-content-center">
        <div class="col-sm-8">
    
            <div class="carousel slide w-100 mx-auto" data-ride="carousel" id="carouselExampleCaptions2" style="background:#CECECE;">
                <ol class="carousel-indicators">
                    <#assign x = -1>
                    <#list Separador4aqq.getSiblings() as item>
                        <#assign x++>
                            <#if x = 0>
                                <li class="active" data-slide-to="${x}" data-target="#carouselExampleCaptions2">&nbsp;</li>
                            <#else>
                                <li data-slide-to="${x}" data-target="#carouselExampleCaptions2">&nbsp;</li>
                            </#if>
                    </#list>
                </ol>
                <div class="carousel-inner">
                <#assign y = 0>
                <#list Separador4aqq.getSiblings() as item>
                    <#assign y++>
                        <#if y = 1>
                        <div class="carousel-item active text-center">
                                <#if item.Imagenkzqx.getData()?? && item.Imagenkzqx.getData() !="">
                                    <img height="400" alt="${item.Imagenkzqx.getAttribute("alt")}" src="${item.Imagenkzqx.getData()}" />
                                </#if>
                            <div class="carousel-caption d-none d-md-block">
                            </div>
                        </div>
                        <#else>
                        <div class="carousel-item text-center">
                                <#if item.Imagenkzqx.getData()?? && item.Imagenkzqx.getData() !="">
                                    <img height="400" alt="${item.Imagenkzqx.getAttribute("alt")}" src="${item.Imagenkzqx.getData()}" />
                                </#if>
                            <div class="carousel-caption d-none d-md-block">
                            </div>
                        </div>
                        </#if>
                </#list>
                </div>
                <a class="carousel-control-prev" data-slide="prev" href="#carouselExampleCaptions2" role="button">
                    <span aria-hidden="true" class="carousel-control-prev-icon"></span>
                    <span class="sr-only">anterior</span>
                </a>
                <a class="carousel-control-next" data-slide="next" href="#carouselExampleCaptions2" role="button">
                    <span aria-hidden="true" class="carousel-control-next-icon"></span>
                    <span class="sr-only">siguiente</span>
                </a>
            </div>
        </div>
    </div>
    <div class="">documentos y multimedia:<br>
        <img src="${DocumentosYMultimediad8yx.getData()}" >
    </div>