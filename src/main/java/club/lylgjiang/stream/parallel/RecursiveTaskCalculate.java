package club.lylgjiang.stream.parallel;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Classname RecursiveTaskCalculate
 * @Description 
 * @Date 2019/10/4 22:22
 * @Created by Jiavg
 */
public class RecursiveTaskCalculate extends RecursiveTask<Long> {
    
    private Long start;
    private Long end;
    
    private static final Long calcInterval = 10000L;

    public RecursiveTaskCalculate(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if(end - start <= calcInterval){
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else {
            Long middle = (end + start) /2;
            RecursiveTaskCalculate left = new RecursiveTaskCalculate(start, middle);
            ForkJoinTask<Long> leftFork = left.fork();// 拆分子任务,同时压入线程池

            RecursiveTaskCalculate right = new RecursiveTaskCalculate(middle + 1, end);
            ForkJoinTask<Long> rightFork = right.fork();

            return leftFork.join() + rightFork.join();
        }
    }
    
}
