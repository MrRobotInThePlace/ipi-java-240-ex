package com.ipiecoles.java.java240;

import org.springframework.context.annotation.*;

@Configuration
//L'annotation @ComponentScan permet de dire à Spring
//de chercher les beans dans toutes les classes de ce
//ce package.
@ComponentScan(basePackages = "com.ipiecoles.java.java240")
@PropertySource("classpath:app.properties")
public class SpringConfig {



    //@Bean(initMethod = "init", destroyMethod = "cleanup")
    @Bean
    @Scope("singleton") // facultatif car par défault c'est du singleton
    public BitcoinService bitcoinServiceWithoutCache(){
        BitcoinService b = new BitcoinService();
        b.setForceRefresh(true);
        // Injection de WebpageManager
        //b.setWebPageManager(webPageManager());
        return b;
    }

    /* => remplacé par @ComponentScan et @Autowirred
    @Bean
    public ProduitManager produitManager(){
        ProduitManager p = new ProduitManager();
        // Injection de BitcoinServive
        p.setBitcoinService(bitcoinService());
        // Injection de WebpageManager
        p.setWebPageManager(webPageManager());
        return p;
    }

    @Bean
    public WebPageManager webPageManager(){
        System.out.println("Initialisation du WebPageManager");
        return new WebPageManager();
    }
    */
}
