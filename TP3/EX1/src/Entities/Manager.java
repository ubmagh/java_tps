package Entities;

public class Manager extends Employe{

    private String service;

    public Manager(){
        super();
        service = " --vide-- ";
    }

    public Manager( String nom, String prenom, String email, String telephone, float salaire, String service){
        super(nom, prenom, email, telephone, salaire);
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public float calculerSalaire() {
        return super.getSalaire()*1.2f;
    }

    @Override
    public String toString() {
        return " Manager : { " +
                super.toString()+
                ", service='" + service + '\'' +
                " }";
    }
}
