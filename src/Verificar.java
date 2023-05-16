public class Verificar {
    private String opMat;
    char[] opmatArray = opMat.toCharArray();
    private Pilha<Character> pnova = new Pilha<>();
    private Pilha<Character> pvelha = new Pilha<>();
    public String getOpMat() {
        return opMat;
    }
    public void setOpMat(String opMat) {
        this.opMat = opMat;
    }
    //transformando a array em uma pilha
    for(int i=0; i<opmatArray.length-1; i++){
        pnova.push(opmatArray[i]);
    }

}

