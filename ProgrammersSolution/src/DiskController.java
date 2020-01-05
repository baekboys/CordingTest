import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The Class DiskController.
 *
 * @FileName : DiskController.java
 * @Project : ProgrammersSolution
 * @Date : 2019. 12. 29.
 * @�ۼ��� : ���
 * @�����̷� :
 * @���α׷� ���� : https://programmers.co.kr/learn/courses/30/lessons/42627?language=java
 ******************************************************************************************
 �ϵ��ũ�� �� ���� �ϳ��� �۾��� ������ �� �ֽ��ϴ�. ��ũ ��Ʈ�ѷ��� �����ϴ� ����� ���� ������ �ֽ��ϴ�. ���� �Ϲ����� ����� ��û�� ���� ������� ó���ϴ� ���Դϴ�.

�������

- 0ms ������ 3ms�� �ҿ�Ǵ� A�۾� ��û
- 1ms ������ 9ms�� �ҿ�Ǵ� B�۾� ��û
- 2ms ������ 6ms�� �ҿ�Ǵ� C�۾� ��û
�� ���� ��û�� ���Խ��ϴ�. �̸� �׸����� ǥ���ϸ� �Ʒ��� �����ϴ�.
Screen Shot 2018-09-13 at 6.34.58 PM.png

�� ���� �ϳ��� ��û���� ������ �� �ֱ� ������ ������ �۾��� ��û���� ������� ó���ϸ� ������ ���� ó�� �˴ϴ�.
Screen Shot 2018-09-13 at 6.38.52 PM.png

- A: 3ms ������ �۾� �Ϸ� (��û���� ������� : 3ms)
- B: 1ms���� ����ϴٰ�, 3ms ������ �۾��� �����ؼ� 12ms ������ �۾� �Ϸ�(��û���� ������� : 11ms)
- C: 2ms���� ����ϴٰ�, 12ms ������ �۾��� �����ؼ� 18ms ������ �۾� �Ϸ�(��û���� ������� : 16ms)
�� �� �� �۾��� ��û���� ������� �ɸ� �ð��� ����� 10ms(= (3 + 11 + 16) / 3)�� �˴ϴ�.

������ A �� C �� B ������� ó���ϸ�
Screen Shot 2018-09-13 at 6.41.42 PM.png

- A: 3ms ������ �۾� �Ϸ�(��û���� ������� : 3ms)
- C: 2ms���� ����ϴٰ�, 3ms ������ �۾��� �����ؼ� 9ms ������ �۾� �Ϸ�(��û���� ������� : 7ms)
- B: 1ms���� ����ϴٰ�, 9ms ������ �۾��� �����ؼ� 18ms ������ �۾� �Ϸ�(��û���� ������� : 17ms)
�̷��� A �� C �� B�� ������ ó���ϸ� �� �۾��� ��û���� ������� �ɸ� �ð��� ����� 9ms(= (3 + 7 + 17) / 3)�� �˴ϴ�.

�� �۾��� ���� [�۾��� ��û�Ǵ� ����, �۾��� �ҿ�ð�]�� ���� 2���� �迭 jobs�� �Ű������� �־��� ��, �۾��� ��û���� ������� �ɸ� �ð��� ����� ���� ���̴� ������� ó���ϸ� ����� �󸶰� �Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���. (��, �Ҽ��� ������ ���� �����ϴ�)

���� ����
jobs�� ���̴� 1 �̻� 500 �����Դϴ�.
jobs�� �� ���� �ϳ��� �۾��� ���� [�۾��� ��û�Ǵ� ����, �۾��� �ҿ�ð�] �Դϴ�.
�� �۾��� ���� �۾��� ��û�Ǵ� �ð��� 0 �̻� 1,000 �����Դϴ�.
�� �۾��� ���� �۾��� �ҿ�ð��� 1 �̻� 1,000 �����Դϴ�.
�ϵ��ũ�� �۾��� �����ϰ� ���� ���� ������ ���� ��û�� ���� �۾����� ó���մϴ�.
����� ��
jobs	return
[[0, 3], [1, 9], [2, 6]]	9
����� �� ����
������ �־��� ���� �����ϴ�.

0ms ������ 3ms �ɸ��� �۾� ��û�� ���ɴϴ�.
1ms ������ 9ms �ɸ��� �۾� ��û�� ���ɴϴ�.
2ms ������ 6ms �ɸ��� �۾� ��û�� ���ɴϴ�.
 ******************************************************************************************
 */
public class DiskController {
	

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] jobs = {{0, 3}, {1, 9}, {2, 9}, {20, 4}, {21,6}, {23,1}};

		DiskController dc = new DiskController();
		int result = dc.solution(jobs);
		System.out.println(result);
	}

	/**
	  * @Method Name : solution
	  * @�ۼ��� : 2019. 12. 29.
	  * @�ۼ��� : ���
	  * @�����̷� : 
	  * @Method ���� :
	  * @Return : int
	  * @param jobs
	  * @return
	  */
	public int solution(int[][] jobs) {
		int answer = 0;

		class Job {
			int start_ms;
			int process_ms;

			public Job(int start_ms, int process_ms) {
				this.start_ms = start_ms;
				this.process_ms = process_ms;
			}
		}

		PriorityQueue<Job> fifo_job_queue = new PriorityQueue<>(jobs.length, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				if(o1.start_ms < o2.start_ms) {
					return -1;
				}
				if(o1.start_ms > o2.start_ms) {
					return 1;
				}
				return 0;
			}
		});

		PriorityQueue<Job> sjf_job_queue = new PriorityQueue<>(jobs.length, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				if(o1.process_ms < o2.process_ms) {
					return -1;
				}
				if(o1.process_ms > o2.process_ms) {
					return 1;
				}

				if(o1.process_ms == o2.process_ms) {
					if(o1.start_ms < o2.start_ms) {
						return -1;
					}
					if(o1.start_ms > o2.start_ms) {
						return 1;
					}
				}

				return 0;
			}
		});

		for(int i = 0 ; i < jobs.length ; i++) {
			Job job = new Job(jobs[i][0], jobs[i][1]);

			fifo_job_queue.add(job);
		}

		int curr_ms = 0;
		int total_process_time = 0;

		while(!fifo_job_queue.isEmpty()) {
			Job job = fifo_job_queue.poll();
			curr_ms = job.start_ms + job.process_ms;
			total_process_time = job.process_ms;

			Boolean end_flag = true;
			while(end_flag) {
				Job next_job = fifo_job_queue.peek();
				if(next_job == null || next_job.start_ms > curr_ms) {
					end_flag = false;
				}
				else {
					sjf_job_queue.add(fifo_job_queue.poll());
				}
			}

			while(!sjf_job_queue.isEmpty()) {
				Job j = sjf_job_queue.poll();
				int end_ms = curr_ms + j.process_ms;
				int process_ms = end_ms - j.start_ms;
				total_process_time += process_ms;

				curr_ms = end_ms;
			}
		}

		answer = total_process_time / jobs.length;

		return answer;
	}
}
