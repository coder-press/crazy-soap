package crazysoap;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

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
@Warmup(iterations = 4, time=1,timeUnit=TimeUnit.SECONDS)
@Measurement(iterations = 3, time=3,timeUnit=TimeUnit.SECONDS)
@Fork(value = 1, warmups = 1)
//@Warmup(iterations = 1, time=100,timeUnit=TimeUnit.MICROSECONDS)
//@Measurement(iterations = 2, time=200,timeUnit=TimeUnit.MICROSECONDS)
//@Fork(value = 1, warmups = 1)
@State(Scope.Benchmark)
public class ParseBooleanRandomBenchmarkTest {

	private static final int VALUE_SAMPLE_SIZE = 1000;

	@Param
	public Implementation implId;
	
	@Param({"all-random","spec-random"})
	public String valueParam;
	
	private ParseBoolean impl;
	private String[] values;
	
	@Setup(Level.Trial)
	public void setup() {
		impl = implId.getInstance();
		String[] strings=new String[VALUE_SAMPLE_SIZE];
		Value[] values=Value.values();
		if (valueParam.equals("spec-random")) {
			values=new Value[]{Value.TRUE, Value.ZERO, Value.ONE, Value.FALSE, };
		}
		int length = values.length;
		for (int i=0;i<strings.length;i++) {
			int idx=(int) (Math.random()*length);
			strings[i]=ParseBooleanBenchmarkTest.newInstance(values[idx].getValue());
		}
		this.values=strings;
	}

	@Benchmark
	@OperationsPerInvocation(VALUE_SAMPLE_SIZE)
	public void parseRandom(Blackhole bh) {
		for (String v : values) {
			consume(bh, impl.parse(v));
		}
	}
	
	protected void consume(Blackhole bh, boolean parse) {
		bh.consume(parse);
	}

	public static ParseBooleanRandomBenchmarkTest with(Implementation implId, String valueParam) {
		ParseBooleanRandomBenchmarkTest ret = new ParseBooleanRandomBenchmarkTest() {
			@Override
			protected void consume(Blackhole bh, boolean parse) {
				
			}
		};
		ret.implId=implId;
		ret.valueParam=valueParam;
		ret.setup();
		return ret;
	}
	
	@Test
	public void testAll() {
		for (Implementation impl : Implementation.values()) {
			for (String value : new String[]{"all-random","spec-random"}) {
				with(impl,value).parseRandom(null);
			}
		}
	}

}
