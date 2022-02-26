public class Contest {

    public int[] sortEvenOdd(int[] t) {
        if(t.length<3){
            return t;
        }
   else{
       int i=2;
       int temp = t[1];
       while(i % 2 !=0 && i< t.length){
           if(t[i] > temp){
               int tmp = t[i];
               t[i] = temp;
               temp = tmp;
               i++;
           }
           i++;
       }
       return t;
        }

    }
}
