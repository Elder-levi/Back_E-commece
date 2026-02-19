package com.example.Back_E_commece.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

   /*
     Estava tendo problema para renderizar a imagem no front-end.
     Por isso criei esta classe de configuração para informar ao Spring
     que ele deve servir arquivos estáticos a partir da pasta "upload".
    */

     /*
     Este método altera a forma como o Spring responde às URLs,
     Quando o Spring receber uma requisição para /upload/**,
     ele irá procurar o arquivo correspondente dentro da pasta física "upload"
     e retorná-lo para o navegador renderizar na página web.
    */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry  registry)
    {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:upload/");
    }

}
