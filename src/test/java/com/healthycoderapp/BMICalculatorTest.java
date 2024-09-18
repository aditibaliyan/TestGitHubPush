package com.healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {
	List<Coder> coders= new ArrayList<>();
	private String env="dev";
	
//	@BeforeAll
//	static void b() {
//		System.out.println("before each");
//	}
//	
//	@AfterAll
//	static void a() {
//		System.out.println("after each");
//	}
//
	@Nested
	@DisplayName("tests related to diet recommendation")
	@Disabled
	class isDietRecommended{
		@Test
		void Should_returntrue_when_recommenred() {
			
			//given
			double weight= 89.0;
			double height=1.72;
			
			//when
			Boolean recommended= BMICalculator.isDietRecommended(89.0, 1.72);
			
			//then
			assertTrue(recommended);
		}
		
		@Test
		
		void exception_when_heightZero() {
			//given 
			double weight=50.0;
			double height=0.0;
			
			//when
			Executable executable= ()-> BMICalculator.isDietRecommended(weight, height);
			
			//then
			
			assertThrows(ArithmeticException.class, executable);
		}
		
		@ParameterizedTest(name="weight={0}, height={1}")
		@CsvFileSource(resources = "/DietRecommended.csv", numLinesToSkip = 1)
		public void TestWithParams(Double coderWeight , Double coderHeight ) {
			//given
			double weight= coderWeight;
			double height= coderHeight;
			
			//when
			Boolean recommended= BMICalculator.isDietRecommended(weight, height);
			
			//then
			assertTrue(recommended);
			
		}


		@RepeatedTest(value=10, name=RepeatedTest.LONG_DISPLAY_NAME)
		public void TestWithParams() {
			//given
			double weight= 87;
			double height= 1.72;
			
			//when
			Boolean recommended= BMICalculator.isDietRecommended(weight, height);
			
			//then
			assertTrue(recommended);
			
		}
	}

		@Nested
		class worstBMI{
		    @Test
			void worstBMI() {
				//given 
				
				//when
				Coder coderWorstBMI= BMICalculator.findCoderWithWorstBMI(coders);
				
				//then
				assertNull(coderWorstBMI);
				
			}
		    

		}
		
		@Nested
		class getBMI{
		    @Test
		   	void BMIScores() {
		   		//given 
		   		List<Coder> coders= new ArrayList<>();
		   		coders.add(new Coder(1.80,60.0));
		   		coders.add(new Coder(1.82,98.0));
		   		coders.add(new Coder(1.82,64.7));
		   		double[] result= {18.52,29.59,19.53};
		    		
		   		//when
		   		double[]  bmiScores= BMICalculator.getBMIScores(coders);
		   		
		   		//then
		   		assertArrayEquals(result,bmiScores);
		   		
		   	}

		    @Test
			public void finishesinMilliSecs() {
				assumeTrue(BMICalculatorTest.this.env.equals("dev"));
				//given
				for(int i=0;i<1000;i++) {
					coders.add(new Coder(1.0+i,50.0+i));
				}
				//when
				Executable executable=()-> BMICalculator.getBMIScores(coders);
				
				//then
				assertTimeout(Duration.ofMillis(100), executable);
			}
		}
		

	}
    
	
	
	





