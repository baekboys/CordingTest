import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;

/*
해쉬 포트
패킷ID의 해쉬값을 기반으로 컴퓨터 시스템의 여러 포트로 패킷이 전달됩니다. 해쉬 값을 구하는 방법은 아래와 같습니다:
HASH = mod (packet_id, numberOfPorts)
여기서 mod는 모듈러 연산이고, 첫번째 피연산자를 두번째 피연산자로 나눴을 때의 나머지 값입니다.
포트의 번호는 0에서부터 (포트의 개수)-1로 정해지고, 패킷은 패킷ID의 해쉬값과 동일한 포트 번호로 전달됩니다. 각각의 포트는 하나의 패킷을 전달하는데 시간 t가 소요됩니다. 만약 포트가 패킷을 전달하는 중이면, 해당 포트로 전달되어야 하는 패킷은 그다음 번호의 포트로 보내지고 만약 그 포트 또한 패킷을 전송 중일 시 비어있는 포트 번호까지 넘겨집니다. x개의 패킷이 1초에 한 개씩 도착하고, 패킷들의 ID가 주어질 때 각각의 패킷들이 어느 포트로 전달되었는지 구하십시오. 이때 첫번째 패킷은 t=1로 보내집니다.
Function Description
sentTime 함수를 구현하십시오. 이 함수는 패킷들이 전달된 포트의 번호를 정수 배열로 리턴 해야 합니다
sentTime 함수는 다음 매개 변수들을 받습니다:
    numberOfPorts: 정수, 시스템의 포트 개수
    transmissionTime: 정수, 포트가 하나의 패킷을 전달하는데 걸리는 시간
    packetIds: 정수 배열, 패킷의 도착순으로 정렬된 패킷들의 아이디
제약 조건
1 ≤ numberOfPorts ≤ 2000
1 ≤ transmissionTime ≤ 100
1 ≤ x ≤ 2000
1 ≤ packetIdsi ≤ 105
Input Format For Custom Testing
첫째 줄은 정수, numberOfPorts, 포트의 개수를 나타냅니다
둘째 줄은 정수, transmissionTime, 각각의 포트의 전달 시간을 나타냅니다
셋째 줄은 정수, x, 패킷의 개수를 나타냅니다
이후의 x개에 각각의 i줄은 (0 ≤ i < x) 패킷의 ID를 정수로 나타냅니다
 */


public class Solution {
    public static void main(String[] args) throws IOException {


    	int numberOfPorts = 10;
    	int transmissionTime = 5;
    	
    	List<Integer> packetIds = new ArrayList<Integer>();
    	

    	PrintWriter pw = null;
		String file_name = "C:/Users/baek/Desktop/test/input003.txt";
		
		try {
			
			// ���� �б�
			BufferedReader br = new BufferedReader(new FileReader(file_name));
			System.out.println(file_name + "���� �б� ����!!!");
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				//System.out.println(line);
				packetIds.add(Integer.parseInt(line));
			}
			br.close();
			
			List<Integer> result_list = Solution.sentTimes(numberOfPorts, transmissionTime, packetIds);
	        System.out.println("RESULT : " + result_list);
		} catch (Exception e) {
            e.getStackTrace();
			// TODO: handle exception
		}finally {
			if(pw != null) pw.close(); //�ݵ�� �ݴ´�.
		} 
    	
    	
    }

    
    
//    public static List<Integer> sentTimes(int numberOfPorts, int transmissionTime, List<Integer> packetIds) {
//        // Write your code here
//    	List<Integer> result_list = new ArrayList<Integer>();
//    	
//    	System.out.println("numberOfPorts : " + numberOfPorts);
//    	System.out.println("transmissionTime : " + transmissionTime);
//    	
//    	class Packet {
//        	int time;
//        	String port_num;
//        	Integer PID;
//        	
//        	public Packet(int time, String port_num, Integer P_ID) {
//        		this.time = time;
//        		this.port_num = port_num;
//        		this.PID = P_ID;
//        	}
//        }
//    	
//    	LinkedHashMap<String, Packet> linkedHashMap  = new LinkedHashMap<String,Packet>();
//    	
//    	int time = 1;
//    	
//    	
//    	
//		for (Integer id_list : packetIds) {
//			
//			int HASH_CODE = id_list.intValue() % numberOfPorts;
//			String port_num = String.valueOf(HASH_CODE);
//			
//			System.out.println(id_list + ",  hash_code : " + HASH_CODE);
//			
//			
//			Packet p = linkedHashMap.get(port_num);
//			
//			if(p == null) {
//				
//				Packet new_p = new Packet(time, port_num, id_list);
//				
//				linkedHashMap.put(port_num, new_p);
//			}
//			
//			time += transmissionTime;
//		}
//		
//		Iterator<String> keySetIterator = linkedHashMap.keySet().iterator();
//		while (keySetIterator.hasNext()) {
//		    String key = keySetIterator.next();
//		    
//		    Packet p = linkedHashMap.get(key);
//		    System.out.println("key: " + key + " value: " + p.time + "," + p.port_num + "," + p.PID);
//		    
//		    result_list.add(new Integer(key));
//		}
//    	
//        return result_list;
//    }
    
    public static List<Integer> sentTimes(int numberOfPorts, int transmissionTime, List<Integer> packetIds) {
        // Write your code here
    	List<Integer> result_list = new ArrayList<Integer>();
    	
    	System.out.println("numberOfPorts : " + numberOfPorts);
    	System.out.println("transmissionTime : " + transmissionTime);
    	
    	class Port {
    		int port_num;
    		int transmissionTime;
        	int time = 0;
    		Integer packetId;
    		
    		public Port(int num, int process_time) {
    			this.port_num = num;
    			this.transmissionTime = process_time;
    		}
    		
    		public boolean push(Integer packetId) {
    			if(this.time == 0) {
    				this.time = this.transmissionTime;
    				this.packetId = packetId;
    				System.out.println(this.port_num + ":" + packetId + " push ����");
    				return true;
    			} else {
    				System.out.println(this.port_num + ":" + packetId + ", " + this.packetId + "ó���� ���� " + this.time + "�ð���������");
    			}
    			
    			return false;
    		}
    		
    		public void process() {
    			this.time--;
    			if( this.time <= 0) {
    				this.time = 0; 
    				this.packetId = null;
    			}
    		}
    	}
    	
    	
    	ArrayList<Port> port_list = new ArrayList<Port>(numberOfPorts);
    	for(int i = 0 ; i < numberOfPorts ; i++) {
    		Port p = new Port(i, transmissionTime);
    		port_list.add(p);
    	}
    	
    	LinkedHashSet<Integer> m_used_port_num = new LinkedHashSet<Integer>();
        	
    	for (Integer id_list : packetIds) {                         
    		int HASH_CODE = id_list.intValue() % numberOfPorts;

			boolean suc = false;
			while(!suc) {
				System.out.println("��Ŷ���̵� : " + id_list + ", " + HASH_CODE + "��Ʈ��ȣ push �õ�");
				if(port_list.get(HASH_CODE).push(id_list)) {
					suc = true;
					m_used_port_num.add(new Integer(HASH_CODE));
				} else {
					HASH_CODE++;
					if(HASH_CODE >= numberOfPorts) HASH_CODE = 0;
					if(HASH_CODE == id_list.intValue() % numberOfPorts) suc = true;
				}
				
			}
			
			for (Port p : port_list) {
				if(p.port_num != HASH_CODE)
				p.process();
			}
    	}
    	
    	Object[] list = m_used_port_num.toArray();
    	
    	for (Object ob : list) {
			result_list.add( (Integer)ob);
		}
    	
        return result_list;
    }
   
}