public class MatrixNDG {

    private  int size;//ͼ�������
    private char[] vertexs;//ͼ��������
    private int[][] matrix;//ͼ��ϵ����
    private static final int INF = Integer.MAX_VALUE;

    public MatrixNDG(char[] vertexs,char[][] edges){
        size=vertexs.length;
        matrix=new int[size][size];//�趨ͼ��ϵ�����С
        this.vertexs=vertexs;
        for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				matrix[i][j] = INF;
		}
        
        for(char[] c:edges){//���þ���ֵ
            int p1 = getPosition(c[0]);//���ݶ�������ȷ����Ӧ�����±�
            int p2 = getPosition(c[1]);
            matrix[p1][p2] = edges[p1][p2];//����ͼ���������Գ�λ�ô洢
            matrix[p2][p1] = edges[p1][p2];
        }

    }
    
    /*�ж�ͼ�Ƿ����������������*/
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
     * Dijkstra���·����
     * ����ͳ��ͼ��"����vs"������������������·����
     *
     * ����˵����
     *       vs -- ��ʼ����(start vertex)��������"����vs"��������������·����
     *     prev -- ǰ���������顣����prev[i]��ֵ��"����vs"��"����i"�����·����������ȫ�������У�λ��"����i"֮ǰ���Ǹ����㡣
     *     dist -- �������顣����dist[i]��"����vs"��"����i"�����·���ĳ��ȡ�
     */
    public int dijkstra(char start, char destination) {
        int vs = getPosition(start);
        int vt = getPosition(destination);
        
        int[] prev;
        int[] dist;
    	
    	// flag[i]=true��ʾ"����vs"��"����i"�����·���ѳɹ���ȡ
        boolean[] flag = new boolean[vertexs.length];

        // ��ʼ��
        for (int i = 0; i < vertexs.length; i++) {
            flag[i] = false;          // ����i�����·����û��ȡ����
            prev[i] = 0;              // ����i��ǰ������Ϊ0��
            dist[i] = matrix[vs][i];  // ����i�����·��Ϊ"����vs"��"����i"��Ȩ��
        }

        // ��"����vs"������г�ʼ��
        flag[vs] = true;
        dist[vs] = 0;

        // ����vertexs.length-1�Σ�ÿ���ҳ�һ����������·����
        int k=0;
        for (int i = 1; i < vertexs.length; i++) {
            // Ѱ�ҵ�ǰ��С��·����
            // ������δ��ȡ���·���Ķ����У��ҵ���vs����Ķ���(k)��
            int min = INF;
            for (int j = 0; j < vertexs.length; j++) {
                if (flag[j]==false && dist[j]<min) {
                    min = dist[j];
                    k = j;
                }
            }
            // ���"����k"Ϊ�Ѿ���ȡ�����·��
            flag[k] = true;

            // ������ǰ���·����ǰ������
            // �������Ѿ�"����k�����·��"֮�󣬸���"δ��ȡ���·���Ķ�������·����ǰ������"��
            for (int j = 0; j < vertexs.length; j++) {
                int tmp = (matrix[k][j]==INF ? INF : (min + matrix[k][j]));
                if (flag[j]==false && (tmp<dist[j]) ) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }
        return matrix[vs][vt];

//        // ��ӡdijkstra���·���Ľ��
//        System.out.printf("dijkstra(%c): \n", vertexs[vs]);
//        for (int i=0; i < vertexs.length; i++)
//            System.out.printf("  shortest(%c, %c)=%d\n", vertexs[vs], vertexs[i], dist[i]);
    }

    //ͼ�ı������
    public void print(){
        for(int[] i:matrix){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    //���ݶ������ƻ�ȡ��Ӧ�ľ����±�
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
//        // �Զ���"ͼ"(����������)
//        // �������е�"ͼ"
//        long start=System.nanoTime();
//
//        for(int i=0;i<10000;i++){
//            pG = new MatrixNDG(vexs, edges);
//            //pG.print();   // ��ӡͼ 
//        }
//
//        long end=System.nanoTime();
//
//        System.out.println(end-start);
//    }
}