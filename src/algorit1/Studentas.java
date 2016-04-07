/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorit1;

/**
 *
 * @author Arnoldas
 */
public class Studentas implements KTUable<Studentas> {
    
    private   String pavarde;
    private   int id;

    public Studentas( String pavarde, int id) {
        
        this.pavarde = pavarde;
        this.id = id;
    }

    public Studentas() {
    }

    
    public  String getPavarde() {
        return pavarde;
    }

    public  int getId() {
        return id;
    }

    

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public void setId(int id) {
        this.id = id;
    }
//    @Override
//    public int compareTo(Studentas a) {
//        
//        
//    }
    @Override
    public String toString() {  // papildyta su autoRegNr
        return getId() + "=" +  "_" + pavarde + " ";
    }
    

    

    @Override
    public int compareTo(Studentas e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getId()<e.getId())? -1 : (getId()>e.getId())? 1 : 0;
        
//        return getId().compareTo(e.getId());
        
    }
}
