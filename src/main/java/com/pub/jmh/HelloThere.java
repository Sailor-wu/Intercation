package com.pub.jmh;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class HelloThere {

	@Benchmark
	public void wellMethod() {
		
	}
	
//	 public static void main(String[] args) throws RunnerException {
//	        Options opt = new OptionsBuilder()
//	                .include(HelloThere.class.getSimpleName())
//	                .forks(1)
//	                .build();
//
//	        new Runner(opt).run();
//	    }
	
	@Benchmark
    public void myTest() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1);
    }
}
