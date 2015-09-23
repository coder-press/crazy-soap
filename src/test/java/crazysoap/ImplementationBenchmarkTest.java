package crazysoap;


import crazysoap.jdk7_80.ParseBooleanJDK7_80;
import crazysoap.simple.ParseBooleanSimpleImpl;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/*
 * Copyright 2015 mosmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 * @author mosmann
 */
@Warmup(iterations = 2)
@Measurement(iterations = 2)
@Fork(value = 1, warmups = 1)
@State(Scope.Thread)
public class ImplementationBenchmarkTest {
    
	private static final String TRUE = "true";
	private static final String FALSE = "false";
	private static final String ONE = "1";
	private static final String ZERO = "0";
	private static final String FALSE_TRUE = "tru";
	private static final String FALSE_FALSE = "fals";

//    @Benchmark
//    @Warmup(iterations = 2)
//    @Measurement(iterations = 2)
//    @Fork(value = 1, warmups = 1)
//    public void foo(Blackhole bh) {
//        bh.consume("foo");
//    }
    
    private static boolean parse(ParseBoolean impl, String value) {
    	return impl.parse(value);
    }
    
    private ParseBooleanJDK7_80 jdk7_80;
	private ParseBooleanSimpleImpl simple;
    
    @Setup
    public void setup() {
    	jdk7_80 = new ParseBooleanJDK7_80();
    	simple = new ParseBooleanSimpleImpl();
    }
    
    @Benchmark
    public boolean true_parseJDK7_80() {
		return parse(jdk7_80, TRUE);
    }
    
    @Benchmark
    public boolean true_parseSimple() {
		return parse(simple, TRUE);
    }
    
    @Benchmark
    public boolean one_parseJDK7_80() {
		return parse(jdk7_80, ONE);
    }
    
    @Benchmark
    public boolean one_parseSimple() {
		return parse(simple, ONE);
    }
    
    @Benchmark
    public boolean false_parseJDK7_80() {
		return parse(jdk7_80, FALSE);
    }
    
    @Benchmark
    public boolean false_parseSimple() {
		return parse(simple, FALSE);
    }
    
    @Benchmark
    public boolean zero_parseJDK7_80() {
		return parse(jdk7_80, ZERO);
    }
    
    @Benchmark
    public boolean zero_parseSimple() {
		return parse(simple, ZERO);
    }
    
    @Benchmark
    public boolean falseTypo_parseJDK7_80() {
		return parse(jdk7_80, FALSE_FALSE);
    }
    
    @Benchmark
    public boolean falseTypo_parseSimple() {
		return parse(simple, FALSE_FALSE);
    }
    
    @Benchmark
    public boolean trueTypo_parseJDK7_80() {
		return parse(jdk7_80, FALSE_TRUE);
    }
    
    @Benchmark
    public boolean trueTypo_parseSimple() {
		return parse(simple, FALSE_TRUE);
    }
}
