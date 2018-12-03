package com.wildcodeschool.begin.aSpringQuest.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wildcodeschool.begin.aSpringQuest.entities.Moto;
import com.wildcodeschool.begin.aSpringQuest.repositories.MotoRepo;


@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Wilder");

    @Autowired
    private MotoRepo MotoRepo;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD        
        LOG.info("******************");
        LOG.info("Objects in DB : " + MotoRepo.count());

        // Crée un nouvel utilisateur et l'enregistre dans la BDD
        Moto moto1 = new Moto("Aprilia", "RS", 125);
        LOG.info("******************");
        LOG.info(moto1 + " has been created !");
        MotoRepo.save(moto1);
        LOG.info(moto1 + " has been saved !");

        // Crée un second utilisateur et l'enregistre dans la BDD
        Moto moto2 = new Moto("BMW", "Tuyau", 500);
        LOG.info("******************");
        LOG.info(moto2 + " has been created !");
        MotoRepo.save(moto2);
        LOG.info(moto2 + " has been saved !");

        // Lit les informations correspondant au second utilisateur
        Moto tempMoto = MotoRepo.findById(2L).get(); /* On écrit "2L" car 
                                                       le type de l'id est Long */
        LOG.info("******************");
        LOG.info("Second user's firstName is " + tempMoto.getMake());
        LOG.info("Second user's lastName is " + tempMoto.getModel());
        LOG.info("Second user's age is " + tempMoto.getCc());

        // Liste les utilisateurs enregistrés dans la BDD
        LOG.info("******************");
        LOG.info("Motos in list are ");
        for(Moto myMoto : MotoRepo.findAll()) {
            LOG.info(myMoto.toString());
        };

        // Supprime le second utilisateur de la BDD
        MotoRepo.deleteById(2L); /* risque de provoquer une erreur si 
                                tu n'as pas vidé ta table avant de relancer 
                                ton application ! */

        /*     Liste les utilisateurs enregistrés dans la BDD
             (permet de vérifier que le second utilisateur
             a bien été supprimé de la BDD) */
        LOG.info("******************");
        LOG.info("Motos in list are ");
        for(Moto myMoto : MotoRepo.findAll()) {
            LOG.info(myMoto.toString());
        };
    }    
}