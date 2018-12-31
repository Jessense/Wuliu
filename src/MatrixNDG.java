public class MatrixNDG {

    private  int size;//图顶点个数
    private char[] vertexs;//图顶点名称
    private int[][] matrix;//图关系矩阵
    private static final int INF = Integer.MAX_VALUE;

    public MatrixNDG(char[] vertexs,char[][] edges){
        size=vertexs.length;
        matrix=new int[size][size];//设定图关系矩阵大小
        this.vertexs=vertexs;
        for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				matrix[i][j] = INF;
		}
        
        for(char[] c:edges){//设置矩阵值
            int p1 = getPosition(c[0]);//根据顶点名称确定对应矩阵下标
            int p2 = getPosition(c[1]);
            matrix[p1][p2] = edges[p1][p2];//无向图，在两个对称位置存储
            matrix[p2][p1] = edges[p1][p2];
        }

    }
    
    /*判断图是否包含给定的两个点*/
    public boolean hasRoad(char start, char destination) {
    	boolean hasStart = false;
    	boolean hasDestination = false;
		for (int i = 0; i < vertexs.length; i++) {
			if (start == vertexs[i]) {
				hasStart = true;
			}
			if (start == vertexs[i]) {
				hasDestination = true;
			}
			if (hasStart && hasDestination) {
				return true;
			}
		}
		return false;
	}
    
    /*
     * Dijkstra最短路径。
     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
     *
     * 参数说明：
     *       vs -- 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
     *     prev -- 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
     *     dist -- 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
     */
    public int dijkstra(char start, char destination) {
        int vs = getPosition(start);
        int vt = getPosition(destination);
        
        int[] prev;
        int[] dist;
    	
    	// flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
        boolean[] flag = new boolean[vertexs.length];

        // 初始化
        for (int i = 0; i < vertexs.length; i++) {
            flag[i] = false;          // 顶点i的最短路径还没获取到。
            prev[i] = 0;              // 顶点i的前驱顶点为0。
            dist[i] = matrix[vs][i];  // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }

        // 对"顶点vs"自身进行初始化
        flag[vs] = true;
        dist[vs] = 0;

        // 遍历vertexs.length-1次；每次找出一个顶点的最短路径。
        int k=0;
        for (int i = 1; i < vertexs.length; i++) {
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
            int min = INF;
            for (int j = 0; j < vertexs.length; j++) {
                if (flag[j]==false && dist[j]<min) {
                    min = dist[j];
                    k = j;
                }
            }
            // 标记"顶点k"为已经获取到最短路径
            flag[k] = true;

            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < vertexs.length; j++) {
                int tmp = (matrix[k][j]==INF ? INF : (min + matrix[k][j]));
                if (flag[j]==false && (tmp<dist[j]) ) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }
        return matrix[vs][vt];

//        // 打印dijkstra最短路径的结果
//        System.out.printf("dijkstra(%c): \n", vertexs[vs]);
//        for (int i=0; i < vertexs.length; i++)
//            System.out.printf("  shortest(%c, %c)=%d\n", vertexs[vs], vertexs[i], dist[i]);
    }

    //图的遍历输出
    public void print(){
        for(int[] i:matrix){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    //根据顶点名称获取对应的矩阵下标
    private int getPosition(char ch) {
        for(int i=0; i<vertexs.length; i++)
            if(vertexs[i]==ch)
                return i;
        return -1;
    }
    
    public int[][] getMatrix() {
		return matrix;
	}
    public int getSize() {
		return size;
	}
    public char[] getVertexs() {
		return vertexs;
	}
    public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
    public void setSize(int size) {
		this.size = size;
	}
    public void setVertexs(char[] vertexs) {
		this.vertexs = vertexs;
	}
//    public static void main(String[] args) {
//        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G','H','I','J','K'};
//        char[][] edges = new char[][]{
//            {'A', 'C'}, 
//            {'A', 'D'}, 
//            {'A', 'F'}, 
//            {'B', 'C'}, 
//            {'C', 'D'}, 
//            {'E', 'G'}, 
//            {'D', 'G'},
//            {'I','J'},
//            {'J','G'},};
//        MatrixNDG pG;
//        // 自定义"图"(输入矩阵队列)
//        // 采用已有的"图"
//        long start=System.nanoTime();
//
//        for(int i=0;i<10000;i++){
//            pG = new MatrixNDG(vexs, edges);
//            //pG.print();   // 打印图 
//        }
//
//        long end=System.nanoTime();
//
//        System.out.println(end-start);
//    }
}