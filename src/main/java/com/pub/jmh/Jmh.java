package com.pub.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Jmh {
//	
//	/*
//	 * These are two counters.
//	 */
//	Counter c1 = new Counter1();
//	
//	Counter c2 = new Counter2();
//	public static void main(String[] args) throws RunnerException {
//	    Options opt = new OptionsBuilder()
//	            .include(Jmh.class.getSimpleName())
//	            .forks(1)
//	            .build();
//	    new Runner(opt).run();
//	}
//	public int measure(Counter c) {
//	    int s = 0;
//	    for (int i = 0; i < 10; i++) {
//	        s += c.inc();
//	    }
//	    return s;
//	}
//
//	
//
//	/*
//	 * We first measure the Counter1 alone...
//	 * Fork(0) helps to run in the same JVM.
//	 */
//	@Benchmark
//	@Fork(0)
//	public int measure_1_c1() {
//	    return measure(c1);
//	}
//
//	/*
//	 * Then Counter2...
//	 */
//	@Benchmark
//	@Fork(0)
//	public int measure_2_c2() {
//	    return measure(c1);
//	}
//
//	/*
//	 * Then Counter1 again...
//	 */
//	@Benchmark
//	@Fork(0)
//	public int measure_3_c1_again() {
//	    return measure(c1);
//	}
//
//	@Benchmark
//	@Fork(1)
//	public int measure_4_forked_c1() {
//	    return measure(c1);
//	}
//
//	@Benchmark
//	@Fork(1)
//	public int measure_5_forked_c2() {
//	    return measure(c2);
//	}
//	
//	
}
