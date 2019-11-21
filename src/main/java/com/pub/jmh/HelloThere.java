package com.pub.jmh;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class HelloThere {
//
//	 private int aa = 1;
//	 private int y  = 2;
////	@Benchmark
//	public void wellMethod() {
//		
//	}
//	
//	 public static void main(String[] args) throws RunnerException {
//	        Options opt = new OptionsBuilder()
//	                .include(HelloThere.class.getSimpleName())
//	                .forks(1)
//	                .build();
//
//	        new Runner(opt).run();
//	    }
//	
////	@Benchmark
//    public void myTest() throws InterruptedException {
//        TimeUnit.MILLISECONDS.sleep(1);
//    }
//	
//
////	@Benchmark
//	public int measureRight() {
//	    return (aa + y);
//	}
//
//	private int reps(int reps) {
//	    int s = 0;
//	    for (int i = 0; i < reps; i++) {
//	        s += (aa + y);
//	    }
//	    return s;
//	}
//
//	@Benchmark
//	@OperationsPerInvocation(1)
//	public int measureWrong_1() {
//	    return reps(1);
//	}
//
//	@Benchmark
//	@OperationsPerInvocation(10)
//	public int measureWrong_10() {
//	    return reps(10);
//	}
//
//	@Benchmark
//	@OperationsPerInvocation(100)
//	public int measureWrong_100() {
//	    return reps(100);
//	}
//
//	@Benchmark
//	@OperationsPerInvocation(1000)
//	public int measureWrong_1000() {
//	    return reps(1000);
//	}
//
//	@Benchmark
//	@OperationsPerInvocation(10000)
//	public int measureWrong_10000() {
//	    return reps(10000);
//	}
//
//	@Benchmark
//	@OperationsPerInvocation(100000)
//	public int measureWrong_100000() {
//	    return reps(100000);
//	}
}
