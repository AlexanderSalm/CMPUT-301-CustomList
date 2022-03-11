import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @Before
    public void createList(){
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest(){
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void hasCityTest(){
        City c = new City("Toronto", "ON");
        assertFalse(list.hasCity(c));
        list.addCity(c);
        assertTrue(list.hasCity(c));
    }

    @Test
    public void deleteCityTest(){
        City c = new City("Toronto", "ON");
        list.addCity(c);
        assertTrue(list.hasCity(c));
        list.deleteCity(c);
        assertFalse(list.hasCity(c));
    }

    @Test
    public void countCitiesTest(){
        City c = new City("Toronto", "ON");
        assertEquals(0, list.countCities());
        list.addCity(c);
        assertEquals(1, list.countCities());
        list.deleteCity(c);
        assertEquals(0, list.countCities());
    }
}
