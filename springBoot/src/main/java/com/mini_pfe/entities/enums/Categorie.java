package com.mini_pfe.entities.enums;

public enum Categorie {
    EQUIPEMENT_RESAU("EQUIPEMENT_RESAU"),
    PC("PC"),
    RETRO_PROJECTEUR("RETROPROJECTEUR");
    private String cat;
    private Categorie(String s) {
         this.cat = s;
    }
}
