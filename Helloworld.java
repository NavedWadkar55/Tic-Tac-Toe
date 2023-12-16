import java.util.*;
class tictactoe{
   static char[][] board;
    public tictactoe(){
       board=new char[3][3];
       initboard();
    }
    void initboard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
    }static void displayboard(){
        System.out.print(" C0  C1  C2\n");
        System.out.println("-------------");
        for(int i=0;i<board.length;i++){
            System.out.print("| ");
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.print("R"+i);
            System.out.println("");
            System.out.println("-------------");
        }
    }
    static void placemark(int row,int col,char mark){
        if(row>=0&&row<=2&&col>=0&&col<=2){
            board[row][col]=mark;
        }else{
            System.out.println("Invalid point");
        }
    }
    static boolean checkcolwin(){
        for(int j=0;j<=2;j++){
         if(board[0][j]!=' '&&board[0][j]==board[1][j]&&board[1][j]==board[2][j]){
            return true;
         }
        }
        return false;
    }
   static boolean checkrowwin(){
        for(int i=0;i<=2;i++){
            if(board[i][0]!=' '&&board[i][0]==board[i][1]&&board[i][1]==board[i][2]){
                return true;

            }

        }
        return false; 
    }
   static boolean checkdiagwin(){
        if(board[0][0]!=' '&&board[0][0]==board[1][1]&&board[1][1]==board[2][2]||board[0][2]!=' '&&board[0][2]==board[1][1]&&board[1][1]==board[2][0]){
            return true;
        }
        else{
        return false;
        }
    }static boolean checkdraw(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==' ' || tictactoe.checkrowwin()||tictactoe.checkcolwin()||tictactoe.checkdiagwin() ){
                    return false;
                }
            }
            }
            return true;
        }
    }
   abstract class player{
         String name;
    char mark;
    abstract void makemove();
     boolean isvalidmove(int row,int col){
        if(row>=0&&row<=2&&col>=0&&col<=2){
        if(tictactoe.board[row][col]==' '){
            return true;
        }
    }
        return false;
    }


    }
class humanplayer{
    String name;
    char mark;
    humanplayer(String name,char mark){
        this.name=name;
        this.mark=mark;

    }
    void makemove(){
        Scanner sc=new Scanner(System.in);
        int row;
        int col;
        do{
            System.out.println("Enter row");
            row=sc.nextInt();
            System.out.println("Enter column");
            col=sc.nextInt();
           if(!isvalidmove(row,col)){
                System.out.println("Invalid Position. \nEnter your position again");
                tictactoe.displayboard();
            }
        }while(!isvalidmove(row,col));
        tictactoe.placemark(row,col,mark);


    }
    boolean isvalidmove(int row,int col){
        if(row>=0&&row<=2&&col>=0&&col<=2){
        if(tictactoe.board[row][col]==' '){
            return true;
        }
    }
        return false;
    }
}
class humanplayer1 extends player{
    humanplayer1(String name,char mark){
        this.name=name;
        this.mark=mark;

    }
    void makemove(){
        Scanner sc=new Scanner(System.in);
        int row;
        int col;
        do{
            System.out.println("Enter row");
            row=sc.nextInt();
            System.out.println("Enter column");
            col=sc.nextInt();
            if(!isvalidmove(row,col)){
                System.out.println("Invalid Position. \nEnter your position again");
                tictactoe.displayboard();
            }
        }while(!isvalidmove(row,col));
        tictactoe.placemark(row,col,mark);


    }
    
    }class aiplayer extends player{
    aiplayer(String name,char mark){
        this.name=name;
        this.mark=mark;

    }
    void makemove(){
        Scanner sc=new Scanner(System.in);
        int row;
        int col;
        do{
          Random r=new Random();
         row= r.nextInt(3);
         col= r.nextInt(3);
        }while(!isvalidmove(row,col));
        tictactoe.placemark(row,col,mark);


    }
   
}
    
    public class Helloworld{
    public static void main(String[] args){
        System.out.println("TICTACTOE  GAME!!!!");
        Scanner s=new Scanner(System.in);
        int k;
        System.out.println("Press 1 for PLAYER VS PLAYER");
        System.out.println("Press 2 for PLAYER VS AI");
        k=s.nextInt();
        switch(k){
        case 1:{
tictactoe t=new tictactoe();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name for Player 1");
        String player1 = sc.nextLine();
        System.out.println("Enter name for Player 2");
        String player2 = sc.nextLine();
        humanplayer p1=new humanplayer(player1,'X');
        humanplayer p2=new humanplayer(player2,'O');
        humanplayer cp=p1;
        tictactoe.displayboard();
        while(true){
        System.out.println(cp.name+"'s "+"turn");
        cp.makemove();
        tictactoe.displayboard();
        if(tictactoe.checkdraw()){
            System.out.println("It is a draw");
            break;
        }
            else{
          if(tictactoe.checkrowwin()||tictactoe.checkcolwin()||tictactoe.checkdiagwin()){
            System.out.println(cp.name+" "+"won");
            break;
          }      
                
        else{
            if(cp==p1){
                cp=p2;
            }else{
                cp=p1;
            }
        }
    }
}break;

        }case 2:{
             tictactoe t=new tictactoe();
             Scanner sc = new Scanner(System.in);
             System.out.println("Enter a name for the player");
             String player = sc.nextLine();
        humanplayer1 p=new humanplayer1(player,'X');
        aiplayer p3=new aiplayer("AI",'O');
        player cp=p;
        tictactoe.displayboard();
        while(true){
        System.out.println(cp.name+"'s "+"turn");
        cp.makemove();
        tictactoe.displayboard();
        if(tictactoe.checkdraw()){
            System.out.println("It is a draw");
            break;
        }
            else{
          if(tictactoe.checkrowwin()||tictactoe.checkcolwin()||tictactoe.checkdiagwin()){
            System.out.println(cp.name+' '+"won");
            break;
          }      
                
        else{
            if(cp==p){
                cp=p3;
            }else{
                cp=p;
            }
        }
    }
        }break;
    }
    default:System.out.println("Invalid choice");
    break;
    }
}
    }