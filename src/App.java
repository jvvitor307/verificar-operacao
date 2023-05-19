public class App {
    public static void main(String[] args){
        Verificar ver = new Verificar();
        String str = "34+36+(560+30+450";
        Pilha<Character> pnova;
        pnova = ver.transforPilha(str);
        ver.certo(pnova);
    }
}





