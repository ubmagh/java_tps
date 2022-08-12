public class EntierNaturel {

    private  int val;

    public  EntierNaturel( int Val ) throws NombreNegatifException {
        if(Val<0) throw new NombreNegatifException("(Instanciation) Impossible de stocker la valeur négatif : "+val+" .",val);
        val = Val;
    }
    public int getVal() {
        return val;
    }

    public void setVal(int val)  throws NombreNegatifException {
        if(val<0) {
            throw new NombreNegatifException(" (Modification) Impossible de stocker la valeur négatif : "+val+" .", val);
        }
        this.val = val;
    }


    public void decrementer() throws NombreNegatifException{
        if( val-1<0 ) {
            throw new NombreNegatifException(" (Decrementation) Impossible de stocker la valeur négatif : "+(val-1)+" .",val-1);
        }
        val--;
    }
}
