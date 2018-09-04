class unionFind {
    private int id[];
    private int N;
    public unionFind( int N ){
        this.N = N;
        id = new int[N*N];
        for( int i = 0; i < id.length; ++i )//INITIALLY ALL SITES BLOCKED
            id[i] = -1;
    }
    private int root( int i ){
        while( i != id[i] ){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    public boolean connected( int p, int q ){
        return root(p) == root(q);
    }
    public void Union( int p, int q ){
        int pid = root(p);
        int qid = root(q);
        id[pid] = qid;
    }
    public int posConverter( int a, int b){
        return ( N*( a-1 ) ) + ( b-1 );
    }
    public void openSite( int x, int y){
        int pos = posConverter( x, y );
        id[pos] = pos;
    }
    public void connect( int x, int y ){//BASICALLY MEANS CONNECT WITH ALL NON BLOCKED SITES
        int pos = posConverter( x, y );
        if( id[pos] != -1 ){
            //NOW APPLY UNION 4 TIMES
            if( pos>N ){//NOT AN ELEMENT OF FIRST ROW
                int posUp = posConverter( x-1, y );
                if( id[posUp] != -1 ){//SITE NOT BLOCKED
                    Union(  posUp, pos );
                }
            }
            if( pos<(N*(N-1)) ){//NOT AN ELEMENT OF LAST ROW
                int posDown = posConverter( x+1, y );
                if( id[posDown] != -1 ){//SITE NOT BLOCKED
                    Union( posDown, pos );
                }
            }
            if( !(pos%N == 0) ){//NOT AN ELEMENT OF FIRST COLUMN
                int posLeft = posConverter( x, y-1 );
                if( id[posLeft] != -1 ){//SITE NOT BLOCKED
                    Union( posLeft, pos );
                }
            }
            if( !(pos%N == N-1) ){//NOT AN ELEMENT OF LAST COLUMN
                int posRight = posConverter( x, y+1 );
                if( id[posRight] != -1 ){//SITE NOT BLOCKED
                    Union( posRight, pos );
                }
            }
        }
    }
    public void percolates(){
        for( int i = 1; i <= N; ++i )
            for( int j = 1; j <= N; ++j )
                connect( i, j );
    }
    public void printID(){
        for( int i = 0; i < id.length; ++i ){
            System.out.print( id[i] + " " );
        }
        System.out.println("\n");
    }
}
public class Percolation {
    public static void main( String args[] ){
        unionFind obj = new unionFind( 3 );

        //HAPPENS FOR THIS ONE, VALUE OF FIRST AND LAST IS SAME
        obj.openSite(1, 1);
        obj.openSite(2, 1);
        obj.openSite(2, 2);
        obj.openSite(2, 3);
        obj.openSite(3, 3);
        /*
        //NO PERCOLATION HAPPENS FOR THIS
        obj.openSite(1, 1);
        obj.openSite(2, 1);
        obj.openSite(3, 2);//this is changed
        obj.openSite(2, 3);
        obj.openSite(3, 3);
        */
        obj.printID();

        obj.percolates();
        obj.printID();
    }
}
