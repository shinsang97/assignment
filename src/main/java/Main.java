
class Bus { //속성
    int maxPassenger;  //최대승객 (25명 이하만 운행중으로)
    int nowPassenger; //현재승객 (탑승시 승객수 i++)
    int price;  // 요금
    String busNum; //버스번호(고유값 지정)
    int gas;  //연료  (10미만 떨어지면 주유가 필요하다 메시지)
    int speed;  //속도 (변경할 속도를 현재 속도에서 뺴거나 더할수있다)
    boolean state = true;  //처음 상태 운행 (운행, 차고지행) 연료 떨어지면 (차고지행 으로 바꿈)(주유량이 10이상이여야지 운행)


    public Bus(int maxPassenger, int nowPassenger, int price, String busNum, int gas, int speed ) { //생성자
        this.maxPassenger = maxPassenger;
        this.nowPassenger = nowPassenger;
        this.price = price;
        this.busNum = busNum;
        this.gas = gas;
        this.speed = speed;
    }
    public void gasShortage() { //메소드 ture
            if(gas < 10){
                System.out.println("주유가 필요합니다");
                state = false;
        }
    }
    public void speedUp(int acceleration){ //메소드
        speed = speed+acceleration;
    }
    public String nowstate(){ //메소드
        if(gas > 10){
            state = true;
        }else{
            state = false;
        }
        return state ? "운행" : "차고지행" ;
    }
    public void nowPassenger(){//승객 탑승메소드
        if(maxPassenger > nowPassenger && state){
             nowPassenger++;
        }
}



public void check() {
    System.out.println(nowPassenger);
    System.out.println(state);
    System.out.println();


}
}
class Taxi{
    int taxiNum;  //택시번호
    int gas;  //연료
    int speed;  //스피드
    int destination; //목적지
    int basicDistance; //기본거리
    int distanceToDestination; // 목적지까지거리
    int baseRate;  //기본요금
    int farePerDistance;  //거리당 요금
    boolean situation = true;  //상태
    int totalfee;
    boolean active;

    public Taxi(int taxiNum, int gas, int speed, int destination, int basicDistance, int distanceToDestination, int baseRate, int farePerDistance) {
        this.taxiNum = taxiNum; //택시 번호
        this.gas = gas;    //주유량
        this.speed = speed;  //현재속도
        this.destination = destination;  //목적지
        this.basicDistance = basicDistance;  //기본거리
        this.distanceToDestination = distanceToDestination;  //목적지까지거리
        this.baseRate = baseRate;  //기본요금
        this.farePerDistance = farePerDistance;  //거리당요금
    }
    public String nowsituation(){
        if(gas > 10){
            situation = true;
        }else{
            situation = false;
        }
        return situation ? "운행중" : "차고지" ;
    }

//    public void getIn(){
//        if (situation = true){
//            active=true;
//        }
//    }
    public void changeSpeed(int acceleration){
        speed = acceleration;
    }
    public void feeCount(){
        if (distanceToDestination<=basicDistance){
            int fee =6500;
        }else{ totalfee = 100 * (int)((distanceToDestination - basicDistance)/132)+farePerDistance;

        }
    }
    public void feeTotal(){

    }

}

public class Main {
    public static void main(String[] args){
        Bus tayo = new Bus(25, 20, 1500, "1000번", 9,50);
        tayo.nowstate();
        System.out.println(tayo.busNum + "입니다" + tayo.nowstate() + "이고" + " 현재탑승객은 " + tayo.nowPassenger +"명입니다"+ " , "+"연료가" + tayo.gas +
                "% 남아있습니다" + " 버스요금은 " + tayo.price + "KRW 입니다 " + tayo.speed +"km/hr.");
        tayo.nowPassenger();
        tayo.speedUp(5);
//        tayo.speedDown();
        System.out.println(tayo.busNum + "입니다" + tayo.nowstate() + "이고" + " 현재탑승객은 " + tayo.nowPassenger +"명입니다"+ " , " + tayo.gas +
                "% 의 가스가 남아있습니다" + " 버스요금은 " + tayo.price + "KRW 입니다 " + tayo.speed +"km/hr.");

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        Taxi taxi = new Taxi(1272, 100, 30, 70, 1, 10,3600,2);

        System.out.println(taxi.taxiNum + "모범택시 입니다 " + taxi.nowsituation() + "입니다 "+"연료가" + taxi.gas + "% 남아있습니다" +"기본요금"+ taxi.baseRate + "원 입니다.");

    }
}

