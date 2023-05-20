public class App {public static void main(String[] args){
        Verificar ver = new Verificar();
        String str = "565**56";
        Pilha<Character> pnova;
        pnova = ver.transforPilha(str);
        ver.certo(pnova);
    }
}





