package src.main.java.cn.bnuz;

import java.util.Arrays;

/**
 * @author Zhang Hao
 * @create 2023-08-25-10:30
 */
public class Tesla {
    public static void main(String[] args) {
        //String[] B = new String[]{"x.....>","..v..X.",".>..X..","A......"};
        //String[] B = new String[]{"...Xv","AX..^",".XX.."};
        //String[] B = new String[]{"...",">.A"};
        String[] B = new String[]{"A.v","..."};
        function(B);
    }

    private static void function(String[] B) {
        //1. 序列化
        char[][] b = new char[B.length][B[0].length()];
        for (int i = 0 ; i < b.length ; i++){
            b[i] = B[i].toCharArray();
            System.out.println(Arrays.toString(b[i]));
        }
        System.out.println("************************************************");
        //2. 布尔化
        int i = 0 , j = 0;
        boolean[][] visited = new boolean[b.length][b[0].length];
        for ( int k = 0 ; k < visited.length ; k++){
            for (int o = 0 ; o < visited[0].length ; o++){
                if(b[k][o] == 'A'){
                    i = k ;
                    j = o ;
                }
                if(b[k][o] == '<'){
                    int x = o ;
                    b[k][x] = '.';
                    while(x > 0 && ( b[k][x] == '.' || b[k][x] == 'x' || b[k][x] == 'A'  )){
                        b[k][x--] = 'x';
                    }
                }else if (b[k][o] == '>'){
                    int x = o ;
                    b[k][x] = '.';
                    while(x < visited[0].length && (b[k][x] == '.' || b[k][x] == 'x'|| b[k][x] == 'A') ){
                        b[k][x++] = 'x';
                    }
                }else if(b[k][o] == '^'){
                    int x = k ;
                    b[x][o] = '.';
                    while(x > 0 && (b[x][o] == '.' || b[x][o] == 'x' || b[x][o] == 'A') ){
                        b[x--][o] = 'x';
                    }
                }else if(b[k][o] == 'v'){
                    int x = k ;
                    b[x][o] = '.';
                    while(x < visited.length && (b[x][o] == '.' || b[x][o] == 'x' ||  b[x][o] == 'A') ){
                        b[x++][o] = 'x';
                    }
                }
            }
        }
        for (int s = 0 ; s < b.length ; s++){
            System.out.println(Arrays.toString(b[s]));
        }
        System.out.println(i+"  "+j);

        //3. 深度遍历
        System.out.println(dfs(b,visited,i,j));
    }

    static boolean dfs(char[][] b , boolean[][] visited,int i , int j ) {
        if( i < 0 || i == b.length || j < 0 || j == b[0].length || visited[i][j] || b[i][j] == 'x' || b[i][j] =='X'){
            return false;
        }
        visited[i][j] = true;
        if(i == b.length-1 && j == b[0].length-1){
            return true;
        }
        return  dfs(b,visited,i+1,j)||dfs(b,visited,i-1,j)||dfs(b,visited,i,j-1)||dfs(b,visited,i,j+1);
    }
}


