
package com.mycompany.unicafe;

public class Maksukortti {
 
    private int saldo;
 
    public Maksukortti(int saldo) {
        this.saldo = saldo;
    }
 
    public int saldo() {
        return saldo;
    }
 
    public void lataaRahaa(int lisays) {
        this.saldo += lisays;
    }
 
    public boolean otaRahaa(int maara) {
        if (this.saldo < maara) {
            return false;
        }
 
        this.saldo = this.saldo - maara;
        return true;
    }

    @Override
    public String toString() {
        int euroa = saldo / 100;
        String senttia;

        String saldo2 = Integer.toString(saldo);

        if (("" + saldo2.charAt(saldo2.length() - 1)).equals("0")) {
            senttia = "" + saldo % 100;
        } else {
            String sentti1 = "" + saldo2.charAt(saldo2.length() - 2);
            String sentti2 = "" + saldo2.charAt(saldo2.length() - 1);
            senttia = sentti1 + sentti2;
        }
        return "saldo: "+euroa+"."+senttia;
    } 
    
}
