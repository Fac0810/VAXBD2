package ar.edu.unlp.info.bd2.model;

public class Vaccine {
    private String name;
    private Integer id;

    public Vaccine(String aName) {
        this.name = aName;
        /** this.id = metodo para formar un id unico ?? **/
    }

    public Integer getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }



}
