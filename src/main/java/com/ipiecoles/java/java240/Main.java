package com.ipiecoles.java.java240;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        ApplicationContext ctx =  new AnnotationConfigApplicationContext(SpringConfig.class);
        BitcoinService bitcoinService = ctx.getBean("bitcoinServiceWithoutCache",BitcoinService.class);

        ProduitManager produitManager = ctx.getBean(ProduitManager.class);

        //WebPageManager webPageManager = new WebPageManager();
        //pm.setWebPageManager(webPageManager);
        //BitcoinService bitcoinService = new BitcoinService(); => remplacé par ApplicationContext
        //bitcoinService.setWebPageManager(webPageManager);
        //pm.setBitcoinService(bitcoinService); => Injection faite dans SpringConfig


        System.out.println("Bienvenue !");
        while(true){
            System.out.println("Vous souhaitez : ");
            System.out.println("1 - Connaître le cours du bitcoin");
            System.out.println("2 - Ajouter un produit au catalogue");
            System.out.println("3 - Voir tous les produits du catalogue");
            System.out.println("4 - Voir les détails d'un produit");
            System.out.println("5 - Initialiser le catalogue");
            System.out.println("0 - Quitter");


            Scanner scanner = new Scanner(System.in);
            int saisie = scanner.nextInt();
            switch (saisie){
                case 1:
                    //bitcoinService.setWebPageManager(webPageManager);
                    System.out.println("1 BTC = " + bitcoinService.getBitcoinRate() + " €");
                    break;
                case 2:
                    produitManager.ajouterProduit();
                    break;
                case 3:
                    produitManager.afficherTousLesProduits();
                    break;
                case 4:
                    System.out.println("Quel numéro de produit ?");
                    produitManager.afficherDetailProduit(scanner.nextInt());
                    break;
                case 5:
                    produitManager.initialiserCatalogue();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    return;
            }
        }
    }
}
