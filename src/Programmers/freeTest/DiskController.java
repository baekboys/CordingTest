package FreeTest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The Class DiskController.
 *
 * @FileName : DiskController.java
 * @Project : ProgrammersSolution
 * @Date : 2019. 12. 29.
 * @작성자 : 백명선
 * @변경이력 :
 * @프로그램 설명 : https://programmers.co.kr/learn/courses/30/lessons/42627?language=java
 ******************************************************************************************
하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.
예를들어
- 0ms 시점에 3ms가 소요되는 A작업 요청
- 1ms 시점에 9ms가 소요되는 B작업 요청
- 2ms 시점에 6ms가 소요되는 C작업 요청
와 같은 요청이 들어왔습니다. 이를 그림으로 표현하면 아래와 같습니다.
Screen Shot 2018-09-13 at 6.34.58 PM.png
한 번에 하나의 요청만을 수행할 수 있기 때문에 각각의 작업을 요청받은 순서대로 처리하면 다음과 같이 처리 됩니다.
Screen Shot 2018-09-13 at 6.38.52 PM.png
- A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms)
- B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지 : 11ms)
- C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 16ms)
이 때 각 작업의 요청부터 종료까지 걸린 시간의 평균은 10ms(= (3 + 11 + 16) / 3)가 됩니다.
하지만 A → C → B 순서대로 처리하면
Screen Shot 2018-09-13 at 6.41.42 PM.png
- A: 3ms 시점에 작업 완료(요청에서 종료까지 : 3ms)
- C: 2ms부터 대기하다가, 3ms 시점에 작업을 시작해서 9ms 시점에 작업 완료(요청에서 종료까지 : 7ms)
- B: 1ms부터 대기하다가, 9ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 17ms)
이렇게 A → C → B의 순서로 처리하면 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.
각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)
제한 사항
jobs의 길이는 1 이상 500 이하입니다.
jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
입출력 예
jobs	return
[[0, 3], [1, 9], [2, 6]]	9
입출력 예 설명
문제에 주어진 예와 같습니다.
0ms 시점에 3ms 걸리는 작업 요청이 들어옵니다.
1ms 시점에 9ms 걸리는 작업 요청이 들어옵니다.
2ms 시점에 6ms 걸리는 작업 요청이 들어옵니다.
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
	 * @작성일 : 2019. 12. 29.
	 * @작성자 : 백명선
	 * @변경이력 :
	 * @Method 설명 :
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