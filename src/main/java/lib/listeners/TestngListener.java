package lib.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class TestngListener implements IAnnotationTransformer, IRetryAnalyzer{
	int retryCnt = 1;

	public boolean retry(ITestResult result) {
		if(!result.isSuccess() & retryCnt < 2)
		{
			retryCnt++;
			return true;
		}
		return false;
	}

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		//To retry the failed test case
		annotation.setRetryAnalyzer(this.getClass());

		System.out.println("Method name is "+ testMethod.getName());

		//Disable delete lead test case execution
		if(testMethod.getName().equals("deleteLead"))
		{
			annotation.setEnabled(true);
		}

		//Set time-out to 10 secs for Create Lead method
		if(testMethod.getName().equals("createLead"))
		{
			annotation.setTimeOut(10000);
		}
	}

}
