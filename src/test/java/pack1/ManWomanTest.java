package pack1;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;

public class ManWomanTest
{
    private Man man1;
    private Man man2;
    private Man man3;
    private Woman woman1;
    private Woman woman2;
    private Woman woman3;

    @BeforeTest
    public void init(){
        System.out.println("_______________________");
        man1 = new Man("John", "Brown", 64, null);
        man2 = new Man("Eric", "White", 65, woman2);
        man3 = new Man("Robert", "Zombie", 45, woman3);
        woman1 = new Woman("Anny", "Grey", 59, null);
        woman2 = new Woman("Emma", "Orange", 60, man2);
        woman3 = new Woman("Helga", "Black", 23, man3);
    }

    @Test
    public void testFirstName() {
        Assert.assertEquals(man1.getFirstName(), "John", "FirstName is not valid");
        Assert.assertEquals(man2.getFirstName(), "Eric", "FirstName is not valid");
        Assert.assertEquals(man3.getFirstName(), "Robert", "FirstName is not valid");
        Assert.assertEquals(woman1.getFirstName(), "Anny", "FirstName is not valid");
        Assert.assertEquals(woman2.getFirstName(), "Emma", "FirstName is not valid");
        Assert.assertEquals(woman3.getFirstName(), "Helga", "FirstName is not valid");
    }
    @Test
    public void testLastName() {
        Assert.assertEquals(man1.getLastName(), "Brown", "LastName is not valid");
        Assert.assertEquals(man2.getLastName(), "White", "LastName is not valid");
        Assert.assertEquals(man3.getLastName(), "Zombie", "LastName is not valid");
    }
    @Test
    public void testAge() {
        Assert.assertEquals(man1.getAge(), 64, "Age is not valid");
        Assert.assertEquals(man2.getAge(), 65, "Age is not valid");
        Assert.assertEquals(man3.getAge(), 45, "Age is not valid");
        Assert.assertEquals(woman1.getAge(), 59, "Age is not valid");
        Assert.assertEquals(woman2.getAge(), 60, "Age is not valid");
        Assert.assertEquals(woman3.getAge(), 23, "Age is not valid");
    }
    @Test
    public void testIsRetired() {
        Assert.assertFalse(man1.isRetired());
        Assert.assertTrue(man2.isRetired());
        Assert.assertFalse(man3.isRetired());
        Assert.assertFalse(woman1.isRetired());
        Assert.assertTrue(woman2.isRetired());
        Assert.assertFalse(woman3.isRetired());
    }

    @Test
    public void testPartner() {
        Assert.assertNull(man1.getPartner());
        woman2.registerPartnership(man2);
        Assert.assertEquals(man2.getPartner(), woman2, "Incorrect partner");
        Assert.assertNull(man3.getPartner());
        Assert.assertNull(woman1.getPartner());
        Assert.assertEquals(woman2.getPartner(), man2, "Incorrect partner");
        Assert.assertNull(woman3.getPartner());
    }
    @Test
    public void testRegisterPartnership() {
        Assert.assertNull(man1.getPartner());
        Assert.assertNull(woman1.getPartner());
        woman1.registerPartnership(man1);
        Assert.assertEquals(man1.getPartner(), woman1, "Incorrect partner");
        Assert.assertEquals(woman1.getPartner(), man1, "Incorrect partner");
        Assert.assertEquals(woman1.getLastName(), man1.getLastName(), "Incorrect LastName");
    }
    @Test
    public void testDeRegisterPartnership() {
        woman2.registerPartnership(man2);
        Assert.assertEquals(man2.getPartner(), woman2, "Incorrect partner");
        Assert.assertEquals(woman2.getPartner(), man2, "Incorrect partner");
        Assert.assertEquals(woman2.getLastName(), man2.getLastName(), "Incorrect LastName");
        woman2.deregisterPartnership(false);
        Assert.assertNull(man2.getPartner());
        Assert.assertNull(woman2.getPartner());
        Assert.assertEquals(woman2.getLastName(), man2.getLastName(), "Incorrect LastName");

        woman3.registerPartnership(man3);
        Assert.assertEquals(man3.getPartner(), woman3, "Incorrect partner");
        Assert.assertEquals(woman3.getPartner(), man3, "Incorrect partner");
        Assert.assertEquals(woman3.getLastName(), man3.getLastName(), "Incorrect LastName");
        woman3.deregisterPartnership(true);
        Assert.assertNull(man3.getPartner());
        Assert.assertNull(woman3.getPartner());
        Assert.assertEquals(woman3.getLastName(), woman3.getOriginalLastName(), "Incorrect LastName");
    }

}
