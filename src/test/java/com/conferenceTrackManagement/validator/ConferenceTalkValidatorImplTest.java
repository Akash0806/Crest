package com.conferenceTrackManagement.validator;

import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.EMPTY_STRING;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.ERR_DURATION_MORE_THEN_MAXTIME;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.ERR_INVAILD_DURATIION;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.ERR_INVAILD_INPUT;
import static com.conferenceTrackManagement.constant.ConferenceTrackManagementCostant.ERR_INVAILD_LINE;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ConferenceTalkValidatorImplTest {

	ConferenceTalkValidator conferenceTalkValidator=null;
	List<String> inputList = null;

	@Before
	public void setUp() {
		inputList = new ArrayList<>();
		conferenceTalkValidator =  new ConferenceTalkValidatorImpl();
   }
	
	

	@Test(expected = NullPointerException.class)
	public void shouldReturnNullPointerExceptionWhenListStringIsNull() {
		String emptyStringArray = null;
		inputList.add(emptyStringArray);
		conferenceTalkValidator.validateInput(inputList);
	}

	@Test
	public void shouldReturnVaildInputMSGWhenListIsEmpty() {
		String emptyStringArray = " ";
		String actualResult = validateInputCall(emptyStringArray);
		Assert.assertTrue(actualResult.contains(ERR_INVAILD_INPUT));
	}
	

	@Test
	public void shouldReturn_InvailInputLineError_WhenLineIsInvaild() {
		String actualResult = validateInputCall("Test Test");
		Assert.assertTrue(actualResult.contains(ERR_INVAILD_LINE));
	}

	@Test
	public void shouldReturn_InvailTalkName_WhenUnitIsHour() {
		String actualResult = validateInputCall("Overdoing it in Python 45Hour");
		Assert.assertTrue(actualResult.contains(ERR_INVAILD_LINE));
	}

	@Test
	public void shouldReturn_InvailTalkName_WhenUnitIsPresent() {
		String actualResult = validateInputCall("Overdoing it in Python 45");
		Assert.assertTrue(actualResult.contains(ERR_INVAILD_LINE));
	}

	@Test
	public void shouldReturn_EmptyString_WhenUnitIsLightning() {
		String actualResult = validateInputCall("Rails for Python Developers lightning");
		Assert.assertEquals(EMPTY_STRING, actualResult);
	}

	@Test
	public void shouldReturn_MaxDurationErr_WhenDurationIsMoreThenMaxDuration() {
		String actualResult = validateInputCall("Rails for Python Developers 900min");
		Assert.assertTrue(actualResult.contains(ERR_DURATION_MORE_THEN_MAXTIME));

	}

	@Test
	public void shouldReturn_EmptyString_WhenDurationIsLess() {
		String actualResult = validateInputCall("Rails for Python Developers 60min");
		Assert.assertEquals(EMPTY_STRING, actualResult);

	}

	@Test
	public void shouldReturn_InvailDurationErr_WhenDurationIsnotPresent() {
		String actualResult = validateInputCall("Rails for Python Developers min");
		Assert.assertTrue(actualResult.contains(ERR_INVAILD_DURATIION));

	}

	@Test
	public void shouldReturn_InvaildLine_WhenDurationIsnotPresent() {
		String actualResult = validateInputCall("Sit Down and Write Testmin");
		Assert.assertTrue(actualResult.contains(ERR_INVAILD_LINE));

	}
	private String validateInputCall(String emptyStringArray) {
		inputList.add(emptyStringArray);
		return conferenceTalkValidator.validateInput(inputList);
	}
}
