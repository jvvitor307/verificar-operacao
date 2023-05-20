public class Verificar {
    char[] opmatArray;
    private Pilha<Character> pnova = new Pilha<>();
    private Pilha<Character> pveia = new Pilha<>();
    private int aberto = 0;
    private int fechado = 0;
    private Character op;
    private boolean c;
    private boolean v;
    //transformando a array em uma pilha
    public Pilha<Character> transforPilha(String opMat){
        opmatArray = opMat.toCharArray();
        for(int i=0; i<opmatArray.length; i++){
            pnova.push(opmatArray[i]);
        }
        return pnova;
    }
    public boolean isNum(Pilha<Character> pnova){
        if(pnova.top() != null){
            if (pnova.top() == '0' || pnova.top()=='1' || pnova.top()=='2' || pnova.top()=='3' || pnova.top()=='4' || pnova.top()=='5' || pnova.top()=='6' || pnova.top()=='7' || pnova.top()=='8' || pnova.top()=='9'){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    public boolean isOp(Pilha<Character> pnova){
        if(pnova.top() == '*' || pnova.top() == '/' || pnova.top() == '+' || pnova.top() == '-' || pnova.top() == '(' || pnova.top() == ')'){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean ParOk(Pilha<Character> pnova){
        while(!pnova.isEmpty()){
            if(pnova.top()=='('){
                pnova.pop();
                aberto++;
            }
            else if(pnova.top()==')'){
                pnova.pop();
                fechado++;
                
            }
            else if(pnova.top() == '*' || pnova.top() == '/' || pnova.top() == '+' || pnova.top() == '-' || pnova.top() == '0' || pnova.top()=='1' || pnova.top()=='2' || pnova.top()=='3' || pnova.top()=='4' || pnova.top()=='5' || pnova.top()=='6' || pnova.top()=='7' || pnova.top()=='8' || pnova.top()=='9'){
                pveia.push(pnova.pop());
            }
        }
        while(!pveia.isEmpty()){
            pnova.push(pveia.pop());
        }
        if(fechado == aberto){
            return true;
        }
        else{
            System.out.println("esta faltando parenteses");
            return false;
        }
    }
       
    public void mostrar(Pilha<Character> pnova){
        System.out.println(pnova.top());
    }
    
    //verificar se a equacao matematica atende aos padroes
    public boolean meioCerto(Pilha<Character> pnova){
        if(pnova.top() == '+' || pnova.top() == '-'){
            if(isNum(pnova)){
                if(pnova.isEmpty()){
                    return true;
                }
                return meioOk(pnova);
            }
            else{
                return false;
            }
        }
        else if(isNum(pnova)){
            if(pnova.isEmpty()){
                return true;
            }
            return meioOk(pnova);
        }
        else{
            return false;
        }
    
    }
    public boolean meioOk(Pilha<Character> pnova){
        while(isNum(pnova)){
            pnova.pop();
            if(pnova.isEmpty()){
                return true;
            }
        }
        while(!isNum(pnova) && !pnova.isEmpty()){
            if(isOp(pnova)){
                op = pnova.pop();
                if(isNum(pnova)){
                    if(pnova.isEmpty()){
                        return true;
                    }
                    else{
                        meioOk(pnova);
                        return true;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        } 
        return false;   
    }
    public void certo(Pilha<Character> pnova){
        c = ParOk(pnova);
        v = meioCerto(pnova);
        if(c && v){
            System.out.println("ta certo");
        }
        else{
            System.out.println("ta errado");
        }
    }

}

