import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.RigisterPage;

@Listeners(genericUtilities.ListnersImplementation.class)
public class RigisterUserTest extends BaseClass{

	@Test
	public void TC_001_rigisterUser() throws IOException
	{
		RigisterPage rp = new RigisterPage(driver);
		rp.logout();
		rp.clickOnRigisterLinkButton();
		rp.RegisterUser();
		Assert.fail();
	}
}
