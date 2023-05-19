public class Verificar {
    char[] opmatArray;
    private Pilha<Character> pnova = new Pilha<>();
    private Pilha<Character> pveia = new Pilha<>();
    private int aberto = 0;
    private int fechado = 0;
    private Character op;
    //transformando a array em uma pilha
    public Pilha<Character> transforPilha(String opMat){
        opmatArray = opMat.toCharArray();
        for(int i=0; i<opmatArray.length-1; i++){
            pnova.push(opmatArray[i]);
        }
        return pnova;
    }
    public boolean isNum(Pilha<Character> pnova){
        if (pnova.top() == '0' || pnova.top()=='1' || pnova.top()=='2' || pnova.top()=='3' || pnova.top()=='4' || pnova.top()=='5' || pnova.top()=='6' || pnova.top()=='7' || pnova.top()=='8' || pnova.top()=='9'){
            pnova.pop();
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isOp(Pilha<Character> pnova){
        if(pnova.top() == '*' || pnova.top() == '/' || pnova.top() == '+' || pnova.top() == '-' || pnova.top() == '(' || pnova.top() == ')'){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isPar(Pilha<Character> pnova, Character op){
        if(op == ')'){
            pnova.pop();
            return true;
        }
        return false;
    }

    public boolean ParOk(Pilha<Character> pnova){
        for(int i = 0; pnova.size()+i==i; i++){
            if(pnova.top()=='('){
                aberto++;
            }
            else if(pnova.top()==')'){
                fechado++;
                
            }
            pveia.push(pnova.pop());
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
                return meioOk(pnova);
            }
            else{
                return false;
            }
        }
        else if(isNum(pnova)){
            return meioOk(pnova);
        }
        else{
            return false;
        }
    
    }
    public boolean meioOk(Pilha<Character> pnova){
        while(isNum(pnova)){
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
                    }
                }
                else if(isPar(pnova, op) && pnova.isEmpty()){
                    return true;
                }
                else if(isPar(pnova, op) && isOp(pnova)){
                pnova.pop();
                if(isNum(pnova)){
                    if(pnova.isEmpty()){
                        return true;
                    }
                    else{
                        meioOk(pnova);
                    }
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
        if(meioCerto(pnova) && meioOk(pnova)){
            System.out.println("ta certo");
        }
        else{
            System.out.println("ta errado");
        }
    }

}
//65+98
//(56+56)
//65+(65-98)
//(56+89
