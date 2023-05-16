import java.util.ArrayList;
public class Pilha<T> {
	int size = 0;
	boolean isempty;
	ArrayList<T> lista = new ArrayList<>();
	public void pop(){
       if(size<=1){
        size--;
		System.out.println(lista.get(size()-1));
        lista.remove(size()-1);
       }else{
        System.out.println("lista vazia");
       }
    }
	public int size() {
		return size;
		}
	public void push(T add){
		lista.add(add);
        size++;
		}
	public boolean isEmpty() {
		if(size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public T top() {
		return lista.get(size()-1);
	}
    public void clear(){
        while(size() != 0){
            pop();
        }
    }
}