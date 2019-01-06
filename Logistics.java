import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Logistics {
    private List<Delivery> delivers;
    private List<Seller> sellers;

    public Logistics(List<Delivery> delivers, List<Seller> sellers) {
//		delivers = new ArrayList<Delivery>();
        this.delivers = delivers;
        this.sellers = sellers;
    }

    public List<Solution> makeSolution(Request request) {
        List<Solution> result = new ArrayList<Solution>();
        //TODO ������������б�
        for (int i = 0; i < delivers.size(); i++) {
            List<MatrixNDG> roadmaps = delivers.get(i).getRoadmaps();
            int[] distances = new int[roadmaps.size()];
            for (int j = 0; j < roadmaps.size(); j++) {
                distances[j] = roadmaps.get(i).dijkstra(request.getStart(), request.getDestination());
                double transpeed = 0;
                double charge = 0;
                if (roadmaps.get(i).getSize() == 1) //����ù�Ӧ��û�и����ͽ�ͨ����
                    break;
                else {
                    for (int k = 0; k < delivers.get(i).getTransportations().size(); k ++) {
                        if (delivers.get(i).getTransportations().get(i).getType() == j) {
                            transpeed = delivers.get(i).getTransportations().get(i).getSpeed();
                            charge = delivers.get(i).getTransportations().get(i).getCharge();
                        }
                    }
                }
                double speed = distances[j]/transpeed; //Ԥ���ʹ�ʱ��
                int transportation_type = j; //·��ͼ��Ӧ��ͨ��������
                double weight = request.getWeight();
                double price; //�ٳ��Ͼ����ٳ���ĳ��������
                if (weight <= delivers.get(i).getMx()) {
                    int m;
                    for (m = 0; m < delivers.get(i).getMx(); m++) {
                        if(weight - m < 0)
                            break;
                    }
                    double tempm = weight - m + 1;
                    if (tempm > 0.5)
                        weight = weight - tempm + 1;
                    else
                        weight = weight - tempm + 0.5;

                    price = weight * charge * delivers.get(i).getP0();
                } else {
                    double m;
                    for (m = delivers.get(i).getMx(); ; m++) {
                        if(weight - m < 0)
                            break;
                    }
                    if(weight != m - 1)
                        weight = m;
                    price = weight * charge * delivers.get(i).getP0();
                }

                /*�򵥴ֱ��ļӼ����ԣ�ֱ�ӳ��˸����ӣ���֪��������μӼ�����*/
                if (request.getUrgent()) {
                    price *= delivers.get(i).getUrgent_price();
                    speed *= delivers.get(i).getUrgent_speed();
                }


                /*�ֱ��Ķ��ڴ������Żݲ��ԣ����Ӷ�Ϊ�ù�Ӧ�̵Ķ���������ƽ������ͨ��������ɶ����Ƴ��ö����б����Ż�*/
                for (int k = 0; k < delivers.get(i).getOrders().size(); k ++) {
                    Order tempOrder = delivers.get(i).getOrders().get(k);
                    if (tempOrder.getSeller_id() == request.getSeller_id() && tempOrder.getFlag() != -1) {
                        if (tempOrder.getFlag() == 0) {
                            if ((new Date()).getTime() - tempOrder.getGeneratetime() < delivers.get(i).getDuration()) {
                                int accum = 0;
                                for (int m = k; m < delivers.get(i).getOrders().size(); m ++) {
                                    Order tempOrder2 = delivers.get(i).getOrders().get(m);
                                    if (tempOrder2.getSeller_id() == request.getSeller_id() && tempOrder2.getFlag() == 1) {
                                        accum += tempOrder2.getWeight();
                                        if (accum > delivers.get(i).getEnough())
                                            break;
                                    }
                                }
                                if (accum >= delivers.get(i).getEnough()) {
                                    price *= delivers.get(i).getDiscount();
                                }
                            } else {
                                for (int m = k; m < delivers.get(i).getOrders().size(); m ++) {
                                    Order tempOrder2 = delivers.get(i).getOrders().get(m);
                                    if (tempOrder2.getSeller_id() == request.getSeller_id() && tempOrder2.getFlag() == 1) {
                                        tempOrder.setFlag(-1);
                                    }
                                }
                            }
                        }
                    }
                }






                int seller_id = request.getSeller_id();
                int delivery_id = delivers.get(i).getId();

                int type = 0;//TODO

                char start = request.getStart();
                char destination = request.getDestination();

                Solution tempSolution = new Solution(seller_id, delivery_id, transportation_type, speed, type, weight, price,start, destination, request.getUrgent());
                result.add(tempSolution);
            }

        }
        return result;
    }


    public void makeOrder(Order order) {
        //��������Ӧ��������Ӧ�̵�����������Ӧ�ļ���
        for (int i = 0; i < delivers.size(); i ++) {
            if (order.getDelivery_id() == delivers.get(i).getId()) {
                for (int j = 0; j < delivers.get(i).getTransportations().size(); j ++) {
                    if (order.getTransportation_id() == delivers.get(i).getTransportations().get(j).getId()) {
                        delivers.get(i).getTransportations().get(j).subLoad(order.getWeight());
                    }
                }
            }
        }
    }

    public List<Delivery> getDelivers() {
        return delivers;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setDelivers(List<Delivery> delivers) {
        this.delivers = delivers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }
}

