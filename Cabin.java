package ClassesPart;

public class Cabin {
     String mainName ;
     String mainName2;
     String mainName3;
     String surname1;
     String surname2;
     String surname3;
     int noPsg ;
     int expenses1 ;
     int expenses2 ;
     int expenses3 ;
     int total ;

    public Cabin(){}

    public void setName(String aName) {this.mainName = aName;}
    public String getName() {return mainName;}
    public int getNoPsg() {return noPsg;}
    public void setNoPsg(int noPsg) {this.noPsg = noPsg ;}
    public void setName2(String aName) {this.mainName2 = aName;}
    public String getName2() {return mainName2;}
    public void setName3(String aName) {this.mainName3 = aName;}
    public String getName3() {return mainName3;}
    public void setFirstPsgSurname(String surname1) {this.surname1 = surname1;}
    public String getFirstPsgSurname() {return surname1;}
    public void setSecondPsgSurname(String surname2) {this.surname2 = surname2;}
    public String getSecondPsgSurname() {return surname2;}
    public void setThirdPsgSurname(String surname3) {this.surname3 = surname3;}
    public String getThirdPsgSurname() {return surname3;}
    public int getFirstPsgExpenses () {return expenses1;}
    public void setFirstPsgExpenses (int expenses1) {this.expenses1= expenses1;}
    public int getSecondPsgExpenses () {return expenses2;}
    public void setSecondPsgExpenses (int expenses2) {this.expenses2= expenses2;}
    public int getThirdPsgExpenses () {return expenses3;}
    public void setThirdPsgExpenses (int expenses3) {this.expenses3= expenses3;}
    public int getTotal() {return total;}
    public void setTotal (int total) {this.total= total;}

}

