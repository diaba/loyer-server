package com.loyer.loyer.Model;

public class LoyerRequest implements java.io.Serializable {
   private double montant;
    private String locataire;
    private  String maison;
    private String asset;
    private String maisonAddresse;
    private String date;
    private String telephone;

    /**
     *
     * @param montant
     * @param locataire
     * @param maison
     * @param asset
     * @param maisonAddresse
     * @param date
     * @param telephone
     */
    public LoyerRequest(double montant, String locataire, String maison, String asset, String maisonAddresse, String date, String telephone) {
        this.montant = montant;
        this.locataire = locataire;
        this.maison = maison;
        this.asset = asset;
        this.maisonAddresse = maisonAddresse;
        this.date = date;
        this.telephone = telephone;
    }

    public LoyerRequest() {
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getLocataire() {
        return locataire;
    }

    public void setLocataire(String locataire) {
        this.locataire = locataire;
    }

    public String getMaison() {
        return maison;
    }

    public void setMaison(String maison) {
        this.maison = maison;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getMaisonAddresse() {
        return maisonAddresse;
    }

    public void setMaisonAddresse(String maisonAddresse) {
        this.maisonAddresse = maisonAddresse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
