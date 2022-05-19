
class Bus { //속성
    int maxPassenger;  //최대승객 (25명 이하만 운행중으로)
    int nowPassenger; //현재승객 (탑승시 승객수 i++)
    int price;  // 요금
    final String busNum; //버스번호(고유값 지정)
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
        if(gas > 10 && maxPassenger >= nowPassenger){
            state = true;
        }else{
            System.out.println("주유가 필요합니다.");
            state = false;
            System.out.println("연료가 부족하여 차고지로 이동합니다.");
        }
        return state ? "운행중" : "차고지행" ;
    }
    public void nowPassenger(){//승객 탑승메소드
        if(maxPassenger > nowPassenger && state){
            System.out.println("1명이 탔습니다");
            gas = gas-40;
             nowPassenger++;
        }else{
            System.out.println("인원이 가득차서 탈수없습니다.");
        }
}



public void check() {
    System.out.println(nowPassenger);
    System.out.println(state);
    System.out.println();


}
}
class Taxi{
    final String taxiNum;  //택시번호
    int gas;  //연료
    int speed;  //스피드
    String destination; //목적지
    int basicDistance; //기본거리
    int distanceToDestination; // 목적지까지거리
    int baseRate;  //기본요금
    int farePerDistance;  //거리당 요금
    String situation = "";  //상태
    int totalfee;
    int passenger;
    int feeTotal;
    int passengerIn;
    boolean active;

    public Taxi(String taxiNum, int gas, int speed, String destination, int basicDistance, int distanceToDestination, int baseRate, int farePerDistance,int passengerIn,int passenger) {
        this.taxiNum = taxiNum; //택시 번호
        this.gas = gas;    //주유량
        this.speed = speed;  //현재속도
        this.destination = destination;  //목적지
        this.basicDistance = basicDistance;  //기본거리
        this.distanceToDestination = distanceToDestination;  //목적지까지거리
        this.farePerDistance = farePerDistance;  //거리당요금
        this.passengerIn = passengerIn;
        this.passenger=passenger;
    }
    public String nowSituation() {
        if (gas > 10 && passenger < 1) {
            situation = "운행 종료";
        }
        if (gas < 10 && passenger >= 1) {
            situation = "연료를 채우세요";
        }
        if (gas >= 10 && passenger >= 1) {
            situation = "운행중";
        } else if (gas >= 10 && passenger == 0) {
            situation = "일반";
        }
        return situation;

    }
        public void passenger() {
            nowSituation();
            if (situation.equals("일반")) {
                passenger += passengerIn;
            } else {
                System.out.println("목적지로 이동중입니다.");
            }
        }

    public void SpeedUp(int acceleration){
        nowSituation();
        if ( situation.equals("Running")){
            speed += acceleration;
        }else{
            System.out.println("연료가 부족합니다.");
        }
    }
    public void speedDown(int acceleration) {
        nowSituation();
        if ( situation.equals("Running")) {
            speed -= acceleration;
        } else {
            System.out.println("연료가 부족합니다.");
        }
    }
    public void basic(){
        basicDistance = 2;
    }
    public void basicFee(){
        baseRate = 3800;
    }

    public int feeCount(){
        basic();
        basicFee();
        totalfee = baseRate + (distanceToDestination - basicDistance)*750;
        return totalfee;
    }
    public void feeTotal(){
        feeCount();
        if(situation.equals("운행중")) {
            System.out.println( feeCount() + "원입니다.");
        }
    }

}

public class Main {
    public static void main(String[] args){
        Bus tayo = new Bus(25, 25, 1500, "1000번", 100,50);
        tayo.nowstate();
        System.out.println(tayo.busNum + "입니다" +"("+ tayo.nowstate() +")"+ "이고" + " 현재탑승객은 " + tayo.nowPassenger +"명입니다"+ " , "+"연료가" + tayo.gas +
                "% 남아있습니다" + " 버스요금은 " + tayo.price + "KRW 입니다 " + tayo.speed +"km/hr.");
        tayo.nowPassenger();
        tayo.speedUp(5);
        System.out.println(tayo.busNum + "입니다" +"("+ tayo.nowstate() +")"+ "이고" + " 현재탑승객은 " + tayo.nowPassenger +"명입니다"+ " , " +"연료가" + tayo.gas +
                "% 남아있습니다" + " 버스요금은 " + tayo.price + "KRW 입니다 " + tayo.speed +"km/hr.");

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        Taxi taxi = new Taxi("kakao", 100, 30, "우리집", 2, 10,3800,2,1,0);
        System.out.println(taxi.taxiNum +"(" +taxi.situation +")"+ "모범택시 입니다 "+"연료가" + taxi.gas + "% 남아있습니다");
        taxi.passenger();
        System.out.println(taxi.taxiNum+"(" +taxi.situation +")"+"모범택시 입니다 "+"목적지: "+taxi.destination+"입니다 목적지 까지 거리는"+taxi.distanceToDestination+"km 입니다");
        System.out.println("지불하실금액은 "+taxi.feeTotal+"원 입니다.");
    }
}

