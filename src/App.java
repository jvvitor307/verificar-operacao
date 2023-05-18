public class App {
    public static void main(String[] args){
        Verificar ver = new Verificar();
        String str = "34+34";
        Pilha<Character> pnova;
        pnova = ver.transforPilha(str);
        ver.mostrar(pnova);
    }
}





