package Lv281122;

public class VerketteteListe {
    VerketteteListeKnoten anfang = null;

    void addAtIndex(int value, int index) {
        VerketteteListeKnoten temp = anfang;
        if(index <= 0) {
            addToBeginn(value);
            return;
        }

        for(int i = 0; i < index - 1 && temp.naechsterKnoten != null; i++) {
            temp = temp.naechsterKnoten;
        }
        VerketteteListeKnoten neuerKnoten = new VerketteteListeKnoten();
        neuerKnoten.inhalt = value;
        neuerKnoten.naechsterKnoten = temp.naechsterKnoten;
        temp.naechsterKnoten = neuerKnoten;
    }

    void delValues(int value) {
        int meineLaenge = laenge();
        VerketteteListeKnoten temp = anfang;
        int i;
        for(i = 0; i < meineLaenge; i++) {
            if(temp.inhalt == value)
                break;
            temp = temp.naechsterKnoten;
        }
        loeschen(i);
    }

    void addToBeginn(int newValue) {
        VerketteteListeKnoten neuerKnoten = new VerketteteListeKnoten();
        neuerKnoten.inhalt = newValue;
        neuerKnoten.naechsterKnoten = anfang;
        anfang = neuerKnoten;
    }

    @Override
    public String toString() {
        String result = "";
        for (VerketteteListeKnoten temp = anfang; temp != null; temp = temp.naechsterKnoten) {
            result += temp.inhalt + " ";
        }
        return result;
    }

    public int laenge() {
        int laenge = 0;
        for (VerketteteListeKnoten temp = anfang; temp != null; temp = temp.naechsterKnoten) {
            laenge++;
        }
        return laenge;
    }

    public int summe() {
        int summe = 0;
        for (VerketteteListeKnoten temp = anfang; temp != null; temp = temp.naechsterKnoten) {
            summe = summe + temp.inhalt;
        }
        return summe;
    }

    public int[] makeArray() {
        int[] array = new int[laenge()];
        int i = 0;
        for (VerketteteListeKnoten temp = anfang; temp != null; temp = temp.naechsterKnoten) {
            array[i] = temp.inhalt;
            i++;
        }
        return array;
    }

    public void loeschen(int index){
        VerketteteListeKnoten t1 = null, t2 = anfang;
        for (int i = 0; i < index; i++) {
            t1 = t2;
            t2 = t2.naechsterKnoten;
        }
        if(t1 == null){
            anfang = t2.naechsterKnoten;
        }
        else{
            t1.naechsterKnoten = t2.naechsterKnoten;
        }
        t2.naechsterKnoten = null;
    }
//    public void addAtIndex(int value, int index){
//        VerketteteListeKnoten temp = anfang;
//        for (int i = 0; i < index; i++) {
//            temp = temp.naechsterKnoten;
//        }
//        VerketteteListeKnoten neuerKnoten = new VerketteteListeKnoten();
//        neuerKnoten.inhalt = value;
//        neuerKnoten.naechsterKnoten = temp.naechsterKnoten;
//        temp.naechsterKnoten = neuerKnoten;
//
//    public void addToBeginning(int value){
//        VerketteteListeKnoten neuerKnoten = new VerketteteListeKnoten();
//        neuerKnoten.inhalt = value;
//        neuerKnoten.naechsterKnoten =
//    }
//
//    public void loescheNachWert(int wert, VerketteteListe liste){
//        int listenlaenge = laenge();
//        VerketteteListeKnoten temp = anfang;
//        int i;
//        for (i = 0; i < listenlaenge; i++) {
//
//        }
//    }
}