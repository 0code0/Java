package testarray;

public class TestArray {

    int[] a;
    int n;
    int size(){
        return n;
    }
    
    int get(int i){
    return a[i];
    }
    
    int set(int i,int x){
    
        int y = a[i];
        a[i] =x;
        return y;
        
    }
    
    public static void main(String[] args) {

        
    }
    
}
